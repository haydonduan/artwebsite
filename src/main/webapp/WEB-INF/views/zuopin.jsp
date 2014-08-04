<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../util/links.jsp"%>
<script type="text/javascript" src="${context}/js/page.js"></script>
<title></title>
</head>
<body>
	<div id="topWrap">
	<div id="headBox"></div>
</div>
<div id="wrap">
	<!-- p_r1 begin -->
	<div class="p_r1" id="part_4">
		<script language="javascript" type="text/javascript">
		</script>
		<div class="wrap">
    <!-- 导航头部 begin -->
		 <%@ include  file="head.jsp"%>		
  	<!-- 导航 end -->
  	<!-- main -->
	  <div class="main clearfix">
	  	<div class="sub clearfix" id="sub01">
			<div class="sub_c">
<!-- 作品中心 -->
				<div class="sub_c4" id="sub_c3" style=" ">
					<div class="sub_cmain">
						<div class="right" style="width:900px">
							<div class="tit01">
								<h2>
									<c:choose>
										<c:when test="${productType == 1}">
											作品山水
											<script>
											$("title").html("作品中心-山水")
											</script>
										</c:when>
										<c:when test="${productType == 2}">
											作品骏马
											<script>
											$("title").html("作品中心-骏马")
											</script>
										</c:when>
									</c:choose>
								</h2>
							</div>
							<div class="con01" style="overflow: hidden; position: relative; padding: 0px; ">
								<div class="con01_txt">
									<div class="zgm_list">
										<div class="g-main2 r" style="float:left">
											<ul class="m-listphoto x">
											<c:forEach items="${productionList}" var="production">
												<li>
													<img alt="${production.title}" src="${context}/${production.image}" height="210" width="450">
													<a href="${context}/detail/${production.id}" target="_blank" class="name f-trans">
														<span class="meta">
															<i title="浏览数" class="i1"></i>
															<span class="f-mr20">${production.scanNum}</span> 
															<i title="评论数" class="i2"></i>
															<span class="f-mr20">${production.commentCount}</span> 
															<i title="喜欢数" class="i3"></i>
															<span>${production.loveNum}</span>
														</span>
														时间：<fmt:formatDate value="${production.finishTime}" pattern="yyyy-MM-dd" /><br />
														作品名称：${production.title}
													</a>
													<div class="cover f-trans"></div>
												</li>
											</c:forEach>
											</ul>
									</div>
									</div>
									<div class="smallBtn">
										<ul style="width: 300px; display: block;" id="small">
										</ul>
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
	<!-- hidden  message -->
	<input type="hidden" name="type" value="${productType}">
	<input type="hidden" name="currentPage" value="${currentPage}">
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