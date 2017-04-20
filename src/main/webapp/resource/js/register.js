var process_request = "<img src='loading.gif' width='16' height='16' border='0' align='absmiddle'>正在数据处理中...";
var username_empty = "<span style='COLOR:#ff0000'>  × 用户名不能为空!</span>";
var username_shorter = "<span style='COLOR:#ff0000'> × 用户名长度不能少于 3 个字符。</span>";
var username_longer = "<span style='COLOR:#ff0000'> × 用户名长度不能大于 30个字符。</span>";
var username_invalid = "- 用户名只能是由字母数字以及下划线组成。";
var username_have_register = "<span style='COLOR:#ff0000'> × 用户名已经存在,请重新输入!</span>";
var username_can_register="<span style='COLOR:#006600'> √ 恭喜您！该用户名可以注册!</span>";
var password_empty = "<span style='COLOR:#ff0000'> × 登录密码不能为空。</span>";
var password_shorter_s = "<span style='COLOR:#ff0000'> × 登录密码不能少于 6 个字符。</span>";
var password_shorter_m = "<span style='COLOR:#ff0000'> × 登录密码不能多于 30 个字符。</span>";
var confirm_password_invalid = "<span style='COLOR:#ff0000'> × 两次输入密码不一致!</span>";
var email_empty = "<span style='COLOR:#ff0000'> × 邮箱不能为空！</span>";
var email_invalid = "<span style='COLOR:#ff0000'> × 邮箱格式出错！</span>";
var email_have_register = "<span style='COLOR:#ff0000'> × 该邮箱已被注册！ </span>";
var email_can_register = "<span style='COLOR:#006600'> √ 邮箱可以注册!</span>";
var info_can="<span style='COLOR:#006600'> √ 可以注册!</span>";
var info_right="<span style='COLOR:#006600'> √ 填写正确!</span>";
var phone_empty="<span style='COLOR:#ff0000'> × 手机号不能为空！</span>";
var phone_invalid = "<span style='COLOR:#ff0000'> × 手机格式出错！</span>";
var phone_can_register = "<span style='COLOR:#006600'> √ 手机号可以注册!</span>";
var phone_have_register="<span style='COLOR:#ff0000'> × 该手机号已被注册！ </span>";
var name_flag=false;
var email_flag=false;
var password_flag=false;
var accept_flag=false;
var phone_flag=false;

$(function(){

    $("#register").click(function () {
        var data = getParams();
        register(data);
    });
});

/*
 * 获取工程的路径
 */
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName
            .indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/'
        + webName + '/';
}
/*
 * 用户名检测
 */
function checkUserName(obj) {
    console.log(getRootPath());
    if (obj.value.length < 1){
        showInfo("username_notice", username_empty);
    } else {
        // 调用Ajax函数,向服务器端发送查询
        $.ajax({ //一个Ajax过程
            type: "post", //以post方式与后台沟通
            url :getRootPath()+"/user/checkName", //与此页面沟通
            dataType:'json',//返回的值以 JSON方式 解释
            data: 'username='+obj.value, //发给的数据
            success: function(json){//如果调用成功
                if(!json.success){
                    showInfo("username_notice", username_have_register);
                }else {
                    showInfo("username_notice", username_can_register);
                    name_flag=true;
                   change_submit();
                   return;
                }
            }
        });
    }
    name_flag=false;
change_submit();}
/*
 * 用户名检测是否包含非法字符
 */
function checks(t) {
    szMsg = "[#%&\'\"\\,;:=!^@]"
    for (i = 1; i < szMsg.length + 1; i++) {
        if (t.indexOf(szMsg.substring(i - 1, i)) > -1) {
            return false;
        }
    }
    return true;
}
/*
 * 邮箱检测
 */
function checkEmail(email) {
    var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/
    if (email.value.length < 1) {
        showInfo("email_notice", email_empty);
    } else if (!re.test(email.value)) {
        showInfo("email_notice", email_invalid);
    } else {
        // 调用Ajax函数,向服务器端发送查询
        $.ajax({ //一个Ajax过程
            type: "post", //以post方式与后台沟通
            url :getRootPath()+"/user/checkMail", //与此页面沟通
            dataType:'json',//返回的值以 JSON方式 解释
            data: 'email='+email.value, //发给的数据
            success: function(json){//如果调用成功

                if(json.success== false){
                    console.log(json);
                    showInfo("email_notice", email_have_register);
                }else {
                    showInfo("email_notice", email_can_register);
                    email_flag=true;
change_submit();                    return;
                }
            }
        });
    }
    email_flag=false;
change_submit();}



/*
 * 密码检测
 */
function checkPassword( password )
{
    if(password.value.length < 1){
        password_flag=false;
        showInfo("password_notice",password_empty);
    }
    else
    {
        showInfo("password_notice",info_right);
    }
}

/*
 * 密码确认检测
 */
function checkConformPassword(conform_password)
{
    var password = $("#password").val();
    if (password.length < 1)  {
        showInfo("conform_password_notice",password_empty);

    } else if ( conform_password.value!= password)
    {
        showInfo("conform_password_notice",confirm_password_invalid);
    }
    else
    {
        showInfo("conform_password_notice",info_right);
        password_flag=true;
     change_submit();
        return;
    }
    password_flag=false;
    change_submit();

}

/**
 * 手机号检测
 * @param phone
 */
function checkPhone(phone) {
    var re = /0?(13|14|15|18)[0-9]{9}/
    if (phone.value.length < 1) {
        showInfo("phone_notice", phone_empty);
    } else if (!re.test(phone.value)) {
        showInfo("phone_notice", phone_invalid);
    }else {
        $.ajax({ //一个Ajax过程
            type: "post", //以post方式与后台沟通
            url :getRootPath()+"/user/checkPhone", //与此页面沟通
            dataType:'json',//返回的值以 JSON方式 解释
            data: 'phone='+phone.value, //发给的数据
            success: function(json){//如果调用成功

                if(json.success== false){
                    console.log(json);
                    showInfo("phone_notice", phone_have_register);
                }else {
                    showInfo("phone_notice",phone_can_register);
                    phone_flag=true;
       change_submit();
                    return;
                }
            }
        });

    }
    phone_flag=false;
   change_submit();
}


/*
/*
 * 按钮状态设置
 */
function change_submit()
{
    if(name_flag&&email_flag&&password_flag&&phone_flag){
        document.getElementById("register").disabled=false;
        // document.forms['formUser'].elements['Submit1'].disabled = '';
    }
    else
    {
        document.getElementById("register").disabled=true;
        // document.forms['formUser'].elements['Submit1'].disabled = 'disabled';
    }

}
/* 公用程序
 */
function showInfo(target,Infos){
    document.getElementById(target).innerHTML = Infos;
}
function showclass(target,Infos){
    document.getElementById(target).className = Infos;
}

function register(data) {
    console.log(data);
    $.ajax({ //一个Ajax过程
        type: "post", //以post方式与后台沟通
        url :getRootPath()+"/user/userRegister", //与此页面沟通
        dataType:'json',//返回的值以 JSON方式 解释
        data: data, //发给的数据
        success: function(json){//如果调用成功
            if(json.success== false){
                alert(json.error);
            }else {
                alert(json.error);
            }
        },
        error:function (json) {
            console.log(json);
            alert(json.error);
        }
    });
}

/**
* 获取注册用户信息
* @returns {{}}
*/
var getParams = function(){
    var userName= $.trim($("#username").val());
    var sex = $("input[type='radio']:checked").val();
    if(sex == 1){
        var userGender = "男";
    }else{
        var userGender = "女"
    }
    var userPhone = $("#phone").val();
    var userEmail = $("#email").val();
    var userPassword = $("#password").val();
    var json = {};
    json.userName = userName;
    json.userGender = userGender;
    json.userPhone = userPhone;
    json.userEmail = userEmail;
    json.userPassword = userPassword;
    return json;

}
