package com.cms.dao.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.shengchan.SaleBidMapper;
import com.cms.model.shengchang.SaleBidOrder;
import com.cms.model.shengchang.SaleBidOrderDetail;
import com.cms.model.util.Grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuxin on 2016/5/23.
 */
@Component
public class SaleBidDaoImpl implements SaleBidDao{
    @Autowired
    private SaleBidMapper saleBidMapper;

    public void saveSaleBidOrder(SaleBidOrder saleBidOrder) {
        this.saleBidMapper.saveSaleBidOrder(saleBidOrder);
    }

    public void saveSaleBidOrderDetail(List<SaleBidOrderDetail> saleBidOrderDetailList) {
        this.saleBidMapper.saveSaleBidOrderDetail(saleBidOrderDetailList);
    }

    public SaleBidOrder getSaleBidOrder(SaleBidOrder saleBidOrder) {
        SaleBidOrder order = this.saleBidMapper.getSaleBidOrder(saleBidOrder);
        if (order!=null){
            order.setSaleBidOrderDetailList(this.saleBidMapper.getSaleBidOrderDetail(saleBidOrder));
        }
        return order;
    }

    public List<SaleBidOrder> getSaleBidOrderList(SaleBidOrder saleBidOrder) {
        return this.saleBidMapper.getSaleBidOrderList(saleBidOrder);
    }

    public Integer getSaleBidOrderListCot(SaleBidOrder saleBidOrder) {
        return this.saleBidMapper.getSaleBidOrderListCot(saleBidOrder);
    }

    public void delSaleBidOrderDetailList(List<SaleBidOrderDetail> saleBidOrderDetailList) {
        this.saleBidMapper.delSaleBidOrderDetailList(saleBidOrderDetailList);
    }

    public List<SaleBidOrderDetail> getSaleBidOrderDetail(SaleBidOrder saleBidOrder) {
        return this.saleBidMapper.getSaleBidOrderDetail(saleBidOrder);
    }

    public void delSaleBid(SaleBidOrder saleBidOrder) {
        this.saleBidMapper.delSaleBid(saleBidOrder);
    }

    public void saveReview(JSONObject obj) {
        List<SaleBidOrder> delBidOrderList = (List<SaleBidOrder>) obj.get("delBidOrderList");
        List<SaleBidOrderDetail> delDetailList = (List<SaleBidOrderDetail>) obj.get("delDetailList");
        Boolean reviewFlag = obj.getBoolean("reviewFlag");
        for (SaleBidOrder saleBidOrder:delBidOrderList){
            this.saleBidMapper.saveReviewOrder(saleBidOrder);
            this.saleBidMapper.saveReviewDetailByOrder(saleBidOrder);
        }
        for (SaleBidOrderDetail saleBidOrderDetail:delDetailList){
            this.saleBidMapper.saveReviewDetail(saleBidOrderDetail);
        }
        List<SaleBidOrder> saleBidOrderList = (List<SaleBidOrder>) obj.get("saleBidOrderList");
        List<SaleBidOrderDetail> saleBidOrderDetailList = (List<SaleBidOrderDetail>) obj.get("saleBidOrderDetailList");
        for (SaleBidOrder saleBidOrder:saleBidOrderList){
            if (reviewFlag){
                saleBidOrder.setReviewFlag(reviewFlag);
            }
            this.saleBidMapper.saveReviewOrder(saleBidOrder);
        }
        for (SaleBidOrderDetail saleBidOrderDetail:saleBidOrderDetailList){
            if (reviewFlag){
                saleBidOrderDetail.setReviewFlag(reviewFlag);
            }
            this.saleBidMapper.saveReviewDetail(saleBidOrderDetail);
        }
    }
}
