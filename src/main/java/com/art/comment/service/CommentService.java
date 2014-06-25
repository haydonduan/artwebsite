package com.art.comment.service;

import java.util.List;

import com.art.comment.dto.CommentDto;
import com.art.production.domain.Production;
import com.art.user.dto.UserDto;
import com.util.PageUtil;

public interface CommentService {
	public List<CommentDto> getCommentById(Long id);
	
	public int getCommentCount(Long id);
	
	public int addComment(String comment,Long productionId,UserDto user);
	
	public List<Production> getAdminNoRepeatComment(int page);
	
	public PageUtil getAdminCommentPage(int currentPage);
	
	public List<CommentDto> getNoReplyCommentByProId(Long ProId,int currentPage);
	
	public PageUtil getAdminNoReplyCommentPage(int currentPage,Long proId);
	
	public void updateIsReviewFlag(Long commentId);
}
