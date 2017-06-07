package com.cms.controller.xiaofei;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cms.controller.test.DataTime;
import com.cms.controller.test.ServiceUploadUtil;
import com.cms.controller.test.UploadUtil;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.xiaofei.CmsXAttachmentService;
import com.cms.model.xiaofei.CmsXAttachment;
import com.cms.web.util.s3.S3Util;

@Controller
@RequestMapping("/file")
public class AttachmentControll {
	
	@Autowired
	private GlobalIdService globalIdService;
	@Autowired
	private CmsXAttachmentService cmsXAttachmentService;
	
	/**
	 * 上传选择的文件可预览
	 * 作者： 郑泽
	 * 日期：2016年4月26日
	 * @param request
	 * @param response
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/fileAPreview")
	@ResponseBody
	public String fileAPreview(@RequestParam("num")Integer num,@RequestParam("type")String type,@RequestParam("vive")Integer vive,
			HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		String fileseparator = System.getProperties().getProperty("file.separator");
		String filePath = this.getPath("fiel", request);
		File f1 = new File(filePath);
		if (!f1.exists()) {
			f1.mkdirs();
		}
		List<Map<String,Object>> a = UploadUtil.addFile(filePath, request);
		if(!a.isEmpty()){
			Map<String,Object> map = a.get(0);
			File f2 = new File(filePath+fileseparator+map.get("fileNewName"));
			Map m  =S3Util.upload(S3Util.consumerBucketName, "uploads/images/"+map.get("fileNewName"), f2, true);
			//添加附件信息
			CmsXAttachment cmsXShopApplyAttachment = new CmsXAttachment();
			String id = (String) request.getSession().getAttribute("ID");
			cmsXShopApplyAttachment.setAttId(Long.toString(globalIdService.getGlobalId()));
			cmsXShopApplyAttachment.setBusiCode(id);//Long.parseLong("695597107440123904")
			cmsXShopApplyAttachment.setBusiType(type);
			cmsXShopApplyAttachment.setAttName((String) map.get("fileName"));
			cmsXShopApplyAttachment.setAttSize((String) map.get("size"));
			cmsXShopApplyAttachment.setAttType((String) map.get("type"));
			cmsXShopApplyAttachment.setAttLoc((String) m.get("path"));
			cmsXShopApplyAttachment.setAttKey((String)m.get("key"));
			cmsXShopApplyAttachment.setUpTime(DataTime.getTime());
			cmsXShopApplyAttachment.setAttPreview(vive);
			cmsXShopApplyAttachment.setAttImgCode(num);
			cmsXAttachmentService.addShopApplyAndUploadGetAttachmentInfo(cmsXShopApplyAttachment);
			if (f2.exists())
			{
				f2.delete();
				System.out.println("删除成功！");
			}  else{
				System.out.println("删除失败！");
			}	
		}
		return "/success";
	}
	
	public String getPath(String filePath,HttpServletRequest request){
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String path = realPath + filePath;
		return path;
	}
	
	/**
	 * 多个文件同时上传
	 * 作者： 郑泽
	 * 日期：2016年5月9日
	 * @param request
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/publishNews")
	public String publishNews(HttpServletRequest request,
			@RequestParam("uploadFile") MultipartFile[] file) throws IllegalStateException, IOException{
		String fileseparator = System.getProperties().getProperty("file.separator");
		String path = this.getPath("fiel", request);
		File f1 = new File(path);
		if (!f1.exists()) {
			f1.mkdirs();
		}
		int n =0;
		List<Map<String,Object>> a = ServiceUploadUtil.addFile1(path, file, request);
		if(a != null){
			for(int i=0;i<a.size();i++){
				Map<String,Object> map = a.get(i);
				File f2 = new File(path+fileseparator+map.get("fileNewName"));
				Map m  =S3Util.upload(S3Util.videoImgBucketName, "uploads/images/"+map.get("fileNewName"), f2, true);
				CmsXAttachment cmsXShopApplyAttachment = new CmsXAttachment();
				String id = (String) request.getSession().getAttribute("ID");
				cmsXShopApplyAttachment.setAttId(Long.toString(globalIdService.getGlobalId()));
				cmsXShopApplyAttachment.setBusiCode(id);//Long.parseLong("695597107440123904")
				cmsXShopApplyAttachment.setBusiType("02");
				cmsXShopApplyAttachment.setAttName((String) map.get("fileName"));
				cmsXShopApplyAttachment.setAttSize((String) map.get("size"));
				cmsXShopApplyAttachment.setAttType((String) map.get("type"));
				cmsXShopApplyAttachment.setAttLoc((String) m.get("path"));
				cmsXShopApplyAttachment.setAttKey((String)m.get("key"));
				cmsXShopApplyAttachment.setUpTime(DataTime.getTime());
				cmsXShopApplyAttachment.setAttPreview(0);
				cmsXAttachmentService.addShopApplyAndUploadGetAttachmentInfo(cmsXShopApplyAttachment);
				if (f2.exists())
				{
					f2.delete();
					System.out.println("删除成功！");
				}  else{
					System.out.println("删除失败！");
				}
			}
			System.out.println(n++);
		}
		return "/success";
	}
	
	@RequestMapping("/success_redirect")
	public String openSuccess(HttpServletRequest request,HttpServletResponse response){
		return "/index";
	}
	/*@RequestMapping("/publishNews")
	public String publishNews(HttpServletRequest request,
			@RequestParam("file") MultipartFile[] file) throws IllegalStateException, IOException{
		long id = globalIdService.getGlobalId();
		for (int i = 0; i < file.length; i++) {
			//System.out.println(file[i].getOriginalFilename()+file[i].isEmpty()+file[i].getSize()+file[i].getContentType());
			if (!file[i].isEmpty()||file[i].getSize()>0) {
				String fileName = file[i].getOriginalFilename();
				long size = file[i].getSize();
				String prefix=fileName.substring(fileName.lastIndexOf("."));
                String fileNewName = UUID.randomUUID().toString()+prefix;
				String filePath = this.getPath("fiel\\", request)  
                        + fileNewName;
				File f2 = new File(filePath);
				//File f1 = new File(path);
				if (!f2.exists()) {
					f2.mkdirs();
				}
				file[i].transferTo(new File(filePath));
				Map m  =S3Util.upload(S3Util.tempBucketName, "uploads/images/"+fileNewName, f2, true);
				//S3Util.upload(bucketName, key, file, everyOne)
				System.out.println(filePath+"**********"+size+"***"+id+"***"+f2.getName());
				InputStream in = new FileInputStream(filePath);
				//Map m  =S3Util.upload(S3Util.tempBucketName, "uploads/images/"+f2.getName(), in, file[i].getContentType(), size, true);
				System.out.println(m.get("key")+"***"+f2);
				System.out.println(m.get("path"));
			}
		}*/
		// 判断文件是否为空  
        /*if (!file.isEmpty()) {  
            try {  
                // 文件保存路径  
                String filePath = this.getPath("fiel\\", request)  
                        + file.getOriginalFilename();  
                // 转存文件  
                file.transferTo(new File(filePath));  
                System.out.println(filePath+"**********");
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  */
		/*return "/success";
	}*/

}
