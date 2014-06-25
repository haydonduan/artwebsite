package com.art.backstagecontroller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.art.newsnotice.domain.NewsNotice;
import com.art.newsnotice.service.NewsNoticeService;
import com.util.PageUtil;

@Controller
@RequestMapping("/backstage/on/newsnotice/*")
public class AdminNewsNoticeController{
	
	@Resource
	private NewsNoticeService newsNoticeService;
	
	@Resource
	private HttpServletRequest request;
	
	@RequestMapping("{currentPage}/{type}")
	public ModelAndView getDataByType(@PathVariable("type") int type,@PathVariable("currentPage") int currentPage){
		ModelAndView mav = new ModelAndView();
		if(type == 0){
			mav.setViewName("backstage/news");
		}else{
			mav.setViewName("backstage/notices");
		}
		mav.addObject("dataList", newsNoticeService.getDataList(type, currentPage));
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("page/{currentPage}/{type}")
	public PageUtil getDataByTypePage(@PathVariable("type") int type,@PathVariable("currentPage") int currentPage){
		return newsNoticeService.getDataPage(type, currentPage);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public int deleteById(@RequestParam("id") String ids){
		return newsNoticeService.deleteNewsNotice(ids);
	}
	
	
	/**
	 * 
	 * @param type 新闻还是公告 1为新闻  0为公告
	 * @param isEdit 是否跳入更新画面 1是
	 * @param id 
	 * @return
	 */
	@RequestMapping(value="toEditPage/{type}/{isEdit}/{id}")
	public ModelAndView toEditPage(
			@PathVariable("type") int type,
			@PathVariable("isEdit") int isEdit,
			@PathVariable("id") String id){
		ModelAndView mav = new ModelAndView();
		
		//是新闻OR公告
		if(type == 1){
			mav.addObject("type", "news");
		}else if(type == 0){
			mav.addObject("type", "notice");
		}
		
		//是否更新
		if(isEdit == 1){
			mav.addObject("newsNotice",newsNoticeService.getNewsNoticeById(Long.parseLong(id)));
			mav.addObject("newsId", id);
			mav.setViewName("backstage/updateNews");
		}else{
			mav.setViewName("backstage/addNews");
		}
		return mav;
	}
	
	/**
	 * 
	 * @param title
	 * @param text 
	 * @param id
	 * @param type 对于新闻而言，1为个人 0 为普通
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="save",method=RequestMethod.POST)
	public int save(
			MultipartHttpServletRequest request1,
			@RequestParam("title") String title,
			@RequestParam("text") String text,
			@RequestParam("id") String id,
			@RequestParam("type") int type){
		NewsNotice nn = new NewsNotice();
		MultipartFile file = request1.getFile("image");
		if(!"".equals(id.trim())){
			nn.setId(Long.parseLong(id));
		}
		nn.setCreateTime(new Date());
		nn.setText(text);
		nn.setTitle(title);
		if(type == 2){
			nn.setType((byte)1);
		}else{
			nn.setType((byte)0);
			nn.setIsOwn((byte)type);
		}
		
		return newsNoticeService.addNewsNotice(nn,file,request.getSession(true));
	}
}
