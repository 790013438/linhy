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
								<a href="/teacher/index">首页</a>
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
									请合理准确的输入资源信息
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
											<%--<input type="text" id="input_jobType" placeholder="" class="col-xs-10 col-sm-5" />--%>
												<select id="input_jobType" class="col-xs-10 col-sm-5">
													<option value ="讲义">讲义</option>
													<option value ="课件">课件</option>
													<option value="录像">录像</option>
													<option value="教材">教材</option>
													<option value ="指导书">指导书</option>
													<option value="软件">软件</option>
													<option value="代码">代码</option>
												</select>
										</div>
									</div>
									<div class="space-4"></div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 资源描述 </label>

										<div class="col-sm-9">
											<textarea placeholder="资源描述" maxlength="500" id="input_introduction" class="col-xs-10 col-sm-5" ></textarea>
											<%--<input  id="input_introduction" placeholder="资源描述" class="col-xs-10 col-sm-5" />--%>
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 建议每日学习时长</label>

										<div class="col-sm-6">
											<input  id="job_hours" placeholder="资源时长（时）" onchange="checkHours(this.value)" maxlength="5" class="col-xs-10 col-sm-5" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"> 截止时间</label>

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
                                <div></div>
                                <form class="form-horizontal" id="fromFile" method="post" enctype="multipart/form-data" action="/teacher/addJobFiles">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right"> 上传文件(如果需要多文件上传，请一次性选择多个需要上传的文件)</label>

                                        <div class="col-sm-6">
                                            <input  name="job_file" type="file" placeholder="上传的文件" multiple="multiple" maxlength="5" class="col-xs-10 col-sm-5" />
                                        </div>
                                    </div>
                                    <div align="center">
                                        <button style="width:200px;height:50px;background:white;" id="btn_saveFile" type="submit" disabled="disabled">文件上传</button>
                                    </div>
                                </form>
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
	<script src="${resource}/resource/js/teacher_addJob.js"></script>
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
