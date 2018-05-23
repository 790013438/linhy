
$(function(){
    $('.menu-list').removeClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#systemTeacher").addClass('active open');
    getTeacherList();
    /*禁用*/
    $("#btnFrozen").click(function () {
        closepop();
        var teacherId = $("#teacherId").val();
        var condition = {
            teacherId:teacherId,
           /* teaStatus:'comp_frozen'*/
            teaStatus:3
        };
        updateCompStatus(condition);
    });
    /*解禁*/
    $("#btnThaw").click(function () {
        closepop();
        var teacherId = $("#teacherId").val();
        var condition = {
            teacherId:teacherId,
           /* teaStatus:'comp_successful'*/
            teaStatus:1
        };
        updateCompStatus(condition);
    });
    /*审核通过*/
    $("#btnAuditAgree").click(function () {
        closepop();
        var teacherId = $("#teacherId").val();
        var condition = {
            teacherId:teacherId,
           /* teaStatus:'comp_successful'*/
            teaStatus:1
        };
        updateCompStatus(condition);
    });
    /*审核拒绝*/
    $("#btnAuditRefuse").click(function () {
        closepop();
        var teacherId = $("#teacherId").val();
        var condition = {
            teacherId:teacherId,
           /* teaStatus:'comp_refused'*/
            teaStatus:2
        };
        updateCompStatus(condition);
    });
});

//查询用户列表
var getTeacherList = function() {
    $.ajax({
        url:"../admin/getAllTeacher",
        type : 'post',
        data : null,
        dataType : 'json',
        success:function(result){
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    $("#table_teacher tbody").empty();
                    return;
                }
                if (result.data!=null){
                    console.log(result.data);
                    $("#table_teacher tbody").empty();
                    $.each(result.data, function (index, obj) {
                        var tr = appendTeacherNode(obj);
                        $("#table_teacher tbody").append(tr);
                        appendTabTitleById("table_teacher");
                    });
                    $(document).ready(function(){
                        $('#table_teacher').DataTable();
                    });
                } else{
                    $("#table_teacher tbody").empty();
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
            $("#table_teacher tbody").empty();
            var txt = "没有查询到符合条件的信息";
            alert(txt);
            return;
        },
    });
}

//修改教师状态
var updateCompStatus = function(data) {
    $.ajax({
        url:"../admin/updateTeacherStatus",
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
                    var txt = "修改教师状态成功";
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
            var txt = "修改教师状态失败";
            alert(txt);
            return;
        },
        complete: function () {
            getTeacherList();
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



var appendTeacherNode = function(obj) {
    var status="审核通过";
    if(obj.teaStatus==0){
        status="未审核"
    }else if(obj.teaStatus==1){
        status="审核通过";
    }else if(obj.teaStatus==2){
        status="审核未通过"
    }else if(obj.teaStatus==3){
        status="禁用"
    }
    var user_str = "<tr>"+
            "<td>"+obj.teaAccount+"</td>"+
            "<td> "+status+"</td>"+
            "<td> "+obj.teaContacts+"</td>"+
            "<td> "+obj.teaPhone+"</td>"+
    "<td> "+obj.teaEmail+"</td>"+
  /*  "<td> "+obj.commWebsite+"</td>"+*/
    "<td> "+obj.teaAddress+"</td>"+
            "<td>"+
            "<a  href =\"../system/teacher_showinfo?teacherId="+obj.id+"\" >查看教师信息</a> |";
    if(obj.teaStatus==3){
        user_str =user_str+ "<button type=\"button\" onclick=\"thawTeacher('"+obj.id+"')\" class='btn btn-link'>解禁</button>";
    }else if(obj.teaStatus ==1){
        user_str = user_str+"<button type=\"button\" onclick=\"frozenTeacher('"+obj.id+"')\" class='btn btn-link'>禁用</button>";
    }else  if(obj.teaStatus == 0){
        user_str =user_str+ "<button type=\"button\" onclick=\" AuditTeacher('"+obj.id+"')\" class='btn btn-link'>审核</button>";
    }else{
        user_str = user_str+"<button type=\"button\" disabled='disabled'  class='btn btn-link'>审核</button>";
    }
    user_str=user_str+"<input type=\"hidden\" name=\"job_id\" value=\""+obj.id+"\"></td></tr>";
    return user_str;
}
function frozenTeacher(data)
{
    $("#teacherId").val(data);
    $(".pop").show();
    $("#popinto_frozen").show();
}
function thawTeacher(data)
{
    $("#teacherId").val(data);
    $(".pop").show();
    $("#popinto_thaw").show();
}

function AuditTeacher(data)
{
    $("#teacherId").val(data);
    $(".pop").show();
    $("#popinto_audit").show();
}





