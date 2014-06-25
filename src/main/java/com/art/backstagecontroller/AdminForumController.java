package com.art.backstagecontroller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.art.article.service.ArticleService;
import com.art.articlecomment.service.ArticleCommentService;
import com.util.Constant;
import com.util.PageUtil;

@Controller
@RequestMapping("/backstage/on/forum/*")
public class AdminForumController{
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private ArticleCommentService articleCommentService;
	
	@ResponseBody
	@RequestMapping(value="{page}")
	public ModelAndView getForumData(@PathVariable("page") int page){
		ModelAndView mav = new ModelAndView("backstage/forumlist");
		mav.addObject("currentPage", page);
		mav.addObject("forumList", articleService.getArticleByPage(page, Constant.BACKSTAGE_FORUM_PAGE_SIZE,2));
		return mav;
 	}
	
	@ResponseBody
	@RequestMapping(value = "page/{page}", method = RequestMethod.GET)
	public PageUtil getForumDataPage(@PathVariable("page") int page){
		PageUtil pageUtil =  articleService.getPage(page,Constant.BACKSTAGE_FORUM_PAGE_SIZE,2);
		return pageUtil;
	}
	
	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public ModelAndView getForumDetail(@PathVariable("id") Long id){
		ModelAndView mav = new ModelAndView("backstage/forumdetail");
		mav.addObject("forum", articleService.getAdminArtcleById(id));
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "udpateisview", method = RequestMethod.POST)
	public int updateIsView(@RequestParam("id") Long id,@RequestParam("type") int type){
		try {
			articleService.updateIsViewById(id, type);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	
	@RequestMapping(value = "comment/{page}", method = RequestMethod.GET)
	public ModelAndView getForumByNoReply(@PathVariable("page") int page){
		ModelAndView mav = new ModelAndView("backstage/forumCommentNoReplyList");
		mav.addObject("currentPage", page);
		mav.addObject("forumList", articleService.getNoReplyArticle(page));
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "comment/page/{page}", method = RequestMethod.GET)
	public PageUtil getForumDataPageByNoReplay(@PathVariable("page") int page){
		PageUtil pageUtil =  articleService.getPage(page,Constant.BACKSTAGE_FORUM_PAGE_SIZE,3);
		return pageUtil;
	}
	
	
	@RequestMapping(value = "comment/data/{page}/{ProId}", method = RequestMethod.GET)
	public ModelAndView getForumCommentByNoReply(@PathVariable("page") int page,@PathVariable("ProId") Long ProId){
		ModelAndView mav = new ModelAndView("backstage/commentForumNoReplyList");
		mav.addObject("currentPage", page);
		mav.addObject("proId", ProId);
		mav.addObject("forumList", articleCommentService.getCommentByNoReply(ProId, page));
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "comment/page/data/{page}/{id}", method = RequestMethod.GET)
	public PageUtil getForumCommentDataPageByNoReplay(@PathVariable("page") int page,@PathVariable("id") Long id){
		PageUtil pageUtil =  articleService.getCommentPage(page, id);
		return pageUtil;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "updateisview", method = RequestMethod.POST)
	public int updateIsViewFlag(@RequestParam("id") Long id){
		articleCommentService.updateIsReply(id);
		return 1;
	}
}
