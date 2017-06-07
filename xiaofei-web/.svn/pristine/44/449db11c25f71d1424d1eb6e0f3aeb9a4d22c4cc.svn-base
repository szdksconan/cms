package com.cms.controller.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.cms.model.util.GlobalUtil;
import com.cms.web.util.s3.S3Util;

public class S3Operate {
    private static Logger logger = LoggerFactory.getLogger(S3Operate.class);

   
    /**
     * MultipartFile 类型文件上传
     * @param file MultipartFile[]
     * @param func 功能模块
     * @param everyone
     * @return
     */
    public static List fileUpload(MultipartFile[] file,String func,boolean everyone){
    	
    	List<Map> fileList = new ArrayList<Map>();
        try {
        	for (int i=0;i<file.length;i++){
            	
        	    String _now = GlobalUtil.getCreateTime().substring(0,10);
        	    String fileKey = func+"/"+_now+"/"+UUID.randomUUID().toString().replace("-","");
        	    MultipartFile multipartFile = file[i];
                if (multipartFile.getSize()==0){
                    continue;
                }
                Map map = S3Util.upload(S3Util.tempBucketName, fileKey, multipartFile.getInputStream(),
                        multipartFile.getContentType(), multipartFile.getSize(), everyone);
                fileList.add(map);
            }
        }catch (Exception e){
            logger.debug("MultipartFile文件上传出错\n"+e.getMessage());
        }
        return fileList;
    }
    /**
     * 删除s3文件
     * @param filekey 文件key
     */
    public static void delfile(String filekey){
    	
    	S3Util.deleteObject(S3Util.producerBucketName,filekey);
    }
}
