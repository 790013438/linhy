
$(function(){
    $('.menu-list').removeClass('active open');
    $("#userManage").addClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#systemStudent").addClass('active open');
    getStudentList();
    $("#btnFrozenUser").click(function () {
        closepop();
        var userId = $("#input_userId").val();
        var condition = {
            userId:userId,
            userStatus:0
        };
        updateUserStatus(condition);
    });
    $("#btnThawUser").click(function () {
        closepop();
        var userId = $("#input_userId").val();
        var condition = {
            userId:userId,
            userStatus:1
        };
        updateUserStatus(condition);
    });
});

//查询用户列表
var getStudentList = function() {
	$.ajax({
		url:"../admin/getAllUsers",
		type : 'post',
		data : null,
		dataType : 'json',
		success:function(result){
			if (result.success == true) {
				if (result.error != "") {
					alert(result.error);
					$("#table_student tbody").empty();
					return;
				}
				if (result.data!=null){
					console.log(result.data);
					$("#table_student tbody").empty();
					$.each(result.data, function (index, obj) {
						var tr = appendUserNode(obj);
						$("#table_student tbody").append(tr);
						appendTabTitleById("table_student");
                    });
                    $(document).ready(function(){
                        $('#table_student').DataTable();
                    });
				} else{
					$("#table_student tbody").empty();
					var txt = "没有查询到符合条件的信息";
					alert(txt);
					return;
				}
			} else {
				//还得先清空所有行
				var txt = result.error;
				alert(txt);
				return;
			}
		},
		error : function(obj, msg) {
			//还得先清空所有行
			$("#table_student tbody").empty();
			var txt = "没有查询到符合条件的信息";
			alert(txt);
			return;
		},
	});
}

//修改用户状态
var updateUserStatus = function(data) {
    $.ajax({
        url:"../admin/updateStudentStatus",
        type : 'post',
        data :data,
        dataType : 'json',
        success:function(result){
            console.log(result);
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    return;
                }else{
                    var txt = "修改用户状态成功";
                    alert(txt);
                    return;
                }
            } else {
                //还得先清空所有行
                var txt = result.error;
                alert(txt);
                return;
            }
        },
        error : function(obj, msg) {
            var txt = "修改用户状态失败";
            alert(txt);
            return;
        },
        complete: function () {
            getStudentList();
        }
    });
}

$(".table tr td input").each(function(){
    $(this).attr("title",$(this).val());
});
/**
 * 传入要实现table的Id即可
 * @param id
 */
 var appendTabTitleById = function(id)
{
    var cellIndex = parseInt ($ ("#" + id + ".table th").length) - 1;
    $ ($ ("#" + id + ".table tr td")).each (function ()
    {
        if (this.cellIndex != cellIndex)
        {
            $ (this).attr ("title", $ (this).text ());
        }
    });
    $ ("#" + id + ".table tr td input").each (function ()
    {
        $ (this).attr ("title", $ (this).val ());
    });
}
/**
 * 将td的内容(包括td下input)赋值给其title属性。
 * 配合max样式使用
 */
 var appendTabTitle = function()
{
    $ (".table tr td").each (function ()
    {
        if ($ (this).parent ().attr ('class') != 'last_tr')
        { //有操作按钮的一栏不添加 title 属性
            if ($ (this).children ("select").length <= 0)
            {
                $ (this).attr ("title", $ (this).text ());
            }
        }
    });
}



var appendUserNode = function(obj) {
    var user_str = "<tr>"+
		"<td>"+obj.userName+"</td>"+
		"<td> "+obj.userEmail+"</td>"+
		"<td> "+obj.userPhone+"</td>"+
		"<td> "+obj.userRealName+"</td>";
         if(obj.userStatus == 1){
             user_str = user_str+"<td> "+"正常"+"</td>";
         }else{
             user_str =user_str+ "<td> "+"禁用"+"</td>";
         }
    user_str = user_str + "<td> "+obj.userGender+"</td>"+
		"<td>"+
		"<a  href =\"../system/student_showInfo?userId="+obj.id+"\" >查看用户信息</a> |";
    if(obj.userStatus == 1){
        user_str =user_str+ "<button type=\"button\" onclick=\"frozenUser('"+obj.id+"')\" class='btn btn-link'>禁用</button>";
    }else{
        user_str = user_str+"<button type=\"button\" onclick=\"thawUser('"+obj.id+"')\" class='btn btn-link'>解禁</button>";
    }
    user_str=user_str+"<input type=\"hidden\" name=\"job_id\" value=\""+obj.id+"\"></td></tr>";
	return user_str;
}
function frozenUser(data)
{
    $("#input_userId").val(data);
    $(".pop").show();
    $("#popinto_frozen").show();
}
function thawUser(data)
{
    $("#input_userId").val(data);
    $(".pop").show();
    $("#popinto_thaw").show();
}





