<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../util/links.jsp"%>
<script src="${context}/js/newspage.js"></script>
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
				<!-- 更多新闻动态 -->
				<div class="sub_c4" id="sub_c38">
					<div class="sub_cmain">
						<div class="right" style="width:100%">
							<div class="tit01">
								<c:if test="${type == 0}">
									<h2>新闻动态</h2>
								</c:if>
								<c:if test="${type == 1}">
									<h2>公告</h2>
								</c:if>
							</div>
							<div class="con01" style="overflow: hidden; position: relative; padding: 0px; "><div class="jscroll-c" style="top: 0px; z-index: 9999; zoom: 1; position: relative; padding-right: 7px; "><div style="height:0px;overflow:hidden"></div>
								<div class="con01_txt">
									<div class="zgm_list1">
										<ul>
										<c:forEach items="${newsList}" var="news">
											<li style="cursor:pointer" onclick="window.location.href='${context}/newsnotice/${news.id}'">${news.title} ( <fmt:formatDate value="${news.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>)</li>
										</c:forEach>
										</ul>
									</div>　
									<div class="smallBtn">
										<ul style="width: 300px; display: block;" id="small">
										</ul>
									</div>
								</div>
							</div><div class="jscroll-e" unselectable="on" style="height: 100%; top: 0px; right: 0px; position: absolute; overflow: hidden; z-index: 10000; width: 7px; background-color: rgb(224, 214, 194); background-position: initial initial; background-repeat: initial initial; "><div class="jscroll-u" style="position: absolute; top: 0px; width: 100%; left: 0px; background-color: black; overflow: hidden; height: 0px; background-position: initial initial; background-repeat: initial initial; "></div><div class="jscroll-h" unselectable="on" style="background-color:rgb(33,63,70); position: absolute; left: 0px; border: 1px solidrgb(33,63,70); top: 0px; width: 5px; height: 134.9638403990025px; background-position: initial initial; background-repeat: initial initial; "></div><div class="jscroll-d" style="position: absolute; bottom: 0px; width: 100%; left: 0px; background-color: black; overflow: hidden; height: 0px; background-position: initial initial; background-repeat: initial initial; "></div></div></div>
						</div>
					</div>
				</div>
				</div>
				
</div>
			<div class="sub_tbg"></div>
		</div>		
	</div>
  <!-- end main -->
  <input type="hidden" name="currentPage" value="${currentPage}">
  <input type="hidden" name="type" value="${type}">
</div>
</div>
<%@include file="footer.jsp"%>	
</body>
</html>