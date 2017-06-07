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
/**
 * 文件上传
 *
 * 作者： 郑泽
 * 日期：2016年4月20日
 */
public class UploadUtil {
	public static List<Map<String,Object>> addFile(String filepath,HttpServletRequest request) throws IllegalStateException, IOException{
		 List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		File filea = new File(filepath);
		if (!filea.exists()) {
			   filea.mkdir();
			}
			String fileseparator = System.getProperties().getProperty("file.separator");
			//创建一个通用的多部分解析器 
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){  
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //取得request中的所有文件名 
	            Iterator<String> iter = multiRequest.getFileNames();  
	            while(iter.hasNext()){  
	                //取得上传文件  
	                MultipartFile file = multiRequest.getFile(iter.next());  
	                System.out.println(file.getSize()+"--------");
	                if(file != null){  
	                    //取得当前上传文件的文件名称 
	                    String myFileName = file.getOriginalFilename();  
	                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在 
	                    if(myFileName.trim() !=""){  
	                        System.out.println(myFileName);  
	                        //重命名上传后的文件名
	                        String fileName =  file.getOriginalFilename(); 
	                        String prefix=fileName.substring(fileName.lastIndexOf("."));
	                        String fileNewName = UUID.randomUUID().toString()+prefix;
	                        //String fileNewName = fileName;
	                        //文件大小
	                        String size = file.getSize()/1024+"KB";
	                        //文件类型
	                        String type = file.getContentType();
	                        //定义上传路径   
	                        String path = filepath+fileseparator+fileNewName;  
	                       
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
