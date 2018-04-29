
$(function(){
    $('.menu-list').removeClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#li_myInfo").addClass('active open');
    queryMyInfo();
    $("#btn_save").click(function () {
        var var1 = $("#li_basic").attr("class");
        if(var1 == "active"){
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
        url: "../teacher/updateCompPassword",
        type: 'post',
        data:data,
        dataType : 'json',
        error: function (obj, msg) {
            var txt = "修改密码失败";
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
		url:"../teacher/getTeacherInfoById",
		type : 'post',
		data : null,
		dataType : 'json',
        success: function (result) {
		    console.log(result);
            if (result.data != null) {
                initTeacherForm(result.data);
            }
            else{
                var txt = "无教师信息";
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
var updateTeacher = function (data) {
    $.ajax({
        url: "../teacher/updateTeacherInfo",
        type: 'post',
        data: data,
        dataType : 'json',
        error: function (obj, msg) {
            var txt = "修改教师信息失败";
            alert(txt);
            return;
        },
        complete: function () {
            queryMyInfo();
        },
        success: function (result) {
            if (result.success == true) {
                if (result.data > 0) {
                    alert("修改教师信息成功");
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
            if(p == "teaAccount"){
                var name = "账号";
            }
            if(p == "teaName"){
                var name = "教师名";
            }
            if(p == "teaContacts"){
                var name = "教师职称";
            }
            if(p == "teaAddress"){
                var name = "教师地址";
            }
            if(p == "teaInfo"){
                var name = "教师简介";
            }
            if(p == "teaEmail"){
                var name = "邮箱";
            }
            if(p == "teaPhone"){
                var name = "联系电话";
            }
/*            if(p == "commWebsite"){
                var name = "教师网站";
            }*/
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
 * 向个人信息设置页面填充教师信息
 */
var initTeacherForm = function (obj) {
    console.log(obj);
    $("#tea_account").val(obj.teaAccount);
    $("#tea_name").val(obj.teaName);
    $("#tea_contacts").val(obj.teaContacts);
    $("#tea_address").val(obj.teaAddress);
    $("#tea_info").val(obj.teaInfo);
    $("#input_email").val(obj.teaEmail);
    $("#input_phone").val(obj.teaPhone);
/*    $("#comm_website").val(obj.commWebsite);*/
}

/**
 * 获取修改后的用户信息
 * @returns {{}}
 */
var getParams = function(){
    var teaAccount= $.trim($("#tea_account").val());
    var teaName = $.trim($("#tea_name").val());
    var teaContacts = $.trim($("#tea_contacts").val());
    var teaAddress = $.trim($("#tea_address").val());
    var teaInfo = $("#tea_info").val();
    var teaEmail = $("#input_email").val();
/*    var commWebsite = $("#comm_website").val();*/
    var teaPhone = $("#input_phone").val();
    var json = {};
    json.teaAccount = teaAccount;
    json.teaName = teaName;
    json.teaContacts = teaContacts;
    json.teaAddress = teaAddress;
    json.teaInfo = teaInfo;
    json.teaEmail = teaEmail;
/*    json.commWebsite = commWebsite;*/
    json.teaPhone = teaPhone;
    return json;

}





