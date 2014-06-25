package com.art.newsnotice.repository;

import java.util.List;

import com.art.newsnotice.domain.NewsNotice;

public interface NewsNoticeRepositoryCutstom {
	
	//后台
	public List<NewsNotice> getDataList(int type,int currentPage);
	
	public int getDataAll(int type);
	
	public void deleteByIdType(Long id);
	
	//前台
	
	public List<NewsNotice> getDataByNewsNotice(int newsNoticeType,int currentPage,int painterNewsType);
	
	public List<NewsNotice> getDataByNewsNoticeMore(int newsNoticeType,int currentPage);
	
	public List<NewsNotice> getRightData();
}
