package com.art.style.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.art.style.domain.Style;

public interface StyleService {
	public List<Style> getStyle();
	
	public void updateStyle(MultipartFile logo,MultipartFile banner,HttpSession session);
	
	public List<Style> findColorByType();
	
	public void updateFlashFontColor(String color, int type);
}
