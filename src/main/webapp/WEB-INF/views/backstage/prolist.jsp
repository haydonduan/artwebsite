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
	setPageUrl("/backstage/on/pro/page/");
	setDataUrl("/backstage/on/pro/");
});
</script>
<script type="text/javascript" src="${context}/backstagejs/prolist.js"></script>
</head>
<body leftmargin="8" topmargin="8">

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
    <input type='button' class="coolbg np" onclick="window.location.href='${context}/backstage/on/pro/addProPage'" value='添加作品' />
    <input type='button' class="coolbg np" onclick="deleteMore()" value='批量删除' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>
  
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10">&nbsp;作品列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#99B0C7" height="22">

	<td width="6%"><input type="checkbox" id="parentChe"></td>
	<td width="6%">ID</td>
	<td width="28%">作品标题</td>
	<td width="10%">完成时间</td>
	<td width="10%">类目</td>
	<td width="8%">点击量</td>
	<td width="6%">喜欢数</td>
	<td width="10%">操作</td>
</tr>
<c:forEach items="${proList}" var="pro">
	<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td width="6%"><input type="checkbox" class="childChe" name="child_${pro.id}"></td>
		<td>${pro.id}</td>
		<td>${pro.title}</td>
		<td><fmt:formatDate value="${pro.finishTime}" pattern="yyyy-MM-dd"/></td>
		<td>${pro.productionType}</td>
		<td>${pro.scanNum}</td>
		<td>${pro.loveNum}</td>
		<td><a href="${context}/backstage/on/pro/updateProPage/${pro.id}">编辑</a> | <a onclick="deletePro(${pro.id})" style="cursor:pointer">删除</a></td>
	</tr>
</c:forEach>
<tr bgcolor="#FAFAF1">
</tr>
<input type="hidden" name="currentPage" value="${currentPage}">
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="center"  id="pagearea">
	</td>
</tr>
</table>
</form>
</body>
</html>
<script>
	function deletePro(id){
		if(confirm("确定删除？")){
			$.ajax({
				url:$.ART.context + "/backstage/on/pro/delete",
				type:"POST",
				data:{
						id:id
					},
				success:function(data){
					if(data == 1){
						alert("删除成功！");
						window.location.reload();
					}else{
						alert("删除失败！");
					}
				}
			});
		}
	}
</script>
<script type="text/javascript" src="${context}/backstagejs/deleteMore.js"></script>