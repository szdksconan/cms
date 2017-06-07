package com.cms.controller.company;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.CompanyService;
import com.cms.model.shengchang.CompAttachRel;
import com.cms.model.shengchang.CompBaseInfo;
import com.cms.model.shengchang.CompContactInfo;
import com.cms.model.shengchang.CompSaleRule;
import com.cms.model.shengchang.CompSaleRuleArea;
import com.cms.util.S3Operate;
import com.cms.util.SysUtil;
import com.cms.web.util.s3.S3Util;

@Controller
@RequestMapping("comp")
public class CompController {
	@Autowired
	private CompanyService companyService;
	@Autowired 
	private GlobalIdService globalIdService;
	

	/**
	 * 
	 * 
	 * @param request
	 */
	@RequestMapping("saveContact")
	@ResponseBody
	public String saveContact(CompContactInfo contact,HttpServletRequest request) {
		JSONObject obj = new JSONObject();

		try {
			companyService.saveContact(contact);
			
			obj.put("success", true);
		} catch (Exception e) {

			obj.put("success", false);
		}
		System.out.println(obj.toString());
		return obj.toString();
	}
	@RequestMapping("delContact")
	@ResponseBody
	public String delContact(String id,String compid,HttpServletRequest request) {
		JSONObject obj = new JSONObject();

		try {

			companyService.deleteContactById(id,compid);
			
			obj.put("success", true);
		} catch (Exception e) {

			obj.put("success", false);
		}
		System.out.println(obj.toString());
		return obj.toString();
	}
	@RequestMapping("updateContact")
	@ResponseBody
	public String updateContact(String id,String compid,HttpServletRequest request) {
		JSONObject obj = new JSONObject();

		try {

			CompContactInfo bean = companyService.getContactById(id,compid);
			obj.put("list", bean);
			obj.put("success", true);
		} catch (Exception e) {

			obj.put("success", false);
		}
		System.out.println(obj.toString());
		return obj.toString();
	}
	@RequestMapping("saveS3")
	@ResponseBody
	public void saveS3(String compId,MultipartFile test3,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try{

	        CommonsMultipartFile cf= (CommonsMultipartFile)test3;
	        DiskFileItem fi = (DiskFileItem)cf.getFileItem();

	        File f = fi.getStoreLocation(); 
	       Map map =  S3Util.upload(S3Util.producerBucketName, "/uploads/images/company/gongchang/"+f.getName(), f, true);
	       String path = map.get("path").toString();
	       CompAttachRel atta = new CompAttachRel();
	       atta.setAttaName(f.getName());
	       atta.setAttaUrl(path);
	       atta.setCompBaseId(Long.parseLong(compId));
	       atta.setRelType("3");
	       atta.setTypeName("工厂图片");
	       companyService.saveAttach(atta);
	       obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
		}
		
		
	}
	@RequestMapping("deleteAtta")
	@ResponseBody
	public void deleteAtta(String id,String compid,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try{

			companyService.deleteAttachById(id,compid);
	        obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
		}
		
		
	}
	@RequestMapping("updateCompBase")
	@ResponseBody
	public String updateCompBase(CompBaseInfo comp,String delFileKey,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try{
			if(!"".equals(delFileKey)){
				String[] ss = delFileKey.split(",");
				
				for(int i=0;i< ss.length;i++){
					/*CompAttachRel rel = companyService.getAttaByPkId(ss[i]);
					S3Operate.delfile(rel.getUrlKey());*/
					companyService.deleteAttachById(ss[i],comp.getCompid());
					
				}
				
			}
			
			companyService.updateCompBase(comp);
			
	        obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
		}
		return obj.toString();
		
	}
	
	@RequestMapping("uploadContactPic")
	@ResponseBody
	public String uploadContactPic(String compid,MultipartHttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try{
			
			List<MultipartFile> list = request.getFiles("upload");
			if(list.size() > 0){
				
				MultipartFile[] array = new MultipartFile[list.size()];
				for(int i=0;i<list.size();i++){
					array[i] = list.get(i);
				}
				List ls = S3Operate.fileUpload(array, "company", true);
				
				for(int i=0;i<ls.size();i++){
					
					Map m = (Map)ls.get(i);
					
					String key = (String)m.get("key");
					String path = (String)m.get("path");
					
					CompAttachRel rel = new CompAttachRel();
					rel.setId(globalIdService.getGlobalId()+"");
					
					rel.setAttaUrl(path);
					rel.setCompBaseId(Long.parseLong(compid));
					rel.setRelType("3");
					rel.setUrlKey(key);
					companyService.saveAttach(rel);
				}
			}
			
	        obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
		}
		return obj.toString();
		
	}
	
	@RequestMapping("saveSaleRule")
	@ResponseBody
	public String saveSaleRule(CompSaleRule rule,String saleArea,String saleAreaCode,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		String ruleid = rule.getId();
		try{
			if("".equals(SysUtil.nullToString(ruleid))){
				long rule_id = globalIdService.getGlobalId();
				rule.setId(rule_id+"");
				companyService.saveSaleRule(rule);
				if(!"".equals(SysUtil.nullToString(saleArea))){
					String[] sa =saleArea.split(",");
					String[] sacode =saleAreaCode.split(",");
					for(int i=0;i<sa.length;i++){
						String sheng ="";
						String city = "";
						String xian = "";
						String shengid ="";
						String cityid = "";
						String xianid = "";
						try{
							sheng = sa[i].split("-")[0];
							shengid = sacode[i].split("-")[0];
							
						}catch(ArrayIndexOutOfBoundsException e){
							
						}
						try{
							city = sa[i].split("-")[1];
							cityid = sacode[i].split("-")[1];
							
						}catch(ArrayIndexOutOfBoundsException e){
							
						}
						try{
							xian = sa[i].split("-")[2];
							xianid = sacode[i].split("-")[2];
						}catch(ArrayIndexOutOfBoundsException e){
							
						}
						
						CompSaleRuleArea area = new CompSaleRuleArea();
						area.setId(globalIdService.getGlobalId()+"");
						area.setSaleId(rule_id+"");
						area.setSheng(sheng);
						area.setCity(city);
						area.setXian(xian);
						area.setShengId(shengid);
						area.setCityId(cityid);
						area.setXianId(xianid);
						companyService.saveSaleRuleArea(area);
					}
				}
				
			}else{
				companyService.updateSaleRule(rule);
				companyService.delSaleRuleArea(ruleid);
				if(!"".equals(SysUtil.nullToString(saleArea))){
					String[] sa =saleArea.split(",");
					String[] sacode =saleAreaCode.split(",");
					for(int i=0;i<sa.length;i++){
						String sheng ="";
						String city = "";
						String xian = "";
						String shengid ="";
						String cityid = "";
						String xianid = "";
						try{
							sheng = sa[i].split("-")[0];
							shengid = sacode[i].split("-")[0];
							
						}catch(ArrayIndexOutOfBoundsException e){
							
						}
						try{
							city = sa[i].split("-")[1];
							cityid = sacode[i].split("-")[1];
							
						}catch(ArrayIndexOutOfBoundsException e){
							
						}
						try{
							xian = sa[i].split("-")[2];
							xianid = sacode[i].split("-")[2];
							
						}catch(ArrayIndexOutOfBoundsException e){
							
						}
						
						CompSaleRuleArea area = new CompSaleRuleArea();
						area.setId(globalIdService.getGlobalId()+"");
						area.setSaleId(ruleid+"");
						area.setSheng(sheng);
						area.setCity(city);
						area.setXian(xian);
						area.setShengId(shengid);
						area.setCityId(cityid);
						area.setXianId(xianid);
						companyService.saveSaleRuleArea(area);
					}
				}
			}
			
			
	        obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
		}
		return obj.toString();
		
	}

	@RequestMapping("delSaleRule")
	@ResponseBody
	public String delSaleRule(String ruleId,String compid,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try{
			
			companyService.delSaleRule(ruleId,compid);
	        obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
		}
		return obj.toString();
		
	}
	@RequestMapping("getSaleRuleById")
	@ResponseBody
	public String getSaleRuleById(String ruleId,String compid,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try{
			CompSaleRule rule = companyService.getSaleRuleById(ruleId,compid);
			List<CompSaleRuleArea> area= companyService.getRuleAreaByRuleId(ruleId);
			obj.put("rule", rule);
			obj.put("area", area);
	        obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
		}
		return obj.toString();
		
	}
	@RequestMapping("getSaleRuleTab")
	@ResponseBody
	public String getSaleRuleTab(String compId,HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		try{
			
			List<CompSaleRule> ls = companyService.getSaleRuleByCompId(compId);
			sb.append(JSONObject.toJSONString(ls));
		}catch(Exception e){
		}
		return sb.toString();
		
	}
	@RequestMapping("getSaleRuleByCond")
	@ResponseBody
	public String getSaleRuleByCond(CompSaleRule rule,HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		try{
			
			List<CompSaleRule> ls = companyService.getSaleRuleByCond(rule);
			sb.append(JSONObject.toJSONString(ls));
		}catch(Exception e){
		}
		return sb.toString();
		
	}
	@RequestMapping("uploadZiZhiPic")
	@ResponseBody
	public String uploadZiZhiPic(String compid,String delFileKey,String addFileName,MultipartHttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try{
			//上传图片
			List<MultipartFile> list = request.getFiles("zizhi");
			MultipartFile[] array = new MultipartFile[list.size()];
			for(int i=0;i<list.size();i++){
				array[i] = list.get(i);
			}
			if(list.size() > 0){
				List ls = S3Operate.fileUpload(array, "company/zizhi", true);
				
				String[] addFile = addFileName.split("\\^\\^");
				for(int i=0;i<ls.size();i++){
					
					Map m = (Map)ls.get(i);
					
					String key = (String)m.get("key");
					String path = (String)m.get("path");
					
					CompAttachRel rel = new CompAttachRel();
					rel.setId(globalIdService.getGlobalId()+"");
					
					rel.setAttaUrl(path);
					rel.setCompBaseId(Long.parseLong(compid));
					rel.setTypeName(addFile[i]);
					rel.setRelType("4");
					rel.setUrlKey(key);
					companyService.saveAttach(rel);
				}
			}
			
			
			//删除图片
			if(!"".equals(delFileKey)){
				String[] ss = delFileKey.split(",");
				
				for(int i=0;i< ss.length;i++){
					companyService.deleteAttachById(ss[i],compid);
				}
			}
	        obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
		}
		return obj.toString();
		
	}
	
	

}
	
	
	
