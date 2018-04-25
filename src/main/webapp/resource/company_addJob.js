
$(function(){
    $("#btn_saveJob").click(function () {
        var data = getParams();
        if(!checkEmail(data.teaEmail)){
            return;
        }
        if(!checkPhone(data.teaPhone)){
            return;
        }
        if(!checkUserInformation(data)){
            return;
        }
        updateTeacher(data);
    });
});

//发布资源
var updateTeacher = function (data) {
    $.ajax({
        url: "../teacher/updateTeacherInfo",
        type: 'post',
        data: data,
        dataType : 'json',
        error: function (obj, msg) {
            var txt = "保存资源失败";
            alert(txt);
            return;
        },
        complete: function () {
            queryMyInfo();
        },
        success: function (result) {
            if (result.success == true) {
                if (result.data > 0) {
                    alert("保存资源成功，可以提交审核");
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
        alertShow("输入人数不合理");
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
        alertShow ("输入时长不合理");
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
        alertShow ("输入薪资不合理");
        return false;
    }
}
/**
 * 获取修改后的用户信息
 * @returns {{}}
 */
var getParams = function(){
    var teaAccount= $.trim($("#input_jobName").val());
    var teaName = $.trim($("#tea_name").val());
    var teaContacts = $.trim($("#tea_contacts").val());
    var teaAddress = $.trim($("#tea_address").val());
    var teaInfo = $("#tea_info").val();
    var teaEmail = $("#input_email").val();
    var commWebsite = $("#comm_website").val();
    var teaPhone = $("#input_phone").val();
    var json = {};
    json.teaAccount = teaAccount;
    json.teaName = teaName;
    json.teaContacts = teaContacts;
    json.teaAddress = teaAddress;
    json.teaInfo = teaInfo;
    json.teaEmail = teaEmail;
    json.commWebsite = commWebsite;
    json.teaPhone = teaPhone;
    return json;

}








