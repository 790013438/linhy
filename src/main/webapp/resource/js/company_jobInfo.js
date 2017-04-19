var contextPath = window.location.href;
var arrHref = contextPath.split("jobId=");
var jobId = arrHref[1];
$("#input_jobId").val(jobId);
var condition = {
    jobId:jobId
};
$(function(){
    getJobInfoByID(condition);
    getAppliByID(condition);
    $("#btn_agree").click(function () {
        closepop();
        var userId = $("#input_userId").val();
        var jobDemandNumber = $("#input_jobDemandNumber").val();
        var condition = {
            jobId:jobId,
            appliStatus:"appli_successful",
            userId:userId,
            demandNumber:jobDemandNumber
        };
        updateAppliStatus(condition);
    });
    $("#btn_refuse").click(function () {
        var userId = $("#input_userId").val();
        var jobDemandNumber = $("#input_jobDemandNumber").val();
        closepop();
        var condition = {
            jobId:jobId,
            appliStatus:"appli_failed",
            userId:userId,
            demandNumber:jobDemandNumber
    };
        updateAppliStatus(condition);
    });
    $("#btn_delRecord").click(function () {
        var appliId = $("#input_appliId").val();
        closepop();
        var condition = {
            applicationId:appliId,
            jobId:jobId
        };
        delApplicationById(condition);
    });
});

//查询兼职详情
var getJobInfoByID = function(condition)
        {
            $.ajax ({
                url: "../company/getJobDetails",
                type: 'post',
                data: condition,
                dataType: 'json',
                success: function (result)
                {
                    if (result.success == true)
                    {
                        if (result.error != "")
                        {
                            $ ("#ul_jobDetail").empty ();
                            $ ("#ul_jobDetail").append ("<li>该兼职不存在</li>");
                            return;
                        }
                        if (result.data != null)
                        {
                            $ ("#ul_jobDetail").empty ();
                            //填充信息
                            var detail_str = initJobDetailForm (result.data);
                            console.log (result.data);
                            $ ("#ul_jobDetail").append (detail_str);
                        } else
                        {
                            $ ("#ul_jobDetail").empty ();
                            $ ("#ul_jobDetail").append ("<li>该兼职不存在</li>");
                            return;
                        }
                    } else
                    {
                        //还得先清空所有行
                        $ ("#ul_jobDetail").empty ();
                        var txt = result.error;
                        alert (txt);
                        return;
                    }
                },
                error: function (obj, msg)
                {
                    //还得先清空所有行
                    $ ("#ul_jobDetail").empty ();
                    var txt = "没有查询到符合条件的信息";
                    alert (txt);
                    return;
                },
            });
        }

    //删除指定报名记录
    var delApplicationById = function(data) {
        $.ajax({
            url:"../company/updateCompSign",
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
                        var txt = "删除报名记录成功";
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
                var txt = "删除报名记录失败";
                alert(txt);
                return;
            },
            complete: function () {
                getAppliByID(condition);
            }
        });
    }

//查询兼职报名情况
var getAppliByID = function(condition) {
    $.ajax({
        url:"../company/getEnrollmentSituation",
        type : 'post',
        data : condition,
        dataType : 'json',
        success:function(result){
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    $("#table_wating tbody").empty();
                    $("#table_success tbody").empty();
                    $("#table_fail tbody").empty();
                    return;
                }
                if (result.data!=null){
                    console.log(result.data);
                    $("#table_wating tbody").empty();
                    $("#table_success tbody").empty();
                    $("#table_fail tbody").empty();
                    $.each(result.data, function (index, obj) {
                        if(obj.appliStatus == 'appli_apply'){
                            var tr = appendWaitNode(obj);
                            $("#table_wating tbody").append(tr);
                            appendTabTitleById("table_wating");
                        }else if(obj.appliStatus == 'appli_successful'){
                            var tr = appendSuccessNode(obj);
                            $("#table_success tbody").append(tr);
                            appendTabTitleById("table_success");
                        }else{
                            var tr = appendFailNode(obj);
                            $("#table_fail tbody").append(tr);
                            appendTabTitleById("table_fail");
                        }
                    });
                    $(document).ready(function(){
                        $('.table-bordered').DataTable();
                        //$('#table_success').DataTable();
                        //$('#table_fail').DataTable();
                    });
                } else{
                    $("#table_wating tbody").empty();
                    $("#table_success tbody").empty();
                    $("#table_fail tbody").empty();
                    var txt = "没有查询到符合条件的信息";
                    alert(txt);
                    return;
                }
            } else {
                //还得先清空所有行
                $("#table_wating tbody").empty();
                $("#table_success tbody").empty();
                $("#table_fail tbody").empty();
                return;
            }
        },
        error : function(obj, msg) {
            //还得先清空所有行
            $("#table_wating tbody").empty();
            $("#table_success tbody").empty();
            $("#table_fail tbody").empty();
            var txt = "没有查询到符合条件的信息";
            alert(txt);
            return;
        },
    });
}

//筛选用户
var updateAppliStatus = function(data) {
    console.log(data);
    $.ajax({
        url:"../company/screenApplicationUser",
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
                    var txt = "修改用户报名状态成功";
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
            var txt = "修改用户报名状态失败";
            alert(txt);
            return;
        },
        complete: function () {
            getAppliByID(condition);
        }
    });
}
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
var initJobDetailForm = function(obj) {
    $("#input_jobDemandNumber").val(obj.jobDemandNumber);
    if(obj.jobTitle != null){
        var tr = "<li><span>标题：</span>"+obj.jobTitle+"</li>";
    }else{
        var tr = "<li><span>标题：</span>无</li>";
    }
    if(obj.jobType != null){
        tr = tr + "<li><span>兼职类型：</span>"+obj.jobType+"</li>";
    }else{
        tr = tr + "<li><span>兼职类型：</span>无</li>";
    }
    if(obj.jobCompanyName != null){
        tr = tr + "<li><span>企业名称：</span>"+obj.jobCompanyName+"</li>";
    }else{
        tr = tr + "<li><span>企业名称：</span>无</li>";
    }
    if(obj.jobDemandNumber != null){
        tr = tr + "<li><span>需求人数：</span>"+obj.jobDemandNumber+"<span>（人）</span></li>";
    }else{
        tr = tr + "<li><span>需求人数：</span>无</li>";
    }
    if(obj.jobRequiresGender != null){
        tr = tr + "<li><span>性别要求：</span>"+obj.jobRequiresGender+"</li>";
    }else{
        tr = tr + "<li><span>性别要求：</span>无</li>";
    }
    if(obj.jobSalaryType != null){
        tr = tr + "<li><span>薪资类型：</span>"+obj.jobSalaryType+"</li>";
    }else{
        tr = tr + "<li><span>薪资类型：</span>无</li>";
    }
    if(obj.jobHours != null){
        tr = tr + "<li><span>每日工作时长：</span>"+obj.jobHours+"<span>（时）</span></li>";
    }else{
        tr = tr + "<li><span>每日工作时长：</span>无</li>";
    }
    if(obj.jobSalary != null){
        tr = tr + "<li><span>薪资金额：</span>"+obj.jobSalary+"<span>（元）</span></li>";
    }else{
        tr = tr + "<li><span>薪资金额：</span>无</li>";
    }
    if(obj.jobTime != null){
        var jobTime1 = moment(obj.jobTime).format("YYYY-MM-DD HH:mm:ss");
         tr = tr + "<li><span>兼职开始时间：</span>"+jobTime1+"</li>";
    } else{
         tr = tr + "<li><span>兼职开始时间：</span>无</li>";
    }
    if(obj.jobDeadline != null){
        var jobDeadlineTime = moment(obj.jobDeadline).format("YYYY-MM-DD HH:mm:ss");
         tr = tr + "<li><span>报名截止时间：</span>"+jobDeadlineTime+"</li>";
    } else{
         tr = tr + "<li><span>报名截止时间：</span>无</li>";
    }
    if(obj.jobAddress != null){
        tr = tr + "<li><span>工作地点：</span>"+obj.jobAddress+"</li>";
    }else{
        tr = tr + "<li><span>工作地点：</span>无</li>";
    }
    if(+obj.jobIntroduction != null){
        tr = tr + "<li><span>兼职描述信息：</span>" +
                "<textarea style='width:70%;' disabled=\"disabled\">"+obj.jobIntroduction+"</textarea>" +
                "</li>";
    }else{
        tr = tr + "<li><span>兼职描述信息：</span>无</li>";
    }
    return tr;
}

var appendWaitNode = function(obj) {
    var job_str = "<tr>"+
            "<td>"+obj.appliUserId+"</td>"+
            "<td>"+obj.userName+"</td>"+
            "<td> "+obj.userGender+"</td>"+
            "<td> "+obj.userRealName+"</td>"+
            "<td> "+obj.userMajor+"</td>"+
            "<td> "+obj.userEmail+"</td>"+
            "<td> "+obj.userPhone+"</td>"+
            "<td>"+
            "<a  href =\"../company/showInfo?userId="+obj.appliUserId+"\" >查看用户详情</a> |"+
            "<button type=\"button\"  onclick=\"screenUser('"+obj.appliUserId+"')\" class='btn btn-link'>审核</button>";
    "<input type=\"hidden\" name=\"job_id\" value=\""+obj.id+"\">"+
    "</td>"+
    "</tr>";
    return job_str;
}
var appendSuccessNode = function(obj) {
    var job_str = "<tr>"+
            "<td>"+obj.appliUserId+"</td>"+
            "<td>"+obj.userName+"</td>"+
            "<td> "+obj.userGender+"</td>"+
            "<td> "+obj.userRealName+"</td>"+
            "<td> "+obj.userMajor+"</td>"+
            "<td> "+obj.userEmail+"</td>"+
            "<td> "+obj.userPhone+"</td>"+
            "<td>"+
            "<a  href =\"../company/showInfo?userId="+obj.appliUserId+"\" >查看用户详情</a> ";
    "</td>"+
    "</tr>";
    return job_str;
}
var appendFailNode = function(obj) {
    var job_str = "<tr>"+
            "<td>"+obj.appliUserId+"</td>"+
            "<td>"+obj.userName+"</td>"+
            "<td> "+obj.userGender+"</td>"+
            "<td> "+obj.userRealName+"</td>"+
            "<td> "+obj.userMajor+"</td>"+
            "<td> "+obj.userEmail+"</td>"+
            "<td> "+obj.userPhone+"</td>"+
            "<td>"+
            "<a  href =\"../company/showInfo?userId="+obj.appliUserId+"\" >查看用户详情</a> |"+
            "<button type=\"button\"  onclick=\"delAppliRecord('"+obj.id+"')\" class='btn btn-link'>删除</button>";
    "</td>"+
    "</tr>";
    return job_str;
}

function screenUser(data) {
    console.log(data);
    $("#input_userId").val(data);
    $(".pop").show();
    $("#popinto_screen").show();
}

function delAppliRecord(data) {
    $("#input_appliId").val(data);
    $(".pop").show();
    $("#popinto_delRecord").show();
}
function closepop(){
    $(".pop").hide();
    $(".popinto").hide();
}



