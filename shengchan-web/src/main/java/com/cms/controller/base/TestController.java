package com.cms.controller.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.shengchan.shengchanCommonService;
import com.cms.model.dict.BaseProduct;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxin on 2016/4/14.
 */
@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private shengchanCommonService shengchanCommonService;

    @RequestMapping("getBaseProductList")
    @ResponseBody
    public JSONObject getBaseProductList(BaseProduct baseProduct){
        JSONObject json = new JSONObject();
        baseProduct = new BaseProduct();
        baseProduct.setLevel(1);
        List<BaseProduct> list1 = this.shengchanCommonService.getBaseProductList(baseProduct);
        for (BaseProduct bean1:list1){
            BaseProduct b1 = new BaseProduct();
            b1.setLevel(2);
            b1.setSuperId(bean1.getValue());
            List<BaseProduct> list2 = this.shengchanCommonService.getBaseProductList(b1);
            for (BaseProduct bean2:list2){
                BaseProduct b2 = new BaseProduct();
                b2.setLevel(3);
                b2.setSuperId(bean2.getValue());
                List<BaseProduct> list3 = this.shengchanCommonService.getBaseProductList(b2);
                for (BaseProduct bean3:list3){
                    BaseProduct b3 = new BaseProduct();
                    b3.setLevel(4);
                    b3.setSuperId(bean3.getValue());
                    bean3.setS(this.shengchanCommonService.getBaseProductList(b3));
                }
                bean2.setS(list3);
            }
            bean1.setS(list2);
        }
        json.put("list",list1);
        JSONArray array = (JSONArray) JSONArray.toJSON(list1);
        createFile(array.toJSONString());
        return json;
    }

    @RequestMapping("getBaseIndustryList")
    @ResponseBody
    public JSONObject getBaseIndustryList(){
        JSONObject json = new JSONObject();
        json.put("list",this.shengchanCommonService.getBaseIndustryList());
        return json;
    }

    @RequestMapping("getAreaProvinceCityArea")
    @ResponseBody
    public JSONPObject getAreaProvinceCityArea(String jsonpCallback){
        JSONObject json = new JSONObject();
        Map map = this.shengchanCommonService.getProvinceCityAreaList();
        json.put("province", map.get("province"));
        json.put("area",map.get("area"));
//        this.createFile(json.toJSONString());
        return new JSONPObject(jsonpCallback,json);
    }

    private void createFile(String content){
        try{
            FileWriter fw = new FileWriter(new File("c:/cityJson.js"), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.flush();
            bw.close();
            fw.close();
        }catch (Exception e){

        }
    }
}
