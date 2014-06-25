<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../../util/tags.jsp"%>
<%@include file="../../util/links.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base target="_self">
<link rel="stylesheet" type="text/css" href="${context}/skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="${context}/skin/css/main.css" />
<title>后台管理系统</title>
<script type="text/javascript">
	function getTime(){
		var myDate = new Date();
		var Week = ['日','一','二','三','四','五','六'];  
		var time = "今天是" + myDate.getFullYear() + "年" 
		+ (myDate.getMonth()+1) + "月" + myDate.getDate() 
		+ "日  星期" + Week[myDate.getDay()];
		$("#datatime").html(time);
	}
	$(function(){
		setTimeout(getTime,1000);
	});
</script>
</head>
<body leftmargin="8" topmargin='8'>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><div style='float:left'> <img height="14" src="${context}/skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用内容管理系统 </div>
      <div style='float:right;padding-right:8px;'>
        <!--  //保留接口  -->
      </div></td>
  </tr>
  <tr>
    <td height="1" background="${context}/skin/images/frame/sp_bg.gif" style='padding:0px'></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td background="${context}/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>消息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td id="datatime">&nbsp;今天是</td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr>
    <td colspan="2" background="${context}/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'>
    	<div style='float:left'><span>快捷操作</span></div>
    	<div style='float:right;padding-right:10px;'></div>
   </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="30" colspan="2" align="center" valign="bottom"><table width="100%" border="0" cellspacing="1" cellpadding="1">
        <tr>
          <td width="15%" height="31" align="center"><img src="${context}/skin/images/frame/qc.gif" width="90" height="30" /></td>
          <td width="85%" valign="bottom"><div class='icoitem'>
              <div class='ico'><img src='${context}/skin/images/frame/addnews.gif' width='16' height='16' /></div>
              <div class='txt'><a href='${context}/backstage/on/pro/0'><u>作品列表</u></a></div>
            </div>
            <div class='icoitem'>
              <div class='ico'><img src='${context}/skin/images/frame/manage1.gif' width='16' height='16' /></div>
              <div class='txt'><a href='${context}/backstage/on/pro/addProPage'><u>发布作品</u></a></div>
            </div>
            </td>
        </tr>
      </table></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="${context}/skin/images/frame/wbg.gif" class='title'><span>系统基本信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" bgcolor="#FFFFFF">您的级别：</td>
    <td width="75%" bgcolor="#FFFFFF">管理员</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>软件版本信息：</td>
    <td>服务器为${osName}操作系统</td>
  </tr>
</table>
</body>
</html>