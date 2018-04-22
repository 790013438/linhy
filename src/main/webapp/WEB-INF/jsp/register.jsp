<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/28
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8" />
    <title>BCORE Admin Dashboard Template | Login Page</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <!-- GLOBAL STYLES -->
    <!-- PAGE LEVEL STYLES -->
    <!-- END PAGE LEVEL STYLES -->
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<%=request.getContextPath()%>/resource/plugins/jquery-2.0.3.min.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/register.js" ></script>
    <title>Ajax+SpringMVC+Spring+MyBatis+Mysql注册验证实例</title>
</head>
<body>
<div id="reg">
    <%--action="<%=request.getContextPath()%>/register/successed"--%>
    <FORM name="formUser" id="formUser"  method=post>
        <BR>
        <TABLE width="100%" align=center border=0>
            <TBODY>
            <TR>
                <TD align=right width="15%"><STRONG>用户名:</STRONG></TD>
                <TD width="57%"><INPUT id="username" onBlur="checkUserName(this)"
                                       name="username">
                    <SPAN id="username_notice" >*</SPAN></TD>
            </TR>
            <TR>
                <TD align=right><STRONG>邮箱:</STRONG></TD>
                <TD><INPUT id="email" onBlur="checkEmail(this)" name="email">
                    <SPAN id=email_notice >*</SPAN></TD>
            </TR>
            <TR>
                <TD align=right><STRONG>密码:</STRONG></TD>
                <TD><INPUT id="password" onBlur="checkPassword(this)"
                           onkeyup="checkIntensity(this.value)" type="password" name="password">
                    <SPAN
                            id=password_notice >*</SPAN></TD>
            </TR>
            <TR>
                <TD align=right><STRONG>密码强度:</STRONG></TD>
                <TD><TABLE cellSpacing=0 cellPadding=1 width=145 border=0>
                    <TBODY>
                    <TR align=middle>
                        <TD id=pwd_lower width="33%">弱</TD>
                        <TD id=pwd_middle width="33%">中</TD>
                        <TD id=pwd_high width="33%">强</TD>
                    </TR>
                    </TBODY>
                </TABLE></TD>
            </TR>
            <TR>
                <TD align=right><STRONG>确认密码:</STRONG></TD>
                <TD><INPUT id="conform_password" onBlur="checkConformPassword(this)"
                           type="password" name="confirm_password">
                    <SPAN id=conform_password_notice >*</SPAN></TD>
            </TR>
            <TR>
                <TD align=right><STRONG>手机号:</STRONG></TD>
                <TD><INPUT id="phone" onBlur="checkPhone(this)"
                           type="text" name="phone">
                    <SPAN id=phone_notice >*</SPAN></TD>
            </TR>
            <TR>
                <TD align=right><STRONG>性别:</STRONG></TD>
                <TD>
                    <label class="checkbox-inline">
                    <input type="radio" name="gender" id="gender_man" value="男" checked> 男
                </label>
                    <label class="checkbox-inline">
                        <input type="radio" name="gender" id="gender_woman"  value="女"> 女
                    </label>
                    <SPAN id=gender_notice ></SPAN></TD>
            </TR>
            <TR>
                <TD> </TD>
                <TD><LABEL>
                    <INPUT type="checkbox" id="agreement" onclick="checkAgreement(this)">
                    <B>我已看过并接受《<a href="#">用户协议</a>》<SPAN id=agreement_notice >*</SPAN></B></LABEL></TD>
            </TR>
            <TR>
                <TD  ><INPUT type=hidden value=act_register name=act></TD>
                <TD  ><input type=submit value=确认注册  id="register"  name="Submit1" class="anniu" disabled></TD>
            </TR>
            <TR>
                <TD colSpan=2> </TD>
            </TR>
            </TBODY>
        </TABLE>
    </FORM>
</div>
</body>
</html>
