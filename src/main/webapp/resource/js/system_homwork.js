
var condition = {
    jobStatus:"1",
};
$(function(){
    $('.menu-list').removeClass('active open');
    $("#jobManage").addClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#systemIdex").addClass('active open');
    getWaitingAudit(condition);
    getOldhoms();
    $("#btnAdoptJob").click(function () {
        closepop();
        var jobId = $("#input_jobId").val();
        var condition = {
            jobId:jobId,
            jobStatus:3
        };
        updateJobStatus(condition);
    });
    $("#btnRefuseJob").click(function () {
        closepop();
        var jobId = $("#input_jobId").val();
        var condition = {
            jobId:jobId,
            jobStatus:2
        };
        updateJobStatus(condition);
    });
});

//查询待审核作业列表
var getWaitingAudit = function(condition) {
    $.ajax({
        url:"../admin/getAllHoms",
        type : 'post',
        data : condition,
        dataType : 'json',
        success:function(result){
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    $("#homs_one tbody").empty();
                    return;
                }
                if (result.data.data!=null){
                    $("#homs_one tbody").empty();
                    $.each(result.data.data, function (index, obj) {
                        var tr = appendJobNode(obj);
                        $("#homs_one tbody").append(tr);
                        appendTabTitleById("homs_one");
                    });
                    $(document).ready(function(){
                        $('#homs_one').DataTable();
                    });
                } else{
                    $("#homs_one tbody").empty();
                    var txt = "暂无未截止的作业";
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
            $("#homs_one tbody").empty();
            var txt = "暂无未截止的作业";
            alert(txt);
            return;
        },
    });
}

/*查询已经截止了的作业信息*/
var getOldhoms = function(condition) {
    $.ajax({
        url:"../admin/getOldHoms",
        type : 'post',
        data : condition,
        dataType : 'json',
        success:function(result){
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    $("#homs_two tbody").empty();
                    return;
                }
                if (result.data.data!=null){
                    $("#homs_two tbody").empty();
                    $.each(result.data.data, function (index, obj) {
                        var tr = appendJobNodeTwo(obj);
                        $("#homs_two tbody").append(tr);
                        appendTabTitleById("homs_one");
                    });
                    $(document).ready(function(){
                        $('#homs_two').DataTable();
                    });
                } else{
                    $("#homs_two tbody").empty();
                    var txt = "暂无已截止的作业";
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
            $("#homs_two tbody").empty();
            var txt = "暂无已截止的作业";
            alert(txt);
            return;
        },
    });
}




//审核资源
var updateJobStatus = function(data) {
    $.ajax({
        url:"../admin/auditingJob",
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
                    var txt = "审核资源成功";
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
            var txt = "审核资源失败";
            alert(txt);
            return;
        },
        complete: function () {
            window.location.href = '../system/index';
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
    var jobDeadline1 = moment(obj.homDeadline).format("YYYY-MM-DD HH:mm:ss");
    var sign = 1;
    var job_str = "<tr>"+
        "<td>"+obj.id+"</td>"+
        "<td>"+obj.homTitle+"</td>"+
        "<td> "+"未截止"+"</td>"+
        "<td> "+obj.homTeacherName+"</td>"+
        "<td> "+jobDeadline1+"</td>"+
        "<td>"+
        "<a  href =\"../system/homInfo?jobId="+obj.id+"\" >查看作业详情</a> |"+
        "<button type=\"button\" onclick=\"deleteHom('"+obj.id+"')\" class='btn btn-link'>删除作业并通知教师</button>";
   /* "<input type=\"hidden\" name=\"job_id\" value=\""+obj.id+"\">"+*/
    "</td>"+
    "</tr>";
    return job_str;
}

var appendJobNodeTwo= function(obj) {
    var jobDeadline1 = moment(obj.homDeadline).format("YYYY-MM-DD HH:mm:ss");
    var sign = 1;
    var job_str = "<tr>"+
        "<td>"+obj.id+"</td>"+
        "<td>"+obj.homTitle+"</td>"+
        "<td> "+"未截止"+"</td>"+
        "<td> "+obj.jobTeacherName+"</td>"+
        "<td> "+jobDeadline1+"</td>"+
        "<td>"+
        "<a  href =\"../system/homInfo?jobId="+obj.id+"\" >查看作业详情</a> |"+
        "<button type=\"button\" onclick=\"deleteHom("+obj.id+")\" class='btn btn-link'>删除作业并通知教师</button>";
    /* "<input type=\"hidden\" name=\"job_id\" value=\""+obj.id+"\">"+*/
    "</td>"+
    "</tr>";
    return job_str;
}

/*删除作业并通知教师*/
function deleteHom(data)
{
    $.ajax({
        url:"../admin/deleteHom?jobId="+data,
        type : 'post',
        data :null,
        dataType : 'json',
        success:function(result){
            console.log(result);
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    return;
                }else{
                    var txt = "删除作业并通知教师成功";
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
            var txt = "删除作业并通知教师失败";
            alert(txt);
            return;
        },
        complete: function () {
            window.location.href = '../system/homework';
        }
    });
}




