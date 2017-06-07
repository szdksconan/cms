package com.cms.controller.purchase;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.shengchan.PurchaseIntentService;
import com.cms.iservice.common.GlobalIdService;
import com.cms.model.shengchang.PurchaseIntentAreaBean;
import com.cms.model.shengchang.PurchaseIntentBean;
import com.cms.model.util.GlobalUtil;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 采购意向模块
 * Created by liuxin on 2016/5/12.
 */
@Controller
@RequestMapping("purchaseIntent")
public class PurchaseIntentController {
    @Autowired
    private PurchaseIntentService purchaseIntentService;

    @RequestMapping("getPurchaseIntentList")
    @ResponseBody
    public Grid getPurchaseIntentList(PageFilter pageFilter,PurchaseIntentBean purchaseIntentBean){
        purchaseIntentBean.setCompanyId("1312312313");
        if (pageFilter!=null){
            purchaseIntentBean.setOrderStr(pageFilter.getOrderString());
        }
        return this.purchaseIntentService.getPurchaseIntentList(purchaseIntentBean);
    }

    @RequestMapping("savePurchaseIntent")
    @ResponseBody
    public JSONObject savePurchaseIntent(PurchaseIntentBean purchaseIntentBean){
        JSONObject obj = new JSONObject();
        try {
            this.purchaseIntentService.savePurchaseIntent(purchaseIntentBean);
            obj.put("success",true);
            obj.put("msg","保存成功！");
        }catch (Exception e){
            obj.put("success",false);
            obj.put("msg","保存失败！");
        }
        return obj;
    }

    @RequestMapping("delPurchaseIntent")
    @ResponseBody
    public JSONObject delPurchaseIntent(PurchaseIntentBean purchaseIntentBean){
        JSONObject obj = new JSONObject();
        try {
            this.purchaseIntentService.delPurchaseIntent(purchaseIntentBean);
            obj.put("success", true);
            obj.put("msg","删除成功！");
            obj.put("data",this.purchaseIntentService.getPurchaseIntentList(purchaseIntentBean));
        }catch (Exception e){
            e.printStackTrace();
            obj.put("success",false);
            obj.put("msg","删除失败！");
        }
        return obj;
    }
}
