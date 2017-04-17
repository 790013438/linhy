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

							<li class="active">企业用户管理</li>
							
						</ul><!-- .breadcrumb -->
						
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div id="container"> 
   								<!-- 定义一个表格元素 --> 
   									<table id="example" class="table table-striped table-bordered"> 
    									<thead> 
     										<tr> 
      											<th>序号</th> 
      											<th>企业名</th> 
      											<th>状态</th> 
      											<th>联系人</th> 
      											<th>联系电话</th> 
      											<th>邮箱</th> 
      											<th>企业地址</th> 
      											<th>操作</th> 
     										</tr> 
    									</thead> 
    									<tbody>
    										<tr>
    											<td>1</td>
    											<td>测试公司1</td>
    											<td>待审核</td>
    											<td>马可</td>
    											<td>3558543875</td>
    											<td>1502774793@qq.com</td>
    											<td>成都市高新区</td>
    											<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看详情</button><button class="btn btn-link delete">审核</button><button class="btn btn-link delete">禁用</button></td>
    										</tr>
    										<tr>
    											<td>2</td>
    											<td>测试公司2</td>
    											<td>待审核</td>
    											<td>胡亮</td>
    											<td>13370287361</td>
    											<td>1161047485@qq.com</td>
    											<td>四川省成都市龙泉驿区</td>
    											<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看详情</button><button class="btn btn-link delete">审核</button><button class="btn btn-link delete">禁用</button></td>
    										</tr>
    										<tr>
    											<td>3</td>
    											<td>测试公司3</td>
    											<td>审核通过</td>
    											<td>陈坤</td>
    											<td>15923556653</td>
    											<td>157225708@qq.com</td>
    											<td>成都市双流县</td>
    											<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看详情</button><button class="btn btn-link delete" disabled>审核</button><button class="btn btn-link delete">禁用</button></td>
    										</tr>
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

<!--删除弹窗start-->
<div class="popinto" id="doUpdate">
    <div class="font16 center deletediv">真的要删除该兼职吗？</div>
    <div class="deletediv_btn">
        <p class="pull-left"><button type="button" class="btn btn-primary" id="btnDoUpdate">确定</button></p>
        <p class="pull-right"><button type="button" class="btn btn-default" onclick="closepop()">取消</button></p>
        <input hidden="hidden" id="doId"/>
        <input hidden="hidden" id="doStatus"/>
    </div>
</div>
<!--删除弹窗end-->
<div class="pop" onclick="closepop()" style="display: none;"></div>
		<!-- basic scripts -->
	<%@include file="commonFoot.jsp"%>


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
					bootbox.confirm("你确定要删除改兼职吗？", function(result) {
						if(result) {
							//
						}
					});
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
