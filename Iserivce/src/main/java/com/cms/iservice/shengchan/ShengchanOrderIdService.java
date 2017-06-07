package com.cms.iservice.shengchan;

/**
 * Created by liuxin on 2016/5/16.
 */
public interface ShengchanOrderIdService {
    /**
     *
     * @param orderType 单据类型
     * @param companyId 企业id
     * @return
     */
    public String getOrderId(Integer orderType,String companyId);
}
