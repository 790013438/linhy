var condition = {
    jobStatus:"2",
};
$(function(){
    $('.menu-list').removeClass('active open');
    $("#jobManage").addClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#systemJob").addClass('active open');
    getMyJobs(condition);
    $("#btn_delJob").click(function () {
        closepop();
        var jobId = $("#input_jobId").val();
        var data = {
            jobId:jobId
        };
        delJobById(data);
    });
});

//查询待审核资源列表
var getMyJobs = function(condition) {
    $.ajax({
        url:"../admin/getAllJobs",
        type : 'post',
        data : condition,
        dataType : 'json',
        success:function(result){
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    $("#table_myJob tbody").empty();
                    return;
                }
                if (result.data.data!=null){
                    console.log(result.data);
                    $("#table_myJob tbody").empty();
                    $.each(result.data.data, function (index, obj) {
                        var tr = appendJobNode(obj);
                        $("#table_myJob tbody").append(tr);
                        appendTabTitleById("table_myJob");
                    });
                    $(document).ready(function(){
                        $('#table_myJob').DataTable();
                    });
                } else{
                    $("#table_myJob tbody").empty();
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
            $("#table_myJob tbody").empty();
            var txt = "没有查询到符合条件的信息";
            alert(txt);
            return;
        },
    });
}

//删除资源
var delJobById = function(data) {
    $.ajax({
        url:"../admin/deleteJobById?jobId="+data,
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
                    var txt = "删除资源成功";
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
            var txt = "删除资源失败";
            alert(txt);
            return;
        },
        complete: function () {
            getMyJobs(condition);
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
    var status="保存";
    if(obj.jobStatus==0){
        status="保存"
    }else if(obj.jobStatus==1){
        status="待审核"
    }else if (obj.jobStatus==2){
        status="驳回"
    }else if (obj.jobStatus==3){
        status="已审核"
    }
    var jobDeadline1 = moment(obj.jobDeadline).format("YYYY-MM-DD HH:mm:ss");
    var jobTime1 = moment(obj.jobTime).format("YYYY-MM-DD HH:mm:ss");
    var sign = 0;
    var job_str = "<tr>"+
            "<td>"+obj.id+"</td>"+
            "<td>"+obj.jobTitle+"</td>"+
            "<td> "+status+"</td>"+
            "<td> "+obj.jobType+"</td>"+
            "<td> "+obj.appliCount+"</td>"+
            "<td> "+jobDeadline1+"</td>"+
            "<td> "+jobTime1+"</td>"+
            "<td>"+
            "<a  href =\"../system/jobInfo?jobId="+obj.id+"&sign="+sign+"\" >查看资源详情</a> |"+
            "<button type=\"button\" onclick=\"delJobById('"+obj.id+"')\" class='btn btn-link'>删除</button>";
    "<input type=\"hidden\" name=\"job_id\" value=\""+obj.id+"\">"+
    "</td>"+
    "</tr>";
    return job_str;
}
function delJob(data)
{
    $("#input_jobId").val(data);
    $(".pop").show();
    $(".popinto").show();
}

