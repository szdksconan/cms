package com.cms.dao.shengchan;

import com.cms.mapper.shengchan.PurchaseIntentMapper;
import com.cms.model.shengchang.PurchaseIntentAreaBean;
import com.cms.model.shengchang.PurchaseIntentBean;
import com.cms.model.util.Grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by liuxin on 2016/5/13.
 */
@Component
public class PurchaseIntentDaoImpl implements PurchaseIntentDao{
    @Autowired
    private PurchaseIntentMapper purchaseIntentMapper;

    public void savePurchaseIntent(PurchaseIntentBean purchaseIntentBean) {
        this.purchaseIntentMapper.savePurchaseIntent(purchaseIntentBean);
    }

    public Grid getPurchaseIntentList(PurchaseIntentBean purchaseIntentBean) {
        Grid grid = new Grid();
        List<PurchaseIntentBean> purchaseIntentBeanList = this.purchaseIntentMapper.getPurchaseIntentList(purchaseIntentBean);
        for (PurchaseIntentBean bean:purchaseIntentBeanList){
            PurchaseIntentAreaBean purchaseIntentAreaBean = new PurchaseIntentAreaBean();
            purchaseIntentAreaBean.setPurchaseIntentId(bean.getId());
            Map map = this.purchaseIntentMapper.getPurchaseIntentAreaList(purchaseIntentAreaBean);
            if (map != null){
                bean.setSourceId(map.get("courceId").toString());
                bean.setSourceName(map.get("courceName").toString());
            }
        }
        grid.setRows(purchaseIntentBeanList);
        grid.setTotal(this.purchaseIntentMapper.getPurchaseIntentListCot(purchaseIntentBean));
        return grid;
    }

    public void delPurchaseIntent(PurchaseIntentBean purchaseIntentBean) {
        this.purchaseIntentMapper.delPurchaseIntent(purchaseIntentBean);
    }

    public void delPurchaseIntentArea(PurchaseIntentBean purchaseIntentBean) {
        this.purchaseIntentMapper.delPurchaseIntentArea(purchaseIntentBean);
    }

    public void savePurchaseIntentArea(List<PurchaseIntentAreaBean> purchaseIntentAreaBeanList) {
        this.purchaseIntentMapper.savePurchaseIntentArea(purchaseIntentAreaBeanList);
    }
}
