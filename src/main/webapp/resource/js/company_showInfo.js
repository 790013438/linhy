var contextPath = window.location.href;
var arrHref = contextPath.split("companyId=");
var companyId = arrHref[1];
var condition = {
    companyId:companyId
};
$(function() {
    $('.menu-list').removeClass('active open');
    $("#userManage").addClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#systemCompany").addClass('active open');
    queryCompanyInf(condition);

})


    /**
     * 查询企业信息
     */
    var queryCompanyInf = function (condition) {
        $.ajax({
            url: "../admin/getCompanyInfoById",
            type: 'post',
            data:condition,
            dataType : 'json',
            success: function (result) {
                if (result.data != null) {
                    initCompanyForm(result.data);
                }
                else{
                    var txt = "无用户信息";
                    alert(txt);
                    return;
                }
            },
            error: function () {
            }
        });
    }


/**
     * 向个人信息设置页面填充用户信息
     */
    var initCompanyForm = function (obj) {
    $("#company_name").text(obj.compName);
    $("#span_account").text(obj.compAccount);
        $("#span_name").text(obj.compName);
      $("#span_contacts").text(obj.compContacts);
      $("#span_address").text(obj.compAddress);
      $("#span_info").text(obj.compInfo);
      $("#span_phone").text(obj.compPhone);
      $("#span_email").text(obj.compEmail);
      $("#span_website").text(obj.commWebsite);
   // if(obj.userPic==""||obj.userPic==null){
   //     $("#user_pic").attr("src", getRootPath()+"/resource/images/photos/user-avatar.png");
   //  } else {
   //     var filepath=JSON.stringify(obj.userPic).replace("\"","").replace("\"","");
   //     $("#user_pic").attr("src",file_host._fileHost+file_host._fileDownload+filepath);
   //  }
}




