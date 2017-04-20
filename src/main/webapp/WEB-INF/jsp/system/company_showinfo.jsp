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
								<a href="#">首页</a>
							</li>

							<li>
								<a href="#">信息查看</a>
							</li>
							<li class="active">公司信息</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								公司信息
								<small>
									<i class="icon-double-angle-right"></i>
									查看公司信息及评论信息
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div >
									<div id="user-profile-2" class="user-profile">
										<div class="tabbable">
											<ul class="nav nav-tabs padding-18">
												<li class="active">
													<a data-toggle="tab" href="#home">
														<i class="green icon-user bigger-120"></i>
														个人信息
													</a>
												</li>
											</ul>

											<div class="tab-content no-border padding-24">
												<div id="home" class="tab-pane in active">
													<div class="row">
														<div class="col-xs-12 col-sm-3 center">
															<span class="profile-picture">
																<img class="editable img-responsive" alt="Alex's Avatar" id="avatar2" src="${resource}/resource/avatars/profile-pic.jpg" />
															</span>

															<div class="space space-4"></div>
														</div><!-- /span -->

														<div class="col-xs-12 col-sm-9">
															<h4 class="blue">
																<span class="middle" id="company_name"></span>
															</h4>

															<div class="profile-user-info">
																<div class="profile-info-row">
																	<div class="profile-info-name"> 企业账号 </div>

																	<div class="profile-info-value">
																		<span id="span_account">无</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> 公司名 </div>

																	<div class="profile-info-value">
																		<span id="span_name">无</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> 公司联系人 </div>

																	<div class="profile-info-value">
																		<span id="span_contacts">无</span>
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name"> 公司地址 </div>

																	<div class="profile-info-value">
																		<span id="span_address">无</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> 公司简介 </div>

																	<div class="profile-info-value">
																		<span id="span_info">无</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> 联系电话 </div>

																	<div class="profile-info-value">
																		<span id="span_phone">无</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> 公司邮箱 </div>

																	<div class="profile-info-value">
																		<span id="span_email">无</span>
																	</div>
																</div>
															</div>

															<div class="hr hr-8 dotted"></div>

															<div class="profile-user-info">
																<div class="profile-info-row">
																	<div class="profile-info-name"> 公司网站 </div>

																	<div class="profile-info-value">
																		<span id="span_website">无</span>																	</div>
																</div>
															</div>
														</div><!-- /span -->
													</div><!-- /row-fluid -->

													<div class="space-20"></div>
												</div><!-- #home -->

												<div id="feed" class="tab-pane">
													<div class="profile-feed row-fluid">
														<div class="span6">
															<div class="profile-activity clearfix">
																<div>

																	<img class="pull-left" alt="Alex Doe's avatar" src="${resource}/resource/avatars/avatar5.png" />
																	<a class="user" href="#"> Alex Doe </a>
																	changed his profile photo.
																	<a href="#">Take a look</a>

																	<div class="time">
																		<i class="icon-time bigger-110"></i>
																		an hour ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="icon-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="icon-remove bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<img class="pull-left" alt="Susan Smith's avatar" src="${resource}/resource/avatars/avatar1.png" />
																	<a class="user" href="#"> Susan Smith </a>

																	is now friends with Alex Doe.
																	<div class="time">
																		<i class="icon-time bigger-110"></i>
																		2 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="icon-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="icon-remove bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon icon-ok btn-success no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>
																	joined
																	<a href="#">Country Music</a>

																	group.
																	<div class="time">
																		<i class="icon-time bigger-110"></i>
																		5 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="icon-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="icon-remove bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon icon-picture btn-info no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>
																	uploaded a new photo.
																	<a href="#">Take a look</a>

																	<div class="time">
																		<i class="icon-time bigger-110"></i>
																		5 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="icon-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="icon-remove bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<img class="pull-left" alt="David Palms's avatar" src="${resource}/resource/avatars/avatar4.png" />
																	<a class="user" href="#"> David Palms </a>

																	left a comment on Alex's wall.
																	<div class="time">
																		<i class="icon-time bigger-110"></i>
																		8 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="icon-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="icon-remove bigger-125"></i>
																	</a>
																</div>
															</div>
														</div><!-- /span -->

														<div class="span6">
															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon icon-edit btn-pink no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>
																	published a new blog post.
																	<a href="#">Read now</a>

																	<div class="time">
																		<i class="icon-time bigger-110"></i>
																		11 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="icon-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="icon-remove bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<img class="pull-left" alt="Alex Doe's avatar" src="${resource}/resource/avatars/avatar5.png" />
																	<a class="user" href="#"> Alex Doe </a>

																	upgraded his skills.
																	<div class="time">
																		<i class="icon-time bigger-110"></i>
																		12 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="icon-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="icon-remove bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon icon-key btn-info no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>

																	logged in.
																	<div class="time">
																		<i class="icon-time bigger-110"></i>
																		12 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="icon-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="icon-remove bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon icon-off btn-inverse no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>

																	logged out.
																	<div class="time">
																		<i class="icon-time bigger-110"></i>
																		16 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="icon-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="icon-remove bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon icon-key btn-info no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>

																	logged in.
																	<div class="time">
																		<i class="icon-time bigger-110"></i>
																		16 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="icon-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="icon-remove bigger-125"></i>
																	</a>
																</div>
															</div>
														</div><!-- /span -->
													</div><!-- /row -->
												</div><!-- /#feed -->
											</div>
										</div>
									</div>
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

	<%@include file="commonFoot.jsp"%>
	<script src="${resource}/resource/js/moment.js"></script>
	<script src="${resource}/resource/js/company_showInfo.js"></script>
		<script type="text/javascript">
		
		</script>
</body>
</html>
