package com.cms.mapper.shengchan;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.shengchang.*;
import com.cms.model.util.Grid;

/**
 * Created by liuxin on 2016/4/5.
 */
public interface PurchaseNeedMapper {
	
 	public List getPurchaseNeedList(PurchaseNeedBean purchaseNeedBean);
    
    public void delPurchaseNeedById(String id);
    
    public int  getPurchaseNeedListNum(PurchaseNeedBean purchaseNeedBean);
    
    public PurchaseNeedBean getPurchaseNeedById(String id);
    
    /**
     * 修改物资需求主信息
     * @param purchaseNeedBean
     */
    public void editPurchaseNeedMain(PurchaseNeedBean purchaseNeedBean);
    
    
    /**
     * 增加联系人信息
     * @param purchaseNeedLinkman
     */
    public void addPurchaseNeedLinkman(PurchaseNeedLinkman purchaseNeedLinkman);
    
    /**
     * 删除所有相关联系人
     */
    public void delAllPurchaseNeedLinkman(String purchaseNeedId);
    
    /**
     * 增加采购规则相关
     * @param purchaseNeedRuleBean
     */
    public void addPurchaseNeedRuleBean(PurchaseNeedRuleBean purchaseNeedRuleBean);
    
    /**
     * 更新采购规则相关
     * @param purchaseNeedRuleBean
     */
    public void editPurchaseNeedRuleBean(PurchaseNeedRuleBean purchaseNeedRuleBean) ;
    
    /**
     * 新增物资明细
     * @param purchaseNeedDetailBean
     */
    public  void addPurchaseNeedDetailBean(PurchaseNeedDetailBean purchaseNeedDetailBean);
    
    /**
     * 删除所有物资明细
     * @param purchaseNeedId
     */
    public void delAllPurchaseNeedDetailBean(String purchaseNeedId);
    
    /**
     * 更新物资需求主信息
     * 
     * @param purchaseNeedBean
     */
    public void addPurchaseNeedMain(PurchaseNeedBean purchaseNeedBean);
    
    /**
     * 得到相关采购规则信息
     * @param id
     * @return
     */
    public PurchaseNeedRuleBean getPurchaseNeedRuleBeanById(String id);
    
    /**
     * 得到相关物资明细列表
     * @param pid
     * @return
     */
    public List<PurchaseNeedDetailBean> getPurchaseNeedDetailBeanByPid(String pid);
    
    /**
     * 得到相关联系人信息列表
     * @param purchaseNeedId
     * @return
     */
    public List<PurchaseNeedLinkman> getPurchaseNeedLinkmanByPurchaseNeedId(String purchaseNeedId);
    
    public List<PurchaseNeedDetailDocBean> getPurchaseNeedDetailDocBeanByPid(String pid);
    
    
    /**
     * 添加文档信息
     * @param pid
     * @return
     */
    public void addPurchaseNeedDetailDocBean(PurchaseNeedDetailDocBean purchaseNeedDetailDocBean);
    
    /**
     * 删除文档信息
     * @param pid
     * @return
     */
    public void delPurchaseNeedDetailDocBeanByPid(String pid);
    
	public void delPurchaseNeedRuleBean(String id);

    public List<PurchaseNeedDetailBean> getPurchaseNeedDetail(PurchaseNeedDetailBean purchaseNeedDetailBean);

    public Integer getPurchaseNeedDetailCot(PurchaseNeedDetailBean purchaseNeedDetailBean);

    public Integer getProductTypeCot(PurchaseNeedDetailBean purchaseNeedDetailBean);
    
    
    /**
     * 新增采购规则区域信息
     */
    public void addPurchaseNeedRuleArea(PurchaseNeedRuleAreaBean purchaseNeedRuleAreaBean);
    
    /**
     * 删除采购规则区域信息
     * @param ruleId
     */
    public void delPurchaseNeedRuleArea(String ruleId);
    
    /**
     * 根据ruleId得到采购规则区域
     * @param ruleId
     * @return
     */
    public List<PurchaseNeedRuleAreaBean> getPurchaseNeedRuleAreaBeanBy(PurchaseNeedRuleAreaBean purchaseNeedRuleAreaBean);
    
    /**
     * 查询符合规则的规则信息
     */
    public List<PurchaseNeedRuleBean> getPurchaseNeedRuleBeanByFilter(JSONObject json);
    
    public List<PurchaseNeedDetailBean> getPurchaseNeedDetailBeanByFilter(JSONObject json);
    
    public List<PurchaseNeedDetailBean> getPurchaseNeedDetailBeanByMantr(JSONObject json);
    
    public List<MainProductBean> getMainProductBeanByMantr(JSONObject json);
    
    public List<MainProductBean> getMainProductBeanByArea(JSONObject json);
    
    public List<ProductBean> getProductBeanByMantr(JSONObject json);
    
    public List<ProductBean> getProductBeanByArea(JSONObject json);
    
    public List<MainProductBean> getCompanyIdBySaleArea(JSONObject json);
    
    public List<ProductPriceBean> getProductPriceByProductIdAndAreaId(JSONObject json);
	
}
