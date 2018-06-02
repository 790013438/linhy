<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="resource" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh">
<head>
    <%@include file="commonHead.jsp"%>
    <link href="http://vjs.zencdn.net/5.5.3/video-js.css" rel="stylesheet">
    <script src="http://vjs.zencdn.net/ie8/1.1.1/videojs-ie8.min.js"></script>
</head>
<body>
<%--<%@include file="commonLeft.jsp"%>--%>

<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
        </script>

        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="#" onClick="javaScript:history.go(-1)">返回上一页</a>
            </li>

           <%-- <li class="active">视频播放</li>
        </ul><!-- .breadcrumb -->
        <div style="position:absolute;top:3px;right:22px;line-height:24px">
            <button class="btn btn-sm btn-primary" onclick="window.location='../student/index'">资源中心</button>
        </div>--%>
    </div>

    <div class="page-content">
        <div class="page-header">
            <h1>
                资源信息
                <small>
                    <i class="icon-double-angle-right"></i>
                    视频播放
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
<%--                                    <div class="widget-header widget-header-flat">
                                        <h4 class="smaller">视频播放</h4>
                                        <div class="widget-toolbar">
                                            <label>
                                                <button class="btn btn-xs btn-link" id="btn_appli"></button>
                                                <input value="" id="jobId" type="hidden"></li>
                                            </label>
                                        </div>
                                    </div>--%>
                                    <%--资源记录详细信息--%>
<%--                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <ul id="ul_jobDetail">
                                            </ul>
                                        </div>
                                    </div>--%>
                                    <%--资源文件详细信息--%>
<%--                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <span>资源文件</span>
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
                                    </div>--%>
                                    <div class="card">
                                        <div class="card card-body">

                                            <div class="modal-body row justify-content-center">
                                                <video id="my-video" class="video-js justify-content-center" controls preload="auto" width="640" height="300"
                                                      poster="/resource/images/14.jpg"
                                                       data-setup="{}">
                                                    <source src="rtmp://localhost:1935/playback/${name}" type="rtmp/flv">
                                                    <!-- 如果上面的rtmp流无法播放，就播放hls流 -->
                                                    <!-- <source src="http://10.10.5.119/live/livestream.m3u8" type='application/x-mpegURL'> -->
                                                    <p class="vjs-no-js">播放视频需要启用 JavaScript，推荐使用支持HTML5的浏览器访问。
                                                        To view this video please enable JavaScript, and consider upgrading to a web browser that
                                                        <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
                                                    </p>
                                                </video>
                                                <script src="http://vjs.zencdn.net/5.5.3/video.js"></script>
                                            </div>
                                        </div>
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
<%--<script src="${resource}/resource/js/teacher_jobDetails.js"></script>--%>
</body>
</html>
