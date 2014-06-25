package com.art.backstagecontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.art.production.domain.Production;
import com.art.production.service.ProductionService;
import com.util.Constant;
import com.util.PageUtil;

@Controller
@RequestMapping("/backstage/on/pro/*")
public class AdminProductionController{
	
	@Resource
	private ProductionService productionService;
	
	@Resource
	private HttpServletRequest request;
	
	@RequestMapping(value="{page}")
	public ModelAndView list(@PathVariable("page") int page){
		ModelAndView mav = new ModelAndView("backstage/prolist");
		mav.addObject("currentPage", page);
		mav.addObject("proList", productionService.getProByAdminPage(page, Constant.BACKSTAGE_PRO_PAGE_SIZE));
		return mav;
 	}
	
	@ResponseBody
	@RequestMapping(value = "page/{page}", method = RequestMethod.GET)
	public PageUtil getPage(@PathVariable("page") int page){
		PageUtil pageUtil =  productionService.getAdminProPage(page);
		return pageUtil;
	}
	
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public int updateIsViewFlag(@RequestParam("id") String ids){
		return productionService.updateDelFlg(ids);
	}
	
	@RequestMapping(value = "addProPage")
	public String addProPage(){
		return "backstage/addPro";
	}
	
	@RequestMapping(value = "updateProPage/{id}")
	public String updateProPage(@PathVariable("id") Long id,ModelMap model){
		model.addAttribute("production", productionService.getProductionById(id));
		return "backstage/updatePro";
	}
	
	@RequestMapping(value = "uploadPro",method=RequestMethod.POST)
	public ModelAndView uploadPro(
			@RequestParam(value = "image") MultipartFile file
			,@RequestParam("title") String title
			,@RequestParam("time") String time
			,@RequestParam("type") int type
			,@RequestParam("id") String id
			,@RequestParam("inspiration") String inspiration){
			Production p = new Production();
			if(!"".equals(id.trim())){
				p.setId(Long.parseLong(id));
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				p.setFinishTime(sdf.parse(time));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			p.setInspiration(inspiration);
			p.setProductionType(type);
			p.setTitle(title);
			
            productionService.addPro(file,p,request.getSession(true));
        ModelAndView mav = new ModelAndView("redirect:/backstage/on/pro/0");
        return mav;
	}
	
	
	public int deleteMoreAction(@RequestParam("ids") String ids,@RequestParam("type") int type){
	
		
		return 0;
	}
}
