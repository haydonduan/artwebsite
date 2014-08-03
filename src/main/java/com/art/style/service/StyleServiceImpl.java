package com.art.style.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.art.style.domain.Style;
import com.art.style.repository.StyleRepository;
import com.util.Constant;
import com.util.UploadImage;
@Service("styleService")
public class StyleServiceImpl implements StyleService {

	@Autowired
	private StyleRepository styleRepository;

	public List<Style> getStyle() {
		return styleRepository.findAll();
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateStyle(MultipartFile logo, MultipartFile banner,HttpSession session) {
		List<Style> list = styleRepository.findAll();
		Style oldLogo = null;
		Style oldBanner = null;
		for(Style s : list){
			if(s.getType() == 1){
				oldLogo = s;
			}
			if(s.getType() == 2){
				oldBanner = s;
			}
		}
		
		if(logo != null){
			String path = session.getServletContext().getRealPath("upload");
			String fileName = UploadImage.upload(logo, path,1);
			styleRepository.updateImage(oldLogo.getId(), Constant.UPLOAD_FILE + "/" + fileName);
		}
		
		if(banner != null){
			String path = session.getServletContext().getRealPath("upload");
			String fileName = UploadImage.upload(banner, path,2);
			styleRepository.updateImage(oldBanner.getId(), Constant.UPLOAD_FILE + "/" + fileName);
		}
	}


	@Override
	public List<Style> findColorByType() {
		return styleRepository.findColorByType();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateFlashFontColor(String color, int type) {
		styleRepository.updateFlashFontColor(color, type);
	}
}
