$("body").append("<input type='hidden' name='canUpload'/>");
var uploadSize = 300;
function filesize(ele) {
	var name = ele.value;
	var houzhui = name.split(".")[1];
	if(houzhui != "jpg" && houzhui != "png" && houzhui != "gif"){
		$("input[name=canUpload]").val("2");
		return;
	}
    // 返回 KB，保留小数点后两位
    var size = (ele.files[0].size / 1024).toFixed(2);
    if(size <= uploadSize){
        $("input[name=canUpload]").val("1");
    }else{
    	$("input[name=canUpload]").val("0");
    }
}

 $("input[type=submit]").click(function(){
	 if($("input[name=pro]").val() == 'pro'){
		 var title = $.trim($("input[name=title]").val());
			var time = $.trim($("input[name=time]").val());
			var inspiration = $.trim($("input[name=inspiration]").val());
			if(title == ''){
				alert("标题不能为空");
				return false;
			}
			if(time == ''){
				alert("时间不能为空");
				return false;
			}
			if(inspiration == ''){
				alert("灵感不能为空");
				return false;
			}
	 }
	if($("input[name=canUpload]").val() == 1){
		return true;
	}
	if($("input[name=canUpload]").val() == 2){
		alert("请上传图片格式的文件");
		return false;
	}
	alert("建议上传小于"+uploadSize+"K的图片");
	return false;
});