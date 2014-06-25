package com.art.newsnotice.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.art.newsnotice.domain.NewsNotice;
import com.art.newsnotice.repository.NewsNoticeRepository;
import com.util.Constant;
import com.util.PageUtil;
import com.util.UploadImage;
@Service("newsNoticeService")
public class NewsNoticeServiceImpl implements NewsNoticeService {

	@Autowired
	private NewsNoticeRepository newsNoticeRepository;

	public List<NewsNotice> getDataList(int type, int currentPage) {
		return newsNoticeRepository.getDataList(type, currentPage);
	}

	public PageUtil getDataPage(int type,int currentPage) {
		int allCount = newsNoticeRepository.getDataAll(type);
		return new PageUtil(currentPage, allCount,Constant.BACKSTAGE_NEWS_NOTICE_PAGE_SIZE);
	}

	public int deleteNewsNotice(String ids) {
		
		if("".equals(ids)){
			return 0;
		}
		try {
			String id_s[] = ids.split(",");
			for(int i=0;i<id_s.length;i++){
				newsNoticeRepository.deleteByIdType(Long.parseLong(id_s[i]));
			}
		} catch (Exception e) {
			return 2;
		}
		return 1;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int addNewsNotice(NewsNotice nn,MultipartFile file,HttpSession session) {
		try {
			
			//更新
			if(nn.getId() != null){
				NewsNotice oldPro = newsNoticeRepository.findOne(nn.getId());
				if(file == null){
					nn.setImage(oldPro.getImage());
				}else{
					String path = session.getServletContext().getRealPath("upload");
					String fileName = UploadImage.upload(file, path,0);
					nn.setImage(Constant.UPLOAD_FILE + "/" + fileName);
				}
			}else{
			//保存
				if(file != null){
					String path = session.getServletContext().getRealPath("upload");
					String fileName = UploadImage.upload(file, path,0);
					nn.setImage(Constant.UPLOAD_FILE + "/" + fileName);
				}
			}
			newsNoticeRepository.save(nn);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public NewsNotice getNewsNoticeById(Long id) {
		return newsNoticeRepository.findOne(id);
	}

	public List<NewsNotice> getDataByNewsNotice(int newsNoticeType,
			int currentPage, int painterNewsType) {
		return newsNoticeRepository.getDataByNewsNotice(newsNoticeType, currentPage, painterNewsType);
	}

	public List<NewsNotice> getDataByNewsNoticeMore(int newsNoticeType,
			int currentPage) {
		return newsNoticeRepository.getDataByNewsNoticeMore(newsNoticeType, currentPage);
	}

	public PageUtil getPage(int currentPage, int type) {
		int count = newsNoticeRepository.getDataAll(type);
		return new PageUtil(currentPage, count,Constant.NEWS_NOTICE_MORE_PAGE_SIZE);
	}

	@Override
	public List<NewsNotice> getRightData() {
		return newsNoticeRepository.getRightData();
	}

}
