package com.art.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.art.newsnotice.service.NewsNoticeService;
import com.art.production.service.ProductionService;
import com.art.style.domain.Style;
import com.art.style.service.StyleService;

@Controller
public class IndexController extends BaseController{
	
	@Resource
	private ProductionService productionService;
	
	@Resource
	private StyleService styleService;
	
	@Resource
	private NewsNoticeService newsNoticeService;
	
	@RequestMapping("")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("index");
		List<Style> styles = getColorByType();
		for(Style style : styles){
			if(style.getType() == 100){
				mv.addObject("color", style.getImage());
			}else if(style.getType() == 101){
				mv.addObject("title", style.getImage());
			}else{
				mv.addObject("footer", style.getImage());
			}
		}
		
		
		
		return mv;
	}
	
	@RequestMapping("index")
	public ModelAndView dongTai(){
		getStyle();
		ModelAndView mv = new ModelAndView("huajiadongtai");
		mv.addObject("type", "huajiadongtai");
		mv.addObject("JS_GALLERY", productionService.getJSGallery());
		mv.addObject("noticeList", newsNoticeService.getDataByNewsNotice(1, 0, 1));
		mv.addObject("newsList", newsNoticeService.getDataByNewsNotice(0, 0, 0));
		return mv;
	}
}
