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
<script type="text/javascript" src="${context}/js/jqueryForm.js"></script>
</head>
<body leftmargin="8" topmargin="8">

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
    <input type='button' class="coolbg np"  value='更改前台图标'/>
 </td>
 </tr>
</table>
</td>
</tr>
</table>
  
<!--  内容列表   -->
<form enctype="multipart/form-data"  id="form" action="${context}/backstage/on/style/update" method="POST">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
	<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
		<td>LOGO</td><td><input type="file" name="logo"   onchange="filesize(this)"><span style="color:red">建议上传尺寸：100px（宽） * 90px（高）</span></td>
	</tr>
	<tr align='center'  bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
		<td>BANNER</td><td><input type="file" name="banner"   onchange="filesize(this)"><span style="color:red">建议上传尺寸：890px（宽） * 90px（高）</span></td>
	</tr>
	<tr><td></td><td><input type="submit" value="更新" name="submit"></td></tr>
<tr bgcolor="#FAFAF1">
</tr>
</table>
</form>
</body>
</html>
<script src="${context}/backstagejs/isCanUpload.js"></script>
<script>
	/* $("input[name=submit]").click(function(){
		$('#form').ajaxForm();
		$.ajax({
			type:"POST",
			url:$.ART.context + "/backstage/on/style/update",
			success:function(data){
				$('#form').ajaxSubmit({
					error:function(){
						alert("更新失败!");
					},
					success:function(data){
						if(data == 1){
							alert("更新成功！");
						}else{
							alert("更新失败!");
						}
					}
				});
				//window.location.href="${context}/forum/on/tomypage";
			}
		});
	}); */
</script>