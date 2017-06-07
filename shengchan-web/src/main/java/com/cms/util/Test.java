package com.cms.util;

import java.io.File;
import java.util.Map;

import com.cms.web.util.s3.S3Util;


public class Test {

	public static void main(String[] args) {
		
		File f = new File("E://1/dealmenhu.png");
		
		Map<String,String> object = S3Util.upload(S3Util.producerBucketName, "uploads/images/company/gongchang/" + f.getName(), f,true);
		System.out.println("上传成功" + object.get("key"));
		System.out.println("上传成功" + object.get("path"));
		

	}

}
