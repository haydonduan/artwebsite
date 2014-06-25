
$(function(){
	
	$(".btn").click(function(){
		var name = $("input[name=name]").val();
		var password = $("input[name=password]").val();
		
		if($.trim(name) == ''){
			alert("用户名不能为空");
			return;
		}
		if($.trim(password) == ''){
			alert("密码不能为空");
			return;
		}
		
		var data = {
			name:name,
			password:password
		};
		$.ajax({
			url:$.ART.context + "/backstage/dologin",
			type:"POST",
			data:data,
			success:function(data){
				if(data == 0){
					alert("没有该用户");
				}else if(data == 2){
					alert("您不是管理员");
				}else if(data == 3){
					alert("密码错误")
				}else{
					window.location.href = $.ART.context + "/backstage/on/index";
				}
			}
		});
	});
});