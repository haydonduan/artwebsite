$(function(){
	//退出登录
	$("#sub_t333").click(function(){
		$.ajax({
			type:"get",
			url:$.ART.context + "/quit",
			success:function(data){
				window.location.reload();
			}
		});
	});
	//登录
	$("#sub_t333").click(function(){
		$.ajax({
			type:"get",
			url:$.ART.context + "/quit",
			success:function(data){
				window.location.reload();
			}
		});
	});
});