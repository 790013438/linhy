
$(function(){
    queryMyInfo();
    $("#btn_save").click(function () {
        var var1 = $("#li_basic").attr("class");
        if(var1 == "active"){
            var data = getParams();
            if(!checkEmail(data.userEmail)){
                return;
            }
            if(!checkPhone(data.userPhone)){
                return;
            }
            if(!checkUserInformation(data)){
                return;
            }
            updateUser(data);
        }else{
            if(checkPassword()){
                var oldPassword =  $.trim($("#form-field-oldPass").val());
                var newPassword =  $.trim($("#form-field-newPass").val());
                var data={
                    oldPassword:oldPassword,
                    newPassword:newPassword,
                };
                if(!checkUserInformation1(data)){
                    alert("输入了空字符串或者信息不完善");
                    return;
                }
                updatePassword(data);
            }
        }
    });
});


/**
 * 重置密码
 */
var updatePassword = function(data) {
    $.ajax({
        url: "../user/updateUserPassword",
        type: 'post',
        data:data,
        dataType : 'json',
        error: function (obj, msg) {
            var txt = "重置密码失败";
            alert(txt);
            return;
        },
        complete: function () {

        },
        success: function (result) {
            if (result.success == true) {
                if(result.error == ""){
                    alert("密码修改成功");
                    $("#form-field-oldPass").val('');
                    $("#form-field-newPass").val('');
                    $("#form-field-rePass").val('');
                }
                else{
                    alert("密码修改失败");
                    $("#form-field-oldPass").val('');
                    $("#form-field-newPass").val('');
                    $("#form-field-rePass").val('');
                }
            } else {
                var txt = result.error;
                alert(txt);
                $("#form-field-oldPass").val('');
                $("#form-field-newPass").val('');
                $("#form-field-rePass").val('');
                return;
            }
        }
    });
}

/*
 * 验证密码
 */
function checkPassword() {
    var password=$('#form-field-newPass').val();
    var comPassword=$('#form-field-rePass').val();
    if(password===comPassword){
        document.getElementById("label_pass").style.color="#646464";
        return true;
    }
    else{
        alert("两次密码不一致");
        document.getElementById("label_pass").style.color="red";
        return false;
    }
}

//查询用户信息
var queryMyInfo = function() {
	$.ajax({
		url:"../user/queryUserInf",
		type : 'post',
		data : null,
		dataType : 'json',
        success: function (result) {
		    console.log(result);
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
 * 修改个人信息
 */
var updateUser = function (data) {
    $.ajax({
        url: "../user/updateUserInfo",
        type: 'post',
        data: data,
        dataType : 'json',
        error: function (obj, msg) {
            var txt = "修改个人信息失败";
            alert(txt);
            return;
        },
        complete: function () {
            queryMyInfo();
        },
        success: function (result) {
            if (result.success == true) {
                if (result.data > 0) {
                    alert("修改个人信息成功");
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

/**
 * 检测用户信息
 */
var checkUserInformation = function(data)
{
    var flag =true;

    for ( var p in data )
    {
        if (checknull(data[p])==false){
            if(p == "userName"){
                var name = "用户名";
            }
            if(p == "userRealName"){
                var name = "真实姓名";
            }
            if(p == "userDepartments"){
                var name = "院系";
            }
            if(p == "userMajor"){
                var name = "专业";
            }
            if(p == "userProfile"){
                var name = "用户简介";
            }
            if(p == "userPhone"){
                var name = "手机号";
            }
            if(p == "userEmail"){
                var name = "邮箱";
            }
            alert("请输入"+name);
            return false;
        }
    }
    return true;
}

/**
 * 检测用户信息
 */
var checkUserInformation1 = function(data)
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

$('#user-profile-3')
        .find('input[type=file]').ace_file_input({
    style:'well',
    btn_choose:'Change avatar',
    btn_change:null,
    no_icon:'icon-picture',
    thumbnail:'large',
    droppable:true,
    before_change: function(files, dropped) {
        var file = files[0];
        if(typeof file === "string") {//files is just a file name here (in browsers that don't support FileReader API)
            if(! (/\.(jpe?g|png|gif)$/i).test(file) ) return false;
        }
        else {//file is a File object
            var type = $.trim(file.type);
            if( ( type.length > 0 && ! (/^image\/(jpe?g|png|gif)$/i).test(type) )
                    || ( type.length == 0 && ! (/\.(jpe?g|png|gif)$/i).test(file.name) )//for android default browser!
            ) return false;

            if( file.size > 110000 ) {//~100Kb
                return false;
            }
        }

        return true;
    }
})
        .end().find('button[type=reset]').on(ace.click_event, function(){
    $('#user-profile-3 input[type=file]').ace_file_input('reset_input');
})

/**
 * 向个人信息设置页面填充用户信息
 */
var initUserEditForm = function (obj) {
    console.log(obj);
    $("#input_userName").val(obj.userName);
    $("#input_realName").val(obj.userRealName);
    $("#input_department").val(obj.userDepartments);
    $("#input_major").val(obj.userMajor);
    if(obj.userGender == "男"){
        $("input[name='form-field-radio']").get(0).checked=true;
    }else{
        $("input[name='form-field-radio']").get(1).checked=true;
    }
    $("#input_profile").val(obj.userProfile);
    $("#input_email").val(obj.userEmail);
    $("#input_phone").val(obj.userPhone);
    // if(obj.userPic==""||obj.userPic==null){
    //     $("#user_pic").attr("src", getRootPath()+"/resource/images/photos/user-avatar.png");
    // } else {
    //     var filepath=JSON.stringify(obj.userPic).replace("\"","").replace("\"","");
    //     $("#user_pic").attr("src",file_host._fileHost+file_host._fileDownload+filepath);
    // }
}

/**
 * 获取修改后的用户信息
 * @returns {{}}
 */
var getParams = function(){
    var userName= $.trim($("#input_userName").val());
    var realName = $.trim($("#input_realName").val());
    var userDepartments = $.trim($("#input_department").val());
    var userMajor = $.trim($("#input_major").val());
    var sex = $("input[type='radio']:checked").val();
    if(sex == 1){
        var userGender = "男";
    }else{
        var userGender = "女"
    }
    var userProfile = $("#input_profile").val();
    var userPhone = $("#input_phone").val();
    var userEmail = $("#input_email").val();
    var json = {};
    json.userName = userName;
    json.userRealName = realName;
    json.userDepartments = userDepartments;
    json.userMajor = userMajor;
    json.userGender = userGender;
    json.userProfile = userProfile;
    json.userPhone = userPhone;
    json.userEmail = userEmail;
    return json;

}





