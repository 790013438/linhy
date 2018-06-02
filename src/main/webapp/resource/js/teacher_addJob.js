$(function(){
    /*文件上传提示信息*/
    var url=location.search;
    if(url.indexOf("?")!=-1){
        var str=url.substr(1);
        if (str=="success"){
            alert("文件上传成功！")
        }
        if(str=="false"){
            alert("文件上传失败！")
        }
    }

    $("#btn_saveJob").click(function () {
        var data = getParams();
        document.getElementById("btn_saveFile").removeAttribute("disabled");
        if(!checkHours(data.jobHours)){
        }
        if(!checkJobInformation(data)){
            alert("输入了空字符串或者信息不完善");
        }
        console.log(data);
        addJob(JSON.stringify(data));
    });
});

//发布资源s
var addJob = function (data) {
    $.ajax({
        url: "../teacher/addJobs",
        type: 'post',
        data: {
            json:data
        },
        dataType : 'json',
        error: function (obj, msg) {
            var txt = "保存资源信息失败";
            alert(txt);
            return;
        },
        complete: function () {
        },
        success: function (result) {
            if (result.success == true) {
                if (result.data > 0) {
                    alert("保存资源信息成功，可以提交审核");
                    window.location.href='index';
                }
                else {
                    var txt = result.error;
                    alert(txt);
                    return;
                }
            }else{
                var txt = result.error;
                alert(txt);
                return;
            }
        }
    });
}
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
        document.getElementById("job_hours").value=null;
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
  var jobIntroduction = $("#input_introduction").val();
    var jobHours = $("#job_hours").val();
    var jobDeadline = $("#input_deadline").val();
    var json = {};
    json.jobTitle = jobTitle;
    json.jobType = jobType;
    json.jobIntroduction = jobIntroduction;
    json.jobHours = jobHours;
    json.deadline = jobDeadline;
    return json;

}








