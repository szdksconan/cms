package com.cms.iservice.shengchan;

import java.util.HashMap;
import java.util.List;

import com.cms.model.dict.AreaCity;
import com.cms.model.shengchang.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;

/**
 * Created by liuxin on 2016/4/5.
 */
public interface PurchaseNeedService {
    public Grid getPurchaseIntentList();
    
    /**
     * 根据查询条件得到物资需求列表
     */
    public List getPurchaseNeedList(PurchaseNeedBean purchaseNeedBean);
    
    /**
     * 根据Id删除物资需求
     */
    
    public void delPurchaseNeedById(String id);
    
    /**
     * 根据查询条件获取物资需求列表记录条数
     */
    
    public int getPurchaseNeedListNum(PurchaseNeedBean purchaseNeedBean);
    
    /**
     * 根据ID查询物资需求
     */
    public PurchaseNeedBean getPurchaseNeedById(String id);
    
    
    /**
     * 添加物资需求
     * @param purchaseNeedBean
     * @param linklist
     * @param detailist
     * @param purchaseNeedRuleBean
     */
    public void savePurchaseNeed(HashMap map);
    
    /**
     * 修改物资需求
     * @param purchaseNeedBean
     * @param linklist
     * @param detailist
     * @param purchaseNeedRuleBean
     */
    public void editPurchaseNeed(HashMap hashMap);
    
  
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
     * 获取物资需求明细
     * @return
     */
    public Grid getPurchaseNeedDetail(PurchaseNeedDetailBean purchaseNeedDetailBean);

    /**
     * 获取物资类型数量
     * @return
     */
    public List getProductTypeCot();
    
    /**
     * ids获取物资信息
     * @param l
     * @return
     */
    public List getProductByIds(List l);
    
    /**
     * 获取来源地信息
     */
    public List<AreaCity> getCityByProvinceId(HashMap map);
    
    /**
     * 获取推荐物资和前区域的推荐价格
     */
    public List<ProductPriceBean> getProductPriceByProductIdAndAreaId(String  productId,String area);
    

}
