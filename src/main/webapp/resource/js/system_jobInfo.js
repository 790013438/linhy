

var contextPath = window.location.href;
var index1 = contextPath.indexOf("jobId=");
var index2 = contextPath.indexOf("&");
var jobId = contextPath.substring(index1+6,index2);
var arrHref = contextPath.split("sign=");
var sign = arrHref[1];
$("#input_jobId").val(jobId);
var condition = {
    jobId:jobId
};
$(function(){
    $('.menu-list').removeClass('active open');
    $("#jobManage").addClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#systemJob").addClass('active open');
    getJobInfoByID(condition);
    $("#btn_appli").click(function () {
        $(".pop").show();
        if(sign == 0){
            $("#popinto_delPop").show();

        }else{
            $("#popinto_adoptPop").show();
        }
    });
    function closepop(){
        $(".pop").hide();
        $(".popinto").hide();
    }
    $("#btnAdoptJob").click(function () {
        closepop();
        var jobId = $("#input_jobId").val();
        var condition = {
            jobId:jobId,
            jobStatus:3
        };
        updateJobStatus(condition);
    });
    $("#btnRefuseJob").click(function () {
        closepop();
        var jobId = $("#input_jobId").val();
        var condition = {
            jobId:jobId,
            jobStatus:2
        };
        updateJobStatus(condition);
    });
    $("#btn_delJob").click(function () {
        closepop();
        var data = {
            jobId:jobId
        };
        delJobById(data);
    });
});

//查询资源详情
var getJobInfoByID = function(condition) {
	$.ajax({
		url:"../admin/getJobDetails",
		type : 'post',
		data : condition,
		dataType : 'json',
		success:function(result){
			if (result.success == true) {
                if(sign == 0){
                    $("#btn_appli").val("删除资源");
                }else{
                    $("#btn_appli").val("审核资源");
                }
				if (result.error != "") {
                    $("#ul_jobDetail").empty();
                    $("#ul_jobDetail").append("<li>该资源不存在</li>");
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

//删除资源
var delJobById = function(data) {
    $.ajax({
        url:"../admin/deleteJobById",
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
                    var txt = "删除资源成功";
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
            var txt = "删除资源失败";
            alert(txt);
            return;
        },
        complete: function () {
            window.location.href = '../system/job';
        }
    });
}
//审核资源
var updateJobStatus = function(data) {
    $.ajax({
        url:"../admin/auditingJob",
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
                    var txt = "审核资源成功";
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
            var txt = "审核资源失败";
            alert(txt);
            return;
        },
        complete: function () {
            window.location.href = '../system/index';
        }
    });
}

function closepop(){
    $(".pop").hide();
    $(".popinto").hide();
}

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
         tr = tr + "<li><span>资源开始时间：</span>"+jobTime1+"</li>";
    } else{
         tr = tr + "<li><span>资源开始时间：</span>无</li>";
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
        tr = tr + "<li><span>资源描述信息：</span>" +
                "<textarea style='width:70%;' disabled=\"disabled\">"+obj.jobIntroduction+"</textarea>" +
                "</li>";
    }else{
        tr = tr + "<li><span>资源描述信息：</span>无</li>";
    }
    return tr;
}





