<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../util/links.jsp"%>
<script type="text/javascript" src="${context}/ckeditor/ckeditor.js"></script>
<title>发布帖子</title>
</head>
<body>
	<div id="topWrap">
	<div id="headBox"></div>
</div>
<div id="wrap">
	<!-- p_r1 begin -->
	<div class="p_r1" id="part_4">
		<div class="wrap">
    <!-- 导航头部 begin -->
		 <%@ include  file="head.jsp"%>		
  	<!-- 导航 end -->
  	<!-- main -->
	  <div class="main clearfix">
	  	<div class="sub clearfix" id="sub01">
			<div class="sub_c">
				<div class="sub_c4" id="sub_c43">
					<div class="sub_cmain">
						<div class="right" style="width:100%">
							<div class="tit01">
								<h2 class="tr">发表新帖</h2>
							</div>
							<div class="con01" style="overflow: hidden; position: relative; padding: 0px; ">
								<div>
									<div class="con01_txt">
 									<form action="${context}/forum/on/doAddForum" method="POST">
										<div style="float:left;"><input type="text" class="topic_input" name="title"/></div>
										<div class="topic_input content_div">
											<textarea name="editor01"></textarea>
											<input type="hidden" name="text" id="copy">
										</div>
										<div style="float:right; margin-top:20px;"><input type="submit" value="发帖" id="addBu"></span></div>
									</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
				
</div>
			<div class="sub_tbg"></div>
		</div>		
	</div>
  <!-- end main -->
</div>
<!-- begin 下拉 -->
<script type="text/javascript">

</script>
<!-- end 下拉-->
<!-- p_r1 end -->
</div>
<!-- sina footer begin -->
<%@include file="footer.jsp"%>	
</body>
</html>
<script>
var editor = CKEDITOR.replace('editor01',{
    uiColor : '#E0E9F0',
    width:849,
    height:243,
    resize_enabled:false
});
$("#addBu").click(function(){
	var text = editor.document.getBody().getText();
	var html= CKEDITOR.instances.editor01.getData();
	var title = $("input[name=title]").val();

	if($.trim(title) == ''){
		alert("标题不能为空");
		return false;
	}
	if(text == ''){
		alert("内容不能为空");
		return false;
	}

	$("#copy").val(html);
});
</script>