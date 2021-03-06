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

            <li class="active">资源统计图</li>

        </ul><!-- .breadcrumb -->

    </div>

    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <div id="container">
                    <div class="widget-main">
                        <%--<span>按照资源类型</span>--%>
                        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
                        <div id="main" style="width: 600px;height:400px;"></div>
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

<!--删除弹窗start-->
<div class="popinto" id="doUpdate">
    <div class="font16 center deletediv">该资源信息不真实，确定删除该资源？</div>
    <div class="deletediv_btn">
        <p class="pull-left"><button type="button" class="btn btn-primary" id="btn_delJob">确定</button></p>
        <p class="pull-right"><button type="button" class="btn btn-default" onclick="closepop()">取消</button></p>
        <input hidden="hidden" id="doId"/>
        <input hidden="hidden" id="doStatus"/>
    </div>
</div>
<!--删除弹窗end-->
<div class="pop" onclick="closepop()" style="display: none;"></div>
<!-- basic scripts -->
<%@include file="commonFoot.jsp"%>
<script src="${resource}/resource/js/moment.js"></script>
<script src="${resource}/resource/js/echarts.js"></script>
<script src="${resource}/resource/js/system_diagram.js"></script>
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
