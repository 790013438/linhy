<%--
  Created by IntelliJ IDEA.
  User: linhy
  Date: 2018/1/13
  Time: 22:14
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
    <link rel="stylesheet" href="${ctx}/resource/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="${ctx}/resource/css/login.css" />
    <link rel="stylesheet" href="${ctx}/resource/plugins/magic/magic.css" />
    <!-- END PAGE LEVEL STYLES -->
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body >

<!-- PAGE CONTENT -->
<div class="container">
    <div class="text-center">
        <img src="${ctx}/resource/images/logo.png" id="logoimg" alt=" Logo" />
    </div>
    <div class="tab-content">
        <div id="login" class="tab-pane active">
            <form action="index.html" class="form-signin" id="login_form">
                <p class="text-muted text-center btn-block btn btn-primary btn-rect">
                    请输入用户名密码登录
                </p>
                <input type="text" placeholder="用户名" class="form-control" maxlength="16" id="login_username"/>
                <input type="password" placeholder="密码" class="form-control"  maxlength="32" id="login_password"/>
                <div >
                    <label>类型</label>
                    <label class="checkbox-inline">
                        <input type="radio" name="type" id="student" value="1" checked> 学生
                    </label>
                    <label class="checkbox-inline">
                        <input type="radio" name="type" id="teacher"  value="2"> 教师
                    </label>
                    <label class="checkbox-inline">
                        <input type="radio" name="type" id="admin"  value="3"> 管理员
                    </label>
                </div>
                <button class="btn text-muted text-center btn-danger" type="submit" id="login_btn">登录</button>
                <a class="text-muted" href="#forgot" data-toggle="tab">忘记密码？</a>
            </form>
        </div>
        <div id="forgot" class="tab-pane">
            <form action="index.html" class="form-signin">
                <p class="text-muted text-center btn-block btn btn-primary btn-rect">清输入你的邮箱来找回密码</p>
                <input type="email"  required="required" placeholder="你注册时填写的邮箱信息"  class="form-control" maxlength="32"/>
                <br />
                <button class="btn text-muted text-center btn-success" type="submit">重置密码</button>
            </form>
        </div>
        <div id="signup" class="tab-pane">
            <form class="form-signin" id="from_signin">
                <p class="text-muted text-center btn-block btn btn-primary btn-rect">请完整填写信息来完成注册</p>
                <BR>
                <TABLE width="100%" align=center border=0>
                    <TBODY>
                    <INPUT id="compname" placeholder="用户名" onBlur="checkCompName(this)"
                           class="form-control" pattern=".{4,10}" name="username">
                    <SPAN id="compname_notice" >*</SPAN>
                    <INPUT id="comp_email" onBlur="checkCompEmail(this)" placeholder="邮箱" name="email"  class="form-control" pattern=".{4,10}">
                    <SPAN id=compemail_notice >*</SPAN>
                    <INPUT id="comp_password" onBlur="checkCompPassword(this)"  placeholder="密码" class="form-control" pattern=".{4,10}" type="password" name="password">
                    <SPAN id=compassword_notice >*</SPAN>

                    <INPUT id="conform_compassword" class="form-control" pattern=".{4,10}" placeholder="确认密码" onBlur="checkConformComPassword(this)"
                           type="password" name="confirm_password">
                    <SPAN id=conform_compassword_notice >*</SPAN>
                    <INPUT id="comphone" class="form-control" pattern=".{4,10}" placeholder="手机号" onBlur="checkComPhone(this)"
                           type="text" name="phone">
                    <SPAN id=comphone_notice >*</SPAN>
                    <br>
                    <button class="btn text-muted text-center btn-success" name="Submit1"  type="submit" id="registerComp" class="anniu">教师注册</button>
                    <%--id:comp_register-->registerComp--%>
                    </TBODY>
                </TABLE>
            </form>
        </div>
        <div id="signup1" class="tab-pane">
            <form class="form-signin" id="from_signin1">
                <p class="text-muted text-center btn-block btn btn-primary btn-rect">请完整填写信息来完成注册</p>
                <BR>
                <TABLE width="100%" align=center border=0>
                    <TBODY>
                       <INPUT id="username" placeholder="用户名" onBlur="checkUserName(this)"
                              class="form-control" pattern=".{4,10}" name="username">
                            <SPAN id="username_notice" >*</SPAN>
                        <INPUT id="email" onBlur="checkEmail(this)" placeholder="邮箱" name="email"  class="form-control" pattern=".{4,10}">
                            <SPAN id=email_notice >*</SPAN>
                       <INPUT id="password" onBlur="checkPassword(this)"  placeholder="密码" class="form-control" pattern=".{4,10}" type="password" name="password">
                            <SPAN id=password_notice >*</SPAN>

                       <INPUT id="conform_password" class="form-control" pattern=".{4,10}" placeholder="确认密码" onBlur="checkConformPassword(this)"
                                   type="password" name="confirm_password">
                            <SPAN id=conform_password_notice >*</SPAN>
                       <INPUT id="phone" class="form-control" pattern=".{4,10}" placeholder="手机号" onBlur="checkPhone(this)"
                                   type="text" name="phone">
                            <SPAN id=phone_notice >*</SPAN>
                       <div >
                           <label>请选择你的性别</label>
                           <label class="checkbox-inline">
                               <input type="radio" name="gender" id="gender_man" value="1" checked> 男
                           </label>
                           <label class="checkbox-inline">
                               <input type="radio" name="gender" id="gender_woman"  value="0"> 女
                           </label>
                       </div>
                       <button class="btn text-muted text-center btn-success" name="Submit1"  type="submit" id="register" class="anniu">学生注册</button>
                    </TBODY>
                </TABLE>
            </form>
        </div>
    </div>
    <div class="text-center">
        <ul class="list-inline">
            <li><a class="text-muted" href="#login" data-toggle="tab">登录</a></li>
            <li><a class="text-muted" href="#forgot" data-toggle="tab">忘记密码？</a></li>
            <li><a class="text-muted" href="#signup" data-toggle="tab">教师注册</a></li>
            <li><a class="text-muted" href="#signup1" data-toggle="tab">用户注册</a></li>
        </ul>
    </div>


</div>

<!--END PAGE CONTENT -->

<!-- PAGE LEVEL SCRIPTS -->
<script src="${ctx}/resource/plugins/jquery-2.0.3.min.js"></script>
<script src="${ctx}/resource/plugins/bootstrap/js/bootstrap.js"></script>
<script src="${ctx}/resource/js/layer.js"></script>
<script src="${ctx}/resource/js/login.js"></script>
<script src="${ctx}/resource/js/register.js"></script>
<script src="${ctx}/resource/js/teacher_register.js"></script>


<!--END PAGE LEVEL SCRIPTS -->

</body>
<!-- END BODY -->
</html>

