package com.cms.web.util.s3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.jets3t.service.Jets3tProperties;
import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.ServiceException;
import org.jets3t.service.acl.AccessControlList;
import org.jets3t.service.acl.GroupGrantee;
import org.jets3t.service.acl.Permission;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cms.service.common.redis.SerializeUtil;

public class S3Util {

	private static String UPLOADS_IMAGES_PATH = "uploads/images/";
	private static String CN_ENDPOINT = "s3." + Regions.CN_NORTH_1.getName() + ".amazonaws.com.cn";
	private static String SECRET_PASS = "BA2xoM5V4+pa5UB1";
	private static String ACCESS_KEY = "AKIAOMP5LPVPCWSQDLBA";
	private static String SECURE_KEY = "FDAaKkjlYBA2xoM5V4+pa+Z/vyH9cVr+L4oZS6sB";
	private static String SECRET_FILEPATH = "f:/awscredentials.enc";
	public static String producerBucketName = "producer-store";
	public static String commonBucketName = "common-store";
	public static String consumerBucketName = "consumer-store";
	public static String tradersBucketName = "traders-store";
	public static String userBucketName = "user-store";
	public static String videoImgBucketName = "video-img-store";
	public static String tempBucketName = "temp-store";
	public static String chppBucketName = "chpp";

	private static Logger logger = LoggerFactory.getLogger(S3Util.class);
	
	static {
		logger.debug("init JetS3Util......");
		InputStream in = SerializeUtil.class.getClassLoader().getResourceAsStream("META-INF/spring/config.properties");

		Properties pps = new Properties();
		 try {
			pps.load(in);
			CN_ENDPOINT = pps.getProperty("CN_ENDPOINT").trim();
			SECRET_PASS = pps.getProperty("SECRET_PASS").trim();
			ACCESS_KEY = pps.getProperty("ACCESS_KEY").trim();
			SECURE_KEY = pps.getProperty("SECURE_KEY").trim();
			SECRET_FILEPATH = pps.getProperty("SECRET_FILEPATH").trim();
			producerBucketName = pps.getProperty("producerBucketName").trim();
			commonBucketName = pps.getProperty("commonBucketName").trim();
			consumerBucketName = pps.getProperty("consumerBucketName").trim();
			tradersBucketName = pps.getProperty("tradersBucketName").trim();
			userBucketName = pps.getProperty("userBucketName").trim();
			videoImgBucketName = pps.getProperty("videoImgBucketName").trim();
			chppBucketName = pps.getProperty("chppBucketName").trim();
			tempBucketName = pps.getProperty("tempBucketName").trim();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (in!=null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 下载
	 * @param bucketName 桶名称
	 * @param key 对象key（包含目录和文件名）
	 * @param downloadPath 下载路径
	 * @return
	 * @throws RuntimeException
	 */
	public static File download(String bucketName,String key, String downloadPath) throws RuntimeException{
		
		S3Service s3Service = createS3Service();
		// Retrieve the whole data object we created previously
		InputStream inputStream = null;
		File file = null;
		FileOutputStream outputStream = null;
		try {
			S3Object objectComplete = s3Service.getObject(bucketName, key);
			
			inputStream = objectComplete.getDataInputStream();
			file = new File(downloadPath);
			outputStream = new FileOutputStream(file);
			System.out.println("开始读写");
			byte[] bufferArr = new byte[1024];
			//利用输入流，输出流，缓冲数组，循环读取文件，写入文件
			int len = 0;
			while((len = inputStream.read(bufferArr))!=-1){
				outputStream.write(bufferArr,0,len);
			}
			System.out.println("读写完毕");
			
			return file;
		}catch (S3ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException(e1);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException(e1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			//关闭所有reader,writer
			try {
				if (outputStream!=null)
					outputStream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (inputStream!=null)
					inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 下载
	 * @param bucketName
	 * @param key
	 * @return 返回对象的InputStream
	 * @throws RuntimeException
	 */
	public static InputStream download(String bucketName,String key) throws RuntimeException{
		try {
			S3Service s3Service = createS3Service();
			S3Object objectComplete = s3Service.getObject(bucketName, key);
			return objectComplete.getDataInputStream();
		} catch (ServiceException e) {
			logger.info("从S3下载文件{}失败，失败原因：{}",bucketName+key,e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 上传
	 * @param bucketName
	 * @param key
	 * @param file
	 * @param everyOne 是否所有人都有权限查看
	 * @return Map:key(文件key), path(http访问路径)
	 * @throws RuntimeException
	 */
	public static Map<String,String> upload(String bucketName, String key, File file, Boolean everyOne)
			throws RuntimeException {
		if ((key==null || "".equals(key) ||
				(bucketName==null || "".equals(bucketName)))){
			throw new RuntimeException("bucketName or object key is empty!");
		}
		S3Service s3Service = createS3Service();
		S3Bucket bucket;
		try {
			bucket = s3Service.getBucket(bucketName);
		} catch (S3ServiceException e) {
			throw new IllegalStateException("Unable to retrieve S3 Bucket", e);
		}
		
		try {
			// Update the bucket's ACL. Now anyone can view the list of objects in this bucket.
			AccessControlList bucketAcl = s3Service.getBucketAcl(bucket);
			if (everyOne){
				bucketAcl.grantPermission(GroupGrantee.ALL_USERS, Permission.PERMISSION_READ);
				bucket.setAcl(bucketAcl);
				s3Service.putBucketAcl(bucket);
			}	
			S3Object object = new S3Object(file);
			//object.setDataInputStream(in);
			object.setKey(key);
			object.setAcl(bucketAcl);
			
			s3Service.putObject(bucket, object);
			logger.debug("View public object contents here: http://{}/{}",CN_ENDPOINT 
				    +bucket.getName(),object.getKey());
			Map<String,String> r = new HashMap<String,String>();
			r.put("key", object.getKey());
			r.put("path", "https://"+CN_ENDPOINT+"/" + bucket.getName() + "/" + object.getKey());
			return r;
		} catch (S3ServiceException e) {
			throw new RuntimeException("Unable to put object into S3", e);
		} catch (ServiceException e) {			
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.info("new S3Object NoSuchAlgorithmException");
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("new S3Object IOException");
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 上传
	 * @param bucketName
	 * @param key 包含文件目录和文件名
	 * @param InputStream 文件InputStream
	 * @param everyOne 是否所有人都有权限查看
	 * @return Map:key(文件key), path(http访问路径)
	 * @throws RuntimeException
	 */
	private static Map<String,String> uploadByJet(String bucketName, String key, InputStream in, String contentType,long contentLength, Boolean everyOne)
			throws RuntimeException {
		if ((key==null || "".equals(key) ||
				(bucketName==null || "".equals(bucketName)))){
			throw new RuntimeException("bucketName or object key is empty!");
		}
		S3Service s3Service = createS3Service();
		S3Bucket bucket;
		try {
			bucket = s3Service.getBucket(bucketName);
		} catch (S3ServiceException e) {
			throw new IllegalStateException("Unable to retrieve S3 Bucket", e);
		}
		
		try {
			// Update the bucket's ACL. Now anyone can view the list of objects in this bucket.
			AccessControlList bucketAcl = s3Service.getBucketAcl(bucket);
			if (everyOne){
				bucketAcl.grantPermission(GroupGrantee.ALL_USERS, Permission.PERMISSION_READ);
				bucket.setAcl(bucketAcl);
				s3Service.putBucketAcl(bucket);
			}	

			S3Object object = new S3Object(key);
			//BufferedInputStream bis = new BufferedInputStream(in,16 * 1024);
			//ByteArrayInputStream bis = new ByteArrayInputStream();
			object.setDataInputStream(in);
			object.setContentLength(contentLength);
			object.setContentType(contentType);
			object.addMetadata(S3Object.METADATA_HEADER_CONTENT_TYPE, contentType);
			object.addMetadata(S3Object.METADATA_HEADER_CONTENT_LENGTH, contentLength+"");
			object.setAcl(bucketAcl);
			//byte[] md5Hash = ServiceUtils.computeMD5Hash(in);
			//object.setSHA256Hash(md5Hash);
			s3Service.putObject(bucket, object);
			
			logger.debug("View public object contents here: http://{}/{}",CN_ENDPOINT 
				    +bucket.getName(),object.getKey());
			Map<String,String> r = new HashMap<String,String>();
			r.put("key", object.getKey());
			r.put("path", "https://"+CN_ENDPOINT+"/" + bucket.getName() + "/" + object.getKey());
			return r;
		} catch (S3ServiceException e) {
            e.printStackTrace();
			throw new RuntimeException("Unable to put object into S3", e);
		} catch (ServiceException e) {			
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			try {
				if (in!=null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 上传
	 * @param bucketName
	 * @param key 包含文件目录和文件名
	 * @param InputStream 文件InputStream
	 * @param everyOne 是否所有人都有权限查看
	 * @return Map:key(文件key), path(http访问路径)
	 * @throws RuntimeException
	 */
	public static Map<String,String> upload(String bucketName, String key, InputStream in, 
			String contentType,long contentLength, Boolean everyOne)
			throws RuntimeException {
		if ((key==null || "".equals(key) ||
				(bucketName==null || "".equals(bucketName)))){
			throw new RuntimeException("bucketName or object key is empty!");
		}
		AmazonS3 s3Client = createS3Client();
		try {
			ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(contentType);
            metadata.setContentLength(contentLength);
            if (everyOne)
            	s3Client.putObject(new PutObjectRequest(bucketName, key, in, metadata)
            			.withCannedAcl(CannedAccessControlList.PublicRead));
            else
            	s3Client.putObject(bucketName,key,in,metadata);	
			
			logger.debug("View public object contents here: http://{}/{}",CN_ENDPOINT 
				    +bucketName,key);
			Map<String,String> r = new HashMap<String,String>();
			r.put("key", key);
			r.put("path", "https://"+CN_ENDPOINT+"/" + bucketName + "/" + key);
			return r;
		} catch (RuntimeException e) {
            e.printStackTrace();
			throw new RuntimeException("Unable to put object into S3", e);
		}finally{
			try {
				if (in!=null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 删除桶中的对象
	 * @param bucketName
	 * @param key
	 * @throws RuntimeException
	 */
	public static void deleteObject(String bucketName, String key)
			throws RuntimeException{
		if ((key==null || "".equals(key) ||
				(bucketName==null || "".equals(bucketName)))){
			throw new RuntimeException("bucketName or object key is empty!");
		}
		try {
			S3Service s3Service = createS3Service();
			s3Service.deleteObject(bucketName, key);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("从桶"+bucketName+"删除文件{}失败，错误原因：{}",key ,e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 复制桶中的对象到另一个桶
	 * @param sourceBucketName
	 * @param destBucketName
	 * @param key
	 * @param destKey 如果为空，使用sourceKey作为destKey
	 * @param replaceMetadata 是否替换Metadata
	 * @param metadataInfo 如text/html
	 * @return a map of the header and result information after the object copy. The map includes the object's MD5 
	 *          hash value (ETag), its size (Content-Length), and update timestamp (Last-Modified). If the object was successfully 
	 *          copied but the original could not be deleted, the map will also include an item named "DeleteException" with the 
	 *          exception thrown by the delete operation.
	 * @throws RuntimeException
	 */
	public static Map<String,Object> copyObject(String sourceBucketName, String destBucketName, String key, String destKey,
			Boolean replaceMetadata, String metadataInfo)throws RuntimeException{
		if ((key==null || "".equals(key) ||
				(sourceBucketName==null || "".equals(sourceBucketName)) ||
				(destBucketName==null || "".equals(destBucketName)))){
			throw new RuntimeException("bucketName or object key is empty!");
		}
		if (destKey==null || "".equals(destKey))
			destKey = key;
		
		S3Service s3Service = createS3Service();
		S3Object targetObject = null;
		//是否改变Metadata
		targetObject = new S3Object(destKey);
		if (replaceMetadata && 
				metadataInfo!=null && !"".equals(metadataInfo)){
			targetObject.addMetadata(S3Object.METADATA_HEADER_CONTENT_TYPE, metadataInfo);
		}
		
		try {
			return s3Service.copyObject(sourceBucketName, key, destBucketName, targetObject, replaceMetadata);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("从桶"+sourceBucketName+"复制文件{}到目标桶"+destBucketName+"失败，错误原因：{}",key ,e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 移动桶中的对象到另一个桶
	 * @param sourceBucketName
	 * @param destBucketName
	 * @param sourceKey
	 * @param destKey 如果为空，使用sourceKey作为destKey
	 * @param replaceMetadata 是否替换Metadata
	 * @param metadataInfo 如text/html
	 * @return a map of the header and result information after the object copy. The map includes the object's MD5 
	 *          hash value (ETag), its size (Content-Length), and update timestamp (Last-Modified). If the object was successfully 
	 *          copied but the original could not be deleted, the map will also include an item named "DeleteException" with the 
	 *          exception thrown by the delete operation.
	 * @throws RuntimeException
	 */
	public static Map<String,Object> moveObject(String sourceBucketName, String destBucketName, String sourceKey, String destKey,
			Boolean replaceMetadata, String metadataInfo)throws RuntimeException{
		if ((sourceKey==null || "".equals(sourceKey) ||
				(sourceBucketName==null || "".equals(sourceBucketName)) ||
				(destBucketName==null || "".equals(destBucketName)))){
			throw new RuntimeException("bucketName or object key is empty!");
		}
		if (destKey==null || "".equals(destKey))
			destKey = sourceKey;
		
		S3Service s3Service = createS3Service();
		S3Object targetObject = null;
		
		//是否改变Metadata
		targetObject = new S3Object(destKey);
		if (replaceMetadata && 
				metadataInfo!=null && !"".equals(metadataInfo)){
			targetObject.addMetadata(S3Object.METADATA_HEADER_CONTENT_TYPE, metadataInfo);
		}
		
		try {
			return s3Service.moveObject(sourceBucketName, sourceKey, destBucketName, targetObject, replaceMetadata);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("从桶"+sourceBucketName+"移动文件{}到目标桶"+destBucketName+"失败，错误原因：{}",sourceKey ,e.getMessage());
			throw new RuntimeException(e);
		}
	}

	private static S3Service createS3Service() {
		S3Service s3Service;
		try {
			File crFile = new File(SECRET_FILEPATH);
			AWSCredentials awsCredentials = (AWSCredentials)AWSCredentials.load(SECRET_PASS, crFile);
			Jets3tProperties props = new Jets3tProperties();
			props.setProperty("s3service.s3-endpoint", CN_ENDPOINT);
			props.setProperty("s3service.https-only", "false");
			
			s3Service = new RestS3Service(awsCredentials, null, null, props);
			return s3Service;
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static AmazonS3 createS3Client() {
		AmazonS3 s3Client = null;
		try {
			s3Client = new AmazonS3Client(new BasicAWSCredentials(ACCESS_KEY, SECURE_KEY));
			s3Client.setRegion(Region.getRegion(Regions.CN_NORTH_1));
			return s3Client;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private static  String createSignedHttpGetUrl(String bucketName, String key, int hours) throws ServiceException{
		// Determine what the time will be in 5 minutes.
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, hours);
		Date expiryDate = cal.getTime();
		S3Service s3Service = createS3Service();
		return s3Service.createSignedGetUrl(bucketName, key, expiryDate, false);
	}
	
	private static void saveCredFile() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalStateException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, IOException{
		// Save credentials to an encrypted file protected with a password.
		AWSCredentials awsCredentials = new AWSCredentials("AKIAOMP5LPVPCWSQDLBA", "FDAaKkjlYBA2xoM5V4+pa+Z/vyH9cVr+L4oZS6sB");
		File credFile = new File("F:\\awscredentials.enc");
		awsCredentials.save(SECRET_PASS, credFile);
		System.out.println("OK!");
	}
	
	public static void main(String[] args) throws Exception {
		test(S3Util.videoImgBucketName);
		//saveCredFile();
		//JetS3Util.deleteObject(JetS3Util.videoImgBucketName,UPLOADS_IMAGES_PATH+"meinv111.png");
		//JetS3Util.copyObject( JetS3Util.commonBucketName, JetS3Util.videoImgBucketName,UPLOADS_IMAGES_PATH+"meinv111.png", 
		//		null, false, null);
	}

	private static void test(String bucketName) throws ServiceException, NoSuchAlgorithmException, IOException {
		//System.setProperty(SDKGlobalConfiguration.ENFORCE_S3_SIGV4_SYSTEM_PROPERTY, "true"); //加密方法
		S3Service s3Service = createS3Service();
		S3Bucket bucket = s3Service.getBucket(bucketName);
		
		if (bucket != null) {
			File f = new File("D:\\zookeeper.zip");
			
			InputStream in = new FileInputStream(f);
			//Map<String,String> object = upload(bucketName, UPLOADS_IMAGES_PATH + f.getName(), f,true);
			//Map<String,String> object = upload(bucketName, UPLOADS_IMAGES_PATH + f.getName(), in, "application/zip",f.length(),true);
			Map<String,String> object = upload(bucketName, UPLOADS_IMAGES_PATH + f.getName(), in, "application/zip",f.length(),true);
			System.out.println("上传成功" + object.get("key"));
			
			File fDownload = download(bucketName, UPLOADS_IMAGES_PATH + f.getName(),"f:\\zookeeper.zip");
			if(fDownload.exists()){
				System.out.println("下载成功"+fDownload.getAbsolutePath());
			}
			
			String url = createSignedHttpGetUrl(bucket.getName(),object.get("key"),1);
			System.out.println(url);
			
		}
	}
	

}
