var process_request = "<img src='loading.gif' width='16' height='16' border='0' align='absmiddle'>正在数据处理中...";
var username_empty = "<span style='COLOR:#ff0000'>  × 用户名不能为空!</span>";
var username_invalid = "- 用户名只能是由字母数字以及下划线组成。";
var username_have_register = "<span style='COLOR:#ff0000'> × 用户名已经存在,请重新输入!</span>";
var username_can_register = "<span style='COLOR:#006600'> √ 恭喜您！该用户名可以注册!</span>";
var password_empty = "<span style='COLOR:#ff0000'> × 登录密码不能为空。</span>";
var confirm_password_invalid = "<span style='COLOR:#ff0000'> × 两次输入密码不一致!</span>";
var email_empty = "<span style='COLOR:#ff0000'> × 邮箱不能为空！</span>";
var email_invalid = "<span style='COLOR:#ff0000'> × 邮箱格式出错！</span>";
var email_have_register = "<span style='COLOR:#ff0000'> × 该邮箱已被注册！ </span>";
var email_can_register = "<span style='COLOR:#006600'> √ 邮箱可以注册!</span>";
var info_can = "<span style='COLOR:#006600'> √ 可以注册!</span>";
var info_right = "<span style='COLOR:#006600'> √ 填写正确!</span>";
var phone_empty = "<span style='COLOR:#ff0000'> × 手机号不能为空！</span>";
var phone_invalid = "<span style='COLOR:#ff0000'> × 手机格式出错！</span>";
var phone_can_register = "<span style='COLOR:#006600'> √ 手机号可以注册!</span>";
var phone_have_register = "<span style='COLOR:#ff0000'> × 该手机号已被注册！ </span>";
var name_flag = false;
var email_flag = false;
var password_flag = false;
var accept_flag = false;
var phone_flag = false;

$ (function ()
{
/*registerComp是教师注册按钮*/
    $ ("#registerComp").click (function ()
    {
        var data = getComParams ();//得到注册信息
        registerComp (data);
    });
});

/*
 * 获取工程的路径
 */
function getRootPath ()
{
    var pathName = window.location.pathname.substring (1);
    var webName = pathName == '' ? '' : pathName.substring (0, pathName
                    .indexOf ('/'));
    return window.location.protocol + '//' + window.location.host + '/'
            + webName + '/';
}
/*
 * 用户名检测
 */
function checkCompName (obj)
{
    if (obj.value.length < 1)
    {
        showInfo ("compname_notice", username_empty); /*username_notice-->compname_notice myself*/
    } else
    {
        // 调用Ajax函数,向服务器端发送查询
        $.ajax ({ //一个Ajax过程
            type: "post", //以post方式与后台沟通
            url: getRootPath() + "/user/checkTname", //与此页面沟通teacher/checkName
            dataType: 'json',//返回的值以 JSON方式 解释
            data: 'account=' + obj.value, //发给的数据
            success: function (json)//这个方法没有进去，里面的内容没有实现
            {//如果调用成功
                if (!json.success)
                {

                    showInfo ("compname_notice", username_have_register);
                } else
                {
                    showInfo ("compname_notice", username_can_register);
                    name_flag = true;
                    change_submit ();
                    return;
                }
            }
        });
    }
    name_flag = false;
    change_submit ();
}
/*
 * 用户名检测是否包含非法字符
 */
function checks (t)
{
    szMsg = "[#%&\'\"\\,;:=!^@]"
    for (i = 1; i < szMsg.length + 1; i++)
    {
        if (t.indexOf (szMsg.substring (i - 1, i)) > -1)
        {
            return false;
        }
    }
    return true;
}
/*
 * 邮箱检测
 */
function checkCompEmail (email)
{
    var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/
    if (email.value.length < 1)
    {
        showInfo ("compemail_notice", email_empty);
    } else if (!re.test (email.value))
    {
        showInfo ("compemail_notice", email_invalid);
    } else
    {
        // 调用Ajax函数,向服务器端发送查询
        $.ajax ({ //一个Ajax过程
            type: "post", //以post方式与后台沟通
            url: getRootPath () + "/user/checkTmail", //与此页面沟通
            dataType: 'json',//返回的值以 JSON方式 解释
            data: 'email=' + email.value, //发给的数据
            success: function (json)
            {//如果调用成功
                if (json.success == false)
                {
                    console.log (json);
                    showInfo ("compemail_notice", email_have_register);
                } else
                {
                    showInfo ("compemail_notice", email_can_register);
                    email_flag = true;
                    change_submit ();
                    return;
                }
            }
        });
    }
    email_flag = false;
    change_submit ();
}


/*
 * 密码检测
 */
function checkCompPassword (password)
{
    if (password.value.length < 1)
    {
        password_flag = false;
        showInfo ("compassword_notice", password_empty);
    }
    else
    {
        showInfo ("compassword_notice", info_right);
    }
}

/*
 * 密码确认检测
 */
function checkConformComPassword (conform_password)
{
    var password = $ ("#comp_password").val ();
    if (password.length < 1)
    {
        showInfo ("conform_compassword_notice", password_empty);

    } else if (conform_password.value != password)
    {
        showInfo ("conform_compassword_notice", confirm_password_invalid);
    }
    else
    {
        showInfo ("conform_compassword_notice", info_right);
        password_flag = true;
        change_submit ();
        return;
    }
    password_flag = false;
    change_submit ();

}

/**
 * 手机号检测
 * @param phone
 */
function checkComPhone (phone)
{
    var re = /0?(13|14|15|18)[0-9]{9}/
    if (phone.value.length < 1)
    {
        showInfo ("comphone_notice", phone_empty);
    } else if (!re.test (phone.value))
    {
        showInfo ("comphone_notice", phone_invalid);
    } else
    {
        $.ajax ({ //一个Ajax过程
            type: "post", //以post方式与后台沟通
            url: getRootPath () + "user/checkTphone", //与此页面沟通
            dataType: 'json',//返回的值以 JSON方式 解释
            data: data = {phone: phone.value}, //发给的数据
            success: function (json)
            {//如果调用成功
                console.log (json);
                if (json.success == false) {
                    console.log (json);
                    showInfo ("comphone_notice", phone_have_register);
                } else {
                    showInfo ("comphone_notice", phone_can_register);
                    phone_flag = true;
                    change_submit ();
                    return;
                }
            }
        });

    }
    phone_flag = false;
    change_submit ();
}


/*
 /*
 * 按钮状态设置
 */
function change_submit ()
{
    if (name_flag && email_flag && password_flag && phone_flag)
    {
        document.getElementById ("registerComp").disabled = false;
        // document.forms['formUser'].elements['Submit1'].disabled = '';
    }
    else
    {
        document.getElementById ("registerComp").disabled = true;
        // document.forms['formUser'].elements['Submit1'].disabled = 'disabled';
    }

}
/* 公用程序
 */
function showInfo (target, Infos)
{
    document.getElementById (target).innerHTML = Infos;
}
function showclass (target, Infos)
{
    document.getElementById (target).className = Infos;
}

function registerComp (data)
{
    console.log (data);
    $.ajax ({ //一个Ajax过程
        type: "post", //以post方式与后台沟通
        url: getRootPath () + "/user/teacherRegister", //与此页面沟通
        dataType: 'json',//返回的值以 JSON方式 解释
        data: data, //发给的数据
        success: function (json)
        {//如果调用成功
            alert (json.error);
           /* if (json.success == false)
            {
                alert (json.error);
            } else
            {
                alert (json.success);
            }*/
        },
        error: function (json)
        {
            console.log (json);
            alert (json.error);
        }
    });
}

/**
 * 获取注册教师信息
 * @returns {{}}
 */
var getComParams = function ()
{
    var teaAccount = $.trim ($ ("#compname").val ());
    var teaPhone = $ ("#comphone").val ();
    var teaEmail = $ ("#comp_email").val ();
    var teaPassword = $ ("#comp_password").val ();
    var json = {};
    json.teaAccount = teaAccount;
    json.teaPhone = teaPhone;
    json.teaEmail = teaEmail;
    json.teaPassword = teaPassword;
    return json;

}
