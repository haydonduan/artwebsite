<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../util/links.jsp"%>
<script type="text/javascript" src="${context}/js/jqueryForm.js"></script>
<title>更新个人信息</title>
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
<!--立即登录-->
				<div class="sub_c4" id="sub_c28">
					<div class="sub_cmain">
						<div class="right" style="width:100%">
							<div class="tit01">
								<h2 class="tr">用户登录</h2>
							</div>
							<div class="con01" style="overflow: hidden; position: relative; padding: 0px; ">
								<div class="jscroll-c" style="top: 0px; z-index: 9999; zoom: 1; position: relative; padding-right: 7px; ">
									<div style="height:0px;overflow:hidden"></div>
									<div class="con01_txt">　
										<div class="g-wrap">
											<div class="m-loginmain">
												<div class="main">
												 <form action="${context}/forum/on/doupate" method="POST" id="form" enctype="multipart/form-data">
														<ul class="main-form">
															 <li><span class="tit">用户名：</span><input  name="name"  class="input_public" maxlength="32" type="text"></li>
															 <li><span class="tit">旧密码：</span><input  name="oldpsw"  class="input_public" maxlength="32" type="password"></li>
															<li><span class="tit">密码：</span><input  name="psw" class="input_public" maxlength="16" type="password"></li>
															<li><span class="tit">确认密码：</span><input  name="repsw"  class="input_public" maxlength="16" type="password"></li>
															<li><span class="tit">性别：</span>
																<div style="width:70px;margin-left:30px;">
																  <div>男<input type="radio" name="sex" value="0" style="width:50px"></div>
																  <div>女<input type="radio" name="sex" value="1" style="width:50px"></div>
																</div>
															</li>
															<li><span class="tit">头像：</span><input  name="image"  class="input_public" maxlength="32" type="file" onchange="filesize(this)"></li>
														</ul>
													<div class="sub-area"><input id="submit" class="btn-blue" value="更新" type="button"></div>
													</form>
												</div>
											</div>
										</div>
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
</div>
<%@include file="footer.jsp"%>	
</body>
</html>
<script>
var uploadSize = 300;
function filesize(ele) {
	var name = ele.value;
	var houzhui = name.split(".")[1];
	// 返回 KB，保留小数点后两位
    var size = (ele.files[0].size / 1024).toFixed(2);
	if(houzhui != "jpg" && houzhui != "png" && houzhui != "gif"){
		$("input[name=canUpload]").val("2");
	}else if(size <= uploadSize){
        $("input[name=canUpload]").val("1");
    }else{
    	$("input[name=canUpload]").val("0");
    }
}
$(function(){
	$("body").append("<input type='hidden' name='canUpload'/>");
	
	$("#submit").click(function(){

		 if($("input[name=canUpload]").val() == 0){
			alert("建议上传小于"+uploadSize+"K的图片");
			return false;
		} 
		if($("input[name=canUpload]").val() == 2){
			alert("请上传图片格式的文件");
			return false;
		}
		


		
		 $('#form').ajaxForm();
		var name = $("input[name=name]").val();
		var psw = $("input[name=psw]").val();
		var repsw = $("input[name=repsw]").val();
		var oldpsw = $("input[name=oldpsw]").val();
		 if($.trim(name) == ''){
			alert("用户名不能为空");
			return false;
		} 
		 if($.trim(oldpsw) == ''){
			alert("旧密码不能为空");
			return false;
		} 
		if($.trim(psw) == ''){
			alert("密码不能为空");
			return false;
		}
		if($.trim(repsw) != $.trim(psw)){
			alert("重复密码不正确");
			return false;
		}

		 var datas = {
			name:name,
			oldpsw:oldpsw,
			psw:psw,
			repsw:repsw
		};
		$.ajax({
			type:"POST",
			url:$.ART.context + "/forum/on/validate",
			data:datas,
			success:function(data){
				if(data == 0){
					alert("原密码不正确");
					return false;
				}
				if(data == 1){
					alert("重复密码不正确");
					return false;
				}
				if(data == 2){
					alert("用户已占用");
					return false;
				}
				$('#form').ajaxSubmit({
					error:function(){
						alert("更新失败!");
					},
					success:function(){
						alert("更新成功！");
						window.location.href=$.ART.context + "/forum/on/tomypage";
					}
				});
				//window.location.href="${context}/forum/on/tomypage";
			}
		}); 
	});
})
</script>