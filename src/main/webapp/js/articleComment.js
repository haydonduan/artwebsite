$(function(){
	$(".btn-sblue").click(function(){
			//没有登录
			if($("input[name=user]").val() == ''){
				if(confirm("您还没有登录，请登录后才可评论！")){
					window.location.href = $.ART.context + "/login";
				}
			}else{
				//登录后
				
				if($.trim($("#content").val()) == ''){
					alert("评论内容不能为空");
					return;
				}
				
				if($.trim($("#content").val()).length > 100){
					alert("评论内容字数不能超过100");
					return;
				}
				
				var commentData = {
					id:$("input[name=id]").val(),
					comment:$("#content").val()
				};
				
				$.ajax({
					type : "POST",
					url : $.ART.context + "/forum/addcomment",
					data:commentData,
					success : function(data) {
							if(data == 1){
								alert("评论成功");
								$("#content").val("");
								alert("评论需要审核才可以显示");
							}else if(data == 2){
								alert("评论内容字数不能超过100");
							}else{
								alert("评论失败");
							}
						}
				});
			}
		});
});