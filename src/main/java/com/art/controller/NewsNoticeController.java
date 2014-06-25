package com.art.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.art.newsnotice.service.NewsNoticeService;
import com.util.PageUtil;

@Controller
@RequestMapping("/newsnotice/*")
public class NewsNoticeController extends BaseController{
	
	@Resource
	private NewsNoticeService newsNoticeService;
	
	@RequestMapping("{id}")
	public ModelAndView index(@PathVariable("id") Long id){
		getStyle();
		ModelAndView mav = new ModelAndView("newsdetail");
		mav.addObject("news", newsNoticeService.getNewsNoticeById(id));
		mav.addObject("proList", newsNoticeService.getRightData());
		return mav;
	}
	
	@RequestMapping("more/{page}/{type}")
	public ModelAndView more(@PathVariable("page") int page,@PathVariable("type") int type){
		ModelAndView mav = new ModelAndView("news-notice-more");
		getStyle();
		mav.addObject("newsList", newsNoticeService.getDataByNewsNoticeMore(type, page));
		mav.addObject("type", type);
		mav.addObject("currentPage", page);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "page/{type}/{page}", method = RequestMethod.GET)
	public PageUtil getPage(@PathVariable("type") int type,@PathVariable("page") int page){
		PageUtil pageUtil =  newsNoticeService.getPage(page, type);
		return pageUtil;
	}
	
}
