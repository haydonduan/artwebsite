<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../util/links.jsp"%>
<script src="${context}/js/knockout-2.3.0.js"></script>
<script src="${context}/js/comment.js"></script>
<title>作品：${production.title}</title>
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
				<!--山水详情-->
				<div class="sub_c2" id="sub_c27" style=" ">
					<div class="sub_cmain">
						<div class="right" style="width:90%; margin-left:5%;">
							<div class="tit01">
								<%-- <h2 class="tr">作品名称:&nbsp;<span class="size">${production.title}</span>&nbsp;&nbsp;完成时间：&nbsp;<span class="size"><fmt:formatDate value="${production.finishTime}" pattern="yyyy-MM-dd" /></span>&nbsp;&nbsp;灵感：&nbsp;<span class="size">${production.inspiration}</span></h2> --%>
								<h2 class="tr" style="font-size:17px">作品名称:&nbsp;<span class="size" style="font-size:17px">${production.title}</span>&nbsp;&nbsp;完成时间：&nbsp;<span class="size" style="font-size:17px"><fmt:formatDate value="${production.finishTime}" pattern="yyyy-MM-dd" /></span>&nbsp;&nbsp;灵感：&nbsp;<span class="size" style="font-size:17px">${production.inspiration}</span></h2>
							</div>
							<div class="con01" style="overflow: hidden; position: relative; padding: 0px; ">
								<div class="jscroll-c" style="top: 0px; z-index: 9999; zoom: 1; position: relative; padding-right: 7px; ">
									<div style="height:0px;overflow:hidden"></div>
									<div class="con01_txt" style="height:100%;">　
										<img src="${context}/${production.image}" width="860"/>
										<br/>
										<div class="pic-btnarea">
											<a class="btn-dimgray" style="cursor:pointer"><em><img src="${context}/img/good.png" style="width:15px;height:15px">喜欢</em>(<i data-bind="text:loveNum"></i>)</a>					
										</div>
										<i class="clear"></i>
										<div class="cmt">
											<div class="j-wtr">对该组图的评论（${commentAllCount}条）</div>
												<div class="j-main">
													<div class="j-wed clearfix">
														<div class="cmt-avt">
															<a >
																<c:choose>
																	<c:when test="${sessionScope.SESSION_USER == null}">
																		<img src="${context}/img/nophoto.gif" height="50" width="50">
																	</c:when>
																	<c:otherwise>
																		<img src="${context}/${sessionScope.SESSION_USER.image}" height="50" width="50">
																	</c:otherwise>
																</c:choose>
															</a>
														</div>
														<div class="cmt-edt"><textarea id="content" name="content" style="font-size:14px;"></textarea></div>
														<div class="cmt-zbtn">
															<input value="发表评论" class="btn-sblue"  type="button">
														</div>	
													</div>	
													
													<!-- 评论 -->	
														<!-- <div data-bind="foreach:{data:dataList , as: 'data'}"> -->
														<c:forEach items="${comments}" var="comment">
															<div class="j-cnt">
																<div class="nbw-cmt bdwd">
																	<!-- <div class="nbw-fce l"><a class="c-tag" href="#"><img class="" title="" alt="" data-bind="attr:{src:data.image}" height="50" width="50"></a></div> -->
																	<div class="nbw-fce l"><a class="c-tag" href="#"><img class="" title="" alt="" src="${comment.image}" height="50" width="50"></a></div>
																	<div class="thde">
																		<!-- <span class="r s-gray" data-bind="text:data.formatCreateTime"></span> -->
																		<span class="r s-gray">${comment.formatCreateTime}</span>
																		<div class="c-sb">
																			<!-- <a class="s-blue j-name" href="#" data-bind="text:data.name"></a>
																			<div class="cnt" data-bind="text:data.comment"></div> -->
																			 <a class="s-blue j-name" href="#">${comment.name}</a>
																			<div class="cnt">${fn:escapeXml(comment.comment)}</div>
																			<div class="reps"></div>								
																		</div>
																	</div>
																</div>
															</div>
														</c:forEach>
														<!-- </div> -->
													<!-- 评论完 -->
												</div>
											</div>
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
			<div class="sub_tbg"></div>
		</div>		
	</div>
	<!-- hidden -->
	<input type="hidden" name="id" value="${production.id}"/>
	<input type="hidden" name="user" value="${sessionScope.SESSION_USER.id}"/>
</div>
</div>
</div>
<!-- sina footer begin -->
<%@include file="footer.jsp"%>	
</body>
</html>