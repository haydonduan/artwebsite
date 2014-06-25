$(function(){

	$("#changeBu").click(function(){
		var name = $.trim($("input[name=name]").val());
		var oldpsw = $.trim($("input[name=oldpassword]").val());
		var psw = $.trim($("input[name=password]").val());
		var repsw = $.trim($("input[name=repassword]").val());
		
		if(name == ''){
			alert("用户名不能为空！");
			return;
		}
		if(oldpsw == ''){
			alert("原密码不能为空！");
			return;
		}
		if(psw == ''){
			alert("新密码不能为空！");
			return;
		}
		if(repsw == ''){
			alert("重复密码不能为空！");
			return;
		}
		
		var datas = {
			name:name,
			repassword:repsw,
			oldpassword:oldpsw,
			password:psw,
			id: $.ART.id
		};
		
		$.ajax({
			url:$.ART.context + "/backstage/updateadmin",
			type:"POST",
			data:datas,
			success:function(data){
				if(data == 0){
					alert("原密码不正确");
					return;
				}
				if(data == 1){
					alert("重复密码不一致");
					return;
				}
				if(data == 2){
					alert("更改成功");
					parent.location.reload();
					return;
				}
				if(data == 3){
					alert("更改失败");
					return;
				}
			}
		});
	});
});