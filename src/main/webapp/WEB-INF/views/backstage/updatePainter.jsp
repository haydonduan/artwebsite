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
<script type="text/javascript" src="${context}/ckeditor/ckeditor.js"/>
<script type="text/javascript"></script>
</head>
<body rightmargin="8" topmargin="8">
<!--  内容列表   -->
<form action="${context}/backstage/on/updatePainter" method="POST" enctype="multipart/form-data">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px;margin-left:8px">
	<tr bgcolor="#E7E7E7">
		<td height="24" colspan="10">&nbsp;更新画家个人信息&nbsp;</td>
	</tr>
	<tr bgcolor="#EEF4EA">
		<td>
			画家姓名
		</td>
		<td>
			<input type="text" name="name" size=60 value="${painter.name}">
		</td>
	</tr>
	<tr bgcolor="#EEF4EA">
		<td>
			地址
		</td>
		<td>
			<input type="text" name="address" value="${painter.address}">
		</td>
	</tr>
	<tr bgcolor="#EEF4EA">
		<td>
			电话
		</td>
		<td>
			<input type="text" name="telephone" value="${painter.telephone}">
		</td>
	</tr>
	<tr bgcolor="#EEF4EA">
		<td>
			E-mail
		</td>
		<td>
			<input type="text" name="email" value="${painter.email}">
		</td>
	</tr>
	<tr bgcolor="#EEF4EA">
		<td>
			画家头像
		</td>
		<td>
			<input type="file" name="image"  onchange="filesize(this)"><span style="color:red">建议上传350px(宽)*455px(高)的图片</span>
		</td>
	</tr>
	<tr bgcolor="#EEF4EA">
		<td>
			画家介绍
		</td>
		<td>
			<textarea name="editor01">${painter.detail}</textarea>
			<input name="detail" type="hidden">
		</td>
	</tr>
	<tr bgcolor="#EEF4EA">
		<td>
			
		</td>
		<td>
			<input type="submit" value="保存" id="saveBu">
		</td>
		
	</tr>
</table>
</form>
</body>
</html>
<script>
	var editor = CKEDITOR.replace('editor01',{
	    uiColor : '#88C861',
	    width:516,
	    height:400
	});

	 $("#saveBu").click(function(){
		var name = $("input[name=name]").val();
		var address = $("input[name=address]").val();
		var telephone = $("input[name=telephone]").val();
		var email = $("input[name=email]").val();
		var detail = editor.document.getBody().getText();

		//检查
		if($.trim(name) == ''){
			alert("姓名不能为空");
			return false;
		}
		if($.trim(address) == ''){
			alert("地址不能为空");
			return false;
		}

		if($.trim(telephone) == ''){
			alert("电话不能为空");
			return false;
		}

		if($.trim(email) == ''){
			alert("邮件不能为空");
			return false;
		}

		if($.trim(detail) == ''){
			alert("详细介绍不能为空");
			return false;
		}
		
		$("input[name=detail]").val(CKEDITOR.instances.editor01.getData());
	}); 
</script>
<script src="${context}/backstagejs/isCanUpload.js"></script>