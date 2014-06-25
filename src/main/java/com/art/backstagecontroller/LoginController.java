package com.art.backstagecontroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.art.user.domain.User;
import com.art.user.dto.UserDto;
import com.art.user.service.UserService;
import com.util.Constant;

@Controller
@RequestMapping("/backstage/*")
public class LoginController{
	
	@Resource
	private UserService userService;
	
	@Resource
	private HttpServletRequest request;
	
	@ResponseBody
	@RequestMapping(value="logout")
	public int logout(){
		request.getSession(true).removeAttribute(Constant.SESSION_ADMIN_USER);;
		return 1;
 	}
	
	@ResponseBody
	@RequestMapping(value="dologin",method=RequestMethod.POST)
	public int login(@RequestParam("name") String name,@RequestParam("password") String password){
		UserDto user = userService.getUserByAdminName(name,password);
		if(user.getIsAdmin() == 1){
			request.getSession(true).setAttribute(Constant.SESSION_ADMIN_USER,user);
		}
		return user.getIsAdmin();
 	}
	
	@ResponseBody
	@RequestMapping(value="updateadmin",method=RequestMethod.POST)
	public int updateAdminUser(@RequestParam("name") String name,@RequestParam("repassword") String repassword
			,@RequestParam("oldpassword") String oldpassword
			,@RequestParam("password") String password,@RequestParam("id") Long id){
		try {
			UserDto user = (UserDto)request.getSession(true).getAttribute(Constant.SESSION_ADMIN_USER);
			if(!oldpassword.equals(user.getPassword())){
				//原密码不正确
				return 0;
			}
			if(!repassword.equals(password)){
				//重复密码不一致
				return 1;
			}
			userService.updateAdminUser(id, name, password);
			UserDto userOld = (UserDto)request.getSession(true).getAttribute(Constant.SESSION_ADMIN_USER);
			userOld.setName(name);
			userOld.setPassword(password);
			request.getSession(true).setAttribute(Constant.SESSION_ADMIN_USER,userOld);
			//成功
			return 2;
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
 	}
	
	@RequestMapping(value="on/updateadminpage",method=RequestMethod.GET)
	public String updateAdminUserPage(){
		return "backstage/updateadmin";
 	}
	
	@RequestMapping(value="on/updatePainterpage",method=RequestMethod.GET)
	public ModelAndView updatePainterPage(){
		ModelAndView mav = new ModelAndView("backstage/updatePainter");
		mav.addObject("painter", userService.getPainter());
		return mav;
 	}
	
	@RequestMapping(value="on/updatePainter",method=RequestMethod.POST)
	public String updatePainter(
			@RequestParam(value = "image") MultipartFile file
			,@RequestParam(value = "name") String name
			,@RequestParam(value = "detail") String detail
			,@RequestParam(value = "email") String email
			,@RequestParam(value = "address") String address
			,@RequestParam(value = "telephone") String telephone
			){
		User user = new User();
		user.setName(name);
		user.setDetail(detail);
		user.setEmail(email);
		user.setAddress(address);
		user.setTelephone(telephone);
		userService.updatePainter(file, user, request.getSession(true));
		return "redirect:/backstage/on/main";
 	}
}
