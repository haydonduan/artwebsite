package com.art.backstagecontroller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.art.user.service.UserService;

@Controller
@RequestMapping("/backstage/on/users/*")
public class AdminManageUserController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="{page}")
	public ModelAndView userList(@PathVariable("page") int page){
		ModelAndView mav = new ModelAndView("backstage/users");
		mav.addObject("currentPage", page);
		mav.addObject("usersList", userService.getUserListByPage(page));
		return mav;
 	}
	
	@RequestMapping(value="/user/{userId}")
	public ModelAndView getUser(@PathVariable("userId") Long userId){
		ModelAndView mav = new ModelAndView("backstage/userdetail");
		mav.addObject("user", userService.getUserById(userId));
		return mav;
 	}
	
	@ResponseBody
	@RequestMapping(value="/delete")
	public int deleteUser(@RequestParam("id") Long userId){
		return userService.deleteUserById(userId);
 	}
}
