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
								<a href="jz_index.jsp">首页</a>
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
									请合理准确的输入资源信息（请勿填写虚假等信息，如发现将受到惩罚）
								</small>
							</h1>
						</div><!-- /.page-header -->


					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 资源名称 </label>

										<div class="col-sm-9">
											<input type="text" id="form-field-1" placeholder="请输入资源名称" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 资源类型 </label>
										<div class="col-sm-2">
											<select class="form-control" id="form-field-select-2">
												<option value="">发传单</option>
																<option value="AL">销售</option>
																<option value="AK">礼仪</option>
																<option value="AZ">翻译</option>
																<option value="AR">其他</option>
															</select>
														</div>
									</div>
									

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 资源人数</label>

										<div class="col-sm-9">
											<input type="password" id="form-field-2" placeholder="资源人数" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 工作地址 </label>

										<div class="col-sm-9">
											<input type="text" id="form-field-1" placeholder="工作地址" class="col-xs-10 col-sm-5" />
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 资源描述 </label>

										<div class="col-sm-9">
											<input type="password" id="form-field-2" placeholder="资源描述" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 薪资类型 </label>
										<div class="col-sm-2">
											<select class="form-control" id="form-field-select-1">
												<option value="">时新</option>
													<option value="AL">日薪</option>
													<option value="AK">计件</option>
													<option value="AZ">其他</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 薪资金额</label>

										<div class="col-sm-9">
											<input type="text" id="form-field-1" placeholder="薪资金额" class="col-xs-10 col-sm-5" />
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 资源时长</label>

										<div class="col-sm-9">
											<input type="password" id="form-field-2" placeholder="资源时长" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 资源时间</label>

										<div class="col-sm-2 input-group input-group-sm">
													<input type="text" id="datepicker" class="form-control hasDatepicker">
													<span class="input-group-addon">
														<i class="icon-calendar"></i>
													</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 报名截止时间</label>

										<div class="col-sm-2 input-group input-group-sm">
													<input type="text" id="datepicker" class="form-control hasDatepicker">
													<span class="input-group-addon">
														<i class="icon-calendar"></i>
													</span>
										</div>
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

	<%@include file="commonFoot.jsp"%>


		<script type="text/javascript">
			jQuery(function($) {

				$(document).ready(function(){
        			$('#example').DataTable();
    			});
				// var oTable1 = $('#sample-table-2').dataTable( {
				// "aoColumns": [
			 //      { "bSortable": false },
			 //      null, null,null, null, null,
				//   { "bSortable": false }
				// ] } );
				
				
				// $('table th input:checkbox').on('click' , function(){
				// 	var that = this;
				// 	$(this).closest('table').find('tr > td:first-child input:checkbox')
				// 	.each(function(){
				// 		this.checked = that.checked;
				// 		$(this).closest('tr').toggleClass('selected');
				// 	});
						
				// });
			
			
				// $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				// function tooltip_placement(context, source) {
				// 	var $source = $(source);
				// 	var $parent = $source.closest('table')
				// 	var off1 = $parent.offset();
				// 	var w1 = $parent.width();
			
				// 	var off2 = $source.offset();
				// 	var w2 = $source.width();
			
				// 	if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
				// 	return 'left';
				// }
			})
		</script>
</body>
</html>
