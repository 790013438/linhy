var contextPath = window.location.href;
var arrHref = contextPath.split("teacherId=");
var teacherId = arrHref[1];
var condition = {
    teacherId:teacherId
};
$(function() {
    $('.menu-list').removeClass('active open');
    $("#userManage").addClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#systemTeacher").addClass('active open');
    queryTeacherInf(condition);

})


    /**
     * 查询教师信息
     */
    var queryTeacherInf = function (condition) {
        $.ajax({
            url: "../admin/getTeacherInfoById",
            type: 'post',
            data:condition,
            dataType : 'json',
            success: function (result) {
                if (result.data != null) {
                    initTeacherForm(result.data);
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
    var initTeacherForm = function (obj) {
    $("#teacher_name").text(obj.teaName);
    $("#span_account").text(obj.teaAccount);
        $("#span_name").text(obj.teaName);
      $("#span_contacts").text(obj.teaContacts);
      $("#span_address").text(obj.teaAddress);
      $("#span_info").text(obj.teaInfo);
      $("#span_phone").text(obj.teaPhone);
      $("#span_email").text(obj.teaEmail);
     /* $("#span_website").text(obj.commWebsite);*/
   // if(obj.userPic==""||obj.userPic==null){
   //     $("#user_pic").attr("src", getRootPath()+"/resource/images/photos/user-avatar.png");
   //  } else {
   //     var filepath=JSON.stringify(obj.userPic).replace("\"","").replace("\"","");
   //     $("#user_pic").attr("src",file_host._fileHost+file_host._fileDownload+filepath);
   //  }
}




