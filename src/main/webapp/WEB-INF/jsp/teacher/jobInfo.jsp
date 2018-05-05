<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="resource" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh">
	<head>
		<%@include file="commonHead.jsp"%>
	</head>
		<%@include file="commonLeft.jsp"%>
		<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="index.jsp">首页</a>
							</li>

							<li class="active">资源详情</li>
						</ul><!-- .breadcrumb -->
						<div style="position:absolute;top:3px;right:22px;line-height:24px">
							<button class="btn btn-sm btn-primary" onclick="window.location='jz_fbjz.jsp'">发布资源</button>
						</div>
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								资源信息
								<small>
									<i class="icon-double-angle-right"></i>
									资源报名情况
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
														<h4 class="smaller">资源详情</h4>
														<div class="widget-toolbar">
															<label>
																<button class="btn btn-xs btn-link" id="btn_appli"></button>
																<input value="" id="jobId" type="hidden"></li>
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

										<div class="row">
											<div class="col-sm-12">
											<div class="tabbable">
											<ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="myTab4">
												<li class="active">
													<a data-toggle="tab" href="#div_home">未处理列表</a>
												</li>

												<li>
													<a data-toggle="tab" href="#div_home1">已通过</a>
												</li>

												<li>
													<a data-toggle="tab" href="#div_home2">已拒绝</a>
												</li>
											</ul>

											<div class="tab-content">
												<div id="div_home" class="tab-pane in active">
													<table id="table_wating" class="table table-striped table-bordered">
    									<thead> 
     										<tr> 
      											<th>序号</th> 
      											<th>用户名</th> 
      											<th>性别</th>
												<th>用户真实姓名</th>
												<th>专业</th>
												<th>邮箱</th>
												<th>联系电话</th>
      											<th>操作</th> 
     										</tr> 
    									</thead> 
    									<tbody>

    									</tbody> 
    
    								<!-- tbody是必须的 --> 
   									</table> 
												</div>
												<div id="div_home1" class="tab-pane">
													<table id="table_success" class="table table-striped table-bordered tab-dataTable">
														<thead>
														<tr>
															<th>序号</th>
															<th>用户名</th>
															<th>性别</th>
															<th>用户真实姓名</th>
															<th>专业</th>
															<th>邮箱</th>
															<th>联系电话</th>
															<th>操作</th>
														</tr>
														</thead>
														<tbody>

														</tbody>

														<!-- tbody是必须的 -->
													</table>
												</div>

												<div id="div_home2" class="tab-pane">
													<table id="table_fail" class="table table-striped table-bordered">
														<thead>
														<tr>
															<th>序号</th>
															<th>用户名</th>
															<th>性别</th>
															<th>用户真实姓名</th>
															<th>专业</th>
															<th>邮箱</th>
															<th>联系电话</th>
															<th>操作</th>
														</tr>
														</thead>
														<tbody>

														</tbody>

														<!-- tbody是必须的 -->
													</table>
												</div>
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
	<!--删除弹窗start-->
	<div class="popinto" id="popinto_delRecord" style="top: 65%">
		<div class="font16 center deletediv">真的要删除该记录吗？</div>
		<div class="deletediv_btn">
			<p class="pull-left"><button type="button" class="btn btn-primary" id="btn_delRecord">确定</button></p>
			<p class="pull-right"><button type="button" class="btn btn-default" onclick="closepop()">取消</button></p>
			<input hidden="hidden" id="input_appliId"/>
		</div>
	</div>
	<!--删除弹窗end-->
	<!--删除弹窗start-->
	<div class="popinto" id="popinto_screen" style="top: 65%">
		<div class="font16 center deletediv">是否同意用户申请？</div>
		<div class="deletediv_btn">
			<p class="pull-left"><button type="button" class="btn btn-primary" id="btn_agree">同意</button></p>
			<p class="pull-left"><button type="button" class="btn btn-primary" id="btn_refuse">拒绝</button></p>
			<input hidden="hidden" id="input_userId"/>
			<%--<input hidden="hidden" id="input_jobDemandNumber"/>--%>
		</div>
	</div>
	<div class="pop" onclick="closepop()" style="display: none;"></div>
	<!--删除弹窗end-->
	<%@include file="commonFoot.jsp"%>
	<script src="${resource}/resource/js/teacher_jobInfo.js"></script>
	<script src="${resource}/resource/js/moment.js"></script>
	<script type="text/javascript">
			jQuery(function($) {

				$(document).ready(function(){
        			$('#example').DataTable();
    			});
			})
		</script>
</body>
</html>
