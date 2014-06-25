package com.art.article.service;

import java.util.List;

import com.art.article.domain.Article;
import com.art.article.dto.ArticleDto;
import com.util.PageUtil;

public interface ArticleService {
	public List<Article> getNewArticle();
	
	public List<Article> getNewCommentArticle();
	
	public List<Article> getHotArticle();
	
	public ArticleDto getArtcleDetail(Long id);
	
	public List<Article> findByUserId(Long id);
	
	public int getForumCountByUserId(Long userId);
	
	public void addArticle(Article art);
	
	public List<ArticleDto> getArticleByPage(int currentPage,int size,int type);
	
	public PageUtil getPage(int page,int size,int type);
	
	public PageUtil getCommentPage(int page,Long id);
	
	public Article getAdminArtcleById(Long id);
	
	public void updateIsViewById(Long id,int type);
	
	public List<ArticleDto> getNoReplyArticle(int page);
}
