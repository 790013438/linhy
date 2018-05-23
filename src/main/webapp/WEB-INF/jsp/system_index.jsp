<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="resource" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta charset="utf-8" />
		<title>计算机专业学习资源系统--管理员端</title>
		<meta name="keywords" content="计算机专业学习资源系统" />
		<meta name="description" content="专为大学和教师用户设计的桥梁" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->

		<link href="${resource}/resource/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${resource}/resource/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="${resource}/resource/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<!-- fonts -->

		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->

		<link rel="stylesheet" href="${resource}/resource/css/ace.min.css" />
		<link rel="stylesheet" href="${resource}/resource/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${resource}/resource/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${resource}/resource/css/public.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${resource}/resource/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="${resource}/resource/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${resource}/resource/js/html5shiv.js"></script>
		<script src="${resource}/resource/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							计算机专业学习资源系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">5</span>
							</a>

							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
								<a href="#">
									<i class="icon-envelope-alt"></i>
									5 Messages
									</a>
								</li>							
							</ul>
						</li>
						<!-- 右上角头像信息维护 -->
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${resource}/resource/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎您,</small>
									管理员
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-user"></i>
										个人信息
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<ul class="nav nav-list">
						<li>
							<a href="system_index.jsp">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 管理员端 </span>
							</a>
						</li>
						<li class="active open">
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 资源管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li class="active">
									<a href="system_index.jsp">
										<i class="icon-double-angle-right"></i>
										待审核资源管理
									</a>
								</li>

								<li >
									<a href="system_jzgl.jsp">
										<i class="icon-double-angle-right"></i>
										已审核资源管理
									</a>
								</li>
								<li >
									<a href="system_diagram.jsp">
										<i class="icon-double-angle-right"></i>
										资源统计图
									</a>
								</li>
							</ul>
						</li>


						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 用户管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="system_teacher.jsp">
										<i class="icon-double-angle-right"></i>
										教师用户信息管理
									</a>
								</li>

								<li>
									<a href="system_person.jsp">
										<i class="icon-double-angle-right"></i>
										大学生用户信息管理
									</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="system_message.jsp">
								<i class="icon-text-width"></i>
								<span class="menu-text"> 我的消息 </span>
							</a>
						</li>
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

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

							<li class="active">资源审批管理</li>
							
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
      											<th>标题</th> 
      											<th>状态</th> 
      											<%--<th>需求人</th> --%>
      											<th>截止时间</th> 
      											<th>操作</th> 
     										</tr> 
    									</thead> 
    									<tbody>
    										<tr>
    											<td>1</td>
    											<td>派发传单</td>
    											<td>待审核</td>
    											<td>10</td>
    											<td>2017-02-25 22:14:53</td>
    											<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看详情</button><button class="btn btn-link delete">通过</button><button class="btn btn-link delete">拒绝</button></a></td>
    										</tr>
    										<tr>
    											<td>2</td>
    											<td>商品促销</td>
    											<td>待审核</td>
    											<td>5</td>
    											<td>2017-02-25 22:14:53</td>
    											<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看详情</button><button class="btn btn-link delete">通过</button><button class="btn btn-link delete">拒绝</button></a></td>
    										</tr>
    										<tr>
    											<td>3</td>
    											<td>高中家教</td>
    											<td>招聘</td>
    											<td>2</td>
    											<td>2017-02-25 22:14:53</td>
    											<td><button class="btn btn-link" onclick="window.location='jz_jzxq.jsp'">查看详情</button><button class="btn btn-link delete">通过</button><button class="btn btn-link delete">拒绝</button></a></td>
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
    <div class="font16 center deletediv">真的要删除该资源吗？</div>
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

		<!--[if !IE]> -->

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${resource}/resource/js/bootstrap.min.js"></script>
		<script src="${resource}/resource/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<script src="${resource}/resource/js/jquery.dataTables.min.js"></script>
		<script src="${resource}/resource/js/jquery.dataTables.bootstrap.js"></script>

		<!-- ace scripts -->
		<script src="${resource}/resource/js/bootbox.min.js"></script>
		<script src="${resource}/resource/js/ace-elements.min.js"></script>
		<script src="${resource}/resource/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

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
