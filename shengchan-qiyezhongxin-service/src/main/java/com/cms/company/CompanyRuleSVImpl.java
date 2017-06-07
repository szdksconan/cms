package com.cms.company;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.company.util.SysUtil;
import com.cms.dao.shengchan.CompanyRuleDao;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.CompanyRuleSV;
import com.cms.model.shengchang.CompBuyRule;
import com.cms.model.shengchang.CompBuyRuleArea;
import com.cms.model.shengchang.CompBuyRuleBean;
import com.cms.model.shengchang.CompSaleRule;
import com.cms.model.shengchang.CompSaleRuleArea;
import com.cms.model.shengchang.CompSaleRuleBean;
import com.cms.model.util.PageFilter;
import com.cms.service.common.redis.RedisUtil;

public class CompanyRuleSVImpl implements CompanyRuleSV {
	@Autowired
	private CompanyRuleDao companyRuleDao;
	
	@Autowired 
	private GlobalIdService globalIdService;
	/**
	 * 根据采购规则id获取采购规则信息及规则适用区域信息
	 */
	public CompBuyRuleBean getBuyRuleById(String id,String compid) {
		CompBuyRuleBean bean = new CompBuyRuleBean();
		
		CompBuyRule buyrule = (CompBuyRule)RedisUtil.hget("produce_company_CompBuyRuleList_"+compid, id);
		Map map = RedisUtil.hgetAll("produce_company_CompBuyRuleAreaList_"+id);
		List<CompBuyRuleArea> ls =SysUtil.MapToList(map, CompBuyRuleArea.class);
		if(buyrule ==null ){
			CompBuyRule rule = companyRuleDao.getBuyRuleById(id);
			List<CompBuyRuleArea> area = companyRuleDao.getBuyAreaByRuleId(id);
			bean.setRule(rule);
			bean.setArea(area);
		}else{
			bean.setArea(ls);
			bean.setRule(buyrule);
		}
		
		return bean;
	}
	/**
	 * 获取所有采购规则信息
	 */
	public List<CompBuyRule> getAllBuyRule(String compid) {
		Map map= RedisUtil.hgetAll("produce_company_CompBuyRuleList_"+compid);
		List<CompBuyRule> ls = SysUtil.MapToList(map, CompBuyRule.class);
		if(ls.size() >0){
			return ls;
		}
		return companyRuleDao.getAllBuyRule();
	}
	/**
	 * 根据销售规则id获取销售规则信息及规则适用区域信息
	 */
	public CompSaleRuleBean getSaleRuleById(String id,String compid) {
		CompSaleRuleBean bean = new CompSaleRuleBean();
		CompSaleRule saleRule = (CompSaleRule)RedisUtil.hget("produce_company_CompSaleRuleList_"+compid,id);
		Map map = RedisUtil.hgetAll("produce_company_CompSaleRuleAreaList_"+id);
		List<CompSaleRuleArea> ls = SysUtil.MapToList(map, CompSaleRuleArea.class);
		
		if(saleRule == null){
			CompSaleRule rule = companyRuleDao.getSaleRuleById(id);
			List<CompSaleRuleArea> area = companyRuleDao.getSaleAreaByRuleId(id);
			bean.setRule(rule);
			bean.setArea(area);
		}else{
			bean.setRule(saleRule);
			bean.setArea(ls);
		}
		return bean;
	}
	/**
	 *  获取所有销售规则信息
	 */
	public List<CompSaleRule> getAllSaleRule(String compid) {
		// TODO Auto-generated method stub
		Map map = RedisUtil.hgetAll("produce_company_CompSaleRuleList_"+compid);
		List<CompSaleRule> ls = SysUtil.MapToList(map, CompSaleRule.class);
		if(ls.size() > 0){
			return ls;
		}
		return companyRuleDao.getAllSaleRule();
	}
	public void deleteBuyRule(String buyRuleId,String compid) {
		// TODO Auto-generated method stub
		companyRuleDao.deleteBuyRule(buyRuleId);
		RedisUtil.hdel("produce_company_CompBuyRuleList_"+compid, buyRuleId);
		
	}
	public List getBuyRuleByCompId(String compId) {
		// TODO Auto-generated method stub
		Map map = RedisUtil.hgetAll("produce_company_CompBuyRuleList_"+compId);
		List<CompBuyRule> ls = SysUtil.MapToList(map, CompBuyRule.class);
		if(ls.size() > 0){
			return ls;
		}
		return companyRuleDao.getBuyRuleByCompId(compId);
	}
	public void insertBuyRule(CompBuyRule compBuyRule) {
		Long pk = globalIdService.getGlobalId();
		compBuyRule.setId(pk+"");
		companyRuleDao.insertBuyRule(compBuyRule);
		RedisUtil.hset("produce_company_CompBuyRuleList_"+compBuyRule.getCompid(), pk+"", companyRuleDao.getBuyRuleById(pk+""));
	}
	public void updateBuyRule(CompBuyRule compBuyRule) {
		// TODO Auto-generated method stub
		companyRuleDao.updateBuyRule(compBuyRule);
		RedisUtil.hset("produce_company_CompBuyRuleList_"+compBuyRule.getCompid(), compBuyRule.getId(), companyRuleDao.getBuyRuleById(compBuyRule.getId()));
	}
	public List<CompBuyRule> pageBuyRule(PageFilter pageFilter, CompBuyRule compBuyRule) {
		JSONObject obj = new JSONObject();
		obj.put("orderString", pageFilter.getOrderString());
		obj.put("compid", compBuyRule.getCompid());
		obj.put("ruleName", compBuyRule.getRuleName());
		obj.put("applyType",compBuyRule.getApplyType());
		return companyRuleDao.pageBuyRule(obj);
	}
	public int getTotalBuyRule(CompBuyRule compBuyRule) {
		// TODO Auto-generated method stub
		return companyRuleDao.getTotalBuyRule(compBuyRule);
	}
	public void updateBuyRuleArea(CompBuyRuleArea compBuyRuleArea) {
		// TODO Auto-generated method stub
		companyRuleDao.updateBuyRuleArea(compBuyRuleArea);
		CompBuyRuleArea area=companyRuleDao.getBuyAreaById(Long.parseLong(compBuyRuleArea.getId()));
		RedisUtil.hset("produce_company_CompBuyRuleAreaList_"+compBuyRuleArea.getBuyId(),compBuyRuleArea.getId(),area);
		
	}
	public void deleteBuyRuleAreaByRuleId(String ruleId) {
		List<CompBuyRuleArea> ls = companyRuleDao.getBuyAreaByRuleId(ruleId);
		for(int i=0;i<ls.size();i++){
			CompBuyRuleArea area =ls.get(i);
			companyRuleDao.delBuyAreaById(Long.parseLong(area.getId()));
			RedisUtil.hdel("produce_company_CompBuyRuleAreaList_"+area.getBuyId(), area.getId());
		}
		
		
	}
	public List<CompBuyRuleArea> getBuyArea(String buyId) {
		// TODO Auto-generated method stub
		Map map = RedisUtil.hgetAll("produce_company_CompBuyRuleAreaList_"+buyId);
		List<CompBuyRuleArea> ls = SysUtil.MapToList(map, CompBuyRuleArea.class);
		if(ls.size() > 0){
			return ls;
		}
		return companyRuleDao.getBuyArea(buyId);
	}

    public List<CompBuyRule> getAllCompBuyRule(CompBuyRule compBuyRule) {
        return this.companyRuleDao.getAllCompBuyRule(compBuyRule);
    }

}
