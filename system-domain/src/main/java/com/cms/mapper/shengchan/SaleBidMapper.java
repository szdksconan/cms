package com.cms.mapper.shengchan;

import com.cms.model.shengchang.SaleBidOrder;
import com.cms.model.shengchang.SaleBidOrderDetail;

import java.util.List;

/**
 * Created by liuxin on 2016/5/23.
 */
public interface SaleBidMapper {
    public void saveSaleBidOrder(SaleBidOrder saleBidOrder);

    public void saveSaleBidOrderDetail(List<SaleBidOrderDetail> saleBidOrderDetailList);

    public SaleBidOrder getSaleBidOrder(SaleBidOrder saleBidOrder);

    public List<SaleBidOrderDetail> getSaleBidOrderDetail(SaleBidOrder saleBidOrder);

    public List<SaleBidOrder> getSaleBidOrderList(SaleBidOrder saleBidOrder);

    public Integer getSaleBidOrderListCot(SaleBidOrder saleBidOrder);

    public void delSaleBidOrderDetailList(List<SaleBidOrderDetail> saleBidOrderDetailList);

    public void delSaleBid(SaleBidOrder saleBidOrder);

    public void saveReviewOrder(SaleBidOrder SaleBidOrder);

    public void saveReviewDetail(SaleBidOrderDetail saleBidOrderDetail);

    public void saveReviewDetailByOrder(SaleBidOrder saleBidOrder);
}
