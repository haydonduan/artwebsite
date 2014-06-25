package com.art.articlecomment.service;

import java.util.List;

import com.art.articlecomment.dto.ArticleCommentDto;
import com.util.PageUtil;

public interface ArticleCommentService {
	public List<ArticleCommentDto> getArtclecComments(Long id);
	
	public void addArticleComment(String comment,Long articleId,Long userId);
	
	public List<ArticleCommentDto> getCommentByNoReply(Long id,int page);
	
	public PageUtil getCommentCountByNoReply(int page,Long id);
	
	public void updateIsReply(Long id);
}
