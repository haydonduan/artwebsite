package com.util;

import java.io.File;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class UploadImage {
	public static String upload(MultipartFile file,String path,int type){
		String fileName = new Date().getTime()+"";
		if(type == 1){
			fileName = fileName + "111.jpg";
		}else if(type == 2){
			fileName = fileName + "222.jpg";
		}else{
			fileName = fileName + ".jpg";
		}
		File targetFile = new File(path, fileName);  
		if(!targetFile.exists()){
            targetFile.mkdirs();  
        } 
		try {
			file.transferTo(targetFile);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
