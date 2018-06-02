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
        <%--设置每个类型的数量值--%>
        <input hidden="hidden" id="jy">
        <input hidden="hidden" id="kj">
        <input hidden="hidden" id="lx">
        <input hidden="hidden" id="jc">
        <input hidden="hidden" id="zds">
        <input hidden="hidden" id="rj">
        <input hidden="hidden" id="dm">
    </div><!-- /.page-content -->
</div><!-- /.main-content -->

</div><!-- /.main-container-inner -->

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="icon-double-angle-up icon-only bigger-110"></i>
</a>
</div><!-- /.main-container -->
<!-- basic scripts -->
<%@include file="commonFoot.jsp"%>
<script src="${resource}/resource/js/moment.js"></script>
<%--<script src="${resource}/resource/js/system_diagram.js"></script>--%>
<script src="${resource}/resource/js/echarts.js"></script>
<script src="${resource}/resource/js/diagram.js"></script>
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
