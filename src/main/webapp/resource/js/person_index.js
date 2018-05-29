
$(function(){
    queryJobList();


});

//查询资源列表
var queryJobList = function() {
	$.ajax({
		url:"../user/getJobList",
		type : 'post',
		data : null,
		dataType : 'json',
		success:function(result){
			if (result.success == true) {
				if (result.error != "") {
					alert(result.error);
					$("#job_list tbody").empty();
					return;
				}
				if (result.data.data!=null){
					console.log(result.data);
					$("#job_list tbody").empty();
					$.each(result.data.data, function (index, obj) {
						var tr = appendJobNode(obj);
						$("#job_list tbody").append(tr);
						appendTabTitleById("job_list");
                    });
                    $(document).ready(function(){
                        $('#job_list').DataTable();
                    });
				} else{
					$("#job_list tbody").empty();
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
			$("#job_list tbody").empty();
			var txt = "没有查询到符合条件的信息";
			alert(txt);
			return;
		},
	});
}

//申请指定资源
var applicationJob = function(id) {
    $.ajax({
        url:"../user/applicationJob",
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
            queryJobList();
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
		"<td> "+obj.jobTeacherName+"</td>"+
		"<td> "+obj.appliCount+"</td>"+
		"<td> "+jobDeadline1+"</td>"+
      /*  "<td> "+obj.jobSalaryType+"</td>"+*/
      /*  "<td> "+obj.jobSalary+"</td>"+*/
		"<td>"+
		"<a  href =\"../student/jobInfo?jobId="+obj.id+"\" >查看资源详情</a> |"+
        "<button type=\"button\"  onclick=\"showFn("+obj.jobTeacherId+","+0+","+1+","+1+")\" class='btn btn-link'>回复</button>|" ;
    if(obj.flag== 0){
            var job_str1 = job_str +"<button type=\"button\" onclick=\"applicationJob('"+obj.id+"')\" class='btn btn-link'>申请</button>";
        }else{
            var job_str1 = job_str +"<button type=\"button\" disabled='disabled' class='btn btn-link'>已申请</button>";
           // var job_str1 = job_str +"<a  href=\"javascript:getJobDetails('"+obj.id+"');\" class='disabled'>已申请</a>";
        }
		"<input type=\"hidden\" name=\"job_id\" value=\""+obj.id+"\">"+
		"</td>"+
		"</tr>";
	return job_str1;
}

/*显示发送信息表单*/
var showFn = function(senderId,senderType,ObjectType,mesType){
    /*        document.getElementById( "replyMes").style.visibility= "visible";
            document.getElementById( "senderId").style.visibility= "hidden";
            为什么这种显示效果不行*/
    $("#replyMes").show();
    $("#senderId").hide();
    $("#senderType").hide();
    $("#objectType").hide();
    $("#mesType").hide();
    document.getElementById("senderId").value=senderId;
    document.getElementById( "senderType").value=senderType;
    document.getElementById( "objectType").value=ObjectType;
    document.getElementById( "mesType").value=mesType;
}
/*保存留言信息*/
var saveMes=function(){
    var objectId=document.getElementById("senderId").value;
    var objectType=document.getElementById( "senderType").value;
    var con=document.getElementById( "input_content").value;
    var senderType=document.getElementById( "objectType").value;
    var mesType=document.getElementById( "mesType").value;
    var params={};
    params.objectId=objectId;
    params.senderType=senderType;
    params.objectType=objectType;
    params.con=con;
    params.mesType=mesType;
    $.ajax({
        url:"../message/sendMessage",
        type : 'post',
        data : params,
        dataType : 'json',
        success:function(result){
            if (result.success == true) {
                /*隐藏留言板*/
                $("#replyMes").hide();
                /*清空留言内容*/
                document.getElementById( "input_content").value=null;
                if (result.error != "") {
                    alert(result.error);
                    return;
                }else{
                    var txt = "留言信息成功发送";
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
            var txt = "留言信息发送失败";
            alert(txt);
            return;
        },
        complete: function () {  }
    });
}



