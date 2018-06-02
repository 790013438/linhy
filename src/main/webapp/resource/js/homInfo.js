
var contextPath = window.location.href;
var arrHref = contextPath.split("jobId=");
var jobId = arrHref[1];
// $("#jobId").val(jobId);
var condition = {
    jobId:jobId,
};
$(function(){

    /*作业上传成功后显示上传作业信息*/
/*    var url=location.search;
    if(url.indexOf("?")!=-1){
        var str=url.substr(1);
        if (str=="success"){
            alert("作业上传成功！");
            getMyHomFile();
        }
        if(str=="false"){
            alert("作业上传失败！")
        }
    }*/
    getMyHomFile(condition);
    getJobInfoByID(condition);
    $("#btn_appli").click(function () {
        appliJobById(condition);
    });
});

//查询资源详情
var getJobInfoByID = function(condition) {
    $.ajax({
        url:"../admin/getHomDetails",
        type : 'post',
        data : condition,
        dataType : 'json',
        success:function(result){
            var list=result.data;
            var strFiles=jobFileList(list[1]);
            if (result.success == true) {
                if (result.error != "") {
                    $("#ul_jobDetail").empty();
                    $("#ul_jobDetail").append("<li>该资源不存在</li>");
                    return;
                }
                if (result.data!=null){
                    $("#ul_jobDetail").empty();
                    //填充信息
                    var detail_str = initJobDetailForm(list[0]);/*result.data*/
                    if(list[0].flag == 0){
                        document.getElementById("btn_appli").value="申请资源";
                    }else{
                        document.getElementById("btn_appli").value="已申请";
                        /*  console.log(list[0]);*/
                        $("#btn_appli").attr("disabled", true);
                    }
                    $("#jobId").val(list[0].id);
                    $("#ul_jobDetail").append(detail_str);
                } else{
                    $("#ul_jobDetail").empty();
                    $("#ul_jobDetail").append("<li>该资源不存在</li>");
                    return;
                }
            } else {
                //还得先清空所有行
                $("#ul_jobDetail").empty();
                var txt = result.error;
                alert(txt);
                return;
            }
        },
        error : function(obj, msg) {
            //还得先清空所有行
            $("#ul_jobDetail").empty();
            var txt = "没有查询到符合条件的信息";
            alert(txt);
            return;
        },
    });
}
//查询本人上传作业文件详情
var getMyHomFile = function(condition) {
    $.ajax({
        url:"../user/getMyHomFile",
        type : 'post',
        data :condition,
        dataType : 'json',
        success:function(result){
            console.log(result.data);
            var list=result.data;
            /*var myFiles=*/myHomFileList(list);

        },
        error : function(obj, msg) {

    }
})
}


//申请指定作业
var appliJobById = function(data) {
    $.ajax({
        url:"../user/applicationHom",
        type : 'post',
        data :data,
        dataType : 'json',
        success:function(result){
            console.log(result);
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    return;
                }else{
                    var txt = "申请成功";
                    alert(txt);
                    return;
                }
            } else {
                //还得先清空所有行
                var txt = result.error;
                alert(txt);
                return;
            }
        },
        error : function(obj, msg) {
            var txt = "申请资源失败";
            alert(txt);
            return;
        },
        complete: function () {
            getJobInfoByID(condition);
        }
    });
}





var initJobDetailForm = function(obj) {
    if(obj.homTitle != null){
        var tr = "<li><span>标题：</span>"+obj.homTitle+"</li>";
    }else{
        var tr = "<li><span>标题：</span>无</li>";
    }
    if(obj.homType != null){
        tr = tr + "<li><span>资源类型：</span>"+obj.homType+"</li>";
    }else{
        tr = tr + "<li><span>资源类型：</span>无</li>";
    }
    if(obj.homTeacherName != null){
        tr = tr + "<li><span>教师名称：</span>"+obj.homTeacherName+"</li>";
    }else{
        tr = tr + "<li><span>教师名称：</span>无</li>";
    }
    if(obj.createTime != null){
        var jobTime1 = moment(obj.createTime).format("YYYY-MM-DD HH:mm:ss");
        tr = tr + "<li><span>资源开始时间：</span>"+jobTime1+"</li>";
    } else{
        tr = tr + "<li><span>资源开始时间：</span>无</li>";
    }
    if(obj.jobDeadline != null){
        var jobDeadlineTime = moment(obj.homDeadline).format("YYYY-MM-DD HH:mm:ss");
        tr = tr + "<li><span>截止时间：</span>"+jobDeadlineTime+"</li>";
    } else{
        tr = tr + "<li><span>截止时间：</span>无</li>";
    }
    if(+obj.homIntroduction != null){
        tr = tr + "<li><span>资源描述信息：</span>" +
            "<textarea style='width:70%;' disabled=\"disabled\">"+obj.homIntroduction+"</textarea>" +
            "</li>";
    }else{
        tr = tr + "<li><span>资源描述信息：</span>无</li>";
    }
    if(obj.id !=null){
        tr=tr+"<li><span>上传作业：</span>"+
            "<form class=\"form-horizontal\" id=\"fromFile\" method=\"post\" enctype=\"multipart/form-data\" action=\"/admin/addHomFiles\">" +
            "<div class=\"form-group\">" +
            "<label class=\"col-sm-3 control-label no-padding-right\"> 上传文件(如果需要多文件上传，请一次性选择多个需要上传的文件)</label>" +
            "<input name='homId' value='"+obj.id+"'hidden='hidden' />"+
            "<input  name=\"hom_file\" type=\"file\" placeholder=\"上传的文件\" multiple=\"multiple\" maxlength=\"5\" class=\"col-xs-10 col-sm-5\" />" +
            "</div>" +
            "</div>" +
            "<div align=\"center\">" +
            "<button style=\"width:200px;height:50px;background:white;\" id=\"btn_saveFile\" type=\"submit\">文件上传</button>" +
            "</div>" +
            "</form>"
    }else{}
    return tr;
}
/*显示资源文件信息*/
function jobFileList(file){
    var jobfile=file;
    if (jobfile!=null){
        for(var i=0;i<jobfile.length;i++){
            var x=document.getElementById("ta_jobFile").insertRow();
            x.insertCell(0).innerHTML =jobfile[i].file_id;
            x.insertCell(1).innerHTML=jobfile[i].file_realname;
            x.insertCell(2).innerHTML=jobfile[i].file_type;
            x.insertCell(3).innerHTML=jobfile[i].file_size;
            x.insertCell(4).innerHTML="<a href='/teacher/downloadHomFiles?name="+jobfile[i].file_name+"'>下载</a>";
        }
    }
}

    /*显示本人上传作业文件信息*/
    function myHomFileList(file){
        var jobfile=file;
        if (jobfile!=null){
            for(var i=0;i<jobfile.length;i++){
                var x=document.getElementById("ta_myJobFile").insertRow();
                x.insertCell(0).innerHTML =jobfile[i].file_id;
                x.insertCell(1).innerHTML=jobfile[i].file_realname;
                x.insertCell(2).innerHTML=jobfile[i].file_type;
                x.insertCell(3).innerHTML=jobfile[i].file_size;
                x.insertCell(4).innerHTML="<a href='/teacher/downloadHomFiles?name="+jobfile[i].file_name+"'>下载</a>";
            }
        }
    }





