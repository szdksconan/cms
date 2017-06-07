package com.cms.controller.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class ServiceUploadUtil {
	
	/*
	 *上传文件
	 */
	public static List<Map<String,Object>> addFile1(String filepath, MultipartFile[] myfiles,HttpServletRequest request) throws IllegalStateException, IOException{
		 List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		 File filea = new File(filepath);
		 if (!filea.exists()) {
			   filea.mkdir();
			}
			if(myfiles.length > 0){
				String fileseparator = System.getProperties().getProperty("file.separator");
				for(MultipartFile file: myfiles){
					 if(file != null){  
		                    String myFileName = file.getOriginalFilename();  
		                    if(myFileName.trim() !=""){  
		                        //System.out.println(myFileName);  
		                        String fileName =  file.getOriginalFilename();  
		                        String prefix=fileName.substring(fileName.lastIndexOf("."));
		                        String fileNewName = UUID.randomUUID().toString()+prefix;
		                        String path = filepath+fileseparator+fileNewName;  
		                        //文件大小
		                        String size = file.getSize()/1024+"KB";
		                        //long size = file.getSize();
		                        //文件类型
		                        String type = file.getContentType();
		                        File localFile = new File(path);  
		                        file.transferTo(localFile);
		                        Map<String, Object> map = new HashMap<String, Object>();
		                        map.put("fileNewName", fileNewName);
		                        map.put("fileName", fileName);
		                        map.put("size", size);
		                        map.put("type", type);
		                        list.add(map); 
		                    }
		                    
		                }
				}
			}
	       return list;
		}



}
