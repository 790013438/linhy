$(function(){
    var condition = {
        jobStatus:"3",
    };
    //弹出是否退出兼职弹窗
    queryMyAppliJobs(condition);
    $("#btn_quitJob").click(function () {
        $("#popTips_edit").show();
    });
    //确认是否退出兼职
    $("#btn_ifQuitJob").click(function () {
        var appliId = $(this).nextAll("input[name='application_id']").val();
        var data = {
            applicationId:appliId
        };
        quitJobById(data);
    });

});

//查询兼职报名情况
var queryMyAppliJobs = function(condition) {
    $.ajax({
        url:"../user/getMyAppliSituation",
        type : 'post',
        data : condition,
        dataType : 'json',
        success:function(result){
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    $("#myAppliJobs tbody").empty();
                    return;
                }
                if (result.data!=null){
                    $("#myAppliJobs tbody").empty();
                    $.each(result.data, function (index, obj) {
                        var tr = appendJobNode(obj);
                        $("#myAppliJobs tbody").append(tr);
                        appendTabTitleById("myAppliJobs");
                    });
                    $(document).ready(function(){
                        $('#myAppliJobs').DataTable();
                    });
                } else{
                    $("#myAppliJobs tbody").empty();
                    var txt = "没有查询到符合条件的信息";
                    alert(txt);
                    return;
                }
            } else {
                //还得先清空所有行
                alert(result.error);
                return;
            }
        },
        error : function(obj, msg) {
            //还得先清空所有行
            $("#myAppliJobs tbody").empty();
            var txt = "没有查询到符合条件的信息";
            alert(txt);
            return;
        },
    });
}

//报名指定兼职
var quitJobById = function(data) {
    $.ajax({
        url:"../user/quitJob",
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
                    var txt = "退出兼职成功";
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
            var txt = "退出兼职失败";
            alert(txt);
            return;
        },
        complete: function () {
            getJobInfoByID(condition);
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
    var jobTime1 = moment(obj.jobTime).format("YYYY-MM-DD HH:mm:ss");
    var job_str = "<tr>"+
            "<td>"+obj.jobTitle+"</td>"+
            "<td> "+jobTime1+"</td>"+
            "<td> "+obj.jobType+"</td>"+
            "<td> "+obj.jobSalaryType+"</td>"+
            "<td> "+obj.jobSalary+"</td>"+
            "<td> "+obj.jobHours+"</td>"+
            "<td> "+obj.jobCompanyName+"</td>"+
            "<td> "+obj.appliStatus+"</td>"+
            "<td>"+
            "<a  href =\"../student/jobInfo?jobId="+obj.appliJobId+"\" >查看兼职详情</a> |";
    if(obj.appliStatus != "报名失败"){
        var job_str1 = job_str +"<button type=\"button\" onclick=\"applicationJob('"+obj.id+"')\" class='btn btn-link btn_quitJob'>退出兼职</button>";
    }else{
        var job_str1 = job_str +"<button type=\"button\" disabled='disabled' class='btn btn-link'>退出兼职</button>";
        // var job_str1 = job_str +"<a  href=\"javascript:getJobDetails('"+obj.id+"');\" class='disabled'>已报名</a>";
    }
    "<input type=\"hidden\" name=\"application_id\" value=\""+obj.id+"\">"+
    "</td>"+
    "</tr>";
    return job_str1;
}