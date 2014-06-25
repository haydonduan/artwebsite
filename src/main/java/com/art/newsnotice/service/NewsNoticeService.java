package com.art.newsnotice.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.art.newsnotice.domain.NewsNotice;
import com.util.PageUtil;

public interface NewsNoticeService {
	public List<NewsNotice> getDataList(int type,int currentPage);
	
	public PageUtil getDataPage(int type,int currentPage);
	
	public int deleteNewsNotice(String ids);
	
	public int addNewsNotice(NewsNotice nn,MultipartFile file,HttpSession session);
	
	public NewsNotice getNewsNoticeById(Long id);
	
	public List<NewsNotice> getDataByNewsNotice(int newsNoticeType,int currentPage,int painterNewsType);
	
	public List<NewsNotice> getDataByNewsNoticeMore(int newsNoticeType,int currentPage);
	
	public PageUtil getPage(int currentPage,int type);
	
	public List<NewsNotice> getRightData();
}
