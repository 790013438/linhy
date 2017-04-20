$(function(){
    $("#btn_saveJob").click(function () {
        var data = getParams();
        if(!checkNumber(data.jobDemandNumber)){
        }
        if(!checkHours(data.jobHours)){
        }
        if(!checkSalary(data.jobSalary)){
        }
        if(!checkJobInformation(data)){
            alert("输入了空字符串或者信息不完善");
        }
        console.log(data);
        // addJob(data);
    });
});

// //发布兼职
// var addJob = function (data) {
//     $.ajax({
//         url: "../company/addJobs",
//         type: 'post',
//         data: data,
//         dataType : 'json',
//         error: function (obj, msg) {
//             var txt = "保存兼职失败";
//             alert(txt);
//             return;
//         },
//         complete: function () {
//         },
//         success: function (result) {
//             if (result.success == true) {
//                 if (result.data > 0) {
//                     alert("保存兼职成功，可以提交审核");
//                 }
//                 else {
//                     var txt = result.error;
//                     alert(txt);
//                     return;
//                 }
//             }else{
//                 var txt = result.error;
//                 alert(txt);
//                 return;
//             }
//         }
//     });
// }
function checkNumber(obj) {
    var num=/^[1-9]\d*$/;
    if ((num.test(obj))){// 判断是否是数字
        return true;
    } else {
        alert("输入人数不合理");
        return false;
    }
}
function checkHours(obj)
{
    var num = /^\d{1,2}(\.\d{1,2})?$/;
    if ((num.test (obj)))
    {// 判断是否是数字
        return true;
    } else
    {
        alert ("输入时长不合理");
        return false;
    }
}
function checkSalary(obj)
{
    //var num = /^(0|([1-9]\d*))(\.\d+)?$/;
    var num = /^\d{1,6}(\.\d{1,2})?$/;
    if ((num.test (obj) || obj == 0))
    {// 判断是否是数字
        return true;
    } else
    {
        alert ("输入薪资不合理");
        return false;
    }
}
/**
 * 检测用户信息
 */
var checkJobInformation = function(data)
{
    var flag =true;

    for ( var p in data )
    {
        if (checknull(data[p])==false){
            return false;
        }
    }
    return true;
}
/**
 * 获取修改后的用户信息
 * @returns {{}}
 */
var getParams = function(){
    var jobTitle= $.trim($("#input_jobName").val());
    var jobType = $.trim($("#input_jobType").val());
    var jobDemandNumber = $.trim($("#input_jobNumber").val());
    var jobAddress = $.trim($("#input_jobAddress").val());
    var jobRequiresGender = $("#requires_gender").val();
    var jobIntroduction = $("#input_introduction").val();
    var jobRemarks = $("#job_remarks").val();
    var jobSalaryType = $("#salary_type").val();

    var jobSalary = $("#salary_salary").val();
    var jobHours = $("#job_hours").val();
    var jobTime= $("#input_jobTime").val();
    var jobDeadline = $("#input_deadline").val();
    var json = {};
    json.jobTitle = jobTitle;
    json.jobType = jobType;
    json.jobSalary = jobSalary;
    json.jobDemandNumber = jobDemandNumber;
    json.jobRequiresGender = jobRequiresGender;
    json.jobAddress = jobAddress;
    json.jobIntroduction = jobIntroduction;
    json.jobRemarks = jobRemarks;
    json.jobSalaryType = jobSalaryType;
    json.jobHours = jobHours;
    json.jobTime = jobTime;
    json.jobDeadline = jobDeadline;
    return json;

}








