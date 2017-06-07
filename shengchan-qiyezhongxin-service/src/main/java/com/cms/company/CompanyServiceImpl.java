package com.cms.company;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.company.util.SysUtil;
import com.cms.dao.shengchan.CompanyDao;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.CompanyService;
import com.cms.iservice.shengchan.MainProductService;
import com.cms.model.shengchang.CompAttachRel;
import com.cms.model.shengchang.CompBaseInfo;
import com.cms.model.shengchang.CompContactInfo;
import com.cms.model.shengchang.CompSaleRule;
import com.cms.model.shengchang.CompSaleRuleArea;
import com.cms.model.shengchang.CompSuppliers;
import com.cms.model.shengchang.CompanyToOutBean;
import com.cms.model.shengchang.MainDocBean;
import com.cms.model.shengchang.MainProduct;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.CompanyAreaProvince;
import com.cms.model.util.GlobalTypeEnum;
import com.cms.model.util.PageFilter;
import com.cms.service.common.redis.RedisUtil;
import com.cms.service.common.redis.SerializeUtil;

public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private MainProductService mainProductService;
	
	@Autowired 
	private GlobalIdService globalIdService;
	
	
	/**
	 * 根据企业id获取企业基本信息
	 */
	public CompBaseInfo getCompanyInfoById(String id) {
		CompBaseInfo info = (CompBaseInfo)RedisUtil.hget("CompBaseInfoList", id);
		if(info == null){
			return companyDao.getById(id);
		}
		
		return info;
		
	}
	/**
	 * 查询所有企业基本信息
	 */
	public List getAllCompanyInfo(){
		
		Map map = RedisUtil.hgetAll("CompBaseInfoList");
		List<CompBaseInfo> ls= SysUtil.MapToList(map, CompBaseInfo.class);
		if(ls.size()>0){
			return ls;
		}
		return companyDao.getAllCompanyInfo();
	}
	
	/**
	 * 根据企业id获取企业附件信息
	 */
	public List getAttachInfoById(String id) {
		
		Map map = RedisUtil.hgetAll("CompAttachRelList"+id);
		List<CompAttachRel> ls = SysUtil.MapToList(map, CompAttachRel.class);
		if(ls.size() > 0){
			return ls;
		}
		return companyDao.getCompAttachInfo(id);
		
	}
	/**
	 * 根据企业id获取企业联系人信息
	 */
	public List getContactInfoById(String id) {
		Map map = RedisUtil.hgetAll("CompContactInfoList"+id);
		List<CompContactInfo> ls = SysUtil.MapToList(map, CompContactInfo.class);
		if(ls.size()>0){
			return ls;
		}
		return companyDao.getCompContactInfo(id);
		
	}
	/**
	 * 根据企业id获取企业门户信息封装成CompanyToOutBean
	 *  推送给贸易平台或消费平台
	 */
	public CompanyToOutBean getOutBeanById(String id) {
	
		List<MainProduct> mainp=new ArrayList<MainProduct>();
		
		MainProductBean main = new MainProductBean();
		main.setCompanyId(id);
		main.setState(GlobalTypeEnum.NORMALSELL.getCode());
		
		List<MainDocBean> maindocls = null;
		CompanyToOutBean out = new CompanyToOutBean();
		
		List<MainProductBean> mplist = mainProductService.getMainProductById(main);
		
		for(int i=0;i<mplist.size();i++){
			
			MainProductBean mpbean= mplist.get(i);
			maindocls = mainProductService.getMainProductDocListByFilter(Long.parseLong(mpbean.getId()), GlobalTypeEnum.IMG.getCode()+"", "1");
			for(int k=0;k<maindocls.size();k++){
				MainDocBean mdb = maindocls.get(k);
				MainProduct mpt = new MainProduct();
				mpt.setSetIntroduce(mpbean.getSetIntroduce());
				mpt.setFileurl(mdb.getFileUrl());
				System.out.println(mpbean.getSetIntroduce());
				System.out.println(mdb.getFileUrl());
				System.out.println(mpt);
				mainp.add(mpt);
				System.out.println(mainp);
						
			}
		}
		CompBaseInfo base = getCompanyInfoById(id);
		List attach = getAttachInfoById(id);
		List contact = getContactInfoById(id);
		out.setBase(base);
		out.setAttach(attach);
		out.setContact(contact);
		out.setMainProduct(mainp);
		
		return out;
	
		
	}
	/**
	 * 获取企业门户信息封装成List<CompanyToOutBean>
	 * 推送给贸易平台或消费平台
	 */
	/*public List getAllOutBeanList() {
		
		List all = new ArrayList();
		List ls = companyDao.getAllCompanyInfo();
		
		for(int i=0;i<ls.size();i++){
			CompanyToOutBean out = new CompanyToOutBean();
			CompBaseInfo base =(CompBaseInfo)ls.get(i);
			List attach = companyDao.getCompAttachInfo(base.getCompid()+"");
			List contact = companyDao.getCompContactInfo(base.getCompid()+"");
			out.setBase(base);
			out.setAttach(attach);
			out.setContact(contact);
			all.add(out);
		}
		return all;
	 
	}*/
	public void saveContact(CompContactInfo contact) {
		long pk = 0;
		if("".equals(SysUtil.nullToString(contact.getId()))){
			pk = globalIdService.getGlobalId();
			contact.setId(pk+"");
			companyDao.insertContact(contact);
		}else{
			pk = Long.parseLong(contact.getId());
			companyDao.updateContact(contact);
		}
		CompContactInfo cont = companyDao.getContactById(pk);
		RedisUtil.hset("CompContactInfoList"+contact.getCompBaseId(), pk+"", cont);
	}
	public CompContactInfo getContactById(String id,String compid) {
		CompContactInfo cont = (CompContactInfo)RedisUtil.hget("CompContactInfoList"+compid, id);
		if(cont == null){
			CompContactInfo continfo= companyDao.getContactById(Long.parseLong(id));
			RedisUtil.hset("CompContactInfoList"+compid, id, continfo);
		}
		return cont;
	}
	public void deleteContactById(String id,String compid) {
		companyDao.deleteContactById(Long.parseLong(id));
		RedisUtil.hdel("CompContactInfoList"+compid, id);
		
	}
	public void saveAttach(CompAttachRel atta) {
		long pk = Long.parseLong(atta.getId());
		companyDao.saveAttach(atta);
		RedisUtil.hset("CompAttachRelList"+atta.getCompBaseId(), pk+"", companyDao.getAttaByPkId(pk+""));
	}
	public void deleteAttachById(String id,String compid) {
		companyDao.deleteAttachById(Long.parseLong(id));
		RedisUtil.hdel("CompAttachRelList"+compid, id);
		
	}
	public void updateCompBase(CompBaseInfo comp) {
		String pk = comp.getCompid();
		companyDao.updateCompBase(comp);
		CompBaseInfo info = companyDao.getById(pk);
		RedisUtil.hset("CompBaseInfoList", pk, info);
		
		
	}
	//对基本信息进行编辑
	public int updateBaseInfo(CompBaseInfo compBaseInfo) {
		String pk = compBaseInfo.getCompid();
		int num = companyDao.updateBaseInfo(compBaseInfo);
		CompBaseInfo info = companyDao.getById(pk);
		RedisUtil.hset("CompBaseInfoList", pk, info);
		return num;
	}
	public int updateJiagong(CompBaseInfo compBaseInfo) {
		String pk = compBaseInfo.getCompid();
		int num = companyDao.updateJiagong(compBaseInfo);
		CompBaseInfo info = companyDao.getById(pk);
		RedisUtil.hset("CompBaseInfoList", pk, info);
		return num;
	}
	public int updateAttach(CompAttachRel record) {
		// TODO Auto-generated method stub
		int num= companyDao.updateAttach(record);
		RedisUtil.hset("CompAttachRelList"+record.getCompBaseId(), record.getId()+"", companyDao.getAttaByPkId(record.getId()+""));
		return num;
	}
	public void saveSaleRule(CompSaleRule rule) {
		
		companyDao.saveSaleRule(rule);
		
		RedisUtil.hset("produce_company_CompSaleRuleList_"+rule.getCompid(), rule.getId(), companyDao.getSaleRuleById(rule.getId()));
		
	}
	public void saveSaleRuleArea(CompSaleRuleArea area) {
		companyDao.saveSaleRuleArea(area);
		RedisUtil.hset("produce_company_CompSaleRuleAreaList_"+area.getSaleId(), area.getId(), companyDao.getSaleRuleAreaById(area.getId()));
		
		
	}
	public List<CompSaleRule> getSaleRuleByCompId(String compid) {
		Map map  = RedisUtil.hgetAll("produce_company_CompSaleRuleList_"+compid);
		List<CompSaleRule> ls = SysUtil.MapToList(map, CompSaleRule.class);
		if(ls.size() >0){
			return ls;
		}
		return companyDao.getSaleRuleByCompId(compid);
	}
	public void deleteAttachByCompId(String compid, String relType) {
		CompAttachRel rel = new CompAttachRel();
		rel.setCompBaseId(Long.parseLong(compid));
		rel.setRelType(relType);
		
		List<CompAttachRel> ls = companyDao.getAttachByCompidAndType(rel);
		for(int i=0;i<ls.size();i++){
			CompAttachRel compAtta = ls.get(i);
			companyDao.deleteAttachById(Long.parseLong(compAtta.getId()));
			RedisUtil.hdel("CompAttachRelList"+compAtta.getCompBaseId(), compAtta.getId());
		}
	}
	public CompAttachRel getAttaByPkId(String id,String compid) {
		CompAttachRel rel = (CompAttachRel)RedisUtil.hget("CompAttachRelList"+compid, id);
		if(rel == null){
			return companyDao.getAttaByPkId(id);
		}
		return rel;
	}
	public CompAttachRel getCompAttachRel(String attachId,String compid) {
		CompAttachRel rel = (CompAttachRel)RedisUtil.hget("CompAttachRelList"+compid, attachId);
		if(rel == null){
			return companyDao.getCompAttachRel(attachId);
		}
		return rel;
		
	}
	public void delSaleRule(String ruleId,String compid) {
		
		companyDao.delSaleRule(ruleId);
		List<CompSaleRuleArea> ls = companyDao.getRuleAreaByRuleId(ruleId);
		for(int i=0;i<ls.size();i++){
			CompSaleRuleArea ra = ls.get(i);
			companyDao.delSaleRuleAreaById(ra.getId());
			RedisUtil.hdel("produce_company_CompSaleRuleAreaList_"+ruleId, ra.getId());
		}
		
		RedisUtil.hdel("produce_company_CompSaleRuleList_"+compid, ruleId);
		
	}
	
	public void delSaleRuleArea(String ruleId) {
		List<CompSaleRuleArea> ls = companyDao.getRuleAreaByRuleId(ruleId);
		for(int i=0;i<ls.size();i++){
			CompSaleRuleArea ra = ls.get(i);
			companyDao.delSaleRuleAreaById(ra.getId());
			RedisUtil.hdel("produce_company_CompSaleRuleAreaList_"+ruleId, ra.getId());
		}
		
	}
	public CompSaleRule getSaleRuleById(String ruleid,String compid) {
		CompSaleRule rule = (CompSaleRule)RedisUtil.hget("produce_company_CompSaleRuleList_"+compid, ruleid);
		if(rule == null){
			return companyDao.getSaleRuleById(ruleid);
		}
		return rule;
		
	}
	public List<CompSaleRuleArea> getRuleAreaByRuleId(String ruleid) {
		Map map  = RedisUtil.hgetAll("produce_company_CompSaleRuleAreaList_"+ruleid);
		List<CompSaleRuleArea> ls = SysUtil.MapToList(map, CompSaleRuleArea.class);
		if(ls.size() > 0){
			return ls;
		}
		return companyDao.getRuleAreaByRuleId(ruleid);
	}
	public void updateSaleRule(CompSaleRule rule) {
		
		companyDao.updateSaleRule(rule);
		RedisUtil.hset("produce_company_CompSaleRuleList_"+rule.getCompid(), rule.getId(), companyDao.getSaleRuleById(rule.getId()));
		
	}
	public void updateSaleRuleArea(CompSaleRuleArea area) {
		companyDao.updateSaleRuleArea(area);
		
		RedisUtil.hset("produce_company_CompSaleRuleAreaList_"+area.getSaleId(), area.getId(), companyDao.getSaleRuleAreaById(area.getId()));
		
	}
	public List<CompSaleRule> getSaleRuleByCond(CompSaleRule rule) {
		return companyDao.getSaleRuleByCond(rule);
	}
	public List pageSupplier(PageFilter pageFileter, CompBaseInfo compBaseInfo,String supplierRelationship,String supplierType) {
		JSONObject obj = new JSONObject();
		obj.put("limit", pageFileter.getLimit());
		obj.put("address", compBaseInfo.getAddress());
		obj.put("mainIndustry", compBaseInfo.getMainIndustry());
		List<CompSuppliers> ids = getAllSupplierIdByCompId(compBaseInfo.getCompid(),supplierRelationship,supplierType);
		
		obj.put("ids", ids);
		if(ids.size()==0){
			return null;
		}
		return companyDao.pageSupplier(obj);
	}
	
	public List getAllSupplierIdByCompId(String compId,String supplierRelationship,String supplierType){
		JSONObject obj = new JSONObject();
		obj.put("compId", compId);
		obj.put("supplierRelationship", supplierRelationship);
		obj.put("supplierType", supplierType);
		return companyDao.getAllSupplierIdByCompId(obj);
	}
	public CompSuppliers getCompSuppliers(String compId,String supplierRelationship,String supplierType){
		JSONObject obj = new JSONObject();
		obj.put("compId", compId);
		obj.put("supplierRelationship", supplierRelationship);
		obj.put("supplierType", supplierType);
		return companyDao.getCompSuppliers(obj);
	}
	public List<CompBaseInfo> pageAllSupliers(PageFilter pageFileter, CompBaseInfo compBaseInfo,String supplierRelationship,String supplierType){
		List<CompBaseInfo> pageSupplier = pageSupplier(pageFileter,compBaseInfo,supplierRelationship,supplierType);
		List<CompBaseInfo> rows = new ArrayList<CompBaseInfo>();
		for (CompBaseInfo compBaseInfo2 : pageSupplier) {
			CompSuppliers compSuppliers = getCompSuppliers(compBaseInfo2.getCompid(),supplierRelationship,supplierType);
			compBaseInfo2.setCompSuppliers(compSuppliers);
			rows.add(compBaseInfo2);
		}
		return rows;
	}
	public int getSupplierTotal(CompBaseInfo compBaseInfo, String relationship,String supplierType) {
		JSONObject obj = new JSONObject();
		List ids = getAllSupplierIdByCompId(compBaseInfo.getCompid(),relationship,supplierType);
		if(ids.size()==0){
			return 0;
		}
		obj.put("ids",ids);
		obj.put("address", compBaseInfo.getAddress());
		obj.put("mainIndustry", compBaseInfo.getMainIndustry());
		return companyDao.getSupplierTotal(obj);
	}
	public void deleteSupplier(String id) {
		companyDao.deleteSupplier(id);
	}
	public List<CompBaseInfo> getEnterpriseInfo(List<CompSuppliers> ids) {
		
		return null;
	}
	public List<CompSuppliers> getEnterpriseInfo(String supplierRelationship, String applyType, PageFilter pageFileter,
			CompBaseInfo compBaseInfo) {
		JSONObject obj = new JSONObject();
		obj.put("supplierRelationship", supplierRelationship);
		obj.put("compId", compBaseInfo.getCompid());
		obj.put("supplierType", applyType);
		obj.put("address", compBaseInfo.getAddress());
		obj.put("mainIndustry", compBaseInfo.getMainIndustry());
		return companyDao.getEnterpriseInfo(obj);
	}
	public int getTotalSupplierMaoyi(String supplierRelationship, String applyType, CompBaseInfo compBaseInfo) {
		JSONObject obj = new JSONObject();
		obj.put("supplierRelationship", supplierRelationship);
		obj.put("compId", compBaseInfo.getCompid());
		obj.put("supplierType", applyType);
		obj.put("address", compBaseInfo.getAddress());
		obj.put("mainIndustry", compBaseInfo.getMainIndustry());
		return companyDao.getTotalSupplierMaoyi(obj);
	}
	public CompanyAreaProvince getProvince(String appid) {
		return companyDao.getProvince(appid);
	}
	
	
	
}
