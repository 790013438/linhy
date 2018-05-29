<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="resource" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh">
<head>
	<%@include file="commonHead.jsp"%>
</head>
<body>
<%@include file="commonLeft.jsp"%>
<div class="main-content">
	<div class="breadcrumbs" id="breadcrumbs">
		<script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
		</script>

		<ul class="breadcrumb">
			<li>
				<i class="icon-home home-icon"></i>
				<a href="/student/index">首页</a>
			</li>

			<li class="active">我的消息</li>

		</ul><!-- .breadcrumb -->
	</div>

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div id="container">
					<!-- 定义一个表格元素 -->
					<table id="table_message" class="table table-striped table-bordered">
						<thead>
						<tr>
							<th>序号</th>
							<th>发送者名字</th>
							<th>发送者身份</th>
							<th>类型</th>
							<th>时间</th>
							<th>内容</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody>	</tbody>
						<!-- tbody是必须的 -->
					</table>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->

		<%--留言信息表--%>
		<div>
			<form class="form-horizontal" id="replyMes" hidden="hidden">
				<input type="text" id="senderId"/>
				<input type="text" id="senderType"/>
				<input type="text" id="objectType"/>
				<input type="text" id="mesType"/>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">留言</label>

					<div class="col-sm-9">
						<textarea placeholder="留言内容" maxlength="500" id="input_content" class="col-xs-10 col-sm-5" ></textarea>
					</div>
				</div>
				<div align="center">
					<button style="width:200px;height:50px;background:#338FCC;" id="btn_saveMes" type="button" onclick="saveMes()">保存</button>
				</div>
			</form>
		</div>

	</div><!-- /.page-content -->
</div><!-- /.main-content -->

</div><!-- /.main-container-inner -->

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
	<i class="icon-double-angle-up icon-only bigger-110"></i>
</a>
</div><!-- /.main-container -->

<!--删除弹窗start-->
<div class="popinto" id="delPop">
	<div class="font16 center deletediv">真的要删除该消息吗？</div>
	<div class="deletediv_btn">
		<p class="pull-left"><button type="button" class="btn btn-primary" id="btnDoUpdate">确定</button></p>
		<p class="pull-right"><button type="button" class="btn btn-default" onclick="closepop()">取消</button></p>
		<input hidden="hidden" id="doId"/>
		<input hidden="hidden" id="doStatus"/>
	</div>
</div>
<!--查看弹窗start-->
<div class="popinto" id="see">
	<h1 class="font16">
		<span class="pull-left gray_three">查看</span>
		<i class="fa fa-times pull-right font18" onclick="closepop()"></i>
	</h1>
	<div class="popcon">
		<ul class="gray_three">
			<li><span>消息名称:</span>有人申请了你的资源</li>
			<li><span>消息时间:</span>2018-04-10 16:11:38</li>
			<li><span>发送人:</span>系统提示</li>
			<li><span>消息内容:</span>好好学习，天天向上</li>
		</ul>
	</div>
</div>
<!--查看弹窗end-->
<!--删除弹窗end-->
<div class="pop" onclick="closepop()" style="display: none;"></div>
<!-- basic scripts -->
<%@include file="commonFoot.jsp"%>
<script src="${resource}/resource/js/moment.js"></script>
	<script src="${resource}/resource/js/student_message.js"></script>


	<script type="text/javascript">
		function closepop(){
				$(".pop").hide();
				$(".popinto").hide();
			}
			jQuery(function($) {
			    closepop();
				$(".del").click(function(){
					$(".pop").show();
					$("#delPop").show();
				})
				$(".see").click(function(){
					$(".pop").show();
				$("#see").show();
				})

				$(document).ready(function(){
        			$('#example').DataTable();
    			});

    			$(".delete").on(ace.click_event, function() {
					bootbox.confirm("Are you sure?", function(result) {
						if(result) {
							//
						}
					});
				});
			})
		</script>
</body>
</html>
