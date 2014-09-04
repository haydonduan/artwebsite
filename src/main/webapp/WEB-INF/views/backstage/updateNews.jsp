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
<script type="text/javascript" src="${context}/ckeditor/ckeditor.js"/>
<script type="text/javascript"></script>
</head>
<body leftmargin="8" topmargin="8">
<!--  内容列表   -->
<form action="${context}/backstage/on/newsnotice/save" method="POST" enctype="multipart/form-data" id="form">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
	<tr bgcolor="#E7E7E7">
		<td height="24" colspan="10">&nbsp;
		<c:if test="${type == 'news'}">
			更新新闻
		</c:if>
		<c:if test="${type == 'notice'}">
			更新公告
		</c:if>
		&nbsp;</td>
	</tr>
	<tr bgcolor="#EEF4EA">
		<td>
		<c:if test="${type == 'news'}">
			新闻标题
		</c:if>
		<c:if test="${type == 'notice'}">
			公告标题
		</c:if>
		</td>
		<td>
			<input type="text" name="title" size=60 value="${newsNotice.title}">
		</td>
	</tr>
	<c:if test="${type == 'news'}">
		<tr bgcolor="#EEF4EA">
			<td>
				新闻类型
			</td>
			<td>
				<select name="type" id="selectT">
					 <c:if test="${newsNotice.isOwn == 1}">
						<option value="1" selected>个人新闻</option>
						<option value="0">普通新闻</option>
					 </c:if>
					 <c:if test="${newsNotice.isOwn == 0}">
					 <option value="1">个人新闻</option>
						<option value="0" selected>普通新闻</option>
					 </c:if>
				</select>
			</td>
		</tr>
	</c:if>
	<c:if test="${type != 'news'}">
		<input type="hidden" name="type" value="2">
	</c:if>
	<tr bgcolor="#EEF4EA">
			<td>
				图片
			</td>
			<td>
				<input type="file" name="image" onchange="filesize(this)"><span style="color:red">建议上传266px(宽)*168px(高)的图片</span>
			</td>
		</tr>
	<tr bgcolor="#EEF4EA">
		<td>
		<c:if test="${type == 'news'}">
			新闻内容
		</c:if>
		<c:if test="${type == 'notice'}">
			公告内容
		</c:if>
		</td>
		<td>
			<textarea name="editor01">${newsNotice.text}</textarea>
			<input name="text" type="hidden" >
			<input name="id" type="hidden" value="${newsId}">
		</td>
	</tr>
	<tr bgcolor="#EEF4EA">
		<td>
			
		</td>
		<td>
			<input type="button" value="保存" id="saveBu">
		</td>
		
	</tr>
</table>
</body>
</form>
</html>
<script>

$("body").append("<input type='hidden' name='canUpload'/>");
var uploadSize = 300;
function filesize(ele) {
	var name = ele.value;
	var houzhui = name.split(".")[1];
	if(houzhui != "jpg" && houzhui != "png" && houzhui != "gif"){
		$("input[name=canUpload]").val("2");
		return;
	}
    // 返回 KB，保留小数点后两位
    var size = (ele.files[0].size / 1024).toFixed(2);
    if(size <= uploadSize){
        $("input[name=canUpload]").val("1");
    }else{
    	$("input[name=canUpload]").val("0");
    }
}

	var editor = CKEDITOR.replace('editor01',{
	    uiColor : '#88C861',
	    width:516,
	    height:400
	});
	$("#saveBu").click(function(){
		$('#form').ajaxForm();
		var selectV;
		var html= CKEDITOR.instances.editor01.getData();
		var title = $("input[name=title]").val();
		var text = editor.document.getBody().getText();

		if("${type}" == "news"){
			selectV = $("#selectT").val();
		}else{
			selectV = "2";
		}
		//检查
		if($.trim(title) == ''){
			alert("标题不能为空");
			return;
		}
		if($.trim(text) == ''){
			alert("内容不能为空");
			return;
		}
		//引入文件判断
		if($("input[name=canUpload]").val() != ''){
			if($("input[name=canUpload]").val() == 2){
				alert("请上传图片格式的文件");
				return;
			}
			if($("input[name=canUpload]").val() == 0){
				alert("建议上传小于"+uploadSize+"K的图片");
				return;
			}
		}

		
		$("input[name=text]").val(html);

		$('#form').ajaxSubmit({
			error:function(){
				alert("更新失败!");
			},
			success:function(data){
				alert("更新成功！");
				<c:if test="${type == 'news'}">
					window.location.href="${context}/backstage/on/newsnotice/0/0";
				</c:if>
				<c:if test="${type == 'notice'}">
					window.location.href="${context}/backstage/on/newsnotice/0/1";
				</c:if>
			}
		});
	});
</script>