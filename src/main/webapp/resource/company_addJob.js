
$(function(){
    $("#btn_saveJob").click(function () {
        var data = getParams();
        if(!checkEmail(data.compEmail)){
            return;
        }
        if(!checkPhone(data.compPhone)){
            return;
        }
        if(!checkUserInformation(data)){
            return;
        }
        updateCompany(data);
    });
});

//发布资源
var updateCompany = function (data) {
    $.ajax({
        url: "../company/updateCompanyInfo",
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
    var compAccount= $.trim($("#input_jobName").val());
    var compName = $.trim($("#comp_name").val());
    var compContacts = $.trim($("#comp_contacts").val());
    var compAddress = $.trim($("#comp_address").val());
    var compInfo = $("#comp_info").val();
    var compEmail = $("#input_email").val();
    var commWebsite = $("#comm_website").val();
    var compPhone = $("#input_phone").val();
    var json = {};
    json.compAccount = compAccount;
    json.compName = compName;
    json.compContacts = compContacts;
    json.compAddress = compAddress;
    json.compInfo = compInfo;
    json.compEmail = compEmail;
    json.commWebsite = commWebsite;
    json.compPhone = compPhone;
    return json;

}








