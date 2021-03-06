package com.art.backstagecontroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.art.style.service.StyleService;

@Controller
@RequestMapping("/backstage/on/style/*")
public class AdminStyleController{
	
	@Resource
	private StyleService styleService;
	@Resource
	private HttpServletRequest request;
	
	
	@RequestMapping(value="toPage",method=RequestMethod.GET)
	public ModelAndView updateAdminUserPage(){
		ModelAndView mav = new ModelAndView("backstage/changestyle");
		return mav;
 	}
	
	//@ResponseBody
	@RequestMapping(value = "update",method=RequestMethod.POST)
	public ModelAndView uploadPro(MultipartHttpServletRequest request1){
			ModelAndView mav = new ModelAndView("redirect:/backstage/on/main");
			MultipartFile logo = request1.getFile("logo");
			MultipartFile banner = request1.getFile("banner");
			styleService.updateStyle(logo, banner,request.getSession(true));
			return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update_flash_color",method=RequestMethod.POST)
	public int updateFlashColor(@RequestParam("color") String color, @RequestParam("type") int type){
			try {
				styleService.updateFlashFontColor(color,type);
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
	}
}
