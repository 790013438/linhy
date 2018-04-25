<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/15
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="resource" value="${pageContext.request.contextPath}" />
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
                        <img class="nav-user-photo" src="${resource}/resource/avatars/avatar5.png" alt="Jason's Photo" />
                        <span class="user-info">
									<small>欢迎您,</small>
                            <%--<s:property value="#loginuser.teaName"/>--%>
                            <%--<span id ="span_tea_name">${loginuser.teaName}</span>--%>
								</span>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="../teacher/myInfo">
                                <i class="icon-user"></i>
                                个人信息
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="../login">
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
                    <a href="../teacher/index">
                        <i class="icon-dashboard"></i>
                        <span class="menu-text"> 教师端 </span>
                    </a>
                </li>
                <li class="" id="jobManage">
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 资源管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li class="" id="li_myjob">
                            <a href="../teacher/index">
                                <i class="icon-double-angle-right"></i>
                                我的资源
                            </a>
                        </li>

                        <li class=""  id="li_history">
                            <a href="../teacher/myJobs">
                                <i class="icon-double-angle-right"></i>
                                发布历史
                            </a>
                        </li>
                    </ul>
                </li>


                <li id="li_myInfo">
                    <a href="../teacher/myInfo">
                        <i class="icon-text-width"></i>
                        <span class="menu-text"> 我的信息 </span>
                    </a>
                </li>

                <li id="li_message">
                    <a href="../teacher/message">
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