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

							<li class="active">发布兼职</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								兼职信息发布
								<small>
									<i class="icon-double-angle-right"></i>
									请合理准确的输入兼职信息（请勿填写虚假等信息，如发现将受到惩罚）
								</small>
							</h1>
						</div><!-- /.page-header -->


					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<form class="form-horizontal" id="formJob">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 兼职名称 </label>

										<div class="col-sm-9">
											<input type="text" id="input_jobName" placeholder="请输入兼职名称" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 兼职类型 </label>
										<div class="col-sm-2">
											<select class="form-control" id="select_jobtype">
												<option value="">选择兼职类型</option>
												<option value="">11</option>
															</select>
														</div>
									</div>
									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 兼职人数</label>

										<div class="col-sm-9">
											<input  id="input_jobNumber" placeholder="兼职人数" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" > 工作地址 </label>

										<div class="col-sm-9">
											<input type="text" id="input_jobAddress" placeholder="工作地址" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 性别要求 </label>
										<div class="col-sm-2">
											<select class="form-control" id="requires_gender">
												<option value="">性别要求</option>
												<option value="">女</option>
											</select>
										</div>
									</div>
									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 兼职描述 </label>

										<div class="col-sm-9">
											<input  id="input_introduction" placeholder="兼职描述" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">备注信息</label>

										<div class="col-sm-9">
											<input  id="job_remarks" placeholder="备注信息" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" > 薪资类型 </label>
										<div class="col-sm-2">
											<select class="form-control" id="salary_type">
												<option value="">薪资类型</option>
												<option value="">000</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" > 薪资金额</label>

										<div class="col-sm-9">
											<input type="text" id="salary_salary" placeholder="薪资金额" class="col-xs-10 col-sm-5" />
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 每日工作时长</label>

										<div class="col-sm-9">
											<input  id="job_hours" placeholder="兼职时长" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 兼职时间</label>

										<div class="col-sm-2 input-group input-group-sm">
													<input type="text" id="datepicker" class="form-control hasDatepicker">
													<span class="input-group-addon">
														<i class="icon-calendar"></i>
													</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 报名截止时间</label>

										<div class="col-sm-2 input-group input-group-sm">
													<input type="text" id="" class="form-control hasDatepicker">
													<span class="input-group-addon">
														<i class="icon-calendar"></i>
													</span>
										</div>
									</div>
									<div align="center">
										<button style="width:200px;height:50px;background:#338FCC;" id="btn_saveJob" type="submit">保存</button>
									</div>
								</form>
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
		<!-- basic scripts -->
	<%@include file="commonFoot.jsp"%>
	<script type="text/javascript">
			jQuery(function($) {

				$(document).ready(function(){
        			$('#example').DataTable();
    			});
			})
		</script>
</body>
</html>
