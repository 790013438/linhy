$(function(){
    /*文件上传提示信息*/
    var url=location.search;
    if(url.indexOf("?")!=-1){
        var str=url.substr(1);
        if (str=="success"){
            alert("文件上传成功！")
        }
        if(str=="false"){
            alert("文件上传失败！")
        }
    }

    $("#btn_saveHom").click(function () {
        var data = getParams();
        document.getElementById("btn_saveFile").removeAttribute("disabled");
        /*        if(!checkNumber(data.jobDemandNumber)){
                }*/
/*        if(!checkHours(data.jobHours)){
        }*/
        /*        if(!checkSalary(data.jobSalary)){
                }*/
        if(!checkHomInformation(data)){
            alert("输入了空字符串或者信息不完善");
        }
        addHom(JSON.stringify(data));
    });
});

//发布资源s
var addHom = function (data) {
    $.ajax({
        url: "../teacher/addHoms",
        type: 'post',
        data: {
            json:data
        },
        dataType : 'json',
        error: function (obj, msg) {
            var txt = "保存作业信息失败";
            alert(txt);
            return;
        },
        complete: function () {
        },
        success: function (result) {
            if (result.success == true) {
                if (result.data > 0) {
                    alert("保存作业信息成功");
                    window.location.href='index';
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
var checkHomInformation = function(data)
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
/**
 * 获取修改后的用户信息
 * @returns {{}}
 */
var getParams = function(){
    var homTitle= $.trim($("#input_homTitle").val());
    var homType = $.trim($("#input_homType").val());
    var homIntroduction = $("#input_homIntroduction").val();
    var homDeadline = $("#input_homDeadline").val();
    var json = {};
    json.homTitle = homTitle;
    json.homType = homType;
    json.homIntroduction = homIntroduction;
    json.deadline = homDeadline;
    return json;

}