package com.cms.dao.shengchan;

import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductBean;
import com.cms.model.shengchang.ProductPriceBean;
import com.cms.model.shengchang.PurchaseNeedBean;
import com.cms.model.shengchang.PurchaseNeedDetailBean;
import com.cms.model.shengchang.PurchaseNeedDetailDocBean;
import com.cms.model.shengchang.PurchaseNeedLinkman;
import com.cms.model.shengchang.PurchaseNeedRuleAreaBean;
import com.cms.model.shengchang.PurchaseNeedRuleBean;
import com.cms.model.util.Grid;

/**
 * Created by liuxin on 2016/4/5.
 */
public interface PurchaseNeedDao {
    public Grid getPurchaseIntentList();
    
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
     * 删除交易规则
     * @param id
     */
    public void delPurchaseNeedRuleBean(String id);
    
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
    
    /**
     * 得到相关文档信息
     * @param pid
     * @return
     */
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

    public Grid getPurchaseNeedDetail(PurchaseNeedDetailBean purchaseNeedDetailBean);

    public List getProductTypeCot();
    
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
     * 根据来源地查询物资需求明细
     * @param 
     * 
     */
    public Set getPurchaseNeedDetailBeanByArea(List areaList,String orderStr);
    
   
    /**
     * 根据物资类别或者企业ID查询所有物资需求明细Id
     * @param filter 物资类别List 
     * @param companyId 公司ID
     * @param orderStr limit语句等等
     * @return
     */
    public Set getPurchaseNeedDetailBeanByMantr(List filter,String companyId,String orderStr);
    
    /**
     * 根据物资类别获取产品Id
     * @param filter 物资类别List
     * @param orderStr
     * @return
     */
    public Set getProductBeanByMantr(List filter,String orderStr);
    
    /**
     * 根据销售区域获取产品Id
     * @param filter 物资类别List
     * @param orderStr
     * @return
     */
    public Set getProductBeanByArea(List filter,String orderStr);
    
    
    /**
     * 根据物资类别获取企业ID
     * @param filter
     * @param orderStr
     * @return
     */
    public Set getCompanyIdByMantr(List filter,String orderStr);
    
    
    /**
     * 根据来源的到所有产品产地符合的企业ID
     * @param list
     * @return
     */
    public Set getCompanyIdByArea(List filter,String orderStr);
    
    /**
     * 根据实际销售区域查询企业ID
     */
    public Set getCompanyIdBySaleArea(List filter,String orderStr);
    
    public List<ProductPriceBean> getProductPriceByProductIdAndAreaId(String  productId,String area);
    
    
}
