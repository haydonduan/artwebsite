<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../util/links.jsp"%>
<title>联系方式</title>
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
					<div class="sub_c2" id="sub_c33" style=" ">
					<div class="sub_cmain">
						<div class="left" style=" width:200px; background:#EDF5FC; border:1px dotted #DBEAF9; padding-top:20px; text-align:center;">
							<a href="${context}/forum/on/update/page"><img src="${context}/${sessionScope.SESSION_USER.image}" width="100" class="pho_a"></a>
							<br/>
							<ul>
								<li>昵称(${sessionScope.SESSION_USER.name})</li>
								<li>帖子数(${forumCount})</li>
							</ul>
							<br/>
						</div>
						<div class="right" style="width:650px;">
							<div class="con01" style="overflow: hidden; position: relative; padding: 0px; ">
								<div class="jscroll-c" style="top: 0px; z-index: 9999; zoom: 1; position: relative; padding-right: 7px; ">
									<div style="height:0px;overflow:hidden"></div>
									<div class="con01_txt">
										<table style="width:100%;">
											<tr>
												<td>
													<div class="tit01" style="width:100%;">
														<h2 style="width:700px;">他的帖子&nbsp;&nbsp;&nbsp;&nbsp;<span id="sub_t43" class="span_btn" style="margin-left:460px;" onclick="window.location.href='${context}/forum/on/addForum'">发帖</span></h2>
													</div>
													<ul class="list">
													<c:forEach items="${forumList}" var="forum">
														<li  style="cursor:pointer" onclick="window.location.href='${context}/forum/${forum.id}'"> 【${forum.title}】 ( <fmt:formatDate value="${forum.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>)
														<span style="font-weight:bold">  
														<c:if test="${forum.isView == 0}">
														【未审核】
														</c:if>
														<c:if test="${forum.isView == 1}">
														【审核通过】
														</c:if>
														<c:if test="${forum.isView == 2}">
														【审核未通过】
														</c:if>
														</span>
														</li>
													</c:forEach>
													</ul>
												</td>
											</tr>
										</table>
									</div>
								</div>
								<div class="jscroll-e" unselectable="on" style="height: 100%; top: 0px; right: 0px; position: absolute; overflow: hidden; z-index: 10000; width: 7px; background-color: rgb(224, 214, 194); background-position: initial initial; background-repeat: initial initial; ">
									<div class="jscroll-u" style="position: absolute; top: 0px; width: 100%; left: 0px; background-color: black; overflow: hidden; height: 0px; background-position: initial initial; background-repeat: initial initial; "></div>
									<div class="jscroll-h" unselectable="on" style="background-color:rgb(33,63,70); position: absolute; left: 0px; border: 1px solidrgb(33,63,70); top: 0px; width: 5px; height: 134.9638403990025px; background-position: initial initial; background-repeat: initial initial; "></div>
									<div class="jscroll-d" style="position: absolute; bottom: 0px; width: 100%; left: 0px; background-color: black; overflow: hidden; height: 0px; background-position: initial initial; background-repeat: initial initial; "></div>
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