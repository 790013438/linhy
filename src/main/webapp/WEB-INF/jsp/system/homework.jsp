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
                <a href="../system/index">首页</a>
            </li>

            <li class="active">作业管理</li>

        </ul><!-- .breadcrumb -->

    </div>

    <div class="page-content">
        <div class="row">
            <span>未截止的作业信息：</span>
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <div id="container_one">
                    <!-- 定义一个表格元素 -->
                    <table id="homs_one" class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>标题</th>
                            <th>状态</th>
                            <%--<th>需求人数</th>--%>
                            <th>发布教师</th>
                            <th>截止时间</th>
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

        <div class="row">
            <span>已截止的作业信息：</span>
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <div id="container_two">
                    <!-- 定义一个表格元素 -->
                    <table id="homs_two" class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>标题</th>
                            <th>状态</th>
                            <th>发布教师</th>
                            <th>截止时间</th>
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
    <div class="font16 center deletediv">请选择对该资源的审核结果</div>
    <div class="deletediv_btn">
        <p class="pull-left"><button type="button" class="btn btn-primary" id="btnAdoptJob">通过</button></p>
        <p class="pull-right"><button type="button" class="btn btn-default" id="btnRefuseJob" >拒绝</button></p>
        <input hidden="hidden" id="input_jobId"/>
    </div>
</div>
<div class="pop" onclick="closepop()" style="display: none;"></div>
<%@include file="commonFoot.jsp"%>
<script src="${resource}/resource/js/moment.js"></script>
<script src="${resource}/resource/js/system_homwork.js"></script>

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
    })
</script>
</body>
</html>
