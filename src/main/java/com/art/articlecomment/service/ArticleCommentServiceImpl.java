package com.art.articlecomment.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.articlecomment.domain.ArticleComment;
import com.art.articlecomment.dto.ArticleCommentDto;
import com.art.articlecomment.repository.ArticleCommentRepository;
import com.art.score.service.ScoreService;
import com.art.user.domain.User;
import com.util.AddScoreEnum;
import com.util.Constant;
import com.util.PageUtil;
@Service("articleCommentService")
public class ArticleCommentServiceImpl implements ArticleCommentService {

	@Autowired
	private ArticleCommentRepository articleCommentRepository;
	
	@Resource
	private ScoreService scoreService;
	
	public List<ArticleCommentDto> getArtclecComments(Long id) {
		return articleCommentRepository.getArtcleComments(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void addArticleComment(String comment,Long articleId,Long userId) {
		ArticleComment article = new ArticleComment();
		
		article.setArticle(articleId);
		
		article.setComment(comment);
		article.setCreateTime(new Date());
		
		User user = new User();
		user.setId(userId);
		article.setUser(user);
		articleCommentRepository.save(article);
	}

	@Override
	public List<ArticleCommentDto> getCommentByNoReply(Long id,int page) {
		return articleCommentRepository.getCommentByNoReply(id,page);
	}

	@Override
	public PageUtil getCommentCountByNoReply(int page,Long id) {
		int allCount = articleCommentRepository.getCommentCountByNoReply(id);
		return new PageUtil(page, allCount,Constant.BACKSTAGE_FORUM_PAGE_SIZE);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateIsReply(Long id) {
		articleCommentRepository.updateIsReply(id);
		ArticleComment comment = articleCommentRepository.findOne(id);
		scoreService.updateScore(AddScoreEnum.COMMENT.getScore(), comment.getUser().getId());
	}

	
}
