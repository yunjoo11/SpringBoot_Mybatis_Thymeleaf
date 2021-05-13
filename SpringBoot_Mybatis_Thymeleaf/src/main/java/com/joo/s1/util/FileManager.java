package com.joo.s1.util;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ResourceLoader resourceLoader;

	public String save(MultipartFile multipartFile, String filePath)throws Exception{
		//filepath : /resources/static/ 제외한 하위경로
		
		//1.경로 설정
		/**
			String path="classpath:/static/";
		 * ResourceLoader
		 * classpath 경로를 받아오기 위해 사용
			File file= new File(resourceLoader.getResource(path).getFile(), filePath);
		 */
		String path="static";
		ClassPathResource classPathResource=new ClassPathResource(path);
		File file=new File(classPathResource.getFile(), filePath);
		
		System.out.println(file.getAbsolutePath());
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. 저장할 파일명을 생성
		String fileName= UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		file= new File(file, fileName);
		
		//transfer
		multipartFile.transferTo(file);
		//FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
	}
	
}
