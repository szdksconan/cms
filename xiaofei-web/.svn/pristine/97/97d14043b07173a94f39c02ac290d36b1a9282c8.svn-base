package com.cms.controller.test;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

public class S3Test {
	public static void main(String[] args) throws Exception {
		testS3store();

	}

	private static void testS3store() {
		AmazonS3 s3Client = new AmazonS3Client(
				new BasicAWSCredentials("AKIAOMP5LPVPCWSQDLBA", "FDAaKkjlYBA2xoM5V4+pa+Z/vyH9cVr+L4oZS6sB"));
		Region north = Region.getRegion(Regions.CN_NORTH_1);
		s3Client.setRegion(north);
		String bucketName = "chpp";
		String key = "chpp_upload_test";
		// ObjectMetadata metadata = new ObjectMetadata();
		// metadata.setContentType(multipartFile.getContentType());
		// metadata.setContentLength(multipartFile.getSize());
		// s3Client.putObject(new PutObjectRequest(bucketName, key, new
		// FileInputStream(file), metadata).
		// withCannedAcl(CannedAccessControlList.PublicRead));
		// s3Client.putObject(bucketName,key,multipartFile.getInputStream(),metadata);

		File file = new File("F:\\20160322163147.jpg");

		PutObjectResult result = s3Client.putObject(
				new PutObjectRequest(bucketName, key, file).withCannedAcl(CannedAccessControlList.PublicRead));
		//System.out.println(result.getETag());

		S3Object s3Obj = s3Client.getObject(bucketName, key);
 
		//System.out.println(s3Obj.getRedirectLocation());

		// 获取一个request
		GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(bucketName, key);
		Date expirationDate = null;
		try {
			expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse("2016-04-30");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 设置过期时间
		urlRequest.setExpiration(expirationDate);
		// 生成公用的url
		URL url = s3Client.generatePresignedUrl(urlRequest);
		System.out.println("=========URL=================\n" + url + "\n============URL=============");

		//s3Client.deleteObject(bucketName, key);

		/*try {
			s3Obj = s3Client.getObject(bucketName, key);
			System.out.println(s3Obj.getRedirectLocation());
		} catch (Exception e) {
			System.out.println("deleted ok!");
		}*/

	}

}
