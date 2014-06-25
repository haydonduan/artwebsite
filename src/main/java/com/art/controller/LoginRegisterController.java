package com.art.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.art.article.service.ArticleService;
import com.art.newsnotice.service.NewsNoticeService;
import com.art.user.domain.User;
import com.art.user.dto.UploadUserDto;
import com.art.user.dto.UserDto;
import com.art.user.service.UserService;

@Controller
public class LoginRegisterController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@Resource
	private NewsNoticeService newsNoticeService;
	
	@Resource
	private ArticleService articleService;
	
	@RequestMapping("/register")
	public ModelAndView register(){
		getStyle();
		ModelAndView mv = new ModelAndView("zhuce");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		getStyle();
		ModelAndView mv = new ModelAndView("denglu");
		return mv;
	}
	
	@RequestMapping(value="/registmethod",method=RequestMethod.POST)
	@ResponseBody
	public int addUser(@RequestParam("name") String name,@RequestParam("password") String password){
		User user = new User(name,password);
		int returnFlg = userService.register(user);
		if(returnFlg == 1){
			setUserToSession(userService.getUesrDtoByName(name));
		}
		return returnFlg;
	}
	
	@RequestMapping(value="/quit")
	@ResponseBody
	public int addUser(){
		clearSession();
		return 1;
	}
	
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	@ResponseBody
	public int login(@RequestParam("name") String name,@RequestParam("password") String password){
		User user = new User(name,password);
		UserDto userDto = userService.userLogin(user);
		if(userDto.getFlag() == 1){
			setUserToSession(userDto);
		}
		return userDto.getFlag();
	}
	
	@RequestMapping(value="forum/on/tomypage",method=RequestMethod.GET)
	public ModelAndView toMyPage(){
		getStyle();
		ModelAndView mav = new ModelAndView("gerenzhongxin");
		mav.addObject("forumList", articleService.findByUserId(getSessionUser().getId()));
		mav.addObject("forumCount", articleService.getForumCountByUserId(getSessionUser().getId()));
		return mav;
	}
	
	@RequestMapping(value="forum/on/update/page",method=RequestMethod.GET)
	public ModelAndView updateUserPage(){
		getStyle();
		ModelAndView mav = new ModelAndView("gengxingeren");
		return mav;
	}
	
	@RequestMapping(value="forum/on/doupate",method=RequestMethod.POST)
		public String doUpdateUserPage(
				MultipartHttpServletRequest request1
				//@RequestParam(value = "image") MultipartFile file
				,UploadUserDto dto){
		getStyle();
		MultipartFile file = request1.getFile("image");
		userService.updateUser(file, dto, request.getSession(true));
		return "redirect:/forum/on/tomypage";
	}
	
	@ResponseBody
	@RequestMapping(value="forum/on/validate",method=RequestMethod.POST)
	public int validateInput(UploadUserDto dto){
		return userService.validateUser(dto, request.getSession(true));
	}
}
