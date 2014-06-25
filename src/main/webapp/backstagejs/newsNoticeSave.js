$(function(){
	
	
	$("#saveBu").click(function(){
		var content= CKEDITOR.instances.editor01.getData();
		var title = $("input[name=title]").val();
		var selectV = $("#selectT").val();
		alert(selectV);
		/*var datas = {
			title:
		};*/
	});
});