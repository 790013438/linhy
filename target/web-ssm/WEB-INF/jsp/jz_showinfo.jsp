<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="resource" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta charset="utf-8" />
		<title>XX大学生兼职系统--企业端</title>
		<meta name="keywords" content="大学生兼职系统" />
		<meta name="description" content="转为大学和企业用户设计的桥梁" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->

		<link href="${resource}/resource/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${resource}/resource/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="${resource}/resource/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<link rel="stylesheet" href="${resource}/resource/css/jquery-ui-1.10.3.custom.min.css" />
		<link rel="stylesheet" href="${resource}/resource/css/jquery.gritter.css" />
		<link rel="stylesheet" href="${resource}/resource/css/select2.css" />
		<link rel="stylesheet" href="${resource}/resource/css/bootstrap-editable.css" />

		<!-- fonts -->

		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->

		<link rel="stylesheet" href="${resource}/resource/css/ace.min.css" />
		<link rel="stylesheet" href="${resource}/resource/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${resource}/resource/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${resource}/resource/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="${resource}/resource/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${resource}/resource/js/html5shiv.js"></script>
		<script src="${resource}/resource/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							大学生兼职系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">5</span>
							</a>

							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
								<a href="#">
									<i class="icon-envelope-alt"></i>
									5 Messages
									</a>
								</li>							
							</ul>
						</li>
						<!-- 右上角头像信息维护 -->
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${resource}/resource/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎您,</small>
									XX公司
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-user"></i>
										个人信息
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<ul class="nav nav-list">
						<li>
							<a href="jz_index.jsp">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 企业端 </span>
							</a>
						</li>
						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 兼职管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="jz_fbjz.jsp">
										<i class="icon-double-angle-right"></i>
										发布兼职
									</a>
								</li>

								<li>
									<a href="jz_index.jsp">
										<i class="icon-double-angle-right"></i>
										我的兼职
									</a>
								</li>
							</ul>
						</li>


						<li class="active">
							<a href="jz_myinfo.jsp">
								<i class="icon-text-width"></i>
								<span class="menu-text"> 我的信息 </span>
							</a>
						</li>

						<li >
							<a href="jz_myMessage.jsp">
								<i class="icon-text-width" ></i>
								<span class="menu-text"> 我的消息 </span>
							</a>
						</li>
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

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

												<li>
													<a data-toggle="tab" href="#feed">
														<i class="orange icon-rss bigger-120"></i>
														评论
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
																<span class="middle">XXX公司</span>
															</h4>

															<div class="profile-user-info">
																<div class="profile-info-row">
																	<div class="profile-info-name"> 公司名 </div>

																	<div class="profile-info-value">
																		<span>XXXXX有限科技</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> 位置 </div>

																	<div class="profile-info-value">
																		<i class="icon-map-marker light-orange bigger-110"></i>
																		<span>四川省</span>
																		<span>成都市</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> 测试 </div>

																	<div class="profile-info-value">
																		<span>38</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> 加入时间 </div>

																	<div class="profile-info-value">
																		<span>20/06/2010</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> Last Online </div>

																	<div class="profile-info-value">
																		<span>3 hours ago</span>
																	</div>
																</div>
															</div>

															<div class="hr hr-8 dotted"></div>

															<div class="profile-user-info">
																<div class="profile-info-row">
																	<div class="profile-info-name"> Website </div>

																	<div class="profile-info-value">
																		<a href="#" target="_blank">www.alexdoe.com</a>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">
																		<i class="middle icon-facebook-sign bigger-150 blue"></i>
																	</div>

																	<div class="profile-info-value">
																		<a href="#">Find me on Facebook</a>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">
																		<i class="middle icon-twitter-sign bigger-150 light-blue"></i>
																	</div>

																	<div class="profile-info-value">
																		<a href="#">Follow me on Twitter</a>
																	</div>
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

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${resource}/resource/js/bootstrap.min.js"></script>
		<script src="${resource}/resource/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="${resource}/resource/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="${resource}/resource/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${resource}/resource/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${resource}/resource/js/jquery.gritter.min.js"></script>
		<script src="${resource}/resource/js/bootbox.min.js"></script>
		<script src="${resource}/resource/js/jquery.slimscroll.min.js"></script>
		<script src="${resource}/resource/js/jquery.easy-pie-chart.min.js"></script>
		<script src="${resource}/resource/js/jquery.hotkeys.min.js"></script>
		<script src="${resource}/resource/js/bootstrap-wysiwyg.min.js"></script>
		<script src="${resource}/resource/js/select2.min.js"></script>
		<script src="${resource}/resource/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="${resource}/resource/js/fuelux/fuelux.spinner.min.js"></script>
		<script src="${resource}/resource/js/x-editable/bootstrap-editable.min.js"></script>
		<script src="${resource}/resource/js/x-editable/ace-editable.min.js"></script>
		<script src="${resource}/resource/js/jquery.maskedinput.min.js"></script>

		<!-- ace scripts -->

		<script src="${resource}/resource/js/ace-elements.min.js"></script>
		<script src="${resource}/resource/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
		
		</script>
</body>
</html>
