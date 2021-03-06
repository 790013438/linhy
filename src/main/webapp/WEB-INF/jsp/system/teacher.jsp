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
								<a href="system_index.jsp">首页</a>
							</li>

							<li class="active">教师用户管理</li>
							
						</ul><!-- .breadcrumb -->
						
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div id="container"> 
   								<!-- 定义一个表格元素 --> 
   									<table id="table_teacher" class="table table-striped table-bordered">
    									<thead> 
     										<tr>
      											<th>教师名</th>
      											<th>教师状态</th>
      											<th>职称</th>
      											<th>联系电话</th> 
      											<th>邮箱</th>
												<%--<th>教师网站</th>--%>
												<th>教师地址</th>
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

<div class="popinto" id="popinto_frozen">
    <div class="font16 center deletediv">是否禁用该用户？</div>
    <div class="deletediv_btn">
        <p class="pull-left"><button type="button" class="btn btn-primary" id="btnFrozen">确定</button></p>
        <p class="pull-right"><button type="button" class="btn btn-default" onclick="closepop()">取消</button></p>
        <input hidden="hidden" id="teacherId"/>
    </div>
</div>
	<div class="popinto" id="popinto_thaw">
		<div class="font16 center deletediv">是否解禁该用户？</div>
		<div class="deletediv_btn">
			<p class="pull-left"><button type="button" class="btn btn-primary" id="btnThaw">确定</button></p>
			<p class="pull-right"><button type="button" class="btn btn-default" onclick="closepop()">取消</button></p>
		</div>
	</div>
	<div class="popinto" id="popinto_audit">
		<div class="font16 center deletediv">请选择审核结果</div>
		<div class="deletediv_btn">
			<p class="pull-left"><button type="button" class="btn btn-primary" id="btnAuditAgree">通过</button></p>
			<p class="pull-right"><button type="button" class="btn btn-default" id="btnAuditRefuse">拒绝</button></p>
			<input hidden="hidden" id="doId"/>
		</div>
	</div>
<div class="pop" onclick="closepop()" style="display: none;"></div>
		<!-- basic scripts -->
	<%@include file="commonFoot.jsp"%>
	<script src="${resource}/resource/js/moment.js"></script>
	<script src="${resource}/resource/js/system_teacher.js"></script>


		<script type="text/javascript">
			function closepop(){
				$(".pop").hide();
				$(".popinto").hide();
			}
			jQuery(function($) {
				$(".del").click(function(){
					$(".pop").show();
				$(".popinto").show();
				})
				$(document).ready(function(){
        			$('#example').DataTable();
    			});

    			$(".delete").on(ace.click_event, function() {
					bootbox.confirm("你确定要删除改资源吗？", function(result) {
						if(result) {
							//
						}
					});
				});

			})
		</script>
</body>
</html>
