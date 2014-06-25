package com.art.production.repository;

import java.util.List;

import com.art.production.domain.Production;


public interface ProductionRepositoryCutstom {
	/**
	 * 画家动态 页面的幻灯
	 * @return
	 */
	public List<Production> getJSGallery();
	
	/**
	 * 作品一览
	 * @param type 类型
	 * @param page 页数
	 * @return
	 */
	public List<Production> getProByTypeAndPage(int type,int page,int pageSize);
	
	/**
	 * 获取作品的总数
	 * @return
	 */
	public int getProductionAll(int type);
	
	/**
	 * 详细页面用（通过ID获取Production）
	 * @param id
	 * @return
	 */
	public Production getProductionById(Long id);
	
	/**
	 * 增加点击数
	 * @param id
	 */
	public void addScanNum(Long id);
	
	/**
	 * 增加喜欢数
	 * @param id
	 */
	public void addLoveNum(Long id);
	
	/**
	 * 获取喜欢数
	 * @param id
	 */
	public int getLoveNum(Long id);
	
	
	/**
	 * 管理员页面获得作品列表
	 * @param type 类型
	 * @param page 页数
	 * @return
	 */
	public List<Production> getProByAdminPage(int page,int pageSize);
	
	/**
	 * 获取作品的总数(管理员)
	 * @return
	 */
	public int getAdminProductionAll();
	
	public void updateDelFlg(Long id);
	
}
