package com.art.article.repository;

import java.util.List;

import com.art.article.domain.Article;
import com.art.article.dto.ArticleDto;


public interface ArticleRepositoryCutstom {
	public List<Article> getNewArticle();
	
	public List<Article> getNewCommentArticle();
	
	public List<Article> getHotArticle();
	
	public ArticleDto getArtcleDetail(Long id);
	
	public void addClickNum(Long id);
	
	public int getForumCountByUserId(Long userId);
	
	public List<ArticleDto> getArticleByPage(int currentPage,int size,int type);
	
	public int getPage(int page,int type);
	
	public int getCommentCount(Long id);
	
	public void updateIsViewById(Long id,int type);
	
	public List<ArticleDto> getNoReplyArticle(int page);
}
