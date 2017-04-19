

var contextPath = window.location.href;
var arrHref = contextPath.split("jobId=");
var jobId = arrHref[1];
$("#input_jobId").val(jobId);
var condition = {
    jobId:jobId
};
$(function(){
    getJobInfoByID(condition);
});

//查询兼职详情
var getJobInfoByID = function(condition) {
	$.ajax({
		url:"../company/getJobDetails",
		type : 'post',
		data : condition,
		dataType : 'json',
		success:function(result){
			if (result.success == true) {
				if (result.error != "") {
                    $("#ul_jobDetail").empty();
                    $("#ul_jobDetail").append("<li>该兼职不存在</li>");
                    return;
				}
				if (result.data!=null){
                    $("#ul_jobDetail").empty();
                    //填充信息
                    var detail_str = initJobDetailForm(result.data);
                    console.log(result.data);
                    $("#ul_jobDetail").append(detail_str);
				} else{
                    $("#ul_jobDetail").empty();
                    $("#ul_jobDetail").append("<li>该兼职不存在</li>");
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

var initJobDetailForm = function(obj) {
    if(obj.jobTitle != null){
        var tr = "<li><span>标题：</span>"+obj.jobTitle+"</li>";
    }else{
        var tr = "<li><span>标题：</span>无</li>";
    }
    if(obj.jobType != null){
        tr = tr + "<li><span>兼职类型：</span>"+obj.jobType+"</li>";
    }else{
        tr = tr + "<li><span>兼职类型：</span>无</li>";
    }
    if(obj.jobCompanyName != null){
        tr = tr + "<li><span>企业名称：</span>"+obj.jobCompanyName+"</li>";
    }else{
        tr = tr + "<li><span>企业名称：</span>无</li>";
    }
    if(obj.jobDemandNumber != null){
        tr = tr + "<li><span>需求人数：</span>"+obj.jobDemandNumber+"<span>（人）</span></li>";
    }else{
        tr = tr + "<li><span>需求人数：</span>无</li>";
    }
    if(obj.jobRequiresGender != null){
        tr = tr + "<li><span>性别要求：</span>"+obj.jobRequiresGender+"</li>";
    }else{
        tr = tr + "<li><span>性别要求：</span>无</li>";
    }
    if(obj.jobSalaryType != null){
        tr = tr + "<li><span>薪资类型：</span>"+obj.jobSalaryType+"</li>";
    }else{
        tr = tr + "<li><span>薪资类型：</span>无</li>";
    }
    if(obj.jobHours != null){
        tr = tr + "<li><span>每日工作时长：</span>"+obj.jobHours+"<span>（时）</span></li>";
    }else{
        tr = tr + "<li><span>每日工作时长：</span>无</li>";
    }
    if(obj.jobSalary != null){
        tr = tr + "<li><span>薪资金额：</span>"+obj.jobSalary+"<span>（元）</span></li>";
    }else{
        tr = tr + "<li><span>薪资金额：</span>无</li>";
    }
    if(obj.jobTime != null){
        var jobTime1 = moment(obj.jobTime).format("YYYY-MM-DD HH:mm:ss");
         tr = tr + "<li><span>兼职开始时间：</span>"+jobTime1+"</li>";
    } else{
         tr = tr + "<li><span>兼职开始时间：</span>无</li>";
    }
    if(obj.jobDeadline != null){
        var jobDeadlineTime = moment(obj.jobDeadline).format("YYYY-MM-DD HH:mm:ss");
         tr = tr + "<li><span>报名截止时间：</span>"+jobDeadlineTime+"</li>";
    } else{
         tr = tr + "<li><span>报名截止时间：</span>无</li>";
    }
    if(obj.jobAddress != null){
        tr = tr + "<li><span>工作地点：</span>"+obj.jobAddress+"</li>";
    }else{
        tr = tr + "<li><span>工作地点：</span>无</li>";
    }
    if(+obj.jobIntroduction != null){
        tr = tr + "<li><span>兼职描述信息：</span>" +
                "<textarea style='width:70%;' disabled=\"disabled\">"+obj.jobIntroduction+"</textarea>" +
                "</li>";
    }else{
        tr = tr + "<li><span>兼职描述信息：</span>无</li>";
    }
    return tr;
}





