package com.cms.dao.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.shengchan.*;
import com.cms.model.shengchang.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CompanyDaoImpl implements CompanyDao {
	@Autowired
	private CompBaseInfoMapper compBaseInfoMapper;
	@Autowired
	private CompAttachRelMapper compAttachRelMapper;
	@Autowired
	private CompContactInfoMapper compContactInfoMapper;
	
	@Autowired
	private CompSaleRuleMapper compSaleRuleMapper;
	@Autowired
	private CompSaleRuleAreaMapper compSaleRuleAreaMapper;
	@Autowired
	private CompSuppliersMapper compSuppliersMapper;
	
	@Autowired
	private CompanyAreaProvinceMapper areaProvinceMapper;
	
	/**
	 * 根据主键获取企业基本信息
	 */
	public CompBaseInfo getById(String id) {
		return compBaseInfoMapper.selectByPrimaryKey(Long.parseLong(id));
	}
	/**
	 * 根据企业id获取企业联系人信息
	 */
	public List getCompContactInfo(String compid) {
		return compContactInfoMapper.selectByCompId(Long.parseLong(compid));
		
	}
	/**
	 * 根据企业id获取企业附件信息
	 */
	public List getCompAttachInfo(String compid) {
		return compAttachRelMapper.selectByCompId(Long.parseLong(compid));
	}
	/**
	 * 获取所有企业基本信息
	 */
	public List getAllCompanyInfo() {
		return compBaseInfoMapper.getAllCompany();
	}
	public void insertContact(CompContactInfo contact) {
		compContactInfoMapper.insert(contact);
		
	}
	public void updateContact(CompContactInfo contact) {
		compContactInfoMapper.updateByPrimaryKeySelective(contact);
		
	}
	public CompContactInfo getContactById(long id) {
		return compContactInfoMapper.selectByPrimaryKey(id);
		
	}
	public void deleteContactById(long id) {
		compContactInfoMapper.deleteByPrimaryKey(id);
		
	}
	public void saveAttach(CompAttachRel atta) {
		compAttachRelMapper.insert(atta);
		
	}
	public void deleteAttachById(long id) {
		compAttachRelMapper.deleteByPrimaryKey(id);
		
	}
	public void updateCompBase(CompBaseInfo comp) {
		compBaseInfoMapper.updateByPrimaryKeySelective(comp);
		
	}
	public int updateBaseInfo(CompBaseInfo compBaseInfo) {
		return compBaseInfoMapper.updateBaseInfo(compBaseInfo);
	}
	public int updateJiagong(CompBaseInfo compBaseInfo) {
		// TODO Auto-generated method stub
		return compBaseInfoMapper.updateJiagong(compBaseInfo);
	}
	public int updateAttach(CompAttachRel record) {
		// TODO Auto-generated method stub
		return compAttachRelMapper.updateAttach(record);
	}
	public void saveSaleRule(CompSaleRule rule) {
		compSaleRuleMapper.insert(rule);
		
	}
	public void saveSaleRuleArea(CompSaleRuleArea area) {
		compSaleRuleAreaMapper.insert(area);
		
	}
	
	public void delSaleRule(String ruleId) {
		compSaleRuleMapper.deleteByPrimaryKey(Long.parseLong(ruleId));
		
	}
	public void delRuleAreaBySaleId(String saleId) {
		compSaleRuleAreaMapper.delRuleBySaleId(Long.parseLong(saleId));
		
	}
	public List<CompSaleRule> getSaleRuleByCompId(String compid) {
		// TODO Auto-generated method stub
		return compSaleRuleMapper.getSaleRuleByCompId(Long.parseLong(compid));
	}
	
	public CompSaleRule getSaleRuleById(String ruleid) {
		return compSaleRuleMapper.selectByPrimaryKey(Long.parseLong(ruleid));
	}
	public void deleteAttachByCompId(String compid, String relType) {
		compAttachRelMapper.delByCompIdAndType(compid,relType);
		
	}
	public CompAttachRel getAttaByPkId(String id) {
		// TODO Auto-generated method stub
		return compAttachRelMapper.selectByPrimaryKey(Long.parseLong(id));
	}
	public CompAttachRel getCompAttachRel(String attachId) {
		// TODO Auto-generated method stub
		return compAttachRelMapper.selectByPrimaryKey(Long.parseLong(attachId));
	}
	public List<CompSaleRuleArea> getRuleAreaByRuleId(String ruleid) {
		// TODO Auto-generated method stub
		return compSaleRuleAreaMapper.getSaleAreaByRuleId(Long.parseLong(ruleid));
	}
	public void updateSaleRule(CompSaleRule rule) {
		compSaleRuleMapper.updateByPrimaryKey(rule);
		
	}
	public void updateSaleRuleArea(CompSaleRuleArea area) {
		compSaleRuleAreaMapper.updateByPrimaryKey(area);
		
	}
	public List<CompSaleRule> getSaleRuleByCond(CompSaleRule rule){
		return compSaleRuleMapper.getSaleRuleByCond(rule);
	}
	public void deleteCompAttachRelByType(String compid,String relType) {
		compAttachRelMapper.delByCompIdAndType(compid, relType);
	}
	public List<CompAttachRel> getAttachByCompidAndType(CompAttachRel rel) {
		// TODO Auto-generated method stub
		return compAttachRelMapper.getAttachByCompidAndType(rel);
	}
	public CompSaleRuleArea getSaleRuleAreaById(String id) {
		return compSaleRuleAreaMapper.selectByPrimaryKey(Long.parseLong(id));
	}
	public void delSaleRuleAreaById(String id) {
		compSaleRuleAreaMapper.deleteByPrimaryKey(Long.parseLong(id));
		
	}
	public List pageSupplier(JSONObject obj) {
		// TODO Auto-generated method stub
		return compBaseInfoMapper.pageSupplier(obj);
	}
	public List getAllSupplierIdByCompId(JSONObject obj) {
		// TODO Auto-generated method stub
		return compSuppliersMapper.getAllSupplierIdByCompId(obj);
	}
	public CompSuppliers getCompSuppliers(JSONObject obj) {
		// TODO Auto-generated method stub
		return compSuppliersMapper.getCompSuppliers(obj);
	}
	public int getSupplierTotal(JSONObject obj) {
		// TODO Auto-generated method stub
		
		return compBaseInfoMapper.getSupplierTotal(obj);
	}
	public void deleteSupplier(String id) {
		// TODO Auto-generated method stub
		compSuppliersMapper.deleteByPrimaryKey(Long.parseLong(id));
	}
	public List<CompSuppliers> getEnterpriseInfo(JSONObject obj) {
		// TODO Auto-generated method stub
		return compSuppliersMapper.getEnterpriseInfo(obj);
	}
	public int getTotalSupplierMaoyi(JSONObject obj) {
		
		return compSuppliersMapper.getTotalSupplierMaoyi(obj);
	}
	public CompanyAreaProvince getProvince(String aapid) {
		// TODO Auto-generated method stub
		return areaProvinceMapper.selectByPrimaryKey(aapid);
	}
	
}
