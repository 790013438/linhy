

var contextPath = window.location.href;
var arrHref = contextPath.split("jobId=");
var jobId = arrHref[1];
$("#input_jobId").val(jobId);
var condition = {
    jobId:jobId
};
$(function(){
    $('.menu-list').removeClass('active open');
    $("#jobManage").addClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#li_myjob").addClass('active open');
    getJobInfoByID(condition);
});

//查询作业详情
var getJobInfoByID = function(condition) {
    $.ajax({
        url:"../teacher/getHomDetails",
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
                    console.log(result.data);
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
/*资源详情*/
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
    if(obj.teacherId != null){
        tr = tr + "<li><span>教师名称：</span>"+obj.teacherId+"</li>";
    }else{
        tr = tr + "<li><span>教师名称：</span>无</li>";
    }
    /*if(obj.jobHours != null){
        tr = tr + "<li><span>建议每日学习时长：</span>"+obj.jobHours+"<span>（时）</span></li>";
    }else{
        tr = tr + "<li><span>建议每日学习时长：</span>无</li>";
    }*/
    if(obj.createTime != null){
        var jobTime1 = moment(obj.createTime).format("YYYY-MM-DD HH:mm:ss");
        tr = tr + "<li><span>资源开始时间：</span>"+jobTime1+"</li>";
    } else{
        tr = tr + "<li><span>资源开始时间：</span>无</li>";
    }
    if(obj.homDeadline != null){
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
    return tr;
}
/*显示作业文件信息*/
function jobFileList(file){
    var jobfile=file;
    if (jobfile!=null){
        for(var i=0;i<jobfile.length;i++){
            var x=document.getElementById("ta_homFile").insertRow();
            x.insertCell(0).innerHTML =jobfile[i].file_id;
            x.insertCell(1).innerHTML=jobfile[i].file_realname;
            x.insertCell(2).innerHTML=jobfile[i].file_type;
            x.insertCell(3).innerHTML=jobfile[i].file_size;
            x.insertCell(4).innerHTML="<a href='/teacher/downloadHomFiles?name="+jobfile[i].file_name+"'>下载</a>";
        }
    }
}