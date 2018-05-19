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
								<a href="/teacher/index">首页</a>
							</li>

							<li class="active">我的资源</li>
							
						</ul><!-- .breadcrumb -->
						<div style="position:absolute;top:3px;right:22px;line-height:24px">
							<button class="btn btn-sm btn-primary" onclick="window.location='../teacher/addJob'">发布资源</button>
							<button class="btn btn-sm btn-primary" onclick="window.location='../teacher/addHom'">发布作业</button>
						</div>
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div id="container"> 
   								<!-- 定义一个表格元素 --> 
   									<table id="table_jobs" class="table table-striped table-bordered datatables-job">
    									<thead> 
     										<tr> 
      											<th>序号</th> 
      											<th>标题</th>
												<th>类型</th>
      											<th>状态</th> 
      											<%--<th>需求人</th> --%>
      											<th>报名数</th> 
      											<th>截止时间</th> 
      											<th>操作</th> 
     										</tr> 
    									</thead> 
    									<tbody>

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
<div class="popinto" id="popinto_remove">
    <div class="font16 center deletediv">将改资源从列表中移除？</div>
    <div class="deletediv_btn">
        <p class="pull-left"><button type="button" class="btn btn-primary" id="btn_removeJob">确定</button></p>
        <p class="pull-right"><button type="button" class="btn btn-default" onclick="closepop()">取消</button></p>
        <input hidden="hidden" id="input_jobId"/>
    </div>
</div>
<!--删除弹窗end-->
	<!--删除弹窗start-->
	<div class="popinto" id="popinto_close">
		<div class="font16 center deletediv">资源还未结束，确定关闭该资源？</div>
		<div class="deletediv_btn">
			<p class="pull-left"><button type="button" class="btn btn-primary" id="btn_closeJob">确定</button></p>
			<p class="pull-right"><button type="button" class="btn btn-default" onclick="closepop()">取消</button></p>
		</div>
	</div>
	<!--删除弹窗end-->
<div class="pop" onclick="closepop()" style="display: none;"></div>
   <%@include file="commonFoot.jsp"%>
	<script src="${resource}/resource/js/moment.js"></script>
	<script src="${resource}/resource/js/teacher_myJobs.js"></script>
		<script type="text/javascript">
			function closepop(){
				$(".pop").hide();
				$(".popinto").hide();
			}
		</script>
</body>
</html>
