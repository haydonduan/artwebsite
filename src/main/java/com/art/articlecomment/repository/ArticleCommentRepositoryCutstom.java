package com.art.articlecomment.repository;

import java.util.List;

import com.art.articlecomment.dto.ArticleCommentDto;

public interface ArticleCommentRepositoryCutstom {
	/**
	 * 
	 * @return
	 */
	public List<ArticleCommentDto> getArtcleComments(Long id);
	
	
	public List<ArticleCommentDto> getCommentByNoReply(Long id,int page);
	
	public int getCommentCountByNoReply(Long id);
	
	public void updateIsReply(Long id);
}
