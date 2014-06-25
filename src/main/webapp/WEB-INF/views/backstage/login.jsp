<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../../util/tags.jsp"%>
<%@include file="../../util/links.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>画家个人网站后台管理系统登录</title>
<link href="${context}/backstagestyle/style/alogin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${context}/backstagejs/login.js"></script>
</head>
<body>
    <div class="Main">
        <ul>
            <li class="top"></li>
            <li class="top2"></li>
            <li class="topA"></li>
            <li class="topB"><span>
                <img src="${context}/backstagestyle/images/login/logo.gif"/>
            </span></li>
            <li class="topC"></li>
            <li class="topD">
                <ul class="login"><br><br><br>
                    <li>
	                    <span class="left">用户名：</span> <span style="left">
	                        <input id="Text1" type="text" class="txt" name="name"/>  
	                    </span>
                   </li>
                    <li>
	                    <span class="left">密 码：</span> <span style="left">
	                       <input id="Text2" type="password" class="txt" name="password"/>  
	                    </span>
                    </li>
                    
                </ul>
            </li>
            <li class="topE"></li>
            <li class="middle_A"></li>
            <li class="middle_B"></li>
            <li class="middle_C">
            <span class="btn">
                <img alt="" src="${context}/backstagestyle/images/login/btnlogin.gif" />
            </span>
            </li>
            <li class="middle_D"></li>
            <li class="bottom_A"></li>
        </ul>
    </div>
</body>
</html>