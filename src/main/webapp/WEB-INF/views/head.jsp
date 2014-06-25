<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../util/tags.jsp"%>
<script src="${context}/js/artCommon.js"></script>
<script>
	$("head").prepend('<link rel="shortcut icon" href="${context}/favicon.ico" type="image/x-icon" />');
</script>
<div id="headBox">
			<div class="secondaryHeader1">
				<div class="sHBorder1">
					<div class="sHLogo1"><a href="${context}" class="logo1">
						<img src="${context}/${logo}">					
					</a></div>
					<div class="sHLinks1" style="background:url(${context}/${banner}) no-repeat;">
						<c:choose>
							<c:when test="${sessionScope.SESSION_USER == null}">
								<ul>
									<li id="sub_t28" style="cursor:pointer;" onclick="window.location.href='${context}/login'">立即登录</li>
									<li id="sub_t29" style="cursor:pointer;" onclick="window.location.href='${context}/register'">免费注册</li>
								</ul>
							</c:when>
							<c:otherwise>
								<!--登陆之后-->
								<ul>
									<li id="sub_t333" style="cursor:pointer;">退出登录</li>
									<li id="sub_t33" style="cursor:pointer;" onclick="window.location.href='${context}/forum/on/tomypage'">个人中心</li>
									<li>你好${sessionScope.SESSION_USER.name}，欢迎你的光临！</li>
								</ul>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<!-- 头部 end -->
		</div>
		  <div class="sub_t">
		  	<ul id="sddm">
				<li id="sub_t1" class='<c:if test="${type == 'huajiadongtai'}">selected</c:if>' onclick="window.location.href='${context}/index'">画家动态</li>
				<li id="sub_t2" class='<c:if test="${type == 'huajiajianjie'}">selected</c:if>' onclick="window.location.href='${context}/painterintroduction/index'">画家简介</li>
				<li class='<c:if test="${type == 'zuopinzhongxin'}">selected</c:if>'>
					<span href="#" onmouseover="mopen('m1')" onmouseout="mclosetime()">作品中心</span>
						<div style="z-index:9999999" id="m1" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
							<a href="javascript:void(0)" id="sub_t7" onclick="window.location.href='${context}/production/1/0'">山水</a>
							<a href="javascript:void(0)" id="sub_t3"  onclick="window.location.href='${context}/production/2/0'">骏马</a>
						</div>
				</li>
				<li id="sub_t4" class='<c:if test="${type == 'huajiayushehui'}">selected</c:if>'  onclick="window.location.href='${context}/paintersocial/index'">画家与社会</li>
				<li id="sub_t5" class='<c:if test="${type == 'luntan'}">selected</c:if>' onclick="window.location.href='${context}/forum/index'">论坛</li>
				<li id="sub_t6" class='<c:if test="${type == 'lianxifangshi'}">selected</c:if>' onclick="window.location.href='${context}/contact/index'">联系方式</li>
			</ul>
		</div>