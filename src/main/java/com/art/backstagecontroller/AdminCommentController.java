package com.art.backstagecontroller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.art.comment.service.CommentService;
import com.util.PageUtil;

@Controller
@RequestMapping("/backstage/on/comment/*")
public class AdminCommentController{
	
	@Resource
	private CommentService commentService;
	
	@ResponseBody
	@RequestMapping(value="{page}")
	public ModelAndView commentPageDate(@PathVariable("page") int page){
		ModelAndView mav = new ModelAndView("backstage/commentlist");
		mav.addObject("currentPage", page);
		mav.addObject("commentList", commentService.getAdminNoRepeatComment(page));
		return mav;
 	}
	
	@ResponseBody
	@RequestMapping(value = "page/{page}", method = RequestMethod.GET)
	public PageUtil getCommentPageSize(@PathVariable("page") int page){
		PageUtil pageUtil =  commentService.getAdminCommentPage(page);
		return pageUtil;
	}
	
	@ResponseBody
	@RequestMapping(value="noreply/{page}/{ProId}")
	public ModelAndView commentReplyPageDate(@PathVariable("page") int page,@PathVariable("ProId") Long proId){
		ModelAndView mav = new ModelAndView("backstage/commentNoReplyList");
		mav.addObject("currentPage", page);
		mav.addObject("proId", proId);
		mav.addObject("commentList", commentService.getNoReplyCommentByProId(proId, page));
		return mav;
 	}
	
	@ResponseBody
	@RequestMapping(value = "noreply/page/{page}/{ProId}", method = RequestMethod.GET)
	public PageUtil getCommentReplyPageSize(@PathVariable("page") int page,@PathVariable("ProId") Long proId){
		PageUtil pageUtil =  commentService.getAdminNoReplyCommentPage(page, proId);
		return pageUtil;
	}
	
	@ResponseBody
	@RequestMapping(value = "updateisview", method = RequestMethod.POST)
	public int updateIsViewFlag(@RequestParam("id") Long id){
		commentService.updateIsReviewFlag(id);
		return 1;
	}
}
