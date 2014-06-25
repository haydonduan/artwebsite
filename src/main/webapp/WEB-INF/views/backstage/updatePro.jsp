<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../../util/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${context}/skin/css/base.css">
<script src="${context}/jqueryUI/jquery-1.10.2.js"></script>
<link rel="stylesheet" type="text/css" href="${context}/jqueryUI/jquery-ui-1.10.4.custom.min.css">
<script src="${context}/jqueryUI/jquery-ui-1.10.4.custom.min.js"></script>
<title>后台管理系统</title>
</head>
<body leftmargin="8" topmargin="8">
<!--  内容列表   -->
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
	<tr bgcolor="#E7E7E7">
		<td height="24" colspan="10">
				&nbsp;更新作品&nbsp;
		</td>
	</tr>
<form enctype="multipart/form-data" action="${context}/backstage/on/pro/uploadPro" method="post">
<input type="hidden" name="id" value="${production.id}">
	<tr bgcolor="#EEF4EA" style="text-align:center">
		<td>
			标题
		</td>
		<td>
			<input type="text" name="title" size="30" value="${production.title}">
		</td>
	</tr>
	<tr bgcolor="#EEF4EA" style="text-align:center">
		<td>
			类型
		</td>
		<td>
			<select name="type">
				<option value="1">山水</option>
				<option value="2">骏马</option>
			</select>
		</td>
	</tr>
	<tr bgcolor="#EEF4EA" style="text-align:center">
		<td>
			创建时间
		</td>
		<td>
			<input type="text" name="time" size="30" id="datepicker" value="<fmt:formatDate value='${production.finishTime}' pattern='yyyy-MM-dd'/>">
		</td>
	</tr>
	<tr bgcolor="#EEF4EA" style="text-align:center">
		<td>
			图像
		</td>
		<td>
			<input type="file" name="image" onchange="filesize(this)" ><span style="color:red">建议最合适的宽度890px </span>
		</td>
	</tr>
	<tr bgcolor="#EEF4EA" style="text-align:center">
		<td>
			灵感
		</td>
		<td>
			<input type="text" name="inspiration" size="30"  value="${production.inspiration}">
		</td>
	</tr>
	<tr bgcolor="#EEF4EA" style="text-align:center">
		<td>
		</td>
		<td>
		<input type="button" value="返回" onclick="window.location.href=document.referrer">
			<input type="submit" value="保存" id="submit">
		</td>
	</tr>
	</form>
</table>
</body>
</html>
<script>
$( "#datepicker" ).datepicker({
	showButtonPanel: true,
	dateFormat:"yy-mm-dd"
});
</script>
<script src="${context}/backstagejs/isCanUpload.js"></script>