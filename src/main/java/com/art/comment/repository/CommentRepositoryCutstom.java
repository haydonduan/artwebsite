package com.art.comment.repository;

import java.util.List;

import com.art.comment.dto.CommentDto;
import com.art.production.domain.Production;


public interface CommentRepositoryCutstom {
	/**
	 * 通过Production_id得到comment
	 * @param id
	 * @return
	 */
	public List<CommentDto> getCommentById(Long id);
	
	/**
	 * 得到评论总数
	 * @param id
	 * @return
	 */
	public int getCommentCount(Long id);
	
	/**
	 * 获取作品的总数(管理员)
	 * @return
	 */
	public int getAdminCommentAll();
	
	public List<Production> getAdminNoRepeatComment(int page);
	
	public List<CommentDto> getNoReplyCommentByProId(Long ProId,int currentPage);
	
	public int getAdminNoReplyCommentAllByProId(Long proId);
	
	public void updateIsReviewFlag(Long commentId);
}
