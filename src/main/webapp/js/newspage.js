$(function(){
	$.ajax({
		type:"get",
		url:$.ART.context + "/newsnotice/page/"+$("input[name=type]").val() +"/" +$("input[name=currentPage]").val(),
		success:function(data){
			for(var i=0;i<data.allPage;i++){
				var url =  $.ART.context + "/newsnotice/more/" + $("input[name=type]").val() + "/" + i;
				if(i == data.currentPage){
					$("#small").append("<li class='active'><a href='"+url+"'>" + (i+1) + "</a></li>");
				}else{
					$("#small").append("<li class=''><a href='"+url+"'>" + (i+1) + "</a></li>");
				}
			}
		}
	});
});