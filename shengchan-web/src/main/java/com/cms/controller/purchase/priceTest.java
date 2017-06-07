package com.cms.controller.purchase;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.shengchan.ShengchanOrderIdService;
import com.cms.model.util.GlobalOrderTypeEnum;
import com.cms.model.util.GlobalTypeEnum;
import com.cms.model.util.GlobalUtil;
import com.cms.util.HttpClientUtil;
import com.cms.util.HttpPropertyConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuxin on 2016/5/19.
 */
@Controller
@RequestMapping("priceTest")
public class priceTest {
    @Autowired
    private ShengchanOrderIdService shengchanOrderIdService;

    @RequestMapping("pricePush")
    @ResponseBody
    public JSONObject pricePush(Double actualpaymoney,Double settlemoney,Double notsettlemoney){
        JSONObject payable = new JSONObject();
        JSONObject receivables = new JSONObject();
        payable.put("customertype",3);
        receivables.put("customertype",4);
        payable.put("customercompany",5);
        receivables.put("customercompany",6);
        payable.put("billtype", GlobalOrderTypeEnum.DD.getCode());
        receivables.put("billtype", GlobalOrderTypeEnum.DD.getCode());
        String _billNo = this.shengchanOrderIdService.getOrderId(GlobalOrderTypeEnum.DD.getCode(), "123456789");
        payable.put("billno", _billNo);
        receivables.put("billno", _billNo);
        long _now = new Date().getTime();
        payable.put("billdate",_now);
        receivables.put("billdate", _now);
        payable.put("billtotalmoney", 1000);
        receivables.put("billtotalmoney", 1000);
        payable.put("actualpaymoney", actualpaymoney);
        receivables.put("actualpaymoney", actualpaymoney);
        payable.put("settlemoney", settlemoney);
        receivables.put("settlemoney", settlemoney);
        payable.put("notsettlemoney", notsettlemoney);
        receivables.put("notsettlemoney", notsettlemoney);
        payable.put("settlepaymoney", 100);
        receivables.put("settlepaymoney", 100);
        payable.put("settlenotpaymoney", 100);
        receivables.put("settlenotpaymoney", 100);
        payable.put("status", 0);
        receivables.put("status", 0);
        payable.put("belongarea", 9);
        receivables.put("belongarea", 9);
        payable.put("fundtype", 12);
        receivables.put("fundtype", 12);
        Map map = new HashMap();
        map.put("data",payable.toJSONString());
        Map headerMap = new HashMap();
        headerMap.put("Content-Type","application/x-www-form-urlencoded;charset=gbk");
        System.out.println(HttpPropertyConfigurer.getContextProperty("PRICEURL").toString()+"====================");
        JSONObject json = (JSONObject) JSONObject.parse(HttpClientUtil.Post(HttpPropertyConfigurer.getContextProperty("PRICEURL").toString(), map, headerMap));
        System.out.println(json.toString());
        return json;
    }
}
