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
    
    $("#signup_btn").click(function () {
        // var test=$("#from_signin").serialize();
        var from=$("#from_signin").serializeArray();
        for(var i=0;i<from.length;i++){
            if(from[i].name=="username"){
                if(!username_val.test(from[i].value)){
                    layerAlert("用户名格式输入不正确，只支持4-10位数字字母组合");
                    button_val=false;
                    return false;
                }
            }
            if(from[i].name=="email"){

            }
            if(from[i].name=="password"){

            }

            if(from[i].name=="phone"){

            }
        }
    })
});

function layerAlert(msg) {
    layer.alert(msg, {
        skin: 'layui-layer-molv' //样式类名
        ,closeBtn: 0
    });
}
/**
 * 显示信息
 * @param target
 * @param Infos
 */
function showInfo(target,Infos){
    document.getElementById(target).innerHTML = Infos;
}