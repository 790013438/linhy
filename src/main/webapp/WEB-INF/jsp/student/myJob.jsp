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
								<a href="/student/index">首页</a>
							</li>

							<li class="active">我的资源</li>
							<li class="active">资源报名情况</li>
							
						</ul><!-- .breadcrumb -->
						<div style="position:absolute;top:3px;right:22px;line-height:24px">
							<button class="btn btn-sm btn-primary" onclick="window.location='../student/index'">资源中心</button>
						</div>
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div id="container"> 
   								<!-- 定义一个表格元素 --> 
   									<table id="myAppliJobs" class="table table-striped table-bordered">
    									<thead> 
     										<tr>
      											<th>资源标题</th>
      											<th>资源时间</th>
      											<th>资源状态</th>
												<%--<th>薪资类型</th>--%>
												<%--<th>薪资金额</th>--%>
												<th>工作时长</th>
												<th>发布教师</th>
      											<th>报名状态</th> 
      											<th>操作</th> 
     										</tr> 
    									</thead> 
    									<tbody>

    									</tbody> 
    
    								<!-- tbody是必须的 --> 
   									</table> 
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
	<div class="popinto" id="delPop">
		<div class="font16 center deletediv">真的要退出该资源吗？</div>
		<div class="deletediv_btn">
			<p class="pull-left"><button type="button" class="btn btn-primary" id="btnQuitAppli">确定</button></p>
			<p class="pull-right"><button type="button" class="btn btn-default" onclick="closepop()">取消</button></p>
			<input hidden="hidden" id="input_applId"/>
		</div>
	</div>
	<div class="pop" onclick="closepop()" style="display: none;"></div>
	<%@include file="commonFoot.jsp"%>
	<script src="${resource}/resource/js/moment.js"></script>
	<script src="${resource}/resource/js/myJob.js"></script>
	<script type="text/javascript">
			function closepop(){
				$(".pop").hide();
				$(".popinto").hide();
			}
			jQuery(function($) {
			    closepop();
                $(".quit").on('click',function(){
					$(".pop").show();
				$(".popinto").show();
				})
				$(document).ready(function(){
        			$('#example').DataTable();
    			});

    			$(".delete").on(ace.click_event, function() {
					bootbox.confirm("你确定要退出该资源吗？", function(result) {
						if(result) {
							//
						}
					});
				});
			})
		</script>
</body>
</html>
