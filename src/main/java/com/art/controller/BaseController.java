package com.art.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.art.menu.service.MenuService;
import com.art.style.domain.Style;
import com.art.style.service.StyleService;
import com.art.user.dto.UserDto;
import com.util.Constant;


public class BaseController {
	
	@Resource
	private MenuService menuService;
	
	@Resource
	private StyleService styleService;
	
	@Resource
    protected HttpServletRequest request;
	
	protected void getMenu(ModelAndView mv){
		mv.addObject("menuList",menuService.getMenu());
	}
	
	protected void setUserToSession(UserDto user){
		HttpSession session = request.getSession(true);
		session.setAttribute(Constant.SESSION_USER, user);
	}
	
	protected void clearSession(){
		HttpSession session = request.getSession(true);
		session.removeAttribute(Constant.SESSION_USER);
	}
	
	protected UserDto getSessionUser(){
		HttpSession session = request.getSession(true);
		return (UserDto)session.getAttribute(Constant.SESSION_USER);
	}
	
	protected void getStyle() {
		List<Style> styleList = styleService.getStyle();
		List<Style> styles = getColorByType();
		for(Style style : styles){
			if(style.getType() == 102){
				request.setAttribute("footer", style.getImage());
			}
		}
		
		for(Style s : styleList){
			if(s.getType() == 1){
				request.setAttribute("logo", s.getImage());
			}
			if(s.getType() == 2){
				request.setAttribute("banner", s.getImage());
			}
		}
	}
	
	public List<Style> getColorByType(){
		return styleService.findColorByType();
	}
}
