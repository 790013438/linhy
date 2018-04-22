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

							<li class="active">发布资源</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								资源信息发布
								<small>
									<i class="icon-double-angle-right"></i>
									请合理准确的输入资源信息（请勿发布虚假信息，如发现将受到惩罚）
								</small>
							</h1>
						</div><!-- /.page-header -->


					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<form class="form-horizontal" id="formJob">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 资源名称 </label>

										<div class="col-sm-6">
											<input type="text" id="input_jobName" maxlength="100" placeholder="请输入资源名称" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 资源类型 </label>
										<div class="col-sm-6">
											<input type="text" id="input_jobType" placeholder="如：翻译" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 需求人数</label>

										<div class="col-sm-6">
											<input  id="input_jobNumber" maxlength="10" onchange="checkNumber(this.value)" placeholder="需求人数" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" > 工作地址 </label>

										<div class="col-sm-9">
											<textarea placeholder="工作地址" maxlength="100" id="input_jobAddress" class="col-xs-10 col-sm-5" ></textarea>
											<%--<input type="text" id="input_jobAddress" placeholder="工作地址" class="col-xs-10 col-sm-5" />--%>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 性别要求 </label>
										<div class="col-sm-2">
											<select class="form-control" id="requires_gender">
												<option value="">性别要求</option>
												<option value="male">男</option>
												<option value="female">女</option>
												<option value="unlimited">不限</option>
											</select>
										</div>
									</div>
									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 资源描述 </label>

										<div class="col-sm-9">
											<textarea placeholder="资源描述" maxlength="500" id="input_introduction" class="col-xs-10 col-sm-5" ></textarea>
											<%--<input  id="input_introduction" placeholder="资源描述" class="col-xs-10 col-sm-5" />--%>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">备注信息</label>

										<div class="col-sm-9">
											<textarea placeholder="备注信息" maxlength="100" id="job_remarks" class="col-xs-10 col-sm-5" ></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" > 薪资类型 </label>
										<div class="col-sm-2">
											<select class="form-control" id="salary_type">
												<option value="">薪资类型</option>
												<option value="monthly_pay">月薪</option>
												<option value="daily_wage">日薪</option>
												<option value="hourly_wage">时薪</option>
												<option value="other">其他</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" > 薪资金额</label>

										<div class="col-sm-6">
											<input type="text" id="salary_salary" onchange="checkSalary(this.value)" maxlength="10" placeholder="薪资金额（元）" class="col-xs-10 col-sm-5" />
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 每日工作时长</label>

										<div class="col-sm-6">
											<input  id="job_hours" placeholder="资源时长（时）" onchange="checkHours(this.value)" maxlength="5" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 资源时间</label>

										<div class="col-sm-2 input-group input-group-sm">
													<input type="text" id="input_jobTime" class="form-control hasDatepicker date-picker" id="jobTime" data-date-format="yyyy-mm-dd">
													<span class="input-group-addon">
														<i class="icon-calendar"></i>
													</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 报名截止时间</label>

										<div class="col-sm-2 input-group input-group-sm">
													<input type="text" id="input_deadline" class="form-control hasDatepicker date-picker" data-date-format="yyyy-mm-dd" >
													<span class="input-group-addon">
														<i class="icon-calendar"></i>
													</span>
										</div>
									</div>
									<div align="center">
										<button style="width:200px;height:50px;background:#338FCC;" id="btn_saveJob" type="button">保存</button>
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
	<script src="${resource}/resource/js/moment.js"></script>
	<script src="${resource}/resource/js/company_addJob.js"></script>
	<script src="${resource}/resource/js/check.js"></script>

	<script type="text/javascript">
			jQuery(function($) {
                $('.date-picker').datepicker({
                    autoclose: true,
                    todayHighlight: true
                })

                $(document).ready(function(){
        			$('#example').DataTable();
    			});
			})
		</script>
</body>
</html>
