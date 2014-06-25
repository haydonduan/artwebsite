$(function(){

	$("#submit").click(function(){
		var name = $("input[name=name]").val();
		var password = $("input[name=password]").val();
		if($.trim(name) == ''){
			alert("用户名不能为空！");
			return;
		}
		if($.trim(password) == ''){
			alert("密码不能为空！");
			return;
		}
		var data = {
			name:name,
			password:password
		};
		$.ajax({
			type:"POST",
			url:$.ART.context + "/dologin",
			data:data,
			success:function(data){
				if(data ==0 ){
					alert("该账号没有注册！");
				}else if(data == 1){
					alert("登录成功！");
					window.location.href = document.referrer;
				}else{
					alert("密码错误！");
				}
			}
		});
	});
});