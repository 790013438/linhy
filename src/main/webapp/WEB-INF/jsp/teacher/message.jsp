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
				<a href="system_message.jsp">首页</a>
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
							<th>触发用户id</th>
							<th>状态</th>
							<th>类型</th>
							<th>时间</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>1</td>
							<td>1</td>
							<td>未读</td>
							<td>教师审核</td>
							<td>2017-02-25 22:14:53</td>
							<td><button class="btn btn-link see">查看详情</button><button class="btn btn-link del">删除</button></a></td>
						</tr>
						<tr>
							<td>2</td>
							<td>2</td>
							<td>未读</td>
							<td>资源审核</td>
							<td>2017-02-25 22:14:53</td>
							<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看详情</button><button class="btn btn-link delete">删除</button></a></td>
						</tr>
						<tr>
							<td>3</td>
							<td>2</td>
							<td>未读</td>
							<td>教师审核</td>
							<td>2017-02-25 22:14:53</td>
							<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看详情</button><button class="btn btn-link delete">删除</button></a></td>
						</tr>
						<tr>
							<td>4</td>
							<td>1</td>
							<td>未读</td>
							<td>资源审核</td>
							<td>2017-02-25 22:14:53</td>
							<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看详情</button><button class="btn btn-link delete">删除</button></a></td>
						</tr>
						<tr>
							<td>5</td>
							<td>1</td>
							<td>未读</td>
							<td>用户反馈</td>
							<td>2017-02-25 22:14:53</td>
							<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看详情</button><button class="btn btn-link delete">删除</button></a></td>
						</tr>

						</tbody>

						<!-- tbody是必须的 -->
					</table>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
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
			<li><span>消息名称:</span>有人报名了你的资源</li>
			<li><span>消息时间:</span>2017-03-10 16:11:38</li>
			<li><span>发送人:</span>系统提示</li>
			<li><span>消息内容:</span>你发布的资源金牛万达广场发传单已经有人报名了，请前去处理</li>
		</ul>
	</div>
</div>
<!--查看弹窗end-->
<!--删除弹窗end-->
<div class="pop" onclick="closepop()" style="display: none;"></div>
<!-- basic scripts -->
<%@include file="commonFoot.jsp"%>
	<script src="${resource}/resource/js/teacher_message.js"></script>
    <script src="${resource}/resource/js/moment.js"></script>

	<script type="text/javascript">

		function closepop(){
				$(".pop").hide();
				$(".popinto").hide();
			}
			jQuery(function($) {
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
