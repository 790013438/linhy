

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

//查询资源详情
var getJobInfoByID = function(condition) {
	$.ajax({
		url:"../teacher/getJobDetails",
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
    if(obj.jobTitle != null){
        var tr = "<li><span>标题：</span>"+obj.jobTitle+"</li>";
    }else{
        var tr = "<li><span>标题：</span>无</li>";
    }
    if(obj.jobType != null){
        tr = tr + "<li><span>资源类型：</span>"+obj.jobType+"</li>";
    }else{
        tr = tr + "<li><span>资源类型：</span>无</li>";
    }
    if(obj.jobTeacherName != null){
        tr = tr + "<li><span>教师名称：</span>"+obj.jobTeacherName+"</li>";
    }else{
        tr = tr + "<li><span>教师名称：</span>无</li>";
    }
    if(obj.jobHours != null){
        tr = tr + "<li><span>建议每日学习时长：</span>"+obj.jobHours+"<span>（时）</span></li>";
    }else{
        tr = tr + "<li><span>建议每日学习时长：</span>无</li>";
    }
    if(obj.createTime != null){
        var jobTime1 = moment(obj.createTime).format("YYYY-MM-DD HH:mm:ss");
         tr = tr + "<li><span>资源开始时间：</span>"+jobTime1+"</li>";
    } else{
         tr = tr + "<li><span>资源开始时间：</span>无</li>";
    }
    if(obj.jobDeadline != null){
        var jobDeadlineTime = moment(obj.jobDeadline).format("YYYY-MM-DD HH:mm:ss");
         tr = tr + "<li><span>截止时间：</span>"+jobDeadlineTime+"</li>";
    } else{
         tr = tr + "<li><span>截止时间：</span>无</li>";
    }
    if(+obj.jobIntroduction != null){
        tr = tr + "<li><span>资源描述信息：</span>" +
                "<textarea style='width:70%;' disabled=\"disabled\">"+obj.jobIntroduction+"</textarea>" +
                "</li>";
    }else{
        tr = tr + "<li><span>资源描述信息：</span>无</li>";
    }
    return tr;
}
/*显示资源文件信息*/
function jobFileList(file){
    var jobfile=file;
    if (jobfile!=null){
        for(var i=0;i<jobfile.length;i++){
            var operation="<a href='/teacher/downloadJobFiles?name="+jobfile[i].file_name+"'>下载</a>";
            if(jobfile[i].file_type==".pdf"){
                operation=operation+"|<a href='/resource/plugins/pdfjs/web/viewer.html?file=upload/"+jobfile[i].file_name+"'>在线预览</a>"
            }
            if (jobfile[i].file_type==".mp4"){
                operation=operation+"|<a href='/teacher/play?name="+jobfile[i].file_name+"'>在线播放</a>"
            }
           var x=document.getElementById("ta_jobFile").insertRow();
           x.insertCell(0).innerHTML =jobfile[i].file_id;
           x.insertCell(1).innerHTML=jobfile[i].file_realname;
           x.insertCell(2).innerHTML=jobfile[i].file_type;
           x.insertCell(3).innerHTML=jobfile[i].file_size;
           x.insertCell(4).innerHTML=operation;
        }
    }
}




