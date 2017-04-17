/**
 * 检测真实姓名（2-4位，汉字）
 * @param Name
 * @returns {boolean}
 */
function checkRelName(Name){
    var relname = /[\u4e00-\u9fa5]{2,4}/;
    if(Name==null||!relname.test(Name)){
        return false;
    }
    else{
        return true;
    }
};

/**
 * 添加用户时检测手机号
 * @param PhoneNumber
 * @returns {boolean}
 */
function checkPhone(userPhone) {
    var phonenumber=/^1(3|4|5|7|8)\d{9}$/;
    if(userPhone!=null && phonenumber.test(userPhone)){
        document.getElementById("input_phone").style.color="#646464";
        return true;
    } else{
        alert("手机号输入不合理或输入了空字符串");
        document.getElementById("input_phone").style.color="red";
        return false;
    }

}

/**
 * 添加用户时检测邮箱格式
 * @param Email
 * @returns {boolean}
 */
function checkEmail(userEmail) {
    var email = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
    if(userEmail!=null && email.test(userEmail)){
        document.getElementById("input_email").style.color="#646464";
        return true;
    }
    else{
        alert("邮箱格式不正确或输入了空字符串");
        document.getElementById("input_email").style.color="red";
        return false;
    }
}


/**
 * 编辑用户时检测手机号
 * @param PhoneNumber
 * @returns {boolean}
 */
function checkUpdatePhone(userPhone) {
    var phonenumber=/^1(3|4|5|7|8)\d{9}$/;
    if(userPhone!=null && phonenumber.test(userPhone)){
        document.getElementById("update_phone").style.color="#646464";
        return true;
    } else{
        alert("手机号输入不合理");
        document.getElementById("update_phone").style.color="red";
        return false;
    }

}

/**
 * 编辑用户时检测邮箱格式
 * @param Email
 * @returns {boolean}
 */
function checkUpdateEmail(userEmail) {
    var email = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
    if(userEmail!=null && email.test(userEmail)){
        document.getElementById("update_email").style.color="#646464";
        return true;
    }
    else{
        alert("邮箱格式不正确");
        document.getElementById("update_email").style.color="red";
        return false;
    }
}


function checkNull(Str) {
    var rs=str.trim().split(" ");
    if(!str&&typeof(str)!="undefined"&& exp!=0 &&str.length == 0 ||!str.test(/^\s+$/g)){
        return false;
    }else{
        return true;
    }
}

function checknull(obj) {
    obj = $.trim(obj);
    if (obj == ''||typeof(obj)=="undefined") {// 判断是否是空字符串，而不是null
        return false;
    }
}