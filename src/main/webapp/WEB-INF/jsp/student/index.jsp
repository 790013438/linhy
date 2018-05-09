<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="resource" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
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

							<li class="active">资源中心</li>
							
						</ul><!-- .breadcrumb -->
						<div style="position:absolute;top:3px;right:22px;line-height:24px">
							<button class="btn btn-sm btn-primary" onclick="window.location='../student/index'">资源中心</button>
							<button class="btn btn-sm btn-primary" onclick="window.location='../student/homIndex'">作业中心</button>
						</div>
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div id="container"> 
   								<!-- 定义一个表格元素 --> 
   									<table class="table table-striped table-bordered" id="job_list">
    									<thead> 
     										<tr>
												<th>序号</th>
      											<th>标题</th> 
      											<th>类型</th>
												<th>教师名称</th>
												<th>报名人数</th>
      											<th>截止时间</th> 
      										<%--	<th>薪资类型</th> --%>
      											<%--<th>薪资金额</th> --%>
      											<th>操作</th> 
     										</tr> 
    									</thead> 
    									<tbody id="tbody_jobList">

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
</div>
	<%@include file="commonFoot.jsp"%>
	<script src="${resource}/resource/js/moment.js"></script><%--myself--%>
	<script src="${resource}/resource/js/person_index.js"></script>
	</body>
</html>
