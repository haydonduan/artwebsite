$(function(){
	
	$("#logout").click(function(){
		$.ajax({
			url:$.ART.context + "/backstage/logout",
			type:"get",
			success:function(data){
				if(data == 1){
					parent.location.href=$.ART.context + "/backstage/login";
				}
			}
		});
	});
});