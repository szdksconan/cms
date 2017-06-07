package com.cms.dao.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.shengchang.SaleBidOrder;
import com.cms.model.shengchang.SaleBidOrderDetail;
import com.cms.model.util.Grid;

import java.util.List;

/**
 * Created by liuxin on 2016/5/23.
 */
public interface SaleBidDao {
    public void saveSaleBidOrder(SaleBidOrder saleBidOrder);

    public void saveSaleBidOrderDetail(List<SaleBidOrderDetail> saleBidOrderDetailList);

    public SaleBidOrder getSaleBidOrder(SaleBidOrder saleBidOrder);

    public List<SaleBidOrder> getSaleBidOrderList(SaleBidOrder saleBidOrder);

    public Integer getSaleBidOrderListCot(SaleBidOrder saleBidOrder);

    public void delSaleBidOrderDetailList(List<SaleBidOrderDetail> saleBidOrderDetailList);

    public List<SaleBidOrderDetail> getSaleBidOrderDetail(SaleBidOrder saleBidOrder);

    public void delSaleBid(SaleBidOrder saleBidOrder);

    public void saveReview(JSONObject obj);
}
