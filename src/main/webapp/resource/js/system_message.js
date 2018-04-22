
$(function(){
    $('.menu-list').removeClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#li_message").addClass('active open');
    queryMessageList();
    $("#btn_delJob").click(function () {
        closepop();
        var jobId = $("#input_jobId").val();
        var data = {
            jobId:jobId
        };
        delJobById(data);
    });

});

//查询我的消息
var queryMessageList = function() {
	$.ajax({
		url:"../message/getMessage",
		type : 'post',
		data : {
		    type:1
        },
		dataType : 'json',
		success:function(result){
		    console.log(result);
			if (result.success == true) {
				if (result.error != "") {
					alert(result.error);
					$("#table_message tbody").empty();
					return;
				}
				if (result.data.data!=null){
					console.log(result.data);
					$("#table_message tbody").empty();
					$.each(result.data.data, function (index, obj) {
						var tr = appendJobNode(obj);
						$("#table_message tbody").append(tr);
						appendTabTitleById("table_message");
                    });
                    $(document).ready(function(){
                        $('#table_message').DataTable();
                    });
				} else{
					$("#table_message tbody").empty();
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
			$("#table_message tbody").empty();
			var txt = "没有查询到符合条件的信息";
			alert(txt);
			return;
		},
	});
}
//删除消息
var delJobById = function(data) {
    $.ajax({
        url:"../admin/deleteMessageById",
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
                    var txt = "删除消息成功";
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
            var txt = "删除消息失败";
            alert(txt);
            return;
        },
        complete: function () {
            queryMessageList();
        }
    });
}
//将消息标记为已读
var readMessage = function(id) {
    $.ajax({
        url:"../admin/readMessage",
        type : 'post',
        data : data={jobId:id},
        dataType : 'json',
        success:function(result){
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    return;
                }else{
                    var txt = "修改状态成功";
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
            var txt = "修改状态失败";
            alert(txt);
            return;
        },
        complete: function () {
            queryMessageList();
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



var appendJobNode = function(obj) {
    var jobDeadline1 = moment(obj.createTime).format("YYYY-MM-DD");
    if(obj.mesType==1){
        obj.mesType="资源审批";
    }
    if(obj.mesType==2){
        obj.mesType="资源报名";
    }
    var job_str = "<tr>"+
         "<td>"+obj.id+"</td>"+
		"<td> "+obj.mesType+"</td>"+
		"<td> "+jobDeadline1+"</td>"+
		"<td> "+obj.mesContents+"</td></tr>";
    console.log(job_str);
	return job_str;
}

var delJob = function(data) {
    $("#input_jobId").val(data);
    $(".pop").show();
    $(".popinto").show();
}






