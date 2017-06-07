package com.cms.util;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.cms.web.util.s3.S3Util;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.*;

/**
 * Created by liuxin on 2016/5/4.
 */
public class FileOperate {
    private static Boolean everyone = true;
    private static Logger logger = LoggerFactory.getLogger(FileOperate.class);

    /**
     * MultipartFile 类型文件上传
     * @param map(fileKey:文件key前缀;everyone:文件访问权限是否为每人)
     * @return
     */
    public static List FileUploadMultipartFile(Map map){
        List<MultipartFile> list = (List<MultipartFile>) map.get("fileList");
        String fileKey = map.get("fileKey").toString();
        everyone = map.get("everyone")==null?everyone: (Boolean) map.get("everyone");
        List fileList = new ArrayList();
        if (list.size()!=0){
            try {
                for (int i=0;i<list.size();i++){
                    String _fileKey = fileKey+"_"+UUID.randomUUID().toString().replace("-","");
                    MultipartFile multipartFile = list.get(i);
                    if (multipartFile.getSize()==0){
                        continue;
                    }
                    Map file = S3Util.upload(S3Util.producerBucketName, _fileKey, multipartFile.getInputStream(),
                            multipartFile.getContentType(), multipartFile.getSize(), everyone);
                    fileList.add(file);
                }
            }catch (Exception e){
                logger.debug("MultipartFile文件上传出错\n"+e.getMessage());
            }
        }
        return fileList;
    }
}
