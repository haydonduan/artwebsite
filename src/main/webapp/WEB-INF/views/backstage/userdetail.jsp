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
<script type="text/javascript" src="${context}/backstagejs/prolist.js"></script>
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
  
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10">&nbsp;用户详细&nbsp;</td>
</tr>
<tr bgcolor="#B3CEB2" height="22">
	<td>图像</td><td><img src='${context}/${user.image}'></td>
</tr>
<tr bgcolor="#93ADC7" height="22">
	<td>名字</td><td>${user.name}</td>
</tr>
<%-- <tr bgcolor="#B3CEB2" height="22">
	<td>年龄</td><td>${user.age}</td>
</tr> --%>
<tr bgcolor="#8493C2">
<td>性别</td><td>
<c:choose>
	<c:when test="${user.sex == 0}">男</c:when>
	<c:otherwise>女</c:otherwise>
</c:choose>
</td>          
</tr>
<%-- <tr bgcolor="#B3CEB2" height="22">
	<td>地址</td><td>${user.address}</td>
</tr>
<tr bgcolor="#B3CEB2" height="22">
	<td>电话</td><td>${user.telephone}</td>
</tr>
<tr bgcolor="#B3CEB2" height="22">
	<td>邮箱</td><td>${user.email}</td>
</tr> --%>
<tr bgcolor="#B3CEB2" height="22">
	<td>注册时间</td><td>${user.createdTime}</td>
</tr>
<tr bgcolor="#EEF4EA" align="right">
	<td height="36" align="center" id="pagearea" colspan="10">
		 <a onclick="deletePro(${user.id})" style="cursor:pointer">删除</a>
	</td>
</tr>
</table>
</body>
</html>
<script>
function deletePro(id){
	if(confirm("确定删除？")){
		$.ajax({
			url:$.ART.context + "/backstage/on/users/delete",
			type:"POST",
			data:{
					id:id
				},
			success:function(data){
				if(data == 1){
					alert("删除成功！");
					window.location.href="${context}/backstage/on/users/0"
				}else{
					alert("删除失败！");
				}
			}
		});
	}
}
</script>
