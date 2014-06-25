package com.art.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.art.production.service.ProductionService;
import com.util.Constant;
import com.util.PageUtil;

@Controller
@RequestMapping("/production/*")
public class ProductionController extends BaseController{
	
	@Resource
	private ProductionService productionService;
	
	
	@RequestMapping(value = "{type}/{page}", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable("type") int type,@PathVariable("page") int page){
		getStyle();
		ModelAndView mv = new ModelAndView("zuopin");
		mv.addObject("type", "zuopinzhongxin");
		mv.addObject("productType", type);
		mv.addObject("currentPage", page);
		mv.addObject("productionList", productionService.getProByTypeAndPage(type, page,Constant.PRODUCTION_PAGE_SIZE));
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "page/{type}/{page}", method = RequestMethod.GET)
	public PageUtil getPage(@PathVariable("type") int type,@PathVariable("page") int page){
		PageUtil pageUtil =  productionService.getPage(page, type);
		return pageUtil;
	}
}
