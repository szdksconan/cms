package com.cms.iservice.shengchan;

import java.util.List;

import com.cms.model.shengchang.CompAttachRel;
import com.cms.model.shengchang.CompBaseInfo;
import com.cms.model.shengchang.CompContactInfo;
import com.cms.model.shengchang.CompSaleRule;
import com.cms.model.shengchang.CompSaleRuleArea;
import com.cms.model.shengchang.CompSuppliers;
import com.cms.model.shengchang.CompanyToOutBean;
import com.cms.model.shengchang.CompanyAreaProvince;
import com.cms.model.util.PageFilter;

/**
 * 企业信息接口
 * @author weibo
 *
 */
public interface CompanyService {
	/**
	 * 根据企业id获取企业基本信息
	 * @param id
	 * @return
	 */
	public CompBaseInfo getCompanyInfoById(String id);
	/**
	 * 查询所有企业基本信息
	 * @return
	 */
	public List getAllCompanyInfo();
	/**
	 * 根据企业id获取企业附件信息
	 * @param id
	 * @return
	 */
	public List getAttachInfoById(String id);
	/**
	 * 根据企业id获取企业联系人信息
	 * @param id
	 * @return
	 */
	public List getContactInfoById(String compid);
	
	
	public CompContactInfo getContactById(String id,String compid);
	
	/**
	 * 根据企业id获取企业门户信息封装成CompanyToOutBean
	 * 推送给贸易平台或消费平台
	 * @param id
	 * @return
	 */
	public CompanyToOutBean getOutBeanById(String id);
	/**
	 * 获取企业门户信息封装成List<CompanyToOutBean>
	 * 推送给贸易平台或消费平台
	 * @return
	 */
	/*public List getAllOutBeanList();*/
	
	
	public void saveContact(CompContactInfo contact);
	
	public void deleteContactById(String id,String compid);
	public void saveAttach(CompAttachRel atta);
	public void deleteAttachById(String id,String compid);
	
	public void updateCompBase(CompBaseInfo comp);
	
	int updateBaseInfo(CompBaseInfo compBaseInfo);
	
	int updateJiagong(CompBaseInfo compBaseInfo);
	
	int updateAttach(CompAttachRel record);
	
	public void saveSaleRule(CompSaleRule rule);
	
	public void saveSaleRuleArea(CompSaleRuleArea area);
	
	
	public List<CompSaleRuleArea> getRuleAreaByRuleId(String ruleid);
	
	public void delSaleRule(String ruleId,String compid);
	
	public void delSaleRuleArea(String ruleId);
	
	public List<CompSaleRule> getSaleRuleByCompId(String compid);
	
	public CompSaleRule getSaleRuleById(String ruleid,String compid);
	
	public void deleteAttachByCompId(String compid,String relType);
	
	public CompAttachRel getCompAttachRel(String attachId,String compid);
	
	public CompAttachRel getAttaByPkId(String id,String compid);
	
	public void updateSaleRule(CompSaleRule rule);
	public void updateSaleRuleArea(CompSaleRuleArea area);
	
	public List<CompSaleRule> getSaleRuleByCond(CompSaleRule rule);
	
	public List pageSupplier(PageFilter pageFileter, CompBaseInfo compBaseInfo,String supplierRelationship,String supplierType); 
	/**
	 * 根据当前生产企业的id 获得相关供应商的信息
	 * @param compId 生产企业id
	 * @param supplierRelationship 供应商类型可以是（自荐、合作中、关注）
	 * @return
	 */
	public List getAllSupplierIdByCompId(String compId,String supplierRelationship,String applyType);
	/**
	 * 根据供应商id和供应商关系获得对应的交易次数 和交易总额
	 * @param compId
	 * @param supplierRelationship
	 * @return
	 */
	public CompSuppliers getCompSuppliers(String compId,String supplierRelationship,String applyType);
	/**
	 * 封装所有的数据到一个模型中
	 * @param pageFileter
	 * @param compBaseInfo
	 * @param supplierRelationship
	 * @return
	 */
	public List<CompBaseInfo> pageAllSupliers(PageFilter pageFileter, CompBaseInfo compBaseInfo,String supplierRelationship,String supplierType);
	/**
	 * 获取当前条件下 满足条件的总数
	 * @param compBaseInfo
	 * @param string
	 * @return
	 */
	public int getSupplierTotal(CompBaseInfo compBaseInfo, String relationship,String supplierType);
	/**
	 *  删除供应商关系
	 * @param id
	 */
	public void deleteSupplier(String id);
	
	public List<CompSuppliers> getEnterpriseInfo(String supplierRelationship,String applyType,PageFilter pageFileter, CompBaseInfo compBaseInfo);
	
	public int getTotalSupplierMaoyi(String supplierRelationship,String applyType,CompBaseInfo compBaseInfo);
	/**
	 * 根据身份id 获取到 具体的省份
	 * @param ppid
	 * @return
	 */
	public CompanyAreaProvince getProvince(String appid);
}
