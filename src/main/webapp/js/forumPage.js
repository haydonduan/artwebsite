$(function(){
	$.ajax({
		type:"get",
		url:$.ART.context + "/forum/datapage/" + $("input[name=currentPage]").val(),
		success:function(data){
			for(var i=0;i<data.allPage;i++){
				var url =  $.ART.context + "/forum/page/"+ i;
				if(i == data.currentPage){
					$("#small").append("<li class='active'><a href='"+url+"'>" + (i+1) + "</a></li>");
				}else{
					$("#small").append("<li class=''><a href='"+url+"'>" + (i+1) + "</a></li>");
				}
			}
		}
	});
});