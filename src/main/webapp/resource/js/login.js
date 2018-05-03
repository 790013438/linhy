var username_empty = "<span style='COLOR:#ff0000'>  × 用户名不能为空!</span>";
var username_invalid = "- 用户名只能是由字母数字以及下划线组成。长度为4-10位";
var username_have_register = "<span style='COLOR:#ff0000'> × 用户名已经存在,请重新输入!</span>";
var username_can_register="<span style='COLOR:#006600'> √ 恭喜您！该用户名可以注册!</span>";
/**
 * 对表单中的正则进行校验。
 * @type {string}
 */
var username_val=/^[A-Za-z0-9_\-\u4e00-\u9fa5]{4,10}$/;
var password_val=/^[A-Za-z0-9_\-\u4e00-\u9fa5]{6,16}$/;
var email_val=/ /;
var phonr_val=/0?(13|14|15|18)[0-9]{9}/;
var button_val=true;
$(function () {
    $('.list-inline li > a').click(function () {
        var activeForm = $(this).attr('href') + ' > form';
        //console.log(activeForm);
        $(activeForm).addClass('magictime swap');
        //set timer to 1 seconds, after that, unload the magic animation
        setTimeout(function () {
            $(activeForm).removeClass('magictime swap');
        }, 1000);
    });

    $("#login_form").submit(function(e){
        e.preventDefault();
        login();
    });

});
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName
            .indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/'
        + webName + '/';
}

function login() {
    var obj=$("#login_form").serializeArray();
    var json={};
    json.username=$("#login_username").val();
    json.password=$("#login_password").val();
    if(json.username==null||json.password==null||json.username==""||json.password==""){
        alert("请输入登录信息");
        return;
    }
    json.type=obj[0].value;
    var data={
       json:JSON.stringify(json)
    };
    $.ajax({ //一个Ajax过程
        type: "post", //以post方式与后台沟通
        url :getRootPath()+"/user/login", //与此页面沟通
        dataType:'json',//返回的值以 JSON方式 解释
        data: data, //发给的数据
        success: function(result){//如果调用成功
            if(result.success== true){
                if(result.data == 1){
                    window.location.href=getRootPath()+"student/index";
                }else if(result.data == 2){
                    window.location.href=getRootPath()+"teacher/index";
                }else{
                    window.location.href=getRootPath()+"system/index";
                }
            }else {
                alert(result.error);
            }
        },
        error: function (obj, msg) {
            alert("异常");
            return;
        }
    });
}

function layerAlert(msg) {
    layer.alert(msg, {
        skin: 'layui-layer-molv' //样式类名
        ,closeBtn: 0
    });
}