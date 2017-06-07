package com.cms.service.shengchan;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.dao.shengchan.PurchaseTenderDao;
import com.cms.dao.shengchan.SaleBidDao;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.PurchaseTenderService;
import com.cms.iservice.shengchan.SaleBidService;
import com.cms.iservice.shengchan.ShengchanOrderIdService;
import com.cms.iservice.shengchan.ShengchanRecommendService;
import com.cms.model.shengchang.PurchaseTenderOrder;
import com.cms.model.shengchang.SaleBidOrder;
import com.cms.model.shengchang.SaleBidOrderDetail;
import com.cms.model.shengchang.SaleBidOrderOut;
import com.cms.model.util.GlobalOrderTypeEnum;
import com.cms.model.util.GlobalUtil;
import com.cms.model.util.Grid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxin on 2016/5/23.
 */
public class SaleBidServiceImpl implements SaleBidService{
    @Autowired
    private SaleBidDao saleBidDao;
    @Autowired
    private GlobalIdService globalIdService;
    @Autowired
    private ShengchanOrderIdService shengchanOrderIdService;
    @Autowired
    private ShengchanRecommendService shengchanRecommendService;
    @Autowired
    private PurchaseTenderDao purchaseTenderDao;

    public void saveSaleBidOrder(SaleBidOrder saleBidOrder) {
        String _mainId = this.globalIdService.getGlobalId().toString();
        saleBidOrder.setId(saleBidOrder.getId() == null ? _mainId : ("".equals(saleBidOrder.getId()) ? _mainId : saleBidOrder.getId()));
        saleBidOrder.setCreateTime(GlobalUtil.getCreateTime());
        saleBidOrder.setUpdateTime(GlobalUtil.getCreateTime());
        saleBidOrder.setOrderCode(this.shengchanOrderIdService.getOrderId(GlobalOrderTypeEnum.TBD.getCode(), "1312312313"));
        saleBidOrder.setCompanyId("7");
        saleBidOrder.setCompanyName("贵阳XXX公司");
        saleBidOrder.setCompanyAddress("成都市高新区茂业中心");
        String[] delArray = saleBidOrder.getDelDetailIds().split(",");
        List<SaleBidOrderDetail> delSalebidOrderDetailList = new ArrayList<SaleBidOrderDetail>();
        for (int i=0;i<delArray.length;i++){
            if (!"".equals(delArray[i])){
                SaleBidOrderDetail saleBidOrderDetail = new SaleBidOrderDetail();
                saleBidOrderDetail.setId(delArray[i]);
                delSalebidOrderDetailList.add(saleBidOrderDetail);
            }
        }
        saleBidOrder.setDelSalebidOrderDetailList(delSalebidOrderDetailList);
        JSONArray array = JSONArray.parseArray(saleBidOrder.getDetails());
        List<SaleBidOrderDetail> saleBidOrderDetailList = new ArrayList<SaleBidOrderDetail>();
        for (int i=0;i<array.size();i++){
            SaleBidOrderDetail saleBidOrderDetail = JSONObject.toJavaObject(JSONObject.parseObject(array.getString(i)),SaleBidOrderDetail.class);
            String _detailId = this.globalIdService.getGlobalId().toString();
            saleBidOrderDetail.setSaleBidOrderId(saleBidOrder.getId());
            saleBidOrderDetail.setPurchaseTenderId(saleBidOrder.getPurchaseTenderId());
            saleBidOrderDetail.setActuallyCount(saleBidOrderDetail.getCount());
            saleBidOrderDetail.setId(saleBidOrderDetail.getId() == null ? _detailId : ("".equals(saleBidOrderDetail.getId()) ? _detailId : (saleBidOrderDetail.getId().length()<10?_detailId:saleBidOrderDetail.getId())));
            saleBidOrderDetailList.add(saleBidOrderDetail);
        }
        saleBidOrder.setSaleBidOrderDetailList(saleBidOrderDetailList);

        this.saleBidDao.saveSaleBidOrder(saleBidOrder);
        if (saleBidOrder.getDelSalebidOrderDetailList().size()!=0){
            this.saleBidDao.delSaleBidOrderDetailList(saleBidOrder.getDelSalebidOrderDetailList());
        }
        if (saleBidOrder.getSaleBidOrderDetailList().size()!=0){
            this.saleBidDao.saveSaleBidOrderDetail(saleBidOrder.getSaleBidOrderDetailList());
        }
    }

    public SaleBidOrder getSaleBidOrder(SaleBidOrder saleBidOrder) {
        return this.saleBidDao.getSaleBidOrder(saleBidOrder);
    }

    public Grid getSaleBidOrderList(SaleBidOrder saleBidOrder) {
        Grid grid = new Grid();
        grid.setRows(this.saleBidDao.getSaleBidOrderList(saleBidOrder));
        grid.setTotal(this.saleBidDao.getSaleBidOrderListCot(saleBidOrder));
        return grid;
    }

    public void delSaleBid(SaleBidOrder saleBidOrder) {
        this.saleBidDao.delSaleBid(saleBidOrder);
    }

    public List<SaleBidOrderDetail> getSaleBidOrderDetail(SaleBidOrder saleBidOrder) {
        return this.saleBidDao.getSaleBidOrderDetail(saleBidOrder);
    }

    public void saveReview(JSONObject json) {
        Boolean reviewFlag = json.getBoolean("reviewFlag");
        if (reviewFlag){
            PurchaseTenderOrder purchaseTenderOrder = new PurchaseTenderOrder();
            purchaseTenderOrder.setId(json.getString("purchaseTenderId"));
            purchaseTenderOrder.setReviewFlag(reviewFlag);
            this.purchaseTenderDao.saveReview(purchaseTenderOrder);
        }
        this.saleBidDao.saveReview(json);
    }

    public void saveSaleBidOrderForOut(SaleBidOrderOut saleBidOrderOut) {
        SaleBidOrder saleBidOrder = new SaleBidOrder();
        BeanUtils.copyProperties(saleBidOrderOut,saleBidOrder);
        this.saveSaleBidOrder(saleBidOrder);
    }

    public List<PurchaseTenderOrder> getTenderRecommendList() {
        List<String> ids = this.shengchanRecommendService.getZhaobiaoRecommend("1312312313",0,1000);
        ids.remove(0);
        return this.purchaseTenderDao.getTenderRecommendList(ids);
    }
}
