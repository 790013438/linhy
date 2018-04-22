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

							<li class="active">资源详情</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								资源信息
								<small>
									<i class="icon-double-angle-right"></i>
									请仔细核查资源信息，避免不实资源信息。
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
																<button class="btn btn-xs btn-link" id="btn_appli"></button>
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
	<div class="popinto" id="popinto_adoptPop">
		<div class="font16 center deletediv">请选择对该资源的审核结果</div>
		<div class="deletediv_btn">
			<p class="pull-left"><button type="button" class="btn btn-primary" id="btnAdoptJob">通过</button></p>
			<p class="pull-right"><button type="button" class="btn btn-default" id="btnRefuseJob" >拒绝</button></p>
			<input hidden="hidden" id="input_jobId"/>
		</div>
	</div>
	<div class="popinto" id="popinto_delPop">
		<div class="font16 center deletediv"></div>
		<div class="deletediv_btn">
			<p class="pull-left"><button type="button" class="btn btn-primary" id="btn_delJob">确定</button></p>
			<p class="pull-right"><button type="button" class="btn btn-default" onclick="closepop()">取消</button></p>
		</div>
	</div>
	<div class="pop" onclick="closepop()" style="display: none;"></div>
	<%@include file="commonFoot.jsp"%>
	<script src="${resource}/resource/js/system_jobInfo.js"></script>
	<script src="${resource}/resource/js/moment.js"></script>
	</body>
</html>
