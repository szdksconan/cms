package com.cms.service.shengchan;

import com.cms.iservice.shengchan.ShengchanOrderIdService;
import com.cms.model.util.GlobalUtil;

import java.util.Random;

/**
 * Created by liuxin on 2016/5/16.
 */
public class ShengchanOrderIdServiceImpl implements ShengchanOrderIdService{

    /**
     *
     * @param orderType 单据类型
     * @param companyId 企业id
     * @return
     */
    public  String getOrderId(Integer orderType,String companyId) {
        String time = GlobalUtil.getCreateTime().substring(0,10).replace("-","").substring(2,8);
        String key = time+companyId+this.getRandom();
        final long PRIME = 16777619;
        Long hash =  2166136261L;
        for (byte b : key.getBytes()) {
            hash ^= b;
            hash *= PRIME;
        }
        return (orderType+hash.toString()).replace("-","");
    }

    private String getRandom(){
        String name="";
        for(int i=0;i<3;i++){
            int intValue=(int)(Math.random()*26+65);
            name=name+(char)intValue;
        }
        double pross = (1 + new Random().nextDouble()) * Math.pow(10, 3);
        name+=String.valueOf(pross).substring(1, 3 + 1);
        return name;
    }
}
