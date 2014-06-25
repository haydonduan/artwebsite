package com.art.backstagecontroller;

import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/backstage/*")
public class PageController{
	
	@RequestMapping("login")
	public String login(){
		return "backstage/login";
 	}
	
	@RequestMapping("on/index")
	public String index(){
		return "backstage/index";
 	}
	
	@RequestMapping("on/archives")
	public String archives(){
		return "backstage/archives";
 	}
	
	@RequestMapping("on/main")
	public ModelAndView main(){
		ModelAndView mav = new ModelAndView("backstage/main");
		Properties props=System.getProperties();
		mav.addObject("osName", props.getProperty("os.name"));
		return mav;
 	}
	
	@RequestMapping("on/menu")
	public String menu(){
		return "backstage/menu";
 	}
	
	@RequestMapping("on/top")
	public String top(){
		return "backstage/top";
 	}
}
