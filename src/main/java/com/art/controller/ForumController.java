package com.art.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.art.article.domain.Article;
import com.art.article.dto.ArticleDto;
import com.art.article.service.ArticleService;
import com.art.articlecomment.service.ArticleCommentService;
import com.art.user.domain.User;
import com.util.Constant;
import com.util.PageUtil;

@Controller
@RequestMapping("/forum/*")
public class ForumController extends BaseController{
	
	@Resource
	private ArticleService articleService;
	@Resource
	private ArticleCommentService articleCommentService;
	
	@RequestMapping("index")
	public ModelAndView index(){
		getStyle();
		ModelAndView mv = new ModelAndView("luntan");
		mv.addObject("type", "luntan");
		mv.addObject("newArticle", articleService.getNewArticle());
		mv.addObject("newCommentArticle", articleService.getNewCommentArticle());
		mv.addObject("hotArticle", articleService.getHotArticle());
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView detail(@PathVariable("id") Long id){
		ModelAndView mv = new ModelAndView();
		getStyle();
		ArticleDto dto =  articleService.getArtcleDetail(id);
		if(dto == null || dto.getIsView() == 0 || dto.getIsView() == 2){
			mv.setViewName("redirect:/404");
		}else{
			mv.setViewName("luntanxiangxi");
			mv.addObject("type", "luntan");
			mv.addObject("forum", dto);
			mv.addObject("comments", articleCommentService.getArtclecComments(id));
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("addcomment")
	public int addComment(@RequestParam("comment") String commentStr,@RequestParam("id") Long id){
		
		if(commentStr.length() > Constant.COMMENT_STRING_LENGTH){
			return 2;
		}
		
		try {
			articleCommentService.addArticleComment(commentStr, id, getSessionUser().getId());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@RequestMapping("on/addForum")
	public ModelAndView addForumPage(){
		getStyle();
		ModelAndView mav = new ModelAndView("tiezifabu");
		return mav;
	}
	
	@RequestMapping(value="on/doAddForum",method=RequestMethod.POST)
	public String addForum(@RequestParam("title") String title,@RequestParam("text") String text){
		getStyle();
		Article art = new Article();
		User user = new User();
		user.setId(getSessionUser().getId());
		art.setUser(user);
		art.setTitle(title);
		art.setContent(text);
		art.setCreateTime(new Date());
		
		articleService.addArticle(art);
		
		return "redirect:/forum/on/tomypage";
	}
	
	@RequestMapping(value="page/{page}",method=RequestMethod.GET)
	public ModelAndView page(@PathVariable("page") int page){
		getStyle();
		ModelAndView mav = new ModelAndView("forumlist");
		mav.addObject("forumList", articleService.getArticleByPage(page,Constant.FORUM_PAGE_SIZE,1));
		mav.addObject("currentPage", page);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "datapage/{page}", method = RequestMethod.GET)
	public PageUtil getPage(@PathVariable("page") int page){
		PageUtil pageUtil =  articleService.getPage(page,Constant.FORUM_PAGE_SIZE,1);
		return pageUtil;
	}
}
