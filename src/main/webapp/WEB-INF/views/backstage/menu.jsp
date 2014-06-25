<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../../util/tags.jsp"%>
<%@include file="../../util/links.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${context}/skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="${context}/skin/css/menu.css" type="text/css" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="${context}/skin/js/frame/menu.js"></script>
<base target="main" />
<title>后台管理系统</title>
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0' style="background:#9AD075	">
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
    <!-- Item 3 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items2_11")'><b>画家个人信息设置</b></dt>
        <dd style='display:block' class='sitem' id='items2_11'>
          <ul class='sitemu'>
            <li>
              <div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/updatePainterpage' target='main'>更改信息</a></div>
                <div class='flrct'> <a href='${context}/backstage/on/updatePainterpage' target='main'><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/style/toPage' target='main'>前台布局管理</a></div>
                <div class='flrct'> <a href='${context}/backstage/on/style/toPage' target='main'><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li>
          </ul>
        </dd>
      </dl>
	<!-- Item 1 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items1_1")'><b>作品管理</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
          <ul class='sitemu'>
            <li>
              <div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/pro/0' target='main'>作品列表</a></div>
                <div class='flrct'> <a href='${context}/backstage/on/pro/0' target='main'><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li>
            <li>
            	<div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/comment/0' target='main'>作品评论审核</a></div>
                <div class='flrct'> <a href='${context}/backstage/on/comment/0' target='main'><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li>
            <li>
            	<div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/pro/addProPage' target='main'>发表作品</a></div>
                <div class='flrct'> <a href='${context}/backstage/on/pro/addProPage' target='main'><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li>
          </ul>
        </dd>
      </dl>
      
<!-- 论坛管理 -->      
      <dl class='bitem'>
        <dt onClick='showHide("items2_12")'><b>论坛管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_12'>
          <ul class='sitemu'>
            <li>
            	<div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/forum/0' target='main'>帖子管理</a></div>
                <div class='flrct'> <a href='${context}/backstage/on/forum/0' target='main'><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li>
            <li>
            	<div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/forum/comment/0' target='main'>帖子评论管理</a></div>
                <div class='flrct'> <a href='${context}/backstage/on/forum/comment/0' target='main'><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li>
          </ul>
        </dd>
      </dl>
<!-- 新闻公告管理 -->      
      <dl class='bitem'>
        <dt onClick='showHide("items2_13")'><b>新闻公告管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_13'>
          <ul class='sitemu'>
            <li>
            	<div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/newsnotice/0/1' target='main'>公告管理</a></div>
                <div class='flrct'> <a href='${context}/backstage/on/newsnotice/0/1' target='main'><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li>
            <li>
            	<div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/newsnotice/0/0' target='main'>新闻管理</a></div>
                <div class='flrct'> <a href='${context}/backstage/on/newsnotice/0/0' target='main'><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li>
          </ul>
        </dd>
      </dl>      
      
      <!-- Item 2 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>系统帮助</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li>
              <div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/updateadminpage' target='main'>修改登陆信息</a></div>
                <div class='flrct'> <a href='${context}/backstage/on/updateadminpage' target='main'><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li>
            <%-- <li>
              <div class='items'>
                <div class='fllct'><a href='${context}/backstage/on/main' target='main'>主界面</a></div>
                <div class='flrct'> <a href="${context}/backstage/on/main"  target="main"><img src='${context}/skin/images/frame/gtk-sadd.png'/></a> </div>
              </div>
            </li> --%>
          </ul>
        </dd>
      </dl>
      <!-- Item 2 End -->
	  </td>
  </tr>
</table>
</body>
</html>