package com.art.production.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.art.production.domain.Production;
import com.art.production.repository.ProductionRepository;
import com.art.user.domain.User;
import com.art.user.dto.UserDto;
import com.util.Constant;
import com.util.PageUtil;
import com.util.UploadImage;
@Service("productionService")
public class ProductionServiceImpl implements ProductionService {

	@Autowired
	private ProductionRepository productionRepository;

	public List<Production> getJSGallery() {
		return productionRepository.getJSGallery();
	}

	public List<Production> getProByTypeAndPage(int type, int page,int pageSize) {
		return productionRepository.getProByTypeAndPage(type, page,pageSize);
	}

	public PageUtil getPage(int currentPage,int type) {
		int allCount = productionRepository.getProductionAll(type);
		return new PageUtil(currentPage, allCount,Constant.PRODUCTION_PAGE_SIZE);
	}

	public Production getProductionById(Long id) {
		return productionRepository.getProductionById(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addScanNum(Long id) {
		try {
			productionRepository.addScanNum(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addLoveNum(Long id) {
		productionRepository.addLoveNum(id);
	}

	public int getLoveNum(Long id) {
		return productionRepository.getLoveNum(id);
	}

	public List<Production> getProByAdminPage(int page, int pageSize) {
		return productionRepository.getProByAdminPage(page, pageSize);
	}

	public PageUtil getAdminProPage(int currentPage) {
		int allCount = productionRepository.getAdminProductionAll();
		return new PageUtil(currentPage, allCount,Constant.BACKSTAGE_PRO_PAGE_SIZE);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int updateDelFlg(String ids) {
		
		if("".equals(ids)){
			return 0;
		}
		try {
			String id_s[] = ids.split(",");
			for(int i=0;i<id_s.length;i++){
				productionRepository.updateDelFlg(Long.parseLong(id_s[i]));
			}
		} catch (Exception e) {
			return 2;
		}
		return 1;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void addPro(MultipartFile file,Production pro,HttpSession session) {
		Production production = new Production();
		//更新
		if(pro.getId() != null){
			Production oldPro = productionRepository.getProductionById(pro.getId());
			production.setId(pro.getId());
			if("".equals(file.getOriginalFilename())){
				production.setImage(oldPro.getImage());
			}else{
				String path = session.getServletContext().getRealPath("upload");
				String fileName = UploadImage.upload(file, path,0);
				production.setImage(Constant.UPLOAD_FILE + "/" + fileName);
			}
		}else{
		//保存
			String path = session.getServletContext().getRealPath(Constant.UPLOAD_FILE);
			String fileName = UploadImage.upload(file, path,0);
			production.setImage(Constant.UPLOAD_FILE + "/" + fileName);
		}
		
		
		//保存数据库
        production.setInspiration(pro.getInspiration());
        production.setProductionType(pro.getProductionType());
        production.setTitle(pro.getTitle());
		production.setFinishTime(pro.getFinishTime());
        UserDto sessionUser = (UserDto)session.getAttribute(Constant.SESSION_ADMIN_USER);
        User user = new User();
        user.setId(sessionUser.getId());
        production.setUser(user);
        
        
		productionRepository.save(production);
	}
	
	
}
