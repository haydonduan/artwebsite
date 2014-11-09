<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../../util/tags.jsp"%>
<%@include file="../../util/links.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${context}/skin/css/base.css">
<title>后台管理系统</title>
<script language="javascript">
</script>
<script type="text/javascript" src="${context}/backstagejs/commentNoReply.js"></script>
</head>
<body leftmargin="8" topmargin="8">

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
 </tr>
</table>
</td>
</tr>
</table>
  
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10">&nbsp;用户管理列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#99B0C7" height="22">
<td width="6%"><input type="checkbox" id="parentChe"></td>
	<td width="6%">ID</td>
	<td width="28%">用户名</td>
	<td width="10%">创建时间</td>
	<td width="10%">操作</td>
</tr>
<c:forEach items="${usersList}" var="user">
	<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td width="6%"><input type="checkbox" class="childChe" name="child_${user.id}"></td>
		<td>${user.id}</td>
		<td>${user.name}</td>
		<td><fmt:formatDate value="${user.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td><a href="${context}/backstage/on/users/user/${user.id}">查看</a></td>
	</tr>
</c:forEach>
<tr bgcolor="#FAFAF1">
</tr>
<input type="hidden" name="currentPage" value="${currentPage}">

<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="center"  id="pagearea">
		
	</td>
</tr>
<script>
$.ART.type = 1;
</script>
</table>
</form>
</body>
</html>
