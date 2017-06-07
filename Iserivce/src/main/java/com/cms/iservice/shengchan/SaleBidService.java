package com.cms.iservice.shengchan;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.shengchang.SaleBidOrder;
import com.cms.model.shengchang.SaleBidOrderDetail;
import com.cms.model.shengchang.SaleBidOrderOut;
import com.cms.model.util.Grid;

import java.util.List;

/**
 * Created by liuxin on 2016/5/23.
 */
public interface SaleBidService {
    public void saveSaleBidOrder(SaleBidOrder saleBidOrder);

    public SaleBidOrder getSaleBidOrder(SaleBidOrder saleBidOrder);

    public Grid getSaleBidOrderList(SaleBidOrder saleBidOrder);

    public void delSaleBid(SaleBidOrder saleBidOrder);

    public List<SaleBidOrderDetail> getSaleBidOrderDetail(SaleBidOrder saleBidOrder);

    public void saveReview(JSONObject json);

    public void saveSaleBidOrderForOut(SaleBidOrderOut saleBidOrderOut);

    public List getTenderRecommendList();
}
