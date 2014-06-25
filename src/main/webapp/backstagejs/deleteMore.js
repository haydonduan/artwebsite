$("body").append("<input type='hidden' name='ids'>");
	$("#parentChe").click(function(){
		 if($(this).attr("checked") == true){
			$(".childChe").attr("checked","true");
		 }else{
			 $(".childChe").attr("checked",""); 
		}
	});

	function deleteMore(){
		var childCheLength = $(".childChe").length;
		var ids = "";
		for(var i=0;i<childCheLength;i++){
			if($(".childChe")[i].checked == true){
				var id = $(".childChe")[i].name.split("_")[1];
				ids = id + "," +ids ;
			}
		}
		if($.trim(ids) == ''){
			alert("请勾选要删除的项目");
			return;
		}
		deletePro(ids);
	}