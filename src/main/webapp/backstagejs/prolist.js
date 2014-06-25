var allPage;
var pageUrl;
var dataUrl;
function setPageUrl(pageUrl){
	this.pageUrl = pageUrl;
}
function setDataUrl(dataUrl){
	this.dataUrl = dataUrl;
} 
var getlist = function(page){
	$.ajax({
		url: $.ART.context + pageUrl + page,
		type:"get",
		success:function(data){
			allPage = data.allPage;
			var pagetips;
			var inputPage = "<input type='text' size='4' id='inputpage'>&nbsp;<input type='button' value='跳转' id='inputpagejump' onclick='jumpPage()'>";
			var pageshow = (data.currentPage+1) + "/" + data.allPage;
			if(data.allPage == 1){
				pagetips = pageshow;
			}else if(data.currentPage == 0){
				pagetips = "<a href='"+$.ART.context+dataUrl+(data.currentPage+1)+"' >下一页</a>&nbsp;<a href='"+$.ART.context+dataUrl+(data.allPage-1)+"'>尾页</a>&nbsp;"+inputPage+"&nbsp;"+pageshow;
			}else if(data.currentPage == (data.allPage-1)){
				pagetips = "<a href='"+$.ART.context+dataUrl+"0'>首页</a>&nbsp;<a href='"+$.ART.context+dataUrl+(data.currentPage-1)+"'>上一页</a>&nbsp;"+inputPage+"&nbsp;"+pageshow;
			}else{
				pagetips = "<a href='"+$.ART.context+dataUrl+"0'>首页</a>&nbsp;<a href='"+$.ART.context+dataUrl+(data.currentPage-1)+"'>上一页</a>&nbsp;<a href='"
				+$.ART.context+dataUrl+(data.currentPage+1)+"'>下一页</a>&nbsp;<a href='"+$.ART.context+dataUrl+(data.allPage-1)+"'>尾页</a>&nbsp;"+inputPage+"&nbsp;"+pageshow;
			}
			
			if(data.allPage == 0){
				pagetips = "没有数据";
			}
			$("#pagearea").append(pagetips);
		}
	});
}

$(function(){
	getlist($("input[name=currentPage]").val());
});
function jumpPage(){
	var page = $.trim($("#inputpage").val());
		if(page == ''){
			alert("请输入页数");
			return;
		}
		if(isNaN(page)){
			alert("请输入数字");
			return;
		}
		if(page > allPage){
			alert("输入的页数越界");
			return;
		}
		window.location.href=$.ART.context+dataUrl+(page-1);
}