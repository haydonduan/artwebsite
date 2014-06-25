/*
site:		成都图片网样式表
auther:		tanjia
updated:		2013-06-21
updated by:	tanjia
*/

var zcvr = $(".zcvr");
jQuery.extend({
	tab_:function(id){
		var obj = $("#" + id);
		var holder = obj.find(".tab-holder");
		var panel = obj.find(".tab-panel");
		var i = 0;
		var n = panel.find(".activity-panel").length;
		var trigger_html = "";
		for (s = 1; s <= n; s++){
			if(s == 1){
				trigger_html += "<span class='current'></span>";
			}
			else{
				trigger_html += "<span></span>";
			}
		}
		holder.html(trigger_html);
		holder.find("span").click(function(){
			i = $(this).index();
			action(i);
		});
		var loop = setInterval(loop_player,4000);
		
		obj.hover(function(){
			clearInterval(loop);
		},function(){
			loop = setInterval(loop_player,4000);
		});

		function loop_player(){
			i++;
			if(i == n){i = 0}
			action(i);
		}

		function action(i){
			holder.find("span").eq(i).addClass("current")
			.siblings().removeClass("current");
			panel.children(".activity-panel").eq(i).show()
			.siblings().hide();
		}
	},
	tab:function(id,tag){
		var tab = $("#" + id);
		var holder = tab.find(".tab-holder");
		var panel = tab.find(".tab-panel");
		holder.find(tag).each(function(index){
			$(this).click(function(){
				$(this)
				.addClass("current")
				.siblings().removeClass("current");
				panel.children("div").eq(index).siblings().hide();
				panel.children("div").eq(index).show();
			});
		});
	},
	tween:function(id){
		var i = 0;
		var o = $("#" + id);
		var t = $(".f-tween");
		var n = o.find("i").html();
		o.click(function(){
			var c = $(this).attr("class");
			if(i >= 1) return false;
			$(this).attr("class",c + "disabled")
			var offset = $(this).offset();
			t.css({"top":offset.top,"left":offset.left}).show()
			.animate({
				marginTop: -30},600,function(){
				setTimeout(function(){t.hide()},1000)
			});
			o.find("i").html(n*1+1);
			i++;
		})
		
	},
	like:function(obj){
		var o = $("." + obj);
		var t = $(".f-tween");
		var n;
		o.click(function(){
			if($(this).attr("class") == "btn-dimgray"){
				$(this).attr("class","btn-gray");
				var offset = $(this).offset();
				t.css({"top":offset.top,"left":offset.left}).show()
				.animate({
					marginTop: -30},600,function(){
					setTimeout(function(){t.hide()},1000)
				});
				n = $(this).find("i").html();
				$(this).find("i").html(n*1+1);
				$(this).find("em").html("已喜欢");
				likes($(this).attr("data_id"));
			}
		});
	},
	menu_down:function(obj){
		var obj = $("#" + obj);
		var menu_p = obj.find(".droplist");
		obj.hover(function(){
			menu_p.show();
		},
		function(){
			menu_p.hide();
		});
	},
	pop:function(id){
		var obj = $("#" + id);
		var body_height = document.body.clientHeight;
		var window_height = $(window).height();
		var window_width = $(window).width();
		var obj_height = obj.height();
		var obj_width = obj.width();
		var scroll_height = $(document).scrollTop();
		zcvr.css({"display":"block" , "height":body_height});
		obj.css({"display":"block" , "top":(window_height - obj_height)/2 + scroll_height, "left":(window_width - obj_width)/2});
	},
	close:function(id){
		var obj = $("#" + id);
		zcvr.css({"display":"none"});
		obj.hide();
	},
	slide_player:function(obj){
		var obj = $("#" + obj);
		var photo = obj.find(".m-listmodule");
		var trigger = obj.find(".sl-triggers");
		var info = obj.find(".s-info");
		var n = photo.find("li").length;
		var i = 0;
		var n = photo.find("li").length;
		var trigger_html = "";
		for (s = 1; s <= n; s++){
			if(s == 1){
				trigger_html += "<span class='current'></span>";
			}
			else{
				trigger_html += "<span></span>";
			}
		}
		trigger.html(trigger_html);

		var loop = setInterval(loop_player,4000);
		
		obj.hover(function(){
			clearInterval(loop);
		},function(){
			loop = setInterval(loop_player,4000);
		});
		trigger.find("span").mouseover(function(){
			i = trigger.find("span").index(this);
			player(i);
		});
		function loop_player(){
			i++;
			if(i == n){i = 0}
			player(i);
		}
		
		function player(i){
			photo.find("li").eq(i).show()
			.siblings().hide();
			trigger.find("span").eq(i).addClass("current")
			.siblings("span").removeClass("current");
			info.find("li").eq(i).show()
			.siblings("li").hide();
		} 
	},
	currentTime:function(id) {
	  var obj = $("." + id);
	  today = new Date();
	  var separate = ".";
	  var year = today.getFullYear();
	  var month = today.getMonth() + 1;
	  var date = today.getDate();
	  ymd = "<span>"+year + separate + month + "</span><b>" + date + "</b>";
	  obj.html(ymd);
	},
	edit_info:function(obj){
		var o = $("." + obj);
		o.click(function(){
			var txt = $(this).attr("data-picdesc");
			var id = $(this).attr("data_id");
			var html = '';
			html += '<div id="J-picedit">';
			html += '<textarea class="i-textarea" maxlength="1000" id="description_'+ id +'" name="description_'+ id +'">'+ txt +'</textarea>';
			html += '<input type="button" class="btn-sblue f-mr10" value="保存" onclick="editpic('+ id +');" ><input type="button" onclick="$(\'#J-picedit\').remove();$(\'.J-picinfo\').show();" class="btn-gray" value="取消">';
			html += '</div>';
			$(this).parent().append(html);
			$(this).hide();
		});
	},
	pic_info:function(o,btn,sec){
		var o = $("." + o);
		var exifbtn = $("." + btn);
		var picexif = $("." + sec);
		o.hover(
			function(){
				$(this).children("span").css("visibility","visible");
			},
			function(){
				$(this).children("span").css("visibility","hidden");
			}
		);
		exifbtn.mouseover(function(){
			$(this).siblings("." + sec).css("visibility","visible");
		});
		picexif.hover(
			function(){
				$(this).css("visibility","visible")

			},
			function(){
				$(this).css("visibility","hidden")
			}
		);
	},
	replay:function(obj){
		var o = $("." + obj);
		var r_btn = o.find(".j-replay");
		var r_name = o.find(".j-name").html();
		
		r_btn.click(function(){
			var pid =$(this).attr("pid");
			var html = '';
			html +='<div id="J-replay" class="js-editor">';
			html +='<div class="hnt thide"><span>回复：<span class="s-blue">'+ r_name +'</span></span></div>';
			html +='<input type="hidden" id="pid" name="pid" value="'+pid+'">';
			html +='<div class="w-rep-editor">';
			html +='<textarea  id="replaycontent" name="replaycontent" ></textarea>';
			html +='<div class="zbtn">';
			html +=	'<input type="button" value="发表" class="btn-sblue f-mr10" onclick="replay();"><input type="button" onclick="$(\'#J-replay\').remove();"  value="取消" class="btn-gray">';
			html +='</div>';
			html +='</div>';
			html +='</div>';
			if($("#J-replay").css("visibility") != "visible"){
				$(this).parent().append(html);
			}
		});
	},
	//带按钮的翻动
	u_btn_roll:function(id,t,sec,s){
		var scroll_section = $("#" + sec);
		var scroll_obj = $("#" + id);
		var btn_prev = scroll_section.find(".y-btn-prev");
		var btn_next = scroll_section.find(".y-btn-next");
		var num_this = scroll_section.find(".num-this");
		var num_total = scroll_section.find(".num-total");
		var i = 1;
		var scroll_width = scroll_obj.find("li").outerWidth(true);
		var n = scroll_obj.find("li").length;
		num_total.html(n);
		num_this.html(i);
		scroll_obj.width(scroll_width * n);
		btn_next.click(function(){
			scroll_obj.stop(true,true);
			marquee();
		});

		btn_prev.click(function(){
			i--;
			if(i < 1){i = n;}
			num_this.html(i);
			scroll_obj.stop(true,true);
			scroll_obj.find("li:last").prependTo(scroll_obj);
			scroll_obj.css({marginLeft: -scroll_width});
			scroll_obj.animate({marginLeft: 0},1000);
		});
		function marquee(){
			i++;
			if(i > n){i = 1;}
			num_this.html(i);
			scroll_obj.animate({
				marginLeft: -scroll_width},1000,function(){
				$(this).css({marginLeft:"0px"}).find("li:first").appendTo(this);
			});
		}
		if(!s){
			var mar = setInterval(marquee, t);
		}
		scroll_section.hover(function(){
			if(mar){clearInterval(mar);}},
			function(){
				if(!s){
					clearInterval(mar);
					mar = setInterval(marquee, t);
				}
		});

	}
});



//高亮索引
//var highLightIndex = -1;
//超时的标识(对用户连续快速按下键盘的时间做延时处理，只对用户在500ms内最后一次请求，让其生效)
//var timeoutId;
$(document).ready(function(){
	init();
	$("#search-text").bind("keyup",processKeyup);
	
});

function processKeyup(event){
	var myEvent = event || windows.event;
	var keyCode = myEvent.keyCode;
	//输入是字母，或者是退格键则需要重新请求
	if((keyCode >= 48 && keyCode <= 90) || keyCode == 8 || keyCode == 32){
		//以下两行代码是为了防止用户快速输入导致频繁请求服务器  
		//这样便可以在用户500ms内快速输入的情况下，只请求服务器一次
		//heightLightIndex = -1;
		//clearTimeout(timeoutId);
		//timeoutId = setTimeout(processAjaxRequest,300);
		if($("#search-text").val() !== ""){
			$('.zcse').css({"visibility":"visible"});
			var v = '"'+$("#search-text").val()+'"';
			$(".zitm").find("span").html(v);
		}
		else{
			$('.zcse').css({"visibility":"hidden"});
		}
	}
	/*处理上下键(up,down)
	else if(keyCode == 38 || keyCode == 40){
		processKeyUpAndDown(keyCode);
	}
	//处理回车键
	else if(keyCode == 13){
		processEnter();
	}*/
}
/***
*初始化弹出窗口的位置,大小
*/
function init(){
	var s_t = $(".zitm");
	var s_v = "请输入关键字";
	$("#search-text").focus(function(){
		if($(this).val() == s_v) $(this).val("");
		//$(this).css({"color":"#999"})
		$("#search").addClass("search-focus");
	});
	$("#search-text").blur(function(){
		if($(this).val() == ""){
			$(this).val(s_v)
			.css({"color":"#999"});
		}
		else{$(this).css({"color":"#333"});}
		$("#search").removeClass("search-focus");
		setTimeout(function(){$('.zcse').css({"visibility":"hidden"});$('.zitm').find("span").html("");},300)
	});
	s_t.hover(function(){
		$(this).addClass("hover");
	},
	function(){
		$(this).removeClass("hover");
	});

}











