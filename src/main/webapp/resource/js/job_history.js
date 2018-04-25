var condition = {
    jobStatus:"5",
};
$(function(){

    queryMyAppliJobs(condition);

    $("#btn_delApplication").click(function () {
            var appliId = $("#input_applId").val();
            var data = {
                applicationId:appliId
            };
        closepop();
        delApplicationById(data);
    });
});

//查询资源历史
var queryMyAppliJobs = function(condition) {
    $.ajax({
        url:"../user/getMyAppliSituation",
        type : 'post',
        data : condition,
        dataType : 'json',
        success:function(result){
            console.log(result);
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    $("#myJobHistory tbody").empty();
                    return;
                }
                if (result.data!=null){
                    $("#myJobHistory tbody").empty();
                    $.each(result.data, function (index, obj) {
                        var tr = appendJobNode(obj);
                        $("#myJobHistory tbody").append(tr);
                        appendTabTitleById("myJobHistory");
                    });
                    $(document).ready(function(){
                        $('#myJobHistory').DataTable();
                    });
                } else{
                    $("#myJobHistory tbody").empty();
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
            $("#myJobHistory tbody").empty();
            var txt = "没有查询到符合条件的信息";
            alert(txt);
            return;
        },
    });
}

//删除指定报名记录
var delApplicationById = function(data) {
    $.ajax({
        url:"../user/delApplication",
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
                    var txt = "删除资源记录成功";
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
            var txt = "删除资源记录失败";
            alert(txt);
            return;
        },
        complete: function () {
            queryMyAppliJobs(condition);
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
            "<td> "+"已结束"+"</td>"+
            "<td> "+obj.jobTeacherName+"</td>"+
            "<td> "+jobTime1+"</td>"+
            "<td> "+obj.jobSalaryType+"</td>"+
            "<td> "+obj.jobSalary+"</td>"+
            "<td>"+
            "<a  href =\"../student/jobInfo?jobId="+obj.appliJobId+"\" >查看资源详情</a> |"+
            "<button type=\"button\" class='btn btn-link' onclick=\"delAppli('"+obj.id+"')\" >删除</button>";
    "<input type=\"hidden\" name=\"application_id\" value=\""+obj.id+"\">"+
    "</td>"+
    "</tr>";
    return job_str;
}
function delAppli(data)
{
    $("#input_applId").val(data);
    $(".pop").show();
    $(".popinto").show();
}
