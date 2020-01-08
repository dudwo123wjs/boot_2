package com.iu.b1.util;

import java.io.File;
import java.util.UUID;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	public String save(File file, MultipartFile files)throws Exception{
//		파일이 있는 파일 위치 = filePath / 폴더가 존재하지 않을 수 있으니 if문 ↓↓
//		File file = new File(filePath);
//		if(!file.exists()) {
//			file.mkdirs();
//			
//		}
		
		String fileName = UUID.randomUUID().toString()+"_"+files.getOriginalFilename();
		
		file = new File(file, fileName);
		
		files.transferTo(file);
		
		return fileName;
	}
	
}
