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
								<a href="jz_index.jsp">首页</a>
							</li>

							<li class="active">兼职详情</li>
						</ul><!-- .breadcrumb -->
						<div style="position:absolute;top:3px;right:22px;line-height:24px">
							<button class="btn btn-sm btn-primary" onclick="window.location='jz_fbjz.jsp'">发布兼职</button>
						</div>
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								兼职信息
								<small>
									<i class="icon-double-angle-right"></i>
									兼职报名情况
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
																<small class="green">
																	<b>已审核</b>
																</small>
															</label>
														</div>
													</div>

													<div class="widget-body">
														<div class="widget-main">
															<dl id="dt-list-1">
																<dt>兼职标题：成都金牛万达广场发传单</dt>
																<dt>兼职类型：发传单</dt>
																<dt>需求人数：5人</dt>
																<dt>报名人数：1人</dt>
																<dt>薪资类型：时薪</dt>
																<dt>薪资金额：20￥/小时</dt>
																<dt>兼职时长：4小时</dt>
																<dt>兼职时间：2017-01-01</dt>
																<dt>截止时间：2017-02-25</dt>
																<dt>兼职地址</dt>
																<dd>四川省成都市金牛区万达广场</dd>
																<dt>兼职描述</dt>
																<dd>在四川省成都市金牛区万达广场进行传单的派发</dd>
															</dl>
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
													<a data-toggle="tab" href="#home4">未处理列表</a>
												</li>

												<li>
													<a data-toggle="tab" href="#profile4">已通过</a>
												</li>

												<li>
													<a data-toggle="tab" href="#dropdown14">已拒绝</a>
												</li>
											</ul>

											<div class="tab-content">
												<div id="home4" class="tab-pane in active">
													<table id="example" class="table table-striped table-bordered"> 
    									<thead> 
     										<tr> 
      											<th>序号</th> 
      											<th>用户名</th> 
      											<th>性别</th> 
      											<th>邮箱</th> 
      											<th>用户真实姓名</th> 
      											<th>联系电话</th> 
      											<th>操作</th> 
     										</tr> 
    									</thead> 
    									<tbody>
    										<tr>
    											<td>1</td>
    											<td>大白</td>
    											<td>男</td>
    											<td>1502774793@qq.com</td>
    											<td>陈坤</td>
    											<td>3558543875</td>
    											<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看报名用户</button><button class="btn btn-link delete">审批</button></td>
    										</tr>
    									</tbody> 
    
    								<!-- tbody是必须的 --> 
   									</table> 
												</div>

												<div id="profile4" class="tab-pane">
													<p>暂无已通过列表</p>
												</div>

												<div id="dropdown14" class="tab-pane">
													<p>暂无已拒绝列表</p>
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
