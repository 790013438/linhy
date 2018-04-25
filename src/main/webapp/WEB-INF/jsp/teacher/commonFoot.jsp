<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/15
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="resource" value="${pageContext.request.contextPath}" />
<!-- basic scripts -->

<!--[if !IE]> -->

<script src="${resource}/resource/js/jquery-2.0.3.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="${resource}/resource/js/jquery-1.10.2.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='${resource}/resource/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->
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
<script src="${resource}/resource/js/date-time/bootstrap-datepicker.min.js"></script>
<!-- ace scripts -->
<script src="${resource}/resource/js/bootbox.min.js"></script>
<script src="${resource}/resource/js/ace-elements.min.js"></script>
<script src="${resource}/resource/js/ace.min.js"></script>

<!-- inline scripts related to this page -->