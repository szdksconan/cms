package com.cms.dao.shengchan;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.shengchang.CompAttachRel;
import com.cms.model.shengchang.CompBaseInfo;
import com.cms.model.shengchang.CompContactInfo;
import com.cms.model.shengchang.CompSaleRule;
import com.cms.model.shengchang.CompSaleRuleArea;
import com.cms.model.shengchang.CompSuppliers;
import com.cms.model.shengchang.CompanyAreaProvince;

/**
 * 企业信息dao
 * @author weibo
 *
 */
public interface CompanyDao {
	/**
	 * 根据企业id获取企业基本信息
	 * @param id
	 * @return
	 */
	public CompBaseInfo getById(String id);
	/**
	 * 获取所有企业基本信息
	 * @return
	 */
	public List<CompBaseInfo> getAllCompanyInfo();
	/**
	 * 根据企业id获取企业联系人信息
	 * @param compid
	 * @return
	 */
	public List getCompContactInfo(String compid);
	/**
	 * 根据企业id获取企业附件信息
	 * @param compid
	 * @return
	 */
	
	public List getCompAttachInfo(String compid);
	
	public void insertContact(CompContactInfo contact); 
	public int updateBaseInfo(CompBaseInfo compBaseInfo);
	
	public void updateContact(CompContactInfo contact); 
	
	public CompContactInfo getContactById(long id);
	
	public void deleteContactById(long id);
	
	
	public void saveAttach(CompAttachRel atta);
	
	public void deleteAttachById(long id);
	
	public void updateCompBase(CompBaseInfo comp);
	
	
	int updateJiagong(CompBaseInfo compBaseInfo);
	
	int updateAttach(CompAttachRel record);
	
	public void saveSaleRule(CompSaleRule rule);
	public void saveSaleRuleArea(CompSaleRuleArea area);
	
	public void delSaleRule(String ruleId);
	
	public void delRuleAreaBySaleId(String saleId);
	
	public List<CompSaleRule> getSaleRuleByCompId(String compid);
	
	
	public CompSaleRule getSaleRuleById(String ruleid);
	
	public void deleteAttachByCompId(String compid, String relType);
	
	public List<CompAttachRel> getAttachByCompidAndType(CompAttachRel rel);;
	public CompAttachRel getAttaByPkId(String id);
	
	public CompAttachRel getCompAttachRel(String attachId);
	
	public List<CompSaleRuleArea> getRuleAreaByRuleId(String ruleid);
	
	public void updateSaleRule(CompSaleRule rule);
	public void updateSaleRuleArea(CompSaleRuleArea area);
	
	public List<CompSaleRule> getSaleRuleByCond(CompSaleRule rule);
	
	public CompSaleRuleArea getSaleRuleAreaById(String id);
	
	public void delSaleRuleAreaById(String id);
	/**
	 * 使用这个方法获得所有的供应商信息
	 * @param obj
	 * @return
	 */
	
	public List pageSupplier(JSONObject obj);
	
	public List getAllSupplierIdByCompId(JSONObject obj);
	
	public CompSuppliers getCompSuppliers(JSONObject obj);
	
	public int getSupplierTotal(JSONObject obj);
	public void deleteSupplier(String id);
	
	public List<CompSuppliers> getEnterpriseInfo(JSONObject obj);
	public int getTotalSupplierMaoyi(JSONObject obj);
	
	public CompanyAreaProvince getProvince(String appid);
	
}
