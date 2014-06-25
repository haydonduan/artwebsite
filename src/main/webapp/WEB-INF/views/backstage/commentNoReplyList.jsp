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
function viewArc(aid){
	if(aid==0) aid = getOneItem();
	window.open("archives.asp?aid="+aid+"&action=viewArchives");
}
function editArc(aid){
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=editArchives";
}
function updateArc(aid){
	var qstr=getCheckboxItem();
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=makeArchives&qstr="+qstr+"";
}
function checkArc(aid){
	var qstr=getCheckboxItem();
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=checkArchives&qstr="+qstr+"";
}
function moveArc(aid){
	var qstr=getCheckboxItem();
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=moveArchives&qstr="+qstr+"";
}
function adArc(aid){
	var qstr=getCheckboxItem();
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=commendArchives&qstr="+qstr+"";
}
function delArc(aid){
	var qstr=getCheckboxItem();
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=delArchives&qstr="+qstr+"";
}

//获得选中文件的文件名
function getCheckboxItem()
{
	var allSel="";
	if(document.form2.id.value) return document.form2.id.value;
	for(i=0;i<document.form2.id.length;i++)
	{
		if(document.form2.id[i].checked)
		{
			if(allSel=="")
				allSel=document.form2.id[i].value;
			else
				allSel=allSel+"`"+document.form2.id[i].value;
		}
	}
	return allSel;
}

//获得选中其中一个的id
function getOneItem()
{
	var allSel="";
	if(document.form2.id.value) return document.form2.id.value;
	for(i=0;i<document.form2.id.length;i++)
	{
		if(document.form2.id[i].checked)
		{
				allSel = document.form2.id[i].value;
				break;
		}
	}
	return allSel;
}
function selAll()
{
	for(i=0;i<document.form2.id.length;i++)
	{
		if(!document.form2.id[i].checked)
		{
			document.form2.id[i].checked=true;
		}
	}
}
function noSelAll()
{
	for(i=0;i<document.form2.id.length;i++)
	{
		if(document.form2.id[i].checked)
		{
			document.form2.id[i].checked=false;
		}
	}
}
$(function(){
	setPageUrl("/backstage/on/comment/noreply/page/");
	setDataUrl("/backstage/on/comment/noreply/");
});
</script>
<script type="text/javascript" src="${context}/backstagejs/commentNoReply.js"></script>
</head>
<body leftmargin="8" topmargin="8">

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
</tr>
</table>
  
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10">&nbsp;没有审阅评论的作品&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="6%">ID</td>
	<td width="10%">评论人</td>
	<td width="60%">内容</td>
	<td width="10%">评论时间</td>
	<td width="10%">操作</td>
</tr>
<c:forEach items="${commentList}" var="pro">
	<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
		<td>${pro.id}</td>
		<td>${pro.name}</td>
		<td> ${fn:escapeXml(pro.comment)}</td>
		<td><fmt:formatDate value="${pro.createTime}" pattern="yyyy-MM-dd  HH:mm:ss"/></td>
		<td><a style="cursor:pointer" onclick="toView(${pro.id})">审核通过</a></td>
	</tr>
</c:forEach>
<tr bgcolor="#FAFAF1">
</tr>
<input type="hidden" name="currentPage" value="${currentPage}">
<span style="display:none" id="proId">${proId}</span>
<script>
$.ART.type = "${proId}";
</script>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="center"  id="pagearea">
		
	</td>
</tr>
</table>
</form>
</body>
</html>
<script>
function toView(id){
	if(confirm("确定审核通过？")){
		$.ajax({
			url:$.ART.context + "/backstage/on/comment/updateisview",
			type:"POST",
			data:{
					id:id
				},
			success:function(data){
				if(data == 1){
					alert("审核成功！");
					window.location.href="${context}/backstage/on/comment/0";
				}else{
					alert("审核失败！");
				}
			}
		});
	}
}
</script>