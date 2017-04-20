var contextPath = window.location.href;
var arrHref = contextPath.split("userId=");
var userId = arrHref[1];
var condition = {
    userId:userId
};
$(function() {
    $('.menu-list').removeClass('active open');
    $("#userManage").addClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#systemStudent").addClass('active open');
    queryPersonalInf(condition);
    console.log("111"+userId);

})


    /**
     * 查询用户信息
     */
    var queryPersonalInf = function (data) {
        $.ajax({
            url: "../admin/getUserInfoById",
            type: 'post',
            data:data,
            dataType : 'json',
            success: function (result) {
                if (result.data != null) {
                    initUserEditForm(result.data);
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
    var initUserEditForm = function (obj) {
        $("#span_name").text(obj.userName);
        $("#span_sex").text(obj.userGender);
      $("#span_realName").text(obj.userRealName);
      $("#span_departments").text(obj.userDepartments);
      $("#span_major").text(obj.userMajor);
      $("#span_phone").text(obj.userPhone);
      $("#span_email").text(obj.userEmail);
      $("#span_profile").text(obj.userProfile);
   // if(obj.userPic==""||obj.userPic==null){
   //     $("#user_pic").attr("src", getRootPath()+"/resource/images/photos/user-avatar.png");
   //  } else {
   //     var filepath=JSON.stringify(obj.userPic).replace("\"","").replace("\"","");
   //     $("#user_pic").attr("src",file_host._fileHost+file_host._fileDownload+filepath);
   //  }
}




