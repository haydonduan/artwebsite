package com.art.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.art.user.service.UserService;

@Controller
@RequestMapping("/painterintroduction/*")
public class PainterIntroductionController extends BaseController{
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("index")
	public ModelAndView index(){
		getStyle();
		ModelAndView mv = new ModelAndView("huajiajianjie");
		mv.addObject("type", "huajiajianjie");
		mv.addObject("user", userService.getPainter());
		return mv;
	}
}
