package com.cms.controller.sale;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.PurchaseTenderService;
import com.cms.iservice.shengchan.SaleBidService;
import com.cms.iservice.shengchan.ShengchanOrderIdService;
import com.cms.model.shengchang.PurchaseTenderOrder;
import com.cms.model.shengchang.SaleBidOrder;
import com.cms.model.shengchang.SaleBidOrderDetail;
import com.cms.model.util.GlobalOrderTypeEnum;
import com.cms.model.util.GlobalUtil;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.service.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 投标
 * Created by liuxin on 2016/5/23.
 */
@RequestMapping("saleBid")
@Controller
public class SaleBidController {
    @Autowired
    private SaleBidService saleBidService;
    @Autowired
    private GlobalIdService globalIdService;
    @Autowired
    private PurchaseTenderService purchaseTenderService;
    @Autowired
    private ShengchanOrderIdService shengchanOrderIdService;

    /**
     * 保存投标单
     * @param saleBidOrder
     * @return
     */
    private JSONObject saveSaleBidOrder(SaleBidOrder saleBidOrder){
        JSONObject json = new JSONObject();
        try {
            this.saleBidService.saveSaleBidOrder(saleBidOrder);
            json.put("success", true);
            json.put("msg","保存成功！");
        }catch (Exception e){
            json.put("success",false);
            json.put("msg", "保存失败！");
        }
        return json;
    }

    /**
     * 发布
     * @param saleBidOrder
     * @return
     */
    @RequestMapping("saveSaleBidOrderFB")
    @ResponseBody
    public JSONObject saveSaleBidOrderFB(SaleBidOrder saleBidOrder){
        SaleBidOrder order = (SaleBidOrder) RedisUtil.hget("purchaseTenderOrder_"+saleBidOrder.getPurchaseTenderId(),saleBidOrder.getId());
        JSONObject json = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (order!=null){
                json.put("success",false);
                json.put("msg","不能重复投标！");
            }else {
                Date date = sdf.parse(saleBidOrder.getEndTime());
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DAY_OF_MONTH,1);
                Integer seconds = GlobalUtil.daysBetweenSeconds(sdf.parse(sdf.format(calendar.getTime())));
                saleBidOrder.setState(GlobalOrderTypeEnum.TBFB.getCode());
                json = this.saveSaleBidOrder(saleBidOrder);
                RedisUtil.hsetex("purchaseTenderOrder_" + saleBidOrder.getPurchaseTenderId(),seconds,saleBidOrder.getId(), saleBidOrder);
                RedisUtil.set("saleBidNum_" + saleBidOrder.getPurchaseTenderId(),(Integer)RedisUtil.get("saleBidNum_" + saleBidOrder.getPurchaseTenderId())+1);
            }
        }catch (Exception e){}
        return json;
    }

    /**
     * 暂存
     * @param saleBidOrder
     * @return
     */
    @RequestMapping("saveSaleBidOrderZC")
    @ResponseBody
    public JSONObject saveSaleBidOrderZC(SaleBidOrder saleBidOrder){
        saleBidOrder.setState(GlobalOrderTypeEnum.TBZC.getCode());
        return this.saveSaleBidOrder(saleBidOrder);
    }

    /**
     * 明细页面
     * @param saleBidOrder
     * @return
     */
    @RequestMapping("detailPage")
    public ModelAndView detailPage(SaleBidOrder saleBidOrder){
        ModelAndView model = new ModelAndView("../xiaoshou/xs_tbd_mx");
        Map map = new HashMap();
        PurchaseTenderOrder purchaseTenderOrder = new PurchaseTenderOrder();
        SaleBidOrder order = new SaleBidOrder();
        if (saleBidOrder.getPurchaseTenderId()!=null&&!"".equals(saleBidOrder.getPurchaseTenderId())){
            purchaseTenderOrder.setId(saleBidOrder.getPurchaseTenderId());
            purchaseTenderOrder = this.purchaseTenderService.getPurchaseTenderOrderById(purchaseTenderOrder);
        }
        if (saleBidOrder.getId()!=null&&!"".equals(saleBidOrder.getId())){
            order = this.saleBidService.getSaleBidOrder(saleBidOrder);
        }
        map.put("purchaseTender",JSONObject.toJSON(purchaseTenderOrder));
        map.put("saleBidOrder",JSONObject.toJSON(order));
        model.addObject("map",map);
        return model;
    }

    /**
     * 获取投标列表
     * @param pageFilter
     * @param saleBidOrder
     * @return
     */
    @RequestMapping("getSaleBidOrderList")
    @ResponseBody
    public Grid getSaleBidOrderList(PageFilter pageFilter,SaleBidOrder saleBidOrder){
        if (pageFilter!=null){
            saleBidOrder.setOrderStr(pageFilter.getOrderString());
        }
        return this.saleBidService.getSaleBidOrderList(saleBidOrder);
    }

    /**
     * 删除投标
     * @param saleBidOrder
     * @param pageFilter
     * @return
     */
    @RequestMapping("delSaleBid")
    @ResponseBody
    public Grid delSaleBid(SaleBidOrder saleBidOrder,PageFilter pageFilter){
        try {
            this.saleBidService.delSaleBid(saleBidOrder);
        }catch (Exception e){}
        if (pageFilter!=null){
            saleBidOrder.setOrderStr(pageFilter.getOrderString());
        }
        return this.saleBidService.getSaleBidOrderList(saleBidOrder);
    }

    /**
     * 获取招标推荐列表
     * @return
     */
    @RequestMapping("getTenderRecommendList")
    @ResponseBody
    public List<PurchaseTenderOrder> getTenderRecommendList(){
        return this.saleBidService.getTenderRecommendList();
    }
}
