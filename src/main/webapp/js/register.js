$(function(){

	$("#submit").click(function(){
		var name = $("input[name=name]").val();
		var password = $("input[name=password]").val();
		var repassword = $("input[name=pwdconfirm]").val();
		if($.trim(name) == ''){
			alert("用户名不能为空！");
			return;
		}
		if($.trim(password) == ''){
			alert("密码不能为空！");
			return;
		}
		if($.trim(repassword) == ''){
			alert("确认密码不能为空！");
			return;
		}
		if(password != repassword){
			alert("密码不一致！");
			return;
		}
		var data = {
			name:name,
			password:password
		};
		$.ajax({
			type:"POST",
			url:$.ART.context + "/registmethod",
			data:data,
			success:function(data){
				if(data ==0 ){
					alert("该账号已注册！");
					$("input[name=name]").val('');
					$("input[name=password]").val('');
					$("input[name=pwdconfirm]").val('');
				}else{
					alert("注册成功！");
					window.location.href = $.ART.context + "/index";
				}
			}
		});
	});
});