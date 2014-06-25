package com.art.comment.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.comment.domain.Comment;
import com.art.comment.dto.CommentDto;
import com.art.comment.repository.CommentRepository;
import com.art.production.domain.Production;
import com.art.score.service.ScoreService;
import com.art.user.domain.User;
import com.art.user.dto.UserDto;
import com.util.AddScoreEnum;
import com.util.Constant;
import com.util.PageUtil;
import com.util.UtilClass;
@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	
	@Resource
	private ScoreService scoreService;
	
	@Resource
	private HttpServletRequest request;
	
	public List<CommentDto> getCommentById(Long id) {
		List<CommentDto> list = commentRepository.getCommentById(id);
		String context = request.getContextPath();
		for(int i=0;i<list.size();i++){
			CommentDto comment = list.get(i);
			comment.setImage(context+"/"+comment.getImage());
			comment.setFormatCreateTime(UtilClass.formatTime(comment.getCreateTime()));
		}
		return list;
	}

	public int getCommentCount(Long id) {
		return commentRepository.getCommentCount(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int addComment(String commentStr,Long productionId,UserDto userDto) {
		
		if(commentStr.length() > Constant.COMMENT_STRING_LENGTH){
			return 2;
		}
		
		try {
			Comment comment = new Comment();
			comment.setComment(commentStr);
			comment.setCreateTime(new Date());
			
			Production p = new Production();
			p.setId(productionId);
			comment.setProduction(p);
			User user = new User();
			user.setId(userDto.getId());
			comment.setUser(user);
			commentRepository.save(comment);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Production> getAdminNoRepeatComment(int page) {
		return commentRepository.getAdminNoRepeatComment(page);
	}

	public PageUtil getAdminCommentPage(int currentPage) {
		int allCount = commentRepository.getAdminCommentAll();
		return new PageUtil(currentPage, allCount,Constant.COMMENT_INDEX_PAGE_SIZE);	
	}

	public List<CommentDto> getNoReplyCommentByProId(Long ProId, int currentPage) {
		return commentRepository.getNoReplyCommentByProId(ProId, currentPage);
	}

	public PageUtil getAdminNoReplyCommentPage(int currentPage, Long proId) {
		int allCount = commentRepository.getAdminNoReplyCommentAllByProId(proId);
		return new PageUtil(currentPage, allCount,Constant.COMMENT_NO_REPLY_PAGE_SIZE);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void updateIsReviewFlag(Long commentId) {
		commentRepository.updateIsReviewFlag(commentId);
		Comment comment = commentRepository.findOne(commentId);
		scoreService.updateScore(AddScoreEnum.COMMENT.getScore(), comment.getUser().getId());
	}
}
