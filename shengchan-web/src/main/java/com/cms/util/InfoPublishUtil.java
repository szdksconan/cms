package com.cms.util;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.shengchang.CompBaseInfo;
import com.cms.model.util.GlobalUtil;
import com.cms.service.common.redis.RedisUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuxin on 2016/5/28.
 */
public class InfoPublishUtil {

    /**
     * 厂家计划 推送物流
     */
    public static void CompanyPlan(final Map companyPlan){
        Map map = new HashMap();
        map.put("grant_type", HttpPropertyConfigurer.getContextProperty("GRANTTYPE").toString());
        map.put("client_id", HttpPropertyConfigurer.getContextProperty("CLIENTID").toString());
        map.put("client_secret", HttpPropertyConfigurer.getContextProperty("CLIENTSECRET").toString());
        JSONObject obj = (JSONObject) JSONObject.parse(HttpClientUtil.Post(HttpPropertyConfigurer.getContextProperty("TOKENURL").toString(), map,null));
        if (obj!=null){
            Map headerMap = new HashMap();
            headerMap.put("Authorization","Bearer "+obj.getString("access_token"));
            companyPlan.put("DateTime", GlobalUtil.getCreateTime().substring(0,10));
            System.out.println("=================\n"+HttpClientUtil.Post(HttpPropertyConfigurer.getContextProperty("COMPANYPLANURL").toString(), companyPlan, headerMap));
        }
    }
}
