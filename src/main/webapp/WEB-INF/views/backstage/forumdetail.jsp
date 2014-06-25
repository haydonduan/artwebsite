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
	<td height="24" colspan="10">&nbsp;帖子详细&nbsp;</td>
</tr>
<tr bgcolor="#93ADC7" height="22">
	<td>标题</td><td>${forum.title}</td>
</tr>
<tr bgcolor="#FDDC7A" height="22">
	<td width="80">发布人</td><td>${forum.user.name}</td>
</tr>
<tr bgcolor="#B3CEB2" height="22">
	<td>发布时间</td><td>${forum.createTime}</td>
</tr>
<tr bgcolor="#8493C2">
<td >详细</td><td>${forum.content}</td>
</tr>


<tr bgcolor="#EEF4EA" align="right">
	<td height="36" align="center" id="pagearea" colspan="10">
		<input type="button" value="审核通过" name="yes">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="审核不通过" name="no">
	</td>
</tr>
</table>
</body>
</html>
<script>
	$("input[name=yes]").click(function(){
		changeStatus(1);
	});

	$("input[name=no]").click(function(){
		changeStatus(2);
	});

	
	function changeStatus(type){
		var datas = {
				id:"${forum.id}",
				type:type
			};
		
		$.ajax({
			type:"POST",
			url:$.ART.context + "/backstage/on/forum/udpateisview",
			data:datas,
			success:function(data){
				if(data == 1){
					alert("审核成功");
					window.location.href = $.ART.context + "/backstage/on/forum/0";
				}else{
					alert("审核失败");
				}
			}
		});
	}
</script>
