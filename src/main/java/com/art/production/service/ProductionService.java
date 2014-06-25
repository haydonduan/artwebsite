package com.art.production.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.art.production.domain.Production;
import com.util.PageUtil;

public interface ProductionService {
	public List<Production> getJSGallery();
	
	public List<Production> getProByTypeAndPage(int type,int page,int pageSize);
	
	public PageUtil getPage(int currentPage,int type);
	
	public Production getProductionById(Long id);
	
	public void addScanNum(Long id);
	
	public void addLoveNum(Long id);
	
	public int getLoveNum(Long id);
	
	public List<Production> getProByAdminPage(int page,int pageSize);
	
	public PageUtil getAdminProPage(int currentPage);
	
	public int updateDelFlg(String ids);
	
	public void addPro(MultipartFile file,Production pro,HttpSession session);
}
