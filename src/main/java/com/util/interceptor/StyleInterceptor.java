package com.util.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.art.style.domain.Style;
import com.art.style.service.StyleService;

public class StyleInterceptor implements HandlerInterceptor {
	
	@Resource
	private StyleService styleService;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/*List<Style> styleList = styleService.getStyle();
		for(Style s : styleList){
			if(s.getType() == 1){
				request.setAttribute("logo", s.getImage());
			}
			if(s.getType() == 2){
				request.setAttribute("banner", s.getImage());
			}
		}*/
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

}
