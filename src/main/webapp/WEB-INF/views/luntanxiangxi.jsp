<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../util/links.jsp"%>
<script src="${context}/js/articleComment.js"></script>
<title>帖子-${forum.title}</title>
</head>
<body>
	<div id="topWrap">
	<div id="headBox"></div>
</div>
<div id="wrap">
	<!-- p_r1 begin -->
	<div class="p_r1" id="part_4">
		<script language="javascript" type="text/javascript">
		 function SubShowClass(ID,eventType,defaultID,openClassName,closeClassName){var t=this;this.parentObj=this.$(ID);if(this.parentObj==null&&ID!="none"){throw new Error("SubShowClass(ID)参数错误:ID 对像不存在!(value:"+ID+")")};this.lock=false;this.label=[];this.defaultID=defaultID==null?0:defaultID;this.selectedIndex=this.defaultID;this.openClassName=openClassName==null?"selected":openClassName;this.closeClassName=closeClassName==null?"":closeClassName;this.mouseIn=false;var mouseInFunc=function(){t.mouseIn=true};var mouseOutFunc=function(){t.mouseIn=false};if(ID!="none"&&ID!=""){this.addEvent(this.parentObj,"mouseover",mouseInFunc)};if(ID!="none"&&ID!=""){this.addEvent(this.parentObj,"mouseout",mouseOutFunc)};if(typeof(eventType)!="string"){eventType="onmousedown"};eventType=eventType.toLowerCase();switch(eventType){case"onmouseover":this.eventType="mouseover";break;case"onclick":this.eventType="click";break;case"onmouseup":this.eventType="mouseup";break;default:this.eventType="mousedown"};this.autoPlay=false;this.autoPlayTimeObj=null;this.spaceTime=5000};SubShowClass.prototype={version:"1.31",author:"mengjia",_delay:200,_setClassName:function(obj,type){var temp;temp=obj.className;if(temp){temp=temp.replace(this.openClassName,"");temp=temp.replace(this.closeClassName,"");temp+=" "+(type=="open"?this.openClassName:this.closeClassName)}else{temp=(type=="open"?this.openClassName:this.closeClassName)};obj.className=temp},addLabel:function(labelID,contID,parentBg,springEvent,blurEvent){var t=this;var labelObj=this.$(labelID);var contObj=this.$(contID);if(labelObj==null&&labelID!="none"){throw new Error("addLabel(labelID)参数错误:labelID 对像不存在!(value:"+labelID+")")};var TempID=this.label.length;if(parentBg==""){parentBg=null};this.label.push([labelID,contID,parentBg,springEvent,blurEvent]);var tempFunc=function(){if(t.eventType=='mouseover'){clearTimeout(labelObj._timeout);labelObj._timeout=setTimeout(function(){t.select(TempID)},t._delay)}else{t.select(TempID)}};if(labelID!="none"){this.addEvent(labelObj,this.eventType,tempFunc);if(t.eventType=='mouseover'){this.addEvent(labelObj,'mouseout',function(){clearTimeout(labelObj._timeout)})}};if(TempID==this.defaultID){if(labelID!="none"){this._setClassName(labelObj,"open")};if(this.$(contID)){contObj.style.display=""};if(this.ID!="none"){if(parentBg!=null){this.parentObj.style.background=parentBg}};if(springEvent!=null){eval(springEvent)}}else{if(labelID!="none"){this._setClassName(labelObj,"close")};if(contObj){contObj.style.display="none"}};var mouseInFunc=function(){t.mouseIn=true};var mouseOutFunc=function(){t.mouseIn=false};if(contObj){this.addEvent(contObj,'mouseover',mouseInFunc);this.addEvent(contObj,'mouseout',mouseOutFunc)}if(this.label.length==1){this.selectedContEle=contObj}this.touchInit(contObj)},select:function(num,force){if(typeof(num)!="number"){throw new Error("select(num)参数错误:num 不是 number 类型!(value:"+num+")")};if(force!=true&&this.selectedIndex==num){return};var i;for(i=0;i<this.label.length;i++){if(i==num){if(this.label[i][0]!="none"){this._setClassName(this.$(this.label[i][0]),"open")};if(this.$(this.label[i][1])){this.$(this.label[i][1]).style.display="";if(this.showType){this.extend.show(this.$(this.label[i][1]))}this.selectedContEle=this.$(this.label[i][1])};if(this.ID!="none"){if(this.label[i][2]!=null){this.parentObj.style.background=this.label[i][2]}};if(this.label[i][3]!=null){if(typeof(this.label[i][3])=='function'){this.label[i][3]()}else{eval(this.label[i][3])}}}else if(this.selectedIndex==i||force==true){if(this.label[i][0]!="none"){this._setClassName(this.$(this.label[i][0]),"close")};if(this.$(this.label[i][1])){this.$(this.label[i][1]).style.display="none"};if(this.label[i][4]!=null){if(typeof(this.label[i][4])=='function'){this.label[i][4]()}else{eval(this.label[i][4])}}}};this.selectedIndex=num},random:function(){if(arguments.length!=this.label.length){throw new Error("random()参数错误:参数数量与标签数量不符!(length:"+arguments.length+")")};var sum=0,i;for(i=0;i<arguments.length;i++){sum+=arguments[i]};var randomNum=Math.random(),percent=0;for(i=0;i<arguments.length;i++){percent+=arguments[i]/sum;if(randomNum<percent){this.select(i);break}}},order:function(){if(arguments.length!=this.label.length){throw new Error("order()参数错误:参数数量与标签数量不符!(length:"+arguments.length+")")};if(!(/^\d+$/).test(SubShowClass.sum)){return};var count=0,i;for(i=0;i<arguments.length;i++){count+=arguments[i]};var num=SubShowClass.sum%count;if(num==0){num=count};var sum=0;for(i=0;i<arguments.length;i++){sum+=arguments[i];if(sum>=num){this.select(i);break}}},play:function(spTime){var t=this;if(typeof(spTime)=="number"){this.spaceTime=spTime};clearInterval(this.autoPlayTimeObj);this.autoPlayTimeObj=setInterval(function(){t.autoPlayFunc()},this.spaceTime);this.autoPlay=true},autoPlayFunc:function(){if(this.autoPlay==false||this.mouseIn==true){return};this.nextLabel()},nextLabel:function(){var t=this;var index=this.selectedIndex;index++;if(index>=this.label.length){index=0};this.select(index);if(this.autoPlay==true){clearInterval(this.autoPlayTimeObj);this.autoPlayTimeObj=setInterval(function(){t.autoPlayFunc()},this.spaceTime)}},previousLabel:function(){var t=this;var index=this.selectedIndex;index--;if(index<0){index=this.label.length-1};this.select(index);if(this.autoPlay==true){clearInterval(this.autoPlayTimeObj);this.autoPlayTimeObj=setInterval(function(){t.autoPlayFunc()},this.spaceTime)}},preLabel:function(){this.previousLabel()},stop:function(){clearInterval(this.autoPlayTimeObj);this.autoPlay=false},$:function(objName){if(document.getElementById){return eval('document.getElementById("'+objName+'")')}else{return eval('document.all.'+objName)}},addEvent:function(obj,eventType,func){if(obj.attachEvent){obj.attachEvent("on"+eventType,func)}else{obj.addEventListener(eventType,func,false)}},delEvent:function(obj,eventType,func){if(obj.detachEvent){obj.detachEvent("on"+eventType,func)}else{obj.removeEventListener(eventType,func,false)}},touchX:0,touchLastX:0,touchStatus:'ok',touchInit:function(obj){if(!/\((iPhone|iPad|iPod)/i.test(navigator.userAgent)){return};var tempThis=this;this.addEvent(obj,'touchstart',function(e){tempThis._touchstart(e)});this.addEvent(obj,'touchmove',function(e){tempThis._touchmove(e)});this.addEvent(obj,'touchend',function(e){tempThis._touchend(e)})},_touchstart:function(e){this.touchX=e.touches[0].pageX;this.scrollX=window.pageXOffset;this.scrollY=window.pageYOffset},_touchmove:function(e){if(e.touches.length>1){this.touchStatus='ok';return};this.touchLastX=e.touches[0].pageX;var cX=this.touchX-this.touchLastX;if(this.touchStatus=='ok'){if(this.scrollY==window.pageYOffset&&this.scrollX==window.pageXOffset&&Math.abs(cX)>50){this.selectedContEle.parentNode.style.overflowX='hidden';this.selectedContEle.style.width=this.selectedContEle.offsetWidth+'px';this.touchStatus='touch'}else{return}};if(this.touchStatus=='touch'){this.selectedContEle.style.marginLeft=-cX+'px';e.preventDefault()}},_touchend:function(e){if(this.touchStatus!='touch'){return};this.touchStatus='ok';var cX=this.touchX-this.touchLastX;var tempThis=this;var speed=Math.round(this.selectedContEle.offsetWidth/5);this.selectedContEle.style.marginLeft='';this.selectedContEle.parentNode.style.overflowX='';this.selectedContEle.style.width='';if(cX<0){this.preLabel()}else{this.nextLabel()};this.extend.show(tempThis.selectedContEle)},extend:{setOpacity:function(obj,opacity){if(typeof(obj.style.opacity)!='undefined'){obj.style.opacity=opacity}else{obj.style.filter='Alpha(Opacity='+(opacity*100)+')'}},show:function(obj,timeLimit){var tempThis=this;this.setOpacity(obj,0);if(!timeLimit){timeLimit=200};var opacity=0,step=timeLimit/20;clearTimeout(obj._extend_show_timeOut);obj._extend_show_timeOut=setTimeout(function(){if(opacity>=1){return};opacity+=1/step;tempThis.setOpacity(obj,opacity);obj._extend_show_timeOut=setTimeout(arguments.callee,20)},20)},actPX:function(obj,key,start,end,speed,endFn,u){if(typeof(u)=='undefined'){u='px'};clearTimeout(obj['_extend_actPX'+key.replace(/\-\.\=/,'_')+'_timeOut']);if(start>end){speed=-Math.abs(speed)}else{speed=Math.abs(speed)};var now=start;var length=end-start;obj['_extend_actPX'+key.replace(/\-\.\=/,'_')+'_timeOut']=setTimeout(function(){now+=speed;var space=end-now;if(start<end){if(space<length/3){speed=Math.ceil(space/3)};if(space<=0){obj[key]=end+u;if(endFn){endFn()};return}}else{if(space>length/3){speed=Math.floor(space/3)};if(space>=0){obj[key]=end+u;if(endFn){endFn()};return}};obj[key]=now+u;obj['_extend_actPX'+key.replace(/\-\.\=/,'_')+'_timeOut']=setTimeout(arguments.callee,20)},20)}}};
		</script>
		<div class="wrap">
    <!-- 导航头部 begin -->
		 <%@ include  file="head.jsp"%>		
  	<!-- 导航 end -->
  	<!-- main -->
	  <div class="main clearfix">
	  	<div class="sub clearfix" id="sub01">
			<div class="sub_c">
				<!-- 最新帖子详情 -->
				<div class="sub_c2" id="sub_c32">
					<div class="sub_cmain">
						<div class="right" style="width:90%; margin-left:5%;">
							<div class="tit01">
								<h2><span style="font-size:14px;">查看：</span><span style="font-size:12px;">${forum.clickNum}</span>&nbsp;<span style="font-size:14px;">回复：</span><span style="font-size:12px;">${forum.artComment}</span>&nbsp;|&nbsp;${forum.title}</h2>
							</div>
							<div class="con01" style="overflow: hidden; position: relative; padding: 0px; ">
								<div class="jscroll-c" style="top: 0px; z-index: 9999; zoom: 1; position: relative; padding-right: 7px; ">
									<div style="height:0px;overflow:hidden"></div>
									<div class="con01_txt">
										<div class="left" style="width:200px; border:2px solid #F1FBFD; border-bottom:3px solid #9AA7B7; margin:0px; text-align:center; height:100%; background:#D3DDE7;">
											<img src="${context}/${forum.image}" width="100" class="pho_a">
											<br/>
											<ul>
												<li><a href="javascript:void(0)">${forum.name}</a></li>
												<li>帖子数：${forum.artCount}</li>
											</ul>
											<br/>
										</div>　
										<div class="right" style="width:650px; margin-right:0px; margin-top:-27px;">　
											${forum.content}
										</div>
										<div style="clear:both"></div>
										<br/>
										<div class="cmt">
												<div class="j-wtr">对该帖子的评论（${forum.artComment}条）</div>
												  <div class="j-main">
													<div class="j-wed clearfix">
													<input id="tid" name="tid" value="1576733" type="hidden">
														<div class="cmt-avt">
															<a>
																<c:choose>
																	<c:when test="${sessionScope.SESSION_USER == null}">
																		<img src="${context}/img/nophoto.gif" height="50" width="50">
																	</c:when>
																	<c:otherwise>
																		<img src="${context}/${sessionScope.SESSION_USER.image}" height="50" width="50">
																	</c:otherwise>
																</c:choose>
															</a>
															<c:if test="${sessionScope.SESSION_USER != null}">
																<a class="thide b-tag s-blue" target="_blank">${sessionScope.SESSION_USER.name}</a>
															</c:if>
														</div>
														<div class="cmt-edt"><textarea id="content" name="content" style="font-size:14px;"></textarea></div>
														<div class="cmt-zbtn">
															<input value="发表评论" class="btn-sblue" type="button">
														</div>
													</div>
													<c:forEach items="${comments}" var="comment">
														<div class="j-cnt">
															<div class="nbw-cmt bdwd">
																<div class="nbw-fce l">
																	<a class="c-tag">
																		<img class="" title="" alt="" src="${context}/${comment.image}" height="50" width="50">
																	</a>
																</div>
																<div class="thde">
																	<span class="r s-gray"><fmt:formatDate value="${comment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </span>
																	<div class="c-sb">
																		<a class="s-blue j-name">${comment.name}</a>
																		<div class="cnt">${fn:escapeXml(comment.comment)}</div>
																		<div class="reps">
																		</div>
																	</div>
																</div>
															</div>
													</div>
													</c:forEach>		
													</div>
											</div>
									<div style="clear:both"></div>
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
	<input type="hidden" name="id" value="${forum.id}"/>
	<input type="hidden" name="user" value="${sessionScope.SESSION_USER.id}"/>
  <!-- end main -->
</div>
</div>
</div>
<!-- sina footer begin -->
<%@include file="footer.jsp"%>	
</body>
</html>