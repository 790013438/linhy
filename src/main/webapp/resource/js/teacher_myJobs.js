var condition = {
    jobStatus:"3",
};
$(function(){
    $('.menu-list').removeClass('active open');
    $("#jobManage").addClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#li_history").addClass('active open');
    queryMyJob(condition);
    $("#btn_removeJob").click(function () {
        closepop();
        var jobId = $("#input_jobId").val();
        var data = {
            jobId:jobId,
        };
        removeJobById(data);
    });
    $("#btn_closeJob").click(function () {
        closepop();
        var jobId = $("#input_jobId").val();
        var data = {
            jobId:jobId,
            jobStatus:"-1",
        };
        closeJobById(data);
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
					$("#table_jobs tbody").empty();
					return;
				}
				if (result.data.data!=null){
					console.log(result.data);
					$("#table_jobs tbody").empty();
					$.each(result.data.data, function (index, obj) {
						var tr = appendJobNode(obj);
						$("#table_jobs tbody").append(tr);
						appendTabTitleById("table_myJobs");
                    });
                    $(document).ready(function(){
                        $('#table_jobs').DataTable();
                    });
				} else{
					$("#table_jobs tbody").empty();
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
			$("#table_jobs tbody").empty();
			var txt = "没有查询到符合条件的信息";
			alert(txt);
			return;
		},
	});
}
//移除资源
var removeJobById = function(data) {
        $.ajax({
            url:"../teacher/removeJobById",
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
                        var txt = "移除资源成功";
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
                var txt = "移除资源失败";
                alert(txt);
                return;
            },
            complete: function () {
                queryMyJob(condition);
            }
        });
    }

//关闭资源
var closeJobById = function(data) {
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
                    var txt = "关闭资源成功";
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
            var txt = "关闭资源失败";
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
        "<td> "+obj.appliCount+"</td>"+
        "<td> "+jobDeadline1+"</td>"+
		"<td>"+
		"<a  href =\"../teacher/jobInfo?jobId="+obj.id+"\" >查看报名情况</a> |";
    if(obj.jobStatus== "结束"){
        var job_str1 = job_str +"<button type=\"button\"  onclick=\"removeJob('"+obj.id+"')\" class='btn btn-link'>移除</button>";
    }else{
        var job_str1 = job_str +"<button type=\"button\"  onclick=\"closeJob('"+obj.id+"')\" class='btn btn-link'>关闭</button>";
    }
		"<input type=\"hidden\" name=\"job_id\" value=\""+obj.id+"\">"+
		"</td>"+
		"</tr>";
	return job_str1;
}

var removeJob = function(data) {
    $("#input_jobId").val(data);
    $(".pop").show();
    $("#popinto_remove").show();
}
var closeJob = function(data) {
    $("#input_jobId").val(data);
    $(".pop").show();
    $("#popinto_close").show();
}






