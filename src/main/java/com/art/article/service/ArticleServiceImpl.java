package com.art.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.article.domain.Article;
import com.art.article.dto.ArticleDto;
import com.art.article.repository.ArticleRepository;
import com.art.score.service.ScoreService;
import com.util.AddScoreEnum;
import com.util.Constant;
import com.util.PageUtil;
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private ScoreService scoreService;
	
	public List<Article> getNewArticle() {
		
		List<Article> list = articleRepository.getNewArticle();
		for(Article a : list){
			if(a.getTitle().length() > 20){
				a.setTitle(a.getTitle().substring(0, 20)+"...");
			}
		}
		return list;
	}

	public List<Article> getNewCommentArticle() {
		List<Article> list = articleRepository.getNewCommentArticle();
		for(Article a : list){
			if(a.getTitle().length() > 20){
				a.setTitle(a.getTitle().substring(0, 20)+"...");
			}
		}
		return list;
	}

	public List<Article> getHotArticle() {
		List<Article> list = articleRepository.getHotArticle();
		for(Article a : list){
			if(a.getTitle().length() > 10){
				a.setTitle(a.getTitle().substring(0, 10)+"...");
			}
		}
		return list;
	}

	public ArticleDto getArtcleDetail(Long id) {
		ArticleDto dto  =  articleRepository.getArtcleDetail(id);
		if(dto == null){
			return null;
		}
		articleRepository.addClickNum(id);
		return dto;
	}

	public List<Article> findByUserId(Long id) {
		List<Article> list = articleRepository.findByUserId(id);
		for(Article a : list){
			if(a.getTitle().length() > 33){
				a.setTitle(a.getTitle().substring(0, 33)+"...");
			}
		}
		return list;
	}
	
	public int getForumCountByUserId(Long userId) {
		return articleRepository.getForumCountByUserId(userId);
	}

	public void addArticle(Article art) {
		articleRepository.save(art);
		scoreService.updateScore(AddScoreEnum.FORUM.getScore(), art.getUser().getId());
	}

	public List<ArticleDto> getArticleByPage(int currentPage,int size,int type) {
		return articleRepository.getArticleByPage(currentPage,size,type);
	}

	public PageUtil getPage(int page,int size,int type) {
		int allCount = articleRepository.getPage(page,type);
		return new PageUtil(page, allCount,size);
	}

	@Override
	public Article getAdminArtcleById(Long id) {
		return articleRepository.findOne(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateIsViewById(Long id, int type) {
		articleRepository.updateIsViewById(id, type);
		Long userId = articleRepository.findOne(id).getUser().getId();
		scoreService.updateScore(AddScoreEnum.FORUM.getScore(), userId);
	}

	@Override
	public List<ArticleDto> getNoReplyArticle(int page) {
		return articleRepository.getNoReplyArticle(page);
	}

	@Override
	public PageUtil getCommentPage(int page,Long id) {
		int allCount = articleRepository.getCommentCount(id);
		return new PageUtil(page, allCount,Constant.BACKSTAGE_FORUM_PAGE_SIZE);
	}
}
