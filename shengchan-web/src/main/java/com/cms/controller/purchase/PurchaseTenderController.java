package com.cms.controller.purchase;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.*;
import com.cms.model.shengchang.*;
import com.cms.model.util.*;
import com.cms.service.common.redis.RedisUtil;
import com.cms.util.FileOperate;
import com.cms.util.InfoPublishUtil;
import com.cms.util.XSThreadPool;
import com.cms.web.util.s3.S3Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 招标单模块
 * Created by liuxin on 2016/5/16.
 */
@Controller
@RequestMapping("purchaseTender")
public class PurchaseTenderController {
    @Autowired
    private GlobalIdService globalIdService;

    @Autowired
    private PurchaseTenderService purchaseTenderService;

    @Autowired
    private ShengchanOrderIdService shengchanOrderIdService;

    @Autowired
    private PurchaseNeedService purchaseNeedService;

    @Autowired
    private SaleBidService saleBidService;

    @Autowired
    private static XSThreadPool pool;

    @Autowired
    private static CompanyService companyService;

    /**
     * 发布
     * @param purchaseTenderOrder
     * @param request
     * @return
     */
    @RequestMapping("savePurchaseTenderFb")
    @ResponseBody
    public JSONObject savePurchaseTenderFb(PurchaseTenderOrder purchaseTenderOrder,MultipartHttpServletRequest request){
        purchaseTenderOrder.setState(GlobalOrderTypeEnum.ZBFB.getCode());
        JSONObject obj = savePurchaseTender(purchaseTenderOrder ,request);
        publishBusiness(purchaseTenderOrder);
        companyPlan(purchaseTenderOrder);
        return obj;
    }

    /**
     * 暂存
     * @param purchaseTenderOrder
     * @param request
     * @return
     */
    @RequestMapping("savePurchaseTenderZc")
    @ResponseBody
    public JSONObject savePurchaseTenderZc(PurchaseTenderOrder purchaseTenderOrder,MultipartHttpServletRequest request){
        purchaseTenderOrder.setState(GlobalOrderTypeEnum.ZBZC.getCode());
        return savePurchaseTender(purchaseTenderOrder ,request);
    }

    /**
     * 保存招标信息
     * @param purchaseTenderOrder
     * @param request
     * @return
     */
    private JSONObject savePurchaseTender(PurchaseTenderOrder purchaseTenderOrder,MultipartHttpServletRequest request){
        JSONObject obj = new JSONObject();
        pool = new XSThreadPool();
        try{
            String _mainId = this.globalIdService.getGlobalId().toString();
            String _now = GlobalUtil.getCreateTime();
            if ("".equals(purchaseTenderOrder.getOrderCode())){
                purchaseTenderOrder.setOrderCode(this.shengchanOrderIdService.getOrderId(GlobalOrderTypeEnum.ZBD.getCode(),purchaseTenderOrder.getCompanyId()).replace("-",""));
            }
            purchaseTenderOrder.setUpdateTime(GlobalUtil.getCreateTime());
            purchaseTenderOrder.setCreateTime(purchaseTenderOrder.getCreateTime()==null?_now:purchaseTenderOrder.getCreateTime());
            purchaseTenderOrder.setId(purchaseTenderOrder.getId()==null?
                    _mainId:(("".equals(purchaseTenderOrder.getId())||purchaseTenderOrder.getId().length()<4)
                    ?_mainId:purchaseTenderOrder.getId()));
            String[] _areaIdArray = purchaseTenderOrder.getPurchaseTenderSourceId().split(",");
            String[] _areaNameArray = purchaseTenderOrder.getPurchaseTenderSourceName().split(",");
            List<PurchaseTenderArea> purchaseTenderAreaList = new ArrayList<PurchaseTenderArea>();
            for (int i=0;i<_areaIdArray.length;i++){
                if (!"".equals(_areaIdArray[i])){
                    String[] _areaCode = _areaIdArray[i].split("-");
                    String[] _areaName = _areaNameArray[i].split("-");
                    if (!"".equals(_areaCode[0])){
                        PurchaseTenderArea purchaseTenderArea = new PurchaseTenderArea();
                        purchaseTenderArea.setId(this.globalIdService.getGlobalId().toString());
                        purchaseTenderArea.setPurchaseTenderId(purchaseTenderOrder.getId());
                        switch (_areaCode.length){
                            case 1:
                                purchaseTenderArea.setProvinceId(_areaCode[0] == null ? "" : _areaCode[0]);
                                purchaseTenderArea.setProvinceName(_areaName[0] == null?"":_areaName[0]);
                                break;
                            case 2:
                                purchaseTenderArea.setProvinceId(_areaCode[0] == null ? "" : _areaCode[0]);
                                purchaseTenderArea.setProvinceName(_areaName[0] == null?"":_areaName[0]);
                                purchaseTenderArea.setCityId(_areaCode[1]==null?"":_areaCode[1]);
                                purchaseTenderArea.setCityName(_areaName[1] == null?"":_areaName[1]);
                                break;
                            case 3:
                                purchaseTenderArea.setProvinceId(_areaCode[0] == null ? "" : _areaCode[0]);
                                purchaseTenderArea.setProvinceName(_areaName[0] == null?"":_areaName[0]);
                                purchaseTenderArea.setCityId(_areaCode[1]==null?"":_areaCode[1]);
                                purchaseTenderArea.setCityName(_areaName[1] == null?"":_areaName[1]);
                                purchaseTenderArea.setAreaId(_areaCode[2]==null?"":_areaCode[2]);
                                purchaseTenderArea.setAreaName(_areaName[2] == null?"":_areaName[2]);
                                break;
                        }
                        purchaseTenderAreaList.add(purchaseTenderArea);
                    }
                }
            }
            purchaseTenderOrder.setPurchaseTenderAreaList(purchaseTenderAreaList);
            JSONArray productArray = JSONArray.parseArray(purchaseTenderOrder.getPurchaseTenderDetailArrayStr());
            List<PurchaseTenderDetail> purchaseTenderDetailList = new ArrayList<PurchaseTenderDetail>();
            if (productArray!=null){
                for (int i=0;i<productArray.size();i++){
                    PurchaseTenderDetail purchaseTenderDetail = JSONObject.toJavaObject((JSONObject) productArray.get(i),PurchaseTenderDetail.class);
                    String _purchaseTenderDetailId = this.globalIdService.getGlobalId().toString();
                    purchaseTenderDetail.setId(purchaseTenderDetail.getId()==null?
                            _purchaseTenderDetailId:(("".equals(purchaseTenderDetail.getId())||purchaseTenderDetail.getId().length()<4)
                            ?_purchaseTenderDetailId:purchaseTenderDetail.getId()));
                    purchaseTenderDetail.setPurchaseTenderId(purchaseTenderOrder.getId());
                    purchaseTenderDetail.setUpdateTime(GlobalUtil.getCreateTime());
                    purchaseTenderDetail.setEndTime(purchaseTenderOrder.getEndTime());
                    String[] _delFileKeys = purchaseTenderDetail.getDelFileKeys().split(",");
                    List<PurchaseTenderDetailDoc> delPurchaseTender = new ArrayList<PurchaseTenderDetailDoc>();
                    for (int j=0;j<_delFileKeys.length;j++){
                        if (!"".equals(_delFileKeys[j])){
                            String fileKey=_delFileKeys[j];
                            PurchaseTenderDetailDoc purchaseTenderDetailDoc = (PurchaseTenderDetailDoc) RedisUtil.hget("purchaseTenderDetailDoc"+purchaseTenderDetail.getId(),fileKey);
                            if (purchaseTenderDetailDoc==null){
                                purchaseTenderDetailDoc = new PurchaseTenderDetailDoc();
                                purchaseTenderDetailDoc.setId(fileKey);
                            }
                            delPurchaseTender.add(purchaseTenderDetailDoc);
                            try{
                                S3Util.deleteObject(S3Util.producerBucketName, purchaseTenderDetailDoc.getFileKey());
                            }catch (RuntimeException e){}
                            RedisUtil.hdel("purchaseTenderDetailDoc" + purchaseTenderDetail.getId(),fileKey);
                        }
                    }
                    purchaseTenderDetail.setDelPurchaseTenderDetailDocList(delPurchaseTender);
                    Map _filePara = new HashMap();
                    _filePara.put("fileList",request.getFiles(purchaseTenderDetail.getPurchaseTenderDetailDocName()));
                    _filePara.put("fileKey","purchaseTenderDetailDoc/"+_now.substring(0,10)+"/"+purchaseTenderDetail.getId());
                    _filePara.put("everyone",true);
                    List fileList = FileOperate.FileUploadMultipartFile(_filePara);
                    List<PurchaseTenderDetailDoc> purchaseTenderDetailDocList = new ArrayList<PurchaseTenderDetailDoc>();
                    for (int j=0;j<fileList.size();j++){
                        Map fileMap = (Map) fileList.get(j);
                        PurchaseTenderDetailDoc purchaseTenderDetailDoc = new PurchaseTenderDetailDoc();
                        purchaseTenderDetailDoc.setPurchaseTenderDetailId(purchaseTenderDetail.getId());
                        purchaseTenderDetailDoc.setId(this.globalIdService.getGlobalId().toString());
                        purchaseTenderDetailDoc.setFileUrl(fileMap.get("path").toString());
                        purchaseTenderDetailDoc.setFileKey(fileMap.get("key").toString());
                        purchaseTenderDetailDoc.setFileType(GlobalTypeEnum.IMG.getCode());
                        purchaseTenderDetailDoc.setSort(j + 1);
                        purchaseTenderDetailDoc.setCreateTime(GlobalUtil.getCreateTime());
                        RedisUtil.hset("purchaseTenderDetailDoc"+purchaseTenderDetail.getId(),purchaseTenderDetailDoc.getId(),purchaseTenderDetailDoc);
                        purchaseTenderDetailDocList.add(purchaseTenderDetailDoc);
                    }
                    purchaseTenderDetail.setPurchaseTenderDetailDocList(purchaseTenderDetailDocList);
                    purchaseTenderDetailList.add(purchaseTenderDetail);
                }
            }
            purchaseTenderOrder.setPurchaseTenderDetailList(purchaseTenderDetailList);
            JSONArray supplierArray = JSONArray.parseArray(purchaseTenderOrder.getPurchaseTenderOrderSupplierStr());
            List<PurchaseTenderOrderSupplier> purchaseTenderOrderSupplierList = new ArrayList<PurchaseTenderOrderSupplier>();
            for (int i=0;i<supplierArray.size();i++){
                if (!"".equals(supplierArray.get(i))){
                    PurchaseTenderOrderSupplier purchaseTenderOrderSupplier = JSONObject.toJavaObject(JSONObject.parseObject(supplierArray.getString(i)),PurchaseTenderOrderSupplier.class);
                    purchaseTenderOrderSupplier.setId(purchaseTenderOrderSupplier.getId()!=null&&!"".equals(purchaseTenderOrderSupplier.getId())?purchaseTenderOrderSupplier.getId():globalIdService.getGlobalId().toString());
                    purchaseTenderOrderSupplier.setPurchaseTenderOrderId(purchaseTenderOrder.getId());
                    purchaseTenderOrderSupplierList.add(purchaseTenderOrderSupplier);
                }
            }
            purchaseTenderOrder.setPurchaseTenderOrderSupplierList(purchaseTenderOrderSupplierList);
            this.purchaseTenderService.savePurchaseTender(purchaseTenderOrder);
            obj.put("success",true);
            obj.put("msg","保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            obj.put("success",false);
            obj.put("msg","保存失败！");
        }
        return obj;
    }

    /**
     * 删除招标
     * @param purchaseTenderOrder
     * @return
     */
    @RequestMapping("delPurchaseTender")
    @ResponseBody
    public JSONObject delPurchaseTender(PurchaseTenderOrder purchaseTenderOrder){
        JSONObject obj = new JSONObject();
        try{
            purchaseTenderOrder.setUpdateTime(GlobalUtil.getCreateTime());
            this.purchaseTenderService.delPurchaseTender(purchaseTenderOrder);
            obj.put("success",true);
            obj.put("msg","删除成功！");
        }catch (Exception e){
            obj.put("success",false);
            obj.put("msg","删除失败！");
        }
        return obj;
    }

    /**
     * 获取招标列表
     * @param pageFilter
     * @param purchaseTenderOrder
     * @return
     */
    @RequestMapping("getPurchaseTender")
    @ResponseBody
    public Grid getPurchaseTender(PageFilter pageFilter,PurchaseTenderOrder purchaseTenderOrder){
        if (pageFilter!=null){
            purchaseTenderOrder.setOrderStr(pageFilter.getOrderString());
        }
        return this.purchaseTenderService.getPurchaseTender(purchaseTenderOrder);
    }

    /**
     * 编辑页面
     * @param purchaseTenderOrder
     * @return
     */
    @RequestMapping("updatePage")
    public ModelAndView updatePage(PurchaseTenderOrder purchaseTenderOrder){
        ModelAndView model = new ModelAndView("../caigou/c_zhaobiao_fb");
        purchaseTenderOrder = this.purchaseTenderService.getPurchaseTenderOrderById(purchaseTenderOrder);
        Map map = new HashMap();
        map.put("purchaseTender",JSONObject.toJSON(purchaseTenderOrder));
        model.addObject("map",map);
        return model;
    }

    /**
     * 获取物资需求
     * @return
     */
    @RequestMapping("getProductNeedList")
    @ResponseBody
    public Grid getProductNeedList(PageFilter pageFilter,PurchaseNeedDetailBean purchaseNeedDetailBean){
        if (purchaseNeedDetailBean==null){
            purchaseNeedDetailBean = new PurchaseNeedDetailBean();
        }
        purchaseNeedDetailBean.setCompanyId("1312312313");
        purchaseNeedDetailBean.setFailTimeBak(GlobalUtil.getCreateTime().substring(0,10));
        if (pageFilter!=null){
            purchaseNeedDetailBean.setOrderStr(pageFilter.getOrderString());
        }
        return this.purchaseNeedService.getPurchaseNeedDetail(purchaseNeedDetailBean);
    }

    /**
     * 获取物资类型数量
     * @return
     */
    @RequestMapping("getProductTypeCot")
    @ResponseBody
    public List getProductTypeCot(){
        return this.purchaseNeedService.getProductTypeCot();
    }

    /**
     * 评审页面
     * @return
     */
    @RequestMapping("reviewPage")
    public ModelAndView reviewPage(PurchaseTenderOrder purchaseTenderOrder){
        ModelAndView model = new ModelAndView("../caigou/sc_zhaobiao_pingsheng");
        SaleBidOrder saleBidOrder = new SaleBidOrder();
        saleBidOrder.setPurchaseTenderId(purchaseTenderOrder.getId());
        List<SaleBidOrder> saleBidOrderList = this.saleBidService.getSaleBidOrderList(saleBidOrder).getRows();
        Map map = new HashMap();
        map.put("saleBidOrderList",JSONArray.toJSON(saleBidOrderList));
        map.put("purchaseTenderId",purchaseTenderOrder.getId());
        model.addObject("map",map);
        return model;
    }

    @RequestMapping("getSaleBidOrderDetail")
    @ResponseBody
    public List<SaleBidOrderDetail> getSaleBidOrderDetail(SaleBidOrder saleBidOrder){
        return this.saleBidService.getSaleBidOrderDetail(saleBidOrder);
    }

    /**
     * 评审暂存
     * @return
     */
    @RequestMapping("saveReview")
    @ResponseBody
    public JSONObject saveReview(String delOrderIds,String delDetail,String orderIds,String detailArray,Boolean reviewFlag,String purchaseTenderId){
        JSONObject obj = new JSONObject();
        try {
            List<SaleBidOrder> delBidOrderList = new ArrayList<SaleBidOrder>();
            JSONArray delOrder = JSONArray.parseArray(delOrderIds);
            for (int i=0;i<delOrder.size();i++){
                if (!"".equals(delOrder.getString(i))){
                    SaleBidOrder saleBidOrder = new SaleBidOrder();
                    saleBidOrder.setId(delOrder.getString(i));
                    saleBidOrder.setSaved(false);
                    delBidOrderList.add(saleBidOrder);
                }
            }
            List<SaleBidOrder> saleBidOrderList = new ArrayList<SaleBidOrder>();
            JSONArray orderArray = JSONArray.parseArray(orderIds);
            for (int i=0;i<orderArray.size();i++){
                if (!"".equals(orderArray.getString(i))){
                    SaleBidOrder saleBidOrder = new SaleBidOrder();
                    saleBidOrder.setId(orderArray.getString(i));
                    saleBidOrder.setSaved(true);
                    saleBidOrderList.add(saleBidOrder);
                }
            }
            List<SaleBidOrderDetail> delDetailList = new ArrayList<SaleBidOrderDetail>();
            JSONArray delArray = JSONArray.parseArray(delDetail);
            for (int i=0;i<delArray.size();i++){
                if (delArray.getJSONObject(i)!=null){
                    JSONObject json = delArray.getJSONObject(i);
                    SaleBidOrderDetail saleBidOrderDetail = new SaleBidOrderDetail();
                    saleBidOrderDetail.setSaved(json.getBoolean("saved"));
                    saleBidOrderDetail.setId(json.getString("id"));
                    delDetailList.add(saleBidOrderDetail);
                }
            }
            List<SaleBidOrderDetail> saleBidOrderDetailList = new ArrayList<SaleBidOrderDetail>();
            JSONArray array = JSONArray.parseArray(detailArray);
            for (int i=0;i<array.size();i++){
                if (array.getJSONObject(i)!=null){
                    JSONObject json = array.getJSONObject(i);
                    SaleBidOrderDetail saleBidOrderDetail = new SaleBidOrderDetail();
                    saleBidOrderDetail.setId(json.getString("id"));
                    saleBidOrderDetail.setActuallyCount(json.getInteger("actuallyCount"));
                    saleBidOrderDetail.setSaved(json.getBoolean("saved"));
                    saleBidOrderDetailList.add(saleBidOrderDetail);
                }
            }
            JSONObject json = new JSONObject();
            json.put("saleBidOrderList",saleBidOrderList);
            json.put("delBidOrderList",delBidOrderList);
            json.put("saleBidOrderDetailList",saleBidOrderDetailList);
            json.put("delDetailList",delDetailList);
            json.put("reviewFlag",reviewFlag);
            json.put("purchaseTenderId",purchaseTenderId);
            this.saleBidService.saveReview(json);
            obj.put("success",true);
            obj.put("msg","保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            obj.put("success",false);
            obj.put("msg","保存失败！");
        }
        return obj;
    }

    /**
     * 获取选中的供应商列表
     * @param pageFilter
     * @return
     */
    @RequestMapping("getPurchaseSupplier")
    @ResponseBody
    public Grid getPurchaseSupplier(PageFilter pageFilter,PurchaseTenderOrderSupplier purchaseTenderOrderSupplier){
        if (pageFilter != null){
            purchaseTenderOrderSupplier.setOrderStr(pageFilter.getOrderString());
        }
        return this.purchaseTenderService.getPurchaseSupplier(purchaseTenderOrderSupplier);
    }

    /**
     * 发送邀请给供应商
     * @param purchaseTenderOrder
     * @return
     */
    @RequestMapping("publishSupplier")
    @ResponseBody
    public JSONObject publishSupplier(PurchaseTenderOrder purchaseTenderOrder){
        JSONObject json = new JSONObject();
        try {
            this.purchaseTenderService.savePurchaseTenderSupplier(purchaseTenderOrder);
            json.put("success", true);
            json.put("msg","发送成功！");
        }catch (Exception e){
            json.put("success",false);
            json.put("msg","发送失败！");
        }
        return json;
    }

    /**
     * 获取推荐供应商
     * @return
     */
    @RequestMapping("getSupplierRecommend")
    @ResponseBody
    public List<CompBaseInfo> getSupplierRecommend(){
        return this.purchaseTenderService.getSupplierRecommend();
    }

    /**
     * 招标推送贸易
     * @param purchaseTenderOrder
     */
    private static void publishBusiness(final PurchaseTenderOrder purchaseTenderOrder){
        Runnable runnable = new Runnable() {
            public void run() {
                PurchaseTenderOrderOut purchaseTenderOrderOut = new PurchaseTenderOrderOut();
                BeanUtils.copyProperties(purchaseTenderOrder,purchaseTenderOrderOut);
            }
        };
        pool.execute(runnable);
    }

    /**
     * 厂商计划
     * @param purchaseTenderOrder
     */
    private static void companyPlan(final PurchaseTenderOrder purchaseTenderOrder){
        Runnable runnable = new Runnable() {
            public void run() {
                List<PurchaseTenderDetail> purchaseTenderDetailList = purchaseTenderOrder.getPurchaseTenderDetailList();
                JSONObject DestinationObj = new JSONObject();
                JSONArray Destination = new JSONArray();
                DestinationObj.put("CityId",purchaseTenderOrder.getDeliverAddressId());
                DestinationObj.put("CityName",purchaseTenderOrder.getDeliverAddress());
                Destination.add(DestinationObj);
                String[] _OrgionId = purchaseTenderOrder.getRuleSourceId().split(",");
                String[] _OrgionName = purchaseTenderOrder.getRuleSourceName().split(",");
                JSONArray Orgion = new JSONArray();
                for (int i=0;i<_OrgionId.length;i++){
                    if (!"".equals(_OrgionId[i])){
                        JSONObject obj = new JSONObject();
                        obj.put("CityId",_OrgionId[i]);
                        obj.put("CityName",_OrgionName[i]);
                        Orgion.add(obj);
                    }
                }
                for (PurchaseTenderDetail purchaseTenderDetail:purchaseTenderDetailList){
                    Map companyPlan = new HashMap();
                    CompBaseInfo compBaseInfo = (CompBaseInfo) RedisUtil.hget("CompBaseInfoList", purchaseTenderOrder.getCompanyId());
                    if (compBaseInfo!=null){
                        companyPlan.put("CompanyName",compBaseInfo.getCompanyName());
                        companyPlan.put("CompanyTel",compBaseInfo.getTel());
                    }else {
                        compBaseInfo = companyService.getCompanyInfoById(companyPlan.get("companyId").toString());
                        companyPlan.put("CompanyName",compBaseInfo.getCompanyName());
                        companyPlan.put("CompanyTel",compBaseInfo.getTel());
                    }
                    companyPlan.put("GoodsName",purchaseTenderDetail.getProductName());
                    companyPlan.put("GoodsUnit",purchaseTenderDetail.getUnitName());
                    companyPlan.put("GoodsType",purchaseTenderDetail.getProductTypeName());
                    companyPlan.put("GoodsQty",purchaseTenderDetail.getCount());
                    companyPlan.put("Destination",Destination);
                    companyPlan.put("Orgion",Orgion);
                    InfoPublishUtil.CompanyPlan(companyPlan);
                }
            }
        };
        pool.execute(runnable);
    }

    /**
     * 关注企业
     * @param compSuppliers
     * @return
     */
    @RequestMapping("concernCompany")
    @ResponseBody
    public JSONObject concernCompany(CompSuppliers compSuppliers){
        JSONObject json = new JSONObject();
        compSuppliers.setId(this.globalIdService.getGlobalId());
        compSuppliers.setSupplierRelationship(SupplierTypeEnum.hezuo.getCode());
        compSuppliers.setCompid("1312312313");
        compSuppliers.setSupplierType(0);
        try {
            this.purchaseTenderService.insertConcernCompany(compSuppliers);
            json.put("success", true);
            json.put("msg", "关注成功！");
        }catch (Exception e){
            json.put("success",false);
            json.put("msg","关注失败！");
        }
        return json;
    }
}
