package com.cms.model.util;


import com.cms.model.shengchang.MainDocBean;
import com.cms.model.shengchang.ProductDocBean;
import com.cms.model.shengchang.PurchaseTenderDetailDoc;
import com.cms.service.common.redis.SerializeUtil;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuxin on 2016/3/31.
 */
public class GlobalUtil {
    /**
     * 生产 头部菜单
     */
    public static final String SHENGCHAN = "[{\"menuId\":1,\"name\":\"企业中心\"},{\"menuId\":2,\"name\":\"物资采购\"}," +
            "{\"menuId\":3,\"name\":\"产品销售\"},{\"menuId\":4,\"name\":\"储运管理\"}]";
    /**
     * 物资采购 菜单
     */
    public static final String WZCG = "[{\"name\":\"物资需求\",\"list\":[{\"name\":\"采购意向\",\"url\":\"purchase/purchaseIntent\"}," +
            "{\"name\":\"物资需求发布\",\"url\":\"purchase/needReleaseListPage\"}]},{\"name\":\"物资大厅\",\"list\":[{\"name\":\"\",\"url\":\"\"}]}," +
            "{\"name\":\"物资订单\",\"list\":[{\"name\":\"采购订单\",\"url\":\"purchase/cgdd\"},{\"name\":\"委托代工单\",\"url\":\"purchase/wtdgd\"}," +
            "{\"name\":\"招标单\",\"url\":\"purchase/zbd\"}]},{\"name\":\"采购管理\",\"list\":[{\"name\":\"供应商名录\",\"url\":\"purchase/gysml\"}," +
            "{\"name\":\"统计报表\",\"url\":\"purchase/tjbb\"}]}]";


    public static final String CYGL = "[{\"name\":\"物流运单\",\"list\":[{\"name\":\"运输提请管理\",\"url\":\"chuyun/tansRequestManage\"}]},"
    		+ "							{\"name\":\"物流企业名录\",\"list\":[{\"name\":\"物流合作申请管理\",\"url\":\"chuyun/wuliuhezuo\"},{\"name\":\"物流客户管理\",\"url\":\"storage/stock\"}]},"
    		+ "{\"name\":\"物资管理\",\"list\":[{\"name\":\"库存管理\",\"url\":\"chuyun/stockManage\"}]}]";

    /**
     * 获取当前时间
     * @return
     */
    public static String getCreateTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    /**
     * 与当前日期比较返回秒
     * @param bdate
     * @return
     */
    public static Integer daysBetweenSeconds(Date bdate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date _now = new Date();
        try {
            _now=sdf.parse(sdf.format(_now));
            bdate=sdf.parse(sdf.format(bdate));
        }catch (Exception e){
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(_now);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
//        long between_days=(time2-time1)/(1000*3600*24);
        long between_days=(time2-time1)/1000;
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * Redis hgetAll Map 转 List
     * @param map
     * @return
     */
    public static List MapToList(Map map,Class c){
        Iterator it = map.keySet().iterator();
        List list = new LinkedList();
        while (it.hasNext()){
            String key = it.next().toString();
            try {
                Object obj =  SerializeUtil.convertBytes2Obj(map.get(key).toString().getBytes("ISO8859-1"));
                if (c==MainDocBean.class){
                    MainDocBean mainDocBean = (MainDocBean) obj;
                    list.add(mainDocBean);
                }
                if (c==ProductDocBean.class){
                    ProductDocBean productDocBean = (ProductDocBean) obj;
                    list.add(productDocBean);
                }
                if (c== PurchaseTenderDetailDoc.class){
                    PurchaseTenderDetailDoc purchaseTenderDetailDoc = (PurchaseTenderDetailDoc) obj;
                    list.add(purchaseTenderDetailDoc);
                }
            }catch (Exception e){}
        }
        if (list.size()!=0){
            Collections.sort(list);
        }
        return list;
    }
}
