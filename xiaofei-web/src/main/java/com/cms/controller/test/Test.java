package com.cms.controller.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import com.cms.web.util.s3.S3Util;

public class Test {

	public static void main(String[] args) {
		/*File f = new File("D://消费平台文档//前端//消费页面//cmaosptaixiaofei//images//01.jpg");
		Map m  =S3Util.upload(S3Util.tempBucketName, "uploads/images/"+f.getName(), f, true);
		System.out.println(m.get("key")+"***"+f);
		System.out.println(m.get("path"));*/
		
				
		/*File f = new File("D://消费平台文档//前端//消费页面//cmaosptaixiaofei//images//01.jpg");
		
		Map<String,String> object = S3Util.upload(S3Util.tempBucketName, "uploads/images/" + f.getName(), f,true);
		System.out.println("上传成功" + object.get("key"));
		System.out.println("上传成功" + object.get("path"));*/
		S3Util.deleteObject(S3Util.videoImgBucketName, "uploads/images/b81db797-1142-4d66-9b48-7866cfa19fb5.doc");
				


	}

}
