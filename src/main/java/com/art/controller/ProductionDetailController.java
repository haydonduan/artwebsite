package com.art.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.art.comment.service.CommentService;
import com.art.production.domain.Production;
import com.art.production.service.ProductionService;

@Controller
@RequestMapping("/detail/*")
public class ProductionDetailController extends BaseController{
	
	@Resource
	private ProductionService productionService;
	
	@Resource
	private CommentService commentService;
	
	@RequestMapping("{id}")
	public ModelAndView index(@PathVariable("id") Long id){
		ModelAndView mv = new ModelAndView("zuopinxiangqing");
		Production p = productionService.getProductionById(id);
		getStyle();
		if(p == null){
			mv.setViewName("redirect:/404");
		}else{
			mv.setViewName("zuopinxiangqing");
			productionService.addScanNum(id);
			mv.addObject("type", "zuopinzhongxin");
			mv.addObject("comments", commentService.getCommentById(id));
			mv.addObject("production", p);
			mv.addObject("commentAllCount", commentService.getCommentCount(id));
		}
		return mv;
	}
	
	@RequestMapping("addLoveNum/{id}")
	@ResponseBody
	public int addLoveNum(@PathVariable("id") Long id){
		productionService.addLoveNum(id);
		return 1;
	}
	
	@RequestMapping("getLoveNum/{id}")
	@ResponseBody
	public int getLoveNum(@PathVariable("id") Long id){
		return productionService.getLoveNum(id);
	}
}
