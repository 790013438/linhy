var condition = {
    jobStatus:"2",
};
$(function(){
    $('.menu-list').removeClass('active open');
    $("#jobManage").addClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#li_myjob").addClass('active open');
    queryMyJob(condition);
    $("#btn_delJob").click(function () {
        closepop();
        var jobId = $("#input_jobId").val();
        var data = {
            jobId:jobId
        };
        delJobById(data);
    });

});

//查询我的资源
var queryMyJob = function(data) {
	$.ajax({
		url:"../teacher/getJobsByTeacherId",
		type : 'post',
		data : data,
		dataType : 'json',
		success:function(result){
			if (result.success == true) {
				if (result.error != "") {
					alert(result.error);
					$("#table_myJobs tbody").empty();
					return;
				}
				if (result.data.data!=null){
					console.log(result.data);
					$("#table_myJobs tbody").empty();
					$.each(result.data.data, function (index, obj) {
						var tr = appendJobNode(obj);
						$("#table_myJobs tbody").append(tr);
						appendTabTitleById("table_myJobs");
                    });
                    $(document).ready(function(){
                        $('#table_myJobs').DataTable();
                    });
				} else{
					$("#table_myJobs tbody").empty();
					var txt = "没有查询到符合条件的信息";
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
			//还得先清空所有行
			$("#table_myJobs tbody").empty();
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
            queryMyJob(condition);
        }
    });
}
//提交审核
var submitAudit = function(id) {
    $.ajax({
        url:"../teacher/submitAudit",
        type : 'post',
        data : data={jobId:id},
        dataType : 'json',
        success:function(result){
            console.log(result);
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    return;
                }else{
                    var txt = "提交成功，等待管理员审核";
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
            var txt = "提交审核失败";
            alert(txt);
            return;
        },
        complete: function () {
            queryMyJob(condition);
        }
    });
}

$(".table tr td input").each(function(){
    $(this).attr("title",$(this).val());
});
/**
 * 传入要实现table的Id即可
 * @param id
 */
 var appendTabTitleById = function(id)
{
    var cellIndex = parseInt ($ ("#" + id + ".table th").length) - 1;
    $ ($ ("#" + id + ".table tr td")).each (function ()
    {
        if (this.cellIndex != cellIndex)
        {
            $ (this).attr ("title", $ (this).text ());
        }
    });
    $ ("#" + id + ".table tr td input").each (function ()
    {
        $ (this).attr ("title", $ (this).val ());
    });
}
/**
 * 将td的内容(包括td下input)赋值给其title属性。
 * 配合max样式使用
 */
 var appendTabTitle = function()
{
    $ (".table tr td").each (function ()
    {
        if ($ (this).parent ().attr ('class') != 'last_tr')
        { //有操作按钮的一栏不添加 title 属性
            if ($ (this).children ("select").length <= 0)
            {
                $ (this).attr ("title", $ (this).text ());
            }
        }
    });
}



var appendJobNode = function(obj) {
    var jobDeadline1 = moment(obj.jobDeadline).format("YYYY-MM-DD HH:mm:ss");
    var job_str = "<tr>"+
         "<td>"+obj.id+"</td>"+
		"<td>"+obj.jobTitle+"</td>"+
		"<td> "+obj.jobType+"</td>"+
		"<td> "+obj.jobStatus+"</td>"+
		"<td> "+obj.jobDemandNumber+"</td>"+
		"<td> "+jobDeadline1+"</td>"+
		"<td>"+
		"<a  href =\"../teacher/jobDetails?jobId="+obj.id+"\" >查看资源详情</a> |" +
            "<button type=\"button\"  onclick=\"delJob('"+obj.id+"')\" class='btn btn-link'>删除</button>|";
    if(obj.jobStatus== "保存"){
        var job_str1 = job_str +"<button type=\"button\" onclick=\"submitAudit('"+obj.id+"')\" class='btn btn-link'>提交审核</button>";
    }else{
        var job_str1 = job_str +"<button type=\"button\" disabled='disabled' class='btn btn-link'>提交审核</button>";
        // var job_str1 = job_str +"<a  href=\"javascript:getJobDetails('"+obj.id+"');\" class='disabled'>已报名</a>";
    }
		"<input type=\"hidden\" name=\"job_id\" value=\""+obj.id+"\">"+
		"</td>"+
		"</tr>";
	return job_str1;
}

var delJob = function(data) {
    $("#input_jobId").val(data);
    $(".pop").show();
    $(".popinto").show();
}






