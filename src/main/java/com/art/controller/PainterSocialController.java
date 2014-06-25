package com.art.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.art.newsnotice.service.NewsNoticeService;
import com.art.user.service.UserService;

@Controller
@RequestMapping("/paintersocial/*")
public class PainterSocialController extends BaseController{
	
	@Resource
	private UserService userService;
	
	
	@Resource
	private NewsNoticeService newsNoticeService;
	
	@RequestMapping("index")
	public ModelAndView index(){
		getStyle();
		ModelAndView mv = new ModelAndView("huajiayushehui");
		mv.addObject("type", "huajiayushehui");
		mv.addObject("proList", newsNoticeService.getRightData());
		mv.addObject("newsList", newsNoticeService.getDataByNewsNotice(0, 0, 1));
		return mv;
	}
}
