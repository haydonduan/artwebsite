var viewModel;
var getCommentData = function(id){
	$.ajax({
		type : "get",
		url : $.ART.context + "/comment/"+id,
		success : function(data) {
			viewModel.dataList(data);
		}
	});
};


var getLoveNum = function(id){
	$.ajax({
		type : "get",
		url : $.ART.context + "/detail/getLoveNum/"+id,
		success : function(data) {
			viewModel.loveNum(data);
		}
	});
}
$(function() {
	viewModel = {
		//定义一个简单的属性
		loveNum : ko.observable(),
		// 这是一个array,初始化为空 可用来list
		dataList : ko.observableArray([]),
		//定义的函数
		fun : function(){
			
		 }
		};
		ko.applyBindings(viewModel);
		//getCommentData($("input[name=id]").val());
		getLoveNum($("input[name=id]").val());
	/**
	 * 点击喜欢按钮
	 */
		$(".btn-dimgray").click(function(){
			$.ajax({
				type : "get",
				url : $.ART.context + "/detail/addLoveNum/"+$("input[name=id]").val(),
				success : function(data) {
						getLoveNum($("input[name=id]").val());
					}
			});
		});
	/**
	 * 添加评论
	 */	
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
					url : $.ART.context + "/comment/addcomment",
					data:commentData,
					success : function(data) {
							if(data == 1){
								alert("评论成功");
								$("#content").val("");
								alert("评论内容需要画家审阅后才可显示");
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