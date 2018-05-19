
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
        url:"../message/getMessage?type="+1,
        type : 'post',
        data : null,
        dataType : 'json',
        success:function(result){
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
    var jobDeadline1 = moment(obj.createTime).format("YYYY-MM-DD HH:mm:ss");
    var mesType;
    var mesSenderType;
    if(obj.mesType==1){
        mesType="资源消息";
    }
    if(obj.mesType==2){
        mesType="作业消息";
    }
    if(obj.mesSenderType==0){
        mesSenderType="教师"
    }
    if(obj.mesSenderType==1){
        mesSenderType="学生"
    }
    if(obj.mesSenderType==2){
        mesSenderType="管理员"
    }
    var job_str = "<tr>"+
        "<td>"+obj.id+"</td>"+
        "<td>"+obj.mesSenderName+"</td>"+
        "<td>"+mesSenderType+"</td>"+
        "<td> "+mesType+"</td>"+
        "<td> "+jobDeadline1+"</td>"+
        "<td> "+obj.mesContents+"</td>" +
        "<td><button type=\"button\"  onclick=\"delJob("+"this,"+obj.id+")\" class='btn btn-link'>删除</button>" +
        "<button type=\"button\"  onclick=\"showFn("+obj.mesSenderId+","+obj.mesSenderType+","+obj.mesObjectType+","+obj.mesType+")\" class='btn btn-link'>回复</button></td>" +
        "</tr>"
    return job_str;
}

var delJob = function(myself,mesId) {
    console.log("this:"+myself)
    console.log("id:"+mesId)
    if(confirm("确定删除这条记录？")){
        console.log("mesId:"+mesId);
        $.ajax({
            url:"../message/deleteMessage?mesId="+mesId,
            type : 'get',
            data : null,
            dataType : 'json',
            success:function(result){
                if (result.success == true) {
                    /*删除当前行*/
                    $(myself).parent().parent().remove();
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
    }else{}
}
/*显示发送信息表单*/
var showFn = function(senderId,senderType,ObjectType,mesType){
    /*        document.getElementById( "replyMes").style.visibility= "visible";
            document.getElementById( "senderId").style.visibility= "hidden";
            为什么这种显示效果不行*/
    $("#replyMes").show();
    $("#senderId").hide();
    $("#senderType").hide();
    $("#objectType").hide();
    $("#mesType").hide();
    document.getElementById("senderId").value=senderId;
    document.getElementById( "senderType").value=senderType;
    document.getElementById( "objectType").value=ObjectType;
    document.getElementById( "mesType").value=mesType;
}
/*保存留言信息*/
var saveMes=function(){
    var objectId=document.getElementById("senderId").value;
    var objectType=document.getElementById( "senderType").value;
    var con=document.getElementById( "input_content").value;
    var senderType=document.getElementById( "objectType").value;
    var mesType=document.getElementById( "mesType").value;
    var params={};
    params.objectId=objectId;
    params.senderType=senderType;
    params.objectType=objectType;
    params.con=con;
    params.mesType=mesType;
    $.ajax({
        url:"../message/sendMessage",
        type : 'post',
        data : params,
        dataType : 'json',
        success:function(result){
            if (result.success == true) {
                /*隐藏留言板*/
                $("#replyMes").hide();
                /*清空留言内容*/
                document.getElementById( "input_content").value=null;
                if (result.error != "") {
                    alert(result.error);
                    return;
                }else{
                    var txt = "留言信息成功发送";
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
            var txt = "留言信息发送失败";
            alert(txt);
            return;
        },
        complete: function () {
            queryMessageList();
        }
    });
}




