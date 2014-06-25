package com.util;

public class PageUtil {
	private int currentPage;
	private int allPage;
	private int allCount;
	private int pageSize;
	
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageUtil(int currentPage,int allCount,int pageSize){
		this.currentPage = currentPage;
		this.allCount = allCount;
		this.pageSize = pageSize;
	}

	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getAllPage() {
		allPage = allCount % pageSize == 0 ? 
				allCount / pageSize : allCount / pageSize +1;
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	
}
