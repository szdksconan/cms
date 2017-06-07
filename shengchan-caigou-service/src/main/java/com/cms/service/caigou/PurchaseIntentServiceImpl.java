package com.cms.service.caigou;

import com.cms.dao.shengchan.PurchaseIntentDao;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.PurchaseIntentService;
import com.cms.model.shengchang.PurchaseIntentAreaBean;
import com.cms.model.shengchang.PurchaseIntentBean;
import com.cms.model.util.GlobalUtil;
import com.cms.model.util.Grid;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxin on 2016/5/13.
 */
public class PurchaseIntentServiceImpl implements PurchaseIntentService{
    @Autowired
    private PurchaseIntentDao purchaseIntentDao;
    @Autowired
    private GlobalIdService globalIdService;

    private void buildPurchaseIntent(PurchaseIntentBean purchaseIntentBean){
        String _intentId = this.globalIdService.getGlobalId().toString();
        if (purchaseIntentBean.getId()==null || "".equals(purchaseIntentBean.getId())){
            purchaseIntentBean.setId(_intentId);
        }
        purchaseIntentBean.setCreateTime(GlobalUtil.getCreateTime());
        purchaseIntentBean.setDeleteFlag(false);
        String[] _areaArrayId = purchaseIntentBean.getSourceId().split(",");
        String[] _areaArrayName = purchaseIntentBean.getSourceName().split(",");
        List<PurchaseIntentAreaBean> purchaseIntentAreaBeanList = new ArrayList<PurchaseIntentAreaBean>();
        for(int i=0;i<_areaArrayId.length;i++){
            if (!"".equals(_areaArrayId[i])){
                String[] _areaCode = _areaArrayId[i].split("-");
                String[] _areaName = _areaArrayName[i].split("-");
                if (!"".equals(_areaCode[0])){
                    PurchaseIntentAreaBean purchaseIntentAreaBean = new PurchaseIntentAreaBean();
                    purchaseIntentAreaBean.setId(this.globalIdService.getGlobalId().toString());
                    purchaseIntentAreaBean.setPurchaseIntentId(purchaseIntentBean.getId());
                    switch (_areaCode.length){
                        case 1:
                            purchaseIntentAreaBean.setProvinceId(_areaCode[0] == null ? "" : _areaCode[0]);
                            purchaseIntentAreaBean.setProvinceName(_areaName[0] == null?"":_areaName[0]);
                            break;
                        case 2:
                            purchaseIntentAreaBean.setProvinceId(_areaCode[0] == null ? "" : _areaCode[0]);
                            purchaseIntentAreaBean.setProvinceName(_areaName[0] == null?"":_areaName[0]);
                            purchaseIntentAreaBean.setCityId(_areaCode[1] == null ? "" : _areaCode[1]);
                            purchaseIntentAreaBean.setCityName(_areaName[1] == null?"":_areaName[1]);
                            break;
                        case 3:
                            purchaseIntentAreaBean.setProvinceId(_areaCode[0] == null ? "" : _areaCode[0]);
                            purchaseIntentAreaBean.setProvinceName(_areaName[0] == null?"":_areaName[0]);
                            purchaseIntentAreaBean.setCityId(_areaCode[1] == null ? "" : _areaCode[1]);
                            purchaseIntentAreaBean.setCityName(_areaName[1] == null?"":_areaName[1]);
                            purchaseIntentAreaBean.setAreaId(_areaCode[2] == null ? "" : _areaCode[2]);
                            purchaseIntentAreaBean.setAreaName(_areaName[2] == null?"":_areaName[2]);
                            break;
                    }
                    purchaseIntentAreaBeanList.add(purchaseIntentAreaBean);
                }
            }
        }
        purchaseIntentBean.setPurchaseIntentAreaBeanList(purchaseIntentAreaBeanList);
    }

    public void savePurchaseIntent(PurchaseIntentBean purchaseIntentBean) {
        this.buildPurchaseIntent(purchaseIntentBean);
        this.purchaseIntentDao.delPurchaseIntentArea(purchaseIntentBean);
        if (purchaseIntentBean.getPurchaseIntentAreaBeanList().size()!=0){
            this.purchaseIntentDao.savePurchaseIntentArea(purchaseIntentBean.getPurchaseIntentAreaBeanList());
        }
        this.purchaseIntentDao.savePurchaseIntent(purchaseIntentBean);
    }

    public Grid getPurchaseIntentList(PurchaseIntentBean purchaseIntentBean) {
        return this.purchaseIntentDao.getPurchaseIntentList(purchaseIntentBean);
    }

    public void delPurchaseIntent(PurchaseIntentBean purchaseIntentBean) {
        this.purchaseIntentDao.delPurchaseIntent(purchaseIntentBean);
    }
}
