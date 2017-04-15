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
								<a href="person_index.jsp">首页</a>
							</li>

							<li class="active">兼职详情</li>
						</ul><!-- .breadcrumb -->
						<div style="position:absolute;top:3px;right:22px;line-height:24px">
							<button class="btn btn-sm btn-primary" onclick="window.location='../student/index'">兼职中心</button>
						</div>
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								兼职信息
								<small>
									<i class="icon-double-angle-right"></i>
									请勿相信轻松高薪等兼职，如发现不合理信息请及时举报。
								</small>
							</h1>
						</div><!-- /.page-header -->


					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="col-sm-12">
										<div class="row">
											<div class="col-xs-12">
												<div class="widget-box">
													<div class="widget-header widget-header-flat">
														<h4 class="smaller">成都金牛万达广场发传单</h4>

														<div class="widget-toolbar">
															<label>
																<button class="btn btn-xs btn-link" onclick="window.location='jz_fbjz.jsp'">报名兼职</button>
															</label>
														</div>
													</div>

													<div class="widget-body">
														<div class="widget-main">
															<ul id="ul_jobDetail">

															</ul>
														</div>
													</div>
												</div>
											</div>
										</div>

										<hr/>
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
	<%@include file="commonFoot.jsp"%>
	<script src="${resource}/resource/js/jobInfo.js"></script>
	<script src="${resource}/resource/js/moment.js"></script>
	</body>
</html>
