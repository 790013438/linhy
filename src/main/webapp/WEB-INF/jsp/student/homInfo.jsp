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
                <a href="/student/homIndex">首页</a>
            </li>

            <li class="active">资源详情</li>
        </ul><!-- .breadcrumb -->
        <div style="position:absolute;top:3px;right:22px;line-height:24px">
            <button class="btn btn-sm btn-primary" onclick="window.location='../student/index'">资源中心</button>
        </div>
    </div>

    <div class="page-content">
        <div class="page-header">
            <h1>
                作业信息
                <%--<small>
                    <i class="icon-double-angle-right"></i>
                    请勿相信轻松高薪等资源，如发现不合理信息请及时举报。
                </small>--%>
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
                                        <h4 class="smaller">作业详情</h4>
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
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <span>发布作业文件</span>
                                        <table id="ta_jobFile" class="table table-striped table-bordered">
                                            <thead>
                                            <tr>
                                                <span><th>序号</th></span>
                                                <span><th>文件名</th></span>
                                                <span><th>文件类型</th></span>
                                                <span><th>文件大小（KB，取整)</th></span>
                                                <span><th>操作</th></span>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                </div>
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <span>自我提交作业文件</span>
                                        <table id="ta_myJobFile" class="table table-striped table-bordered">
                                            <thead>
                                            <tr>
                                                <span><th>序号</th></span>
                                                <span><th>文件名</th></span>
                                                <span><th>文件类型</th></span>
                                                <span><th>文件大小（KB，取整)</th></span>
                                                <span><th>操作</th></span>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr/>
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
<script src="${resource}/resource/js/moment.js"></script>
<script src="${resource}/resource/js/homInfo.js"></script>
</body>
</html>