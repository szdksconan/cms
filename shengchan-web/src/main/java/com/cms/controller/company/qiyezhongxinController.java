package com.cms.controller.company;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.CompanyService;
import com.cms.mapper.manager.baseInfo.comboMapper;
import com.cms.model.shengchang.CompAttachRel;
import com.cms.model.shengchang.CompBaseInfo;
import com.cms.service.common.redis.RedisUtil;
import com.cms.util.S3Operate;
import com.cms.web.util.s3.S3Util;

@Controller
@RequestMapping("qiye")
public class qiyezhongxinController {
	@Autowired
	private CompanyService companyService;
	
	@Autowired 
	private GlobalIdService globalIdService;

	@RequestMapping("/changeBaseInfo")
	@ResponseBody
	public String changeBaseInfo(CompBaseInfo compBaseInfo,HttpServletRequest request,String deletelogo) {
		JSONObject obj = new JSONObject();
		if(deletelogo!="1"){
			String[] split = deletelogo.split(",");
			//到数据库中进行查询
			CompAttachRel compAttachRel = companyService.getCompAttachRel(split[0],compBaseInfo.getCompid());
			if(compAttachRel!=null){
				String key = compAttachRel.getUrlKey();
				S3Operate.delfile(key);
				companyService.deleteAttachById(split[0],compBaseInfo.getCompid());
			}
		}	
		try {
			System.out.println("compBaseInfo："+compBaseInfo);
			companyService.updateBaseInfo(compBaseInfo);
			obj.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("success", false);
		}
		return obj.toString();
		
	}
	@RequestMapping("/uploadpic")
	@ResponseBody
	public String uploadpic(String compid,@RequestParam MultipartFile logoname,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		MultipartFile[] file = {logoname};
		try {
			List fileUpload = S3Operate.fileUpload(file, "producer-store", true);
			Map map = (Map)fileUpload.get(0);
			companyService.deleteAttachByCompId(compid, "6");
			CompAttachRel compatt = new CompAttachRel();
			compatt.setId(globalIdService.getGlobalId().toString());
			compatt.setAttaUrl((String)map.get("path"));
			compatt.setUrlKey((String)map.get("key"));
			compatt.setCompBaseId(Long.parseLong(compid));
			compatt.setRelType("6");
			companyService.saveAttach(compatt);
			obj.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("success", false);
		}
		 return obj.toString();
	}
	
	@RequestMapping("/changeJiagong")
	@ResponseBody
	public Map changeJiagong(CompBaseInfo compBaseInfo,String deletejiagong) {
		Map<String, Object> infoMap = new HashMap<String, Object>();
		System.out.println("compBaseInfo123123:"+compBaseInfo);
		if(deletejiagong!="1"){
			String[] jiagongID = deletejiagong.split(",");
			for (String str : jiagongID) {
				CompAttachRel compAttachRel = companyService.getCompAttachRel(str,compBaseInfo.getCompid());
				
				if(compAttachRel!=null){
					S3Operate.delfile(compAttachRel.getUrlKey());
				}
				companyService.deleteAttachById(str,compBaseInfo.getCompid());
			}
		}
		try {
			companyService.updateJiagong(compBaseInfo);
			infoMap.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			infoMap.put("success", false);
		}
		return infoMap;
	}
	
	@RequestMapping("/uploadJiagongImg")
	@ResponseBody
	public String uploadJiagongImg(@RequestParam MultipartFile[] jiagong, HttpServletRequest request,String compid){
		JSONObject obj = new JSONObject();
			try {
				List<Map> fileUpload = S3Operate.fileUpload(jiagong, "producer-store", true);
				for (Map map : fileUpload) {
					CompAttachRel compatt = new CompAttachRel();
					compatt.setId(globalIdService.getGlobalId().toString());
					compatt.setAttaUrl((String)map.get("path"));
					compatt.setUrlKey((String)map.get("key"));
					compatt.setCompBaseId(Long.parseLong(compid));
					compatt.setRelType("2");
					companyService.saveAttach(compatt);
				}
				obj.put("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				obj.put("success", false);
			}
		return obj.toString();
	}
	@RequestMapping("/uploadmenhu")
	@ResponseBody
	public void uploadmenhu(String compid,@RequestParam MultipartFile menhu,HttpServletRequest request,String deletelogPic){
		JSONObject obj = new JSONObject();
		//这儿的业务处理是：进来先对所有的相同类型的数据进行删除 然后在进行添加。
		companyService.deleteAttachByCompId(compid, "5");
		if(deletelogPic!="1"){
			String[] deletemenhu = deletelogPic.split(",");
			CompAttachRel compAttachRel = companyService.getCompAttachRel(deletemenhu[0],compid);
			companyService.deleteAttachById(deletemenhu[0],compid);
			if(compAttachRel!=null){
				String key = compAttachRel.getUrlKey();
				S3Operate.delfile(key);
			}
		}
		//到数据库中进行查询
		MultipartFile[] file = {menhu};
			try {
				List fileUpload = S3Operate.fileUpload(file, "producer-store", true);
				Map  object = (Map)fileUpload.get(0);
				String key = (String)object.get("key");
				String path = (String)object.get("path");
				CompAttachRel compatt = new CompAttachRel();
				compatt.setId(globalIdService.getGlobalId().toString());
				compatt.setAttaUrl(path);
				compatt.setCompBaseId(Long.parseLong(compid));
				compatt.setRelType("5");
				compatt.setUrlKey(key);
				companyService.saveAttach(compatt);
				//对数据库中的图片进行删除
				obj.put("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				obj.put("success", false);
			}
	}
}
