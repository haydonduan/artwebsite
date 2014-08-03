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
<script type="text/javascript" src="${context}/backstagejs/jscolor/jscolor.js"></script>
</head>
<body leftmargin="8" topmargin="8">

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
    <span class="coolbg np">更改前台图标</span> 
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
<br /><br />
<!-- FLASH -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
    <span class="coolbg np">更改FLASH上部文字颜色</span>
 </td>
 </tr>
</table>
</td>
</tr>
</table>
标题<input name="flashtitle" type="text">
<input type="button" id="title-set-button" style="width:40px" value="更新">
<br />
标题颜色<input class="color">
<input type="button" id="color-set-button" style="width:40px" value="更新">
<br />
FOOTER<input type="text" name="footertext">
<input type="button" id="footer-set-button" style="width:40px" value="更新">
</body>
</html>
<script src="${context}/backstagejs/isCanUpload.js"></script>
<script>
	 $("#color-set-button").click(function(){
		 updateFlash($(".color").val(),1)
		});
		
	 $("#title-set-button").click(function(){
		 updateFlash($("input[name=flashtitle]").val(), 0);
		});

	 $("#footer-set-button").click(function(){
		 updateFlash($("input[name=footertext]").val(), 2);
		});
		
	// type 
	// 0 为 title文字
	// 1 为 title颜色
	// 2 为footer文字
		function updateFlash(text,type){
			$.ajax({
				type:"POST",
				url:$.ART.context + "/backstage/on/style/update_flash_color",
				data: { color: text, type: type },
				success:function(data){
					if(data == 1){
						alert("更新成功！");
					}else{
						alert("更新失败!");
					}
				}
			})
		}
</script>