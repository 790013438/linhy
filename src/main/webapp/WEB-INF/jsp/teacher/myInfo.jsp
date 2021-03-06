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

							<li>
								<a href="#">信息维护</a>
							</li>
							<li class="active">教师信息</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								教师信息
								<small>
									<i class="icon-double-angle-right"></i>
									可对教师信息进行维护和登录密码更改
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div>
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-1 col-sm-10">
											<form class="form-horizontal">
												<div class="tabbable">
													<ul class="nav nav-tabs padding-16">
													<li class="active" id="li_basic">
														<a data-toggle="tab" href="#edit-basic">
															<i class="green icon-edit bigger-125"></i>
															基础信息
														</a>
													</li>

													<li id="li_password">
														<a data-toggle="tab" href="#edit-password">
															<i class="blue icon-key bigger-125"></i>
															密码修改
														</a>
													</li>
													</ul>

													<div class="tab-content profile-edit-tab-content">
														<div id="edit-basic" class="tab-pane in active">
															<h4 class="header blue bolder smaller">常规信息</h4>

															<div class="row">
																<div class="col-xs-12 col-sm-4">
																	<img class="nav-user-photo" src="${resource}/resource/avatars/profile-pic.jpg"/>
																</div>

																<div class="vspace-xs"></div>

																<div class="col-xs-12 col-sm-8">
																	<div class="form-group">
																		<label class="col-sm-4 control-label no-padding-right">账户名</label>

																		<div class="col-sm-8">
																			<input class="col-xs-12 col-sm-6" type="text" id="tea_account" placeholder="Username" value="" />
																		</div>
																	</div>

																	<div class="space-4"></div>

																	<div class="form-group">
																		<label class="col-sm-4 control-label no-padding-right">就职单位名称</label>

																		<div class="col-sm-8">
																			<input class="col-xs-12 col-sm-6" type="text" id="tea_name" placeholder="就职单位名称" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-4 control-label no-padding-right">职称</label>

																		<div class="col-sm-8">
																			<input class="col-xs-12 col-sm-6" type="text" id="tea_contacts" placeholder="职称" value="" />
																		</div>
																	</div>
																</div>
															</div>

															<hr />
															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right">所在地</label>
																<div class="col-sm-9">
																	<textarea class="col-xs-12 col-sm-8" id="tea_address"></textarea>
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right">教师简介</label>

																<div class="col-sm-9">
																	<textarea class="col-xs-12 col-sm-8" id="tea_info"></textarea>
																</div>
															</div>

															<div class="space"></div>
															<h4 class="header blue bolder smaller">联系方式</h4>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" >邮箱</label>

																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input type="email" id="input_email" value="" />
																		<i class="icon-envelope"></i>
																	</span>
																</div>
															</div>

															<div class="space-4"></div>

															<%--<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" >网站</label>

																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input type="url" id="comm_website" value="" />
																		<i class="icon-globe"></i>
																	</span>
																</div>
															</div>   myself--%>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right">联系电话</label>

																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input class="input-medium input-mask-phone" type="text" id="input_phone" />
																		<i class="icon-phone icon-flip-horizontal"></i>
																	</span>
																</div>
															</div>

															<div class="space"></div>

															<div class="space-4"></div>

														</div>


														<div id="edit-password" class="tab-pane">
															<div class="space-10"></div>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" >旧密码</label>

																<div class="col-sm-9">
																	<input type="password" id="form-field-oldPass" />
																</div>
															</div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" id="label_pass" style="color:#646464">新密码</label>

																<div class="col-sm-9">
																	<input type="password" id="form-field-newPass" />
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right">确认密码</label>

																<div class="col-sm-9">
																	<input type="password" onchange="checkPassword()" id="form-field-rePass" />
																</div>
															</div>
														</div>
													</div>
												</div>

												<div class="clearfix form-actions">
													<div class="col-md-offset-3 col-md-9">
														<button class="btn btn-info" type="button" id="btn_save">
															<i class="icon-ok bigger-110"></i>
															Save
														</button>

														&nbsp; &nbsp;
													</div>
												</div>
											</form>
										</div><!-- /span -->
									</div><!-- /user-profile -->
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
	<script src="${resource}/resource/js/check.js"></script>
	<script src="${resource}/resource/js/teacher_myInfo.js"></script>


		<%--<script type="text/javascript">--%>
			<%--jQuery(function($) {--%>

				<%--///////////////////////////////////////////--%>
				<%--$('#user-profile-3')--%>
				<%--.find('input[type=file]').ace_file_input({--%>
					<%--style:'well',--%>
					<%--btn_choose:'Change avatar',--%>
					<%--btn_change:null,--%>
					<%--no_icon:'icon-picture',--%>
					<%--thumbnail:'large',--%>
					<%--droppable:true,--%>
					<%--before_change: function(files, dropped) {--%>
						<%--var file = files[0];--%>
						<%--if(typeof file === "string") {//files is just a file name here (in browsers that don't support FileReader API)--%>
							<%--if(! (/\.(jpe?g|png|gif)$/i).test(file) ) return false;--%>
						<%--}--%>
						<%--else {//file is a File object--%>
							<%--var type = $.trim(file.type);--%>
							<%--if( ( type.length > 0 && ! (/^image\/(jpe?g|png|gif)$/i).test(type) )--%>
									<%--|| ( type.length == 0 && ! (/\.(jpe?g|png|gif)$/i).test(file.name) )//for android default browser!--%>
								<%--) return false;--%>

							<%--if( file.size > 110000 ) {//~100Kb--%>
								<%--return false;--%>
							<%--}--%>
						<%--}--%>

						<%--return true;--%>
					<%--}--%>
				<%--})--%>



			<%--});--%>
		<%--</script>--%>
</body>
</html>
