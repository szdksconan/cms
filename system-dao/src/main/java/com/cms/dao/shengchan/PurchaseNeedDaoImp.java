package com.cms.dao.shengchan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.dict.AreaCommonMapper;
import com.cms.mapper.shengchan.PurchaseNeedMapper;
import com.cms.model.dict.AreaCity;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductBean;
import com.cms.model.shengchang.ProductPriceBean;
import com.cms.model.shengchang.PurchaseNeedBean;
import com.cms.model.shengchang.PurchaseNeedDetailBean;
import com.cms.model.shengchang.PurchaseNeedDetailDocBean;
import com.cms.model.shengchang.PurchaseNeedLinkman;
import com.cms.model.shengchang.PurchaseNeedRuleAreaBean;
import com.cms.model.shengchang.PurchaseNeedRuleBean;
import com.cms.model.util.GlobalTypeEnum;
import com.cms.model.util.Grid;

/**
 * Created by liuxin on 2016/4/5.
 */

@Component
public class PurchaseNeedDaoImp implements PurchaseNeedDao{
   
	
	@Autowired
	private PurchaseNeedMapper purchaseNeedMapper;
	
	@Autowired
	private AreaCommonMapper areaCommonMapper;


    public Grid getPurchaseIntentList() {
        Grid grid = new Grid();
        List list = new ArrayList();
        list.add("123123");
        grid.setRows(list);
        return grid;
    }


	public List getPurchaseNeedList(PurchaseNeedBean purchaseNeedBean) {
		return this.purchaseNeedMapper.getPurchaseNeedList(purchaseNeedBean);
	}

	public void delPurchaseNeedById(String id) {
		this.purchaseNeedMapper.delPurchaseNeedById(id);
	}
	
	public int getPurchaseNeedListNum(PurchaseNeedBean purchaseNeedBean){
		return this.purchaseNeedMapper.getPurchaseNeedListNum(purchaseNeedBean);
	}
	
	public PurchaseNeedBean getPurchaseNeedById(String id){
		return this.purchaseNeedMapper.getPurchaseNeedById(id);
	}


	public void editPurchaseNeedMain(PurchaseNeedBean purchaseNeedBean) {
		
		this.purchaseNeedMapper.editPurchaseNeedMain(purchaseNeedBean);
	
	}


	public void addPurchaseNeedLinkman(PurchaseNeedLinkman purchaseNeedLinkman) {
		
		this.purchaseNeedMapper.addPurchaseNeedLinkman(purchaseNeedLinkman);
	
	}


	public void delAllPurchaseNeedLinkman(String purchaseNeedId) {
		
		this.purchaseNeedMapper.delAllPurchaseNeedLinkman(purchaseNeedId);
		
	}


	public void addPurchaseNeedRuleBean(PurchaseNeedRuleBean purchaseNeedRuleBean) {
	
		this.purchaseNeedMapper.addPurchaseNeedRuleBean(purchaseNeedRuleBean);
		
	}


	public void editPurchaseNeedRuleBean(PurchaseNeedRuleBean purchaseNeedRuleBean) {
	
		this.purchaseNeedMapper.editPurchaseNeedRuleBean(purchaseNeedRuleBean);
		
	}


	public void addPurchaseNeedDetailBean(PurchaseNeedDetailBean purchaseNeedDetailBean) {
		
		this.purchaseNeedMapper.addPurchaseNeedDetailBean(purchaseNeedDetailBean);
		
	}


	public void delAllPurchaseNeedDetailBean(String purchaseNeedId) {
		
		this.purchaseNeedMapper.delAllPurchaseNeedDetailBean(purchaseNeedId);
		
	}


	public void addPurchaseNeedMain(PurchaseNeedBean purchaseNeedBean) {
		
		this.purchaseNeedMapper.addPurchaseNeedMain(purchaseNeedBean);
		
	}
	
	
    /**
     * 得到相关采购规则信息
     * @param id
     * @return
     */
    public PurchaseNeedRuleBean getPurchaseNeedRuleBeanById(String id){
    	
    	return this.purchaseNeedMapper.getPurchaseNeedRuleBeanById(id);
    	
    }
    
    /**
     * 得到相关物资明细列表
     * @param pid
     * @return
     */
    public List<PurchaseNeedDetailBean> getPurchaseNeedDetailBeanByPid(String pid){
    	
    	return this.purchaseNeedMapper.getPurchaseNeedDetailBeanByPid(pid);
    	
    }
    
    /**
     * 得到相关联系人信息列表
     * @param purchaseNeedId
     * @return
     */
    public List<PurchaseNeedLinkman> getPurchaseNeedLinkmanByPurchaseNeedId(String purchaseNeedId){
    	
    	return this.purchaseNeedMapper.getPurchaseNeedLinkmanByPurchaseNeedId(purchaseNeedId);
    	
    }


	public List<PurchaseNeedDetailDocBean> getPurchaseNeedDetailDocBeanByPid(String pid) {
		
		return this.purchaseNeedMapper.getPurchaseNeedDetailDocBeanByPid(pid);
		
	}


	public void addPurchaseNeedDetailDocBean(
			PurchaseNeedDetailDocBean purchaseNeedDetailDocBean) {
		
		this.purchaseNeedMapper.addPurchaseNeedDetailDocBean(purchaseNeedDetailDocBean);
		
	}


	public void delPurchaseNeedDetailDocBeanByPid(String pid) {
		
		this.purchaseNeedMapper.delPurchaseNeedDetailDocBeanByPid(pid);
		
	}

    public Grid getPurchaseNeedDetail(PurchaseNeedDetailBean purchaseNeedDetailBean) {
        Grid grid = new Grid();
        List<PurchaseNeedDetailBean> detailList = this.purchaseNeedMapper.getPurchaseNeedDetail(purchaseNeedDetailBean);
        for (PurchaseNeedDetailBean bean:detailList){
            bean.setNeedDetailDoc(this.purchaseNeedMapper.getPurchaseNeedDetailDocBeanByPid(bean.getId()));
        }
        grid.setRows(detailList);
        grid.setTotal(this.purchaseNeedMapper.getPurchaseNeedDetailCot(purchaseNeedDetailBean));
        return grid;
    }

    public List getProductTypeCot() {
        List<Map> typeList = GlobalTypeEnum.getListByTeamId(11);
        List<Map> list = new ArrayList<Map>();
        for (Map map:typeList){
            PurchaseNeedDetailBean purchaseNeedDetailBean = new PurchaseNeedDetailBean();
            purchaseNeedDetailBean.setNeedDetailNo(map.get("code").toString());
            Map _map = new HashMap();
            _map.put("code",map.get("code").toString());
            _map.put("cot",this.purchaseNeedMapper.getProductTypeCot(purchaseNeedDetailBean));
            list.add(_map);
        }
        return list;
    }

    public void delPurchaseNeedRuleBean(String id) {
		this.purchaseNeedMapper.delPurchaseNeedRuleBean(id);
	}


	public void addPurchaseNeedRuleArea(PurchaseNeedRuleAreaBean purchaseNeedRuleAreaBean) {
		
		this.purchaseNeedMapper.addPurchaseNeedRuleArea(purchaseNeedRuleAreaBean);
	}


	public void delPurchaseNeedRuleArea(String ruleId) {
		
		this.purchaseNeedMapper.delPurchaseNeedRuleArea(ruleId);
		
	}


	public List<PurchaseNeedRuleAreaBean> getPurchaseNeedRuleAreaBeanBy(PurchaseNeedRuleAreaBean purchaseNeedRuleAreaBean) {
	
		return 	this.purchaseNeedMapper.getPurchaseNeedRuleAreaBeanBy(purchaseNeedRuleAreaBean);
	}


	public Set getPurchaseNeedDetailBeanByArea(List areaList,String orderStr) {
		
		HashSet set = new HashSet();
		
		//循环遍历来源地List
		for(int i=0;i<areaList.size();i++){
			
			String aacid = String.valueOf(areaList.get(i));
			
			AreaCity city = this.areaCommonMapper.getCityById(aacid);
			
			String areaId = city.getId();
			
			String cityId = city.getAalcid();
			
			String provinceId = city.getApid();
			
			JSONObject json = new JSONObject();
			
			//组装参数
			json.put("areaId", areaId);
			
			List<PurchaseNeedRuleBean> ruleListArea = this.purchaseNeedMapper.getPurchaseNeedRuleBeanByFilter(json);
			
			//遍历写进set
			for(PurchaseNeedRuleBean purchaseNeedRuleBean : ruleListArea){
				
				set.add(purchaseNeedRuleBean.getId());
				
			}
			
			//移除areaId查询上一级
			json.remove("areaId");
			
			json.put("cityId", cityId);
			
			List<PurchaseNeedRuleBean> ruleListCity = this.purchaseNeedMapper.getPurchaseNeedRuleBeanByFilter(json); 
			
			//遍历写进set
			for(PurchaseNeedRuleBean purchaseNeedRuleBean : ruleListCity){
				
				set.add(purchaseNeedRuleBean.getId());
				
			}
			
			//移除cityId查询上一级
			json.remove("cityId");
			
			json.put("provinceId", provinceId);
			
			List<PurchaseNeedRuleBean> ruleListProvince = this.purchaseNeedMapper.getPurchaseNeedRuleBeanByFilter(json); 
			
			//遍历写进set
			for(PurchaseNeedRuleBean purchaseNeedRuleBean : ruleListProvince){
				
				set.add(purchaseNeedRuleBean.getId());
				
			}
			
		}
			
		JSONObject json2 = new JSONObject();
		
		json2.put("list", set);
		
		json2.put("orderStr", orderStr);

		List<PurchaseNeedDetailBean> detailList = this.purchaseNeedMapper.getPurchaseNeedDetailBeanByFilter(json2);
		
		//返回结果集
		HashSet outSet = new HashSet();
		
		for(PurchaseNeedDetailBean purchaseNeedDetailBean : detailList){
						
			outSet.add(purchaseNeedDetailBean.getId()+","+purchaseNeedDetailBean.getCreateTime());

		}
		
		return outSet;
	
	}

	
	public Set getPurchaseNeedDetailBeanByMantr(List filter,String companyId,String orderStr) {
		
		HashSet set = new HashSet();
		
		JSONObject json = new JSONObject();
		
		json.put("filter", filter);
		
		json.put("companyId", companyId);
		
		json.put("orderStr", orderStr);
		
		List<PurchaseNeedDetailBean> detailList = this.purchaseNeedMapper.getPurchaseNeedDetailBeanByMantr(json);
		
		for(PurchaseNeedDetailBean purchaseNeedDetailBean : detailList){
			
			set.add(purchaseNeedDetailBean.getId()+","+purchaseNeedDetailBean.getCreateTime());
		}
		
		return set;
	}
	
    public Set getProductBeanByMantr(List filter,String orderStr){
    	
    	HashSet set = new HashSet();
    	
		JSONObject json = new JSONObject();
		
		JSONObject json2 = new JSONObject();
		
		json.put("filter", filter);
		
		List<MainProductBean> mainProductList = this.purchaseNeedMapper.getMainProductBeanByMantr(json);
		
		List idList = new ArrayList();
		
		for(MainProductBean mainProductBean : mainProductList){
			
			idList.add(mainProductBean.getId());
		}
		
		json2.put("filter", idList);
		
		json2.put("orderStr", orderStr);
		
		List<ProductBean> productList = this.purchaseNeedMapper.getProductBeanByMantr(json2);
		
		for(ProductBean productBean : productList){
			
			set.add(productBean.getId()+","+productBean.getCreateTime());
		}
		
		return set;
    }
    
    
    public Set getProductBeanByArea(List filter,String orderStr){
    	
    	HashSet set = new HashSet();
    	
		JSONObject json = new JSONObject();
		
		JSONObject json2 = new JSONObject();
		
		json.put("filter", filter);
		
		List<MainProductBean> mainProductList = this.purchaseNeedMapper.getMainProductBeanByArea(json);
		
	
		
		if(mainProductList.size() > 0){
			
			List idList = new ArrayList();
			
			for(MainProductBean mainProductBean : mainProductList){
				
				idList.add(mainProductBean.getId());
			}
			
			json2.put("filter", idList);
			
			json2.put("orderStr", orderStr);
		
			List<ProductBean> productList = this.purchaseNeedMapper.getProductBeanByMantr(json2);
			
			for(ProductBean productBean : productList){
				
				set.add(productBean.getId()+","+productBean.getCreateTime());
			}
		
		}
		
		return set;
    }
    
    
    public Set getCompanyIdByMantr(List filter,String orderStr){
     	
    	HashSet set = new HashSet();
    	
    	JSONObject json = new JSONObject();
    		
    	json.put("filter", filter);
    		
    	json.put("orderStr", orderStr);
    
    	List<MainProductBean> mainProductList = this.purchaseNeedMapper.getMainProductBeanByMantr(json);
    	
    	for(MainProductBean mainProductBean : mainProductList){
    		
    		set.add(mainProductBean.getCompanyId());
    	}
    	
    	return set;
    }


	public Set getCompanyIdByArea(List filter,String orderStr) {
		
		HashSet set = new HashSet();
		
    	JSONObject json = new JSONObject();
    		
    	json.put("filter", filter);
    		
    	json.put("orderStr", orderStr);
    
    	List<ProductBean> productBeanList = this.purchaseNeedMapper.getProductBeanByArea(json);
    	
    	for(ProductBean productBean : productBeanList){
    		
    		set.add(productBean.getCompanyId());
    	}
		
		return set;
	}


	public Set getCompanyIdBySaleArea(List filter, String orderStr) {
	
		HashSet set = new HashSet();
		
    	JSONObject json = new JSONObject();
    		
    	json.put("filter", filter);
    		
    	json.put("orderStr", orderStr);
    
    	List<MainProductBean> mainProductBeanList = this.purchaseNeedMapper.getCompanyIdBySaleArea(json);
    	
    	for(MainProductBean mainProductBean : mainProductBeanList){
    		
    		set.add(mainProductBean.getCompanyId());
    	}
		
		return set;
	}


	public List<ProductPriceBean> getProductPriceByProductIdAndAreaId(String  productId,String area) {
		
    	JSONObject json = new JSONObject();
		
    	json.put("productId", productId);
    		
    	json.put("areaId", area);
		
		return this.purchaseNeedMapper.getProductPriceByProductIdAndAreaId(json);
	}





}
