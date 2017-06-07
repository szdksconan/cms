package com.cms.controller.sale;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
//import com.cms.iservice.maoyi.ProductCenterService;
import com.cms.iservice.maoyi.ProductCenterService;
import com.cms.iservice.shengchan.CompanyRuleSV;
import com.cms.iservice.shengchan.CompanyService;
import com.cms.iservice.shengchan.MainProductService;
import com.cms.model.shengchang.*;
import com.cms.model.util.GlobalTypeEnum;
import com.cms.model.util.GlobalUtil;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.service.common.redis.RedisUtil;
import com.cms.util.*;
import com.cms.web.util.s3.S3Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;



/**
 * Created by weitianyu on 2016/4/29.
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private MainProductService mainProductService;

    @Autowired
    private GlobalIdService globalIdService;
    
	@Autowired
	private CompanyRuleSV companyRuleSV;

	@Autowired
	ProductCenterService maoyiService;
	
	@Autowired
	private static CompanyService companyService;

    @Autowired
    private static XSThreadPool pool;

	@RequestMapping("addMainProduct")
    @ResponseBody
    public JSONObject addMainProduct(MainProductBean mainProductBean,MultipartHttpServletRequest request){
        pool = new XSThreadPool();
        Map companyPlan = new HashMap();//厂商计划
        JSONObject json = new JSONObject();
        companyPlan.put("GoodsType",mainProductBean.getProductTypeName());
        companyPlan.put("companyId",mainProductBean.getCompanyId());
    	try {
			mainProductBean.setCreateTime(GlobalUtil.getCreateTime());
            String _mainid = globalIdService.getGlobalId()+"";
			mainProductBean.setId(mainProductBean.getId() == null ? _mainid : ("".equals(mainProductBean.getId()) ? _mainid : mainProductBean.getId()));
            String[] _delDocArray = mainProductBean.getDelMainFileKeys().split(",");
            List<MainDocBean> delMainDocList = new ArrayList<MainDocBean>();
            //组装删除的fileKey
            for (int i=0;i<_delDocArray.length;i++){
                if (!"".equals(_delDocArray[i])){
                    String fileKey=_delDocArray[i];
                    MainDocBean mainDocBean = (MainDocBean) RedisUtil.hget("produceMainDocList"+mainProductBean.getId(),fileKey);
                    if (mainDocBean==null){
                        mainDocBean = new MainDocBean();
                        mainDocBean.setId(fileKey);
                    }
                    delMainDocList.add(mainDocBean);
                    try{
                        S3Util.deleteObject(S3Util.producerBucketName, mainDocBean.getFileKey());
                    }catch (RuntimeException e){}
                    RedisUtil.hdel("produceMainDocList" + mainProductBean.getId(),fileKey);
                }
            }
            mainProductBean.setDelMainDocList(delMainDocList);
            Map _filePara = new HashMap();
            String _now = GlobalUtil.getCreateTime().substring(0,10);
            //上传系列主图
            _filePara.put("fileList",request.getFiles(mainProductBean.getMainProductPicNameTrue()));
            _filePara.put("fileKey","mainProductDoc/"+_now+"/"+mainProductBean.getId());
            _filePara.put("everyone",true);
            List fileList = FileOperate.FileUploadMultipartFile(_filePara);
            List<MainDocBean> mainDocBeanList = new ArrayList<MainDocBean>();
            for (int i=0;i<fileList.size();i++){
                Map fileMap = (Map) fileList.get(i);
                MainDocBean mainDocBean = new MainDocBean();
                String _mainProductDocID = this.globalIdService.getGlobalId()+"";
                mainDocBean.setId(_mainProductDocID);
                mainDocBean.setPid(mainProductBean.getId());
                mainDocBean.setFileType(GlobalTypeEnum.IMG.getCode());
                mainDocBean.setCreateTime(GlobalUtil.getCreateTime());
                mainDocBean.setIsMain(true);
                mainDocBean.setSort(i + 1);
                mainDocBean.setFileUrl(fileMap.get("path").toString());
                mainDocBean.setFileKey(fileMap.get("key").toString());
                RedisUtil.hset("produceMainDocList" + mainProductBean.getId(), mainDocBean.getId(), mainDocBean);
                mainDocBeanList.add(mainDocBean);
            }
            //上传系列附件
            _filePara.put("fileList",request.getFiles(mainProductBean.getMainProductPicName()));
            _filePara.put("fileKey","mainProductDoc/"+_now+"/"+mainProductBean.getId());
            _filePara.put("everyone",true);
            fileList = FileOperate.FileUploadMultipartFile(_filePara);
            //组装系列附件
            for (int i=0;i<fileList.size();i++){
                Map fileMap = (Map) fileList.get(i);
                MainDocBean mainDocBean = new MainDocBean();
                String _mainProductDocID = this.globalIdService.getGlobalId()+"";
                mainDocBean.setId(_mainProductDocID);
                mainDocBean.setSort(i+1);
                mainDocBean.setPid(mainProductBean.getId());
                mainDocBean.setFileType(GlobalTypeEnum.IMG.getCode());
                mainDocBean.setCreateTime(GlobalUtil.getCreateTime());
                mainDocBean.setFileUrl(fileMap.get("path").toString());
                mainDocBean.setFileKey(fileMap.get("key").toString());
                RedisUtil.hset("produceMainDocList"+mainProductBean.getId(), mainDocBean.getId(),mainDocBean);
                mainDocBeanList.add(mainDocBean);
            }
            mainProductBean.setMainDocList(mainDocBeanList);
            //组装删除的物资
            String[] _delProductArray = mainProductBean.getDelProductIds().split(",");
            List<ProductBean> delProductBeanList = new ArrayList<ProductBean>();
            for (int i=0;i<_delProductArray.length;i++){
                if (!"".equals(_delProductArray[i])&&_delProductArray[i].length()>5){
                    ProductBean productBean = new ProductBean();
                    productBean.setId(_delProductArray[i]);
                    delProductBeanList.add(productBean);
                }
            }
            mainProductBean.setDelProductBeanList(delProductBeanList);
            JSONArray productArray = JSONArray.parseArray(mainProductBean.getProductBeanStr());
            JSONArray ruleArray = JSONArray.parseArray(mainProductBean.getProductSellRuleStr());
            //组装物资
            List<ProductBean> productBeanList = new ArrayList<ProductBean>();
            JSONArray Orgion = new JSONArray();//厂商计划
            Integer _count = 0;
            for (int i=0;i<productArray.size();i++){
                JSONObject obj = (JSONObject) productArray.get(i);
                ProductBean productBean = JSONObject.toJavaObject(obj,ProductBean.class);
                String _productId = this.globalIdService.getGlobalId()+"";
                productBean.setId(productBean.getId()==null?_productId:(("".equals(productBean.getId())||productBean.getId().length()<4)?_productId:productBean.getId()));
                productBean.setProductName(mainProductBean.getProductName());
                productBean.setMainProductId(mainProductBean.getId());
                productBean.setCreateTime(GlobalUtil.getCreateTime());
                _count+=productBean.getWarehouseBalance();
                //组装产品属性参数
                JSONObject paraObject = JSONObject.parseObject(obj.getString("productConfigObj"));
                String[] keys = paraObject.getString("key").split(",");
                List<ProductParameterBean> productParameterBeanList = new ArrayList<ProductParameterBean>();
                for (int j=0;j<keys.length;j++){
                    if (!"".equals(keys[j])){
                        ProductParameterBean productParameterBean = new ProductParameterBean();
                        productParameterBean.setId(this.globalIdService.getGlobalId()+"");
                        productParameterBean.setProductId(productBean.getId());
                        productParameterBean.setParameterName(keys[j]);
                        productParameterBean.setParameterValue(paraObject.getString(keys[j]));
                        productParameterBean.setCreateTime(GlobalUtil.getCreateTime());
                        productParameterBeanList.add(productParameterBean);
                    }
                }
                productBean.setProductParameterBeanList(productParameterBeanList);
                //组装删除附件keys
                List<ProductDocBean> delProductDocBeanList = new ArrayList<ProductDocBean>();
                if (productBean.getDelProductFileKeys()!=null){
                    String[] _delProductDocArray = productBean.getDelProductFileKeys().split(",");
                    for (int j=0;j<_delProductDocArray.length;j++){
                        if (!"".equals(_delProductDocArray[j])){
                            String fileKey=_delProductDocArray[j];
                            ProductDocBean productDocBean = (ProductDocBean) RedisUtil.hget("produceProductDoc" + productBean.getId(),fileKey);
                            if (productDocBean==null){
                                productDocBean = new ProductDocBean();
                                productDocBean.setId(fileKey);
                            }
                            delProductDocBeanList.add(productDocBean);
                            try{
                                S3Util.deleteObject(S3Util.producerBucketName,productDocBean.getFileKey());
                            }catch (RuntimeException e){}
                            RedisUtil.hdel("produceProductDoc" + productBean.getId(),fileKey);
                        }
                    }
                }
                productBean.setDelProductDocList(delProductDocBeanList);
                _filePara = new HashMap();
                _filePara.put("fileList",request.getFiles(obj.getString("productPicName")));
                _filePara.put("fileKey","productDoc/"+_now+"/"+productBean.getId());
                _filePara.put("everyone",true);
                fileList = FileOperate.FileUploadMultipartFile(_filePara);//上传物资列表附件
                List<ProductDocBean> productDocBeanList = new ArrayList<ProductDocBean>();
                //组装物资附件
                for (int j=0;j<fileList.size();j++){
                    Map fileMap = (Map) fileList.get(j);
                    ProductDocBean productDocBean = new ProductDocBean();
                    String _productDocId = this.globalIdService.getGlobalId()+"";
                    productDocBean.setId(_productDocId);
                    productDocBean.setProductId(productBean.getId());
                    productDocBean.setFileType(GlobalTypeEnum.IMG.getCode());
                    productDocBean.setSort(j+1);
                    String path = fileMap.get("path").toString();
                    productDocBean.setFileUrl(path);
                    productDocBean.setFileKey(fileMap.get("key").toString());
                    productDocBean.setCreateTime(GlobalUtil.getCreateTime());
                    RedisUtil.hset("produceProductDoc"+productBean.getId(),productDocBean.getId(),productDocBean);
                    productDocBeanList.add(productDocBean);
                }
                productBean.setProductDocBeanList(productDocBeanList);
                JSONObject cityJson = new JSONObject();
                cityJson.put("CityId",productBean.getIndustryId());
                cityJson.put("CityName",productBean.getIndustryName());
                Orgion.add(cityJson);
                productBeanList.add(productBean);
            }
            companyPlan.put("Orgion",Orgion.toString());
            companyPlan.put("GoodsQty",_count);
            mainProductBean.setProductBeanList(productBeanList);
            //组装删除的销售规则
            String[] _delProductRuleIds = mainProductBean.getDelProductRuleIds().split(",");
            List<ProductSellRuleBean> delProductSellRuleBeanList = new ArrayList<ProductSellRuleBean>();
            for (int i=0;i<_delProductRuleIds.length;i++){
                if (!"".equals(_delProductRuleIds[i])&&_delProductRuleIds[i].length()>5){
                    ProductSellRuleBean productSellRuleBean = new ProductSellRuleBean();
                    productSellRuleBean.setId(_delProductRuleIds[i]);
                    delProductSellRuleBeanList.add(productSellRuleBean);
                }
            }
            mainProductBean.setDelProductSellRuleBeanList(delProductSellRuleBeanList);
            //组装规则
            List<ProductSellRuleBean> productSellRuleBeanList = new ArrayList<ProductSellRuleBean>();
            List<ProductPriceBean> productPriceBeanList = new ArrayList<ProductPriceBean>();
            JSONArray Destination = new JSONArray();
            for (int i=0;i<ruleArray.size();i++){
                JSONObject obj = (JSONObject) ruleArray.get(i);
                ProductSellRuleBean productSellRuleBean = JSONObject.toJavaObject(obj,ProductSellRuleBean.class);
                String _ruleId = this.globalIdService.getGlobalId()+"";
                productSellRuleBean.setId(productSellRuleBean.getId()==null?_ruleId:("".equals(productSellRuleBean.getId())||productSellRuleBean.getId().length()<4?_ruleId:productSellRuleBean.getId()));
                productSellRuleBean.setMainProductId(mainProductBean.getId());
                productSellRuleBean.setCreateTime(GlobalUtil.getCreateTime());
                String[] areaCodeArray = productSellRuleBean.getRuleAreaCode().split(",");
                String[] ruleAreaArray = productSellRuleBean.getRuleArea().split(",");
                //组装规则适用区域
                List<ProductSellRuleAreaBean> productSellRuleAreaBeanList = new ArrayList<ProductSellRuleAreaBean>();
                for (int j=0;j<areaCodeArray.length;j++){
                    if (!"".equals(areaCodeArray[j])){
                        String[] _areaCode = areaCodeArray[j].split("-");
                        String[] _areaName = ruleAreaArray[j].split("-");
                        if (!"".equals(_areaCode[0])){
                            ProductSellRuleAreaBean productSellRuleAreaBean = new ProductSellRuleAreaBean();
                            productSellRuleAreaBean.setId(this.globalIdService.getGlobalId()+"");
                            productSellRuleAreaBean.setProductSellRuleId(productSellRuleBean.getId());
                            productSellRuleAreaBean.setCompanyId("1312312313");
                            switch (_areaCode.length){
                                case 1:
                                    productSellRuleAreaBean.setProvinceId(_areaCode[0] == null ? "" : _areaCode[0]);
                                    productSellRuleAreaBean.setProvinceName(_areaName[0] == null?"":_areaName[0]);
                                    break;
                                case 2:
                                    productSellRuleAreaBean.setProvinceId(_areaCode[0] == null ? "" : _areaCode[0]);
                                    productSellRuleAreaBean.setProvinceName(_areaName[0] == null?"":_areaName[0]);
                                    productSellRuleAreaBean.setCityId(_areaCode[1]==null?"":_areaCode[1]);
                                    productSellRuleAreaBean.setCityName(_areaName[1] == null?"":_areaName[1]);
                                    break;
                                case 3:
                                    productSellRuleAreaBean.setProvinceId(_areaCode[0] == null ? "" : _areaCode[0]);
                                    productSellRuleAreaBean.setProvinceName(_areaName[0] == null?"":_areaName[0]);
                                    productSellRuleAreaBean.setCityId(_areaCode[1]==null?"":_areaCode[1]);
                                    productSellRuleAreaBean.setCityName(_areaName[1] == null?"":_areaName[1]);
                                    productSellRuleAreaBean.setAreaId(_areaCode[2]==null?"":_areaCode[2]);
                                    productSellRuleAreaBean.setAreaName(_areaName[2] == null?"":_areaName[2]);
                                    break;
                            }
                            productSellRuleAreaBeanList.add(productSellRuleAreaBean);
                        }
                        JSONObject cityJson = new JSONObject();
                        cityJson.put("CityId",areaCodeArray[j]);
                        cityJson.put("CityName",ruleAreaArray[j]);
                        Destination.add(cityJson);
                    }
                }
                productSellRuleBean.setProductSellRuleAreaBeanList(productSellRuleAreaBeanList);
                //组装产品价格
                JSONObject _rulePrice = obj.getJSONObject("rulePrice");
                for (ProductBean productBean:productBeanList){
                    if (!"".equals(_rulePrice.getString(productBean.getProductCode()))){
                        if (_rulePrice.getDouble(productBean.getProductCode())!=null){
                            ProductPriceBean productPriceBean = new ProductPriceBean();
                            productPriceBean.setId(this.globalIdService.getGlobalId()+"");
                            productPriceBean.setProductId(productBean.getId());
                            productPriceBean.setMainProductId(mainProductBean.getId());
                            productPriceBean.setProductCode(productBean.getProductCode());
                            productPriceBean.setProductSellRuleId(productSellRuleBean.getId());
                            productPriceBean.setPrice(BigDecimal.valueOf(_rulePrice.getDouble(productBean.getProductCode())));
                            productPriceBeanList.add(productPriceBean);
                        }
                    }
                }
                productSellRuleBeanList.add(productSellRuleBean);
            }
            companyPlan.put("Destination",Destination.toString());
            mainProductBean.setProductPriceBeanList(productPriceBeanList);
            mainProductBean.setProductSellRuleBeanList(productSellRuleBeanList);
            this.mainProductService.saveMainProduct(mainProductBean);
            pushBusiness(mainProductBean,this.mainProductService,this.maoyiService,this.companyService);//推送贸易
            CompanyPlan(companyPlan);//推送物流
            json.put("msg","操作成功");
            json.put("success",true);
		} catch (Exception e) {
			e.printStackTrace();
            json.put("msg","操作失败");
            json.put("success",false);
		}
        return json;
    }

    
    /**
     * 获取该企业所有规则
     * @param request
     * @return
     */
    @RequestMapping("getAllSaleRule")
    @ResponseBody
    public JSONObject getAllSaleRule(HttpServletRequest request){
        JSONObject json = new JSONObject();
        List<CompSaleRule> list = this.companyRuleSV.getAllSaleRule("1312312313");
        List saleRuleList = new ArrayList();
        for(CompSaleRule compSaleRule:list){
        	HashMap map = new HashMap();
        	map.put("label", compSaleRule.getRuleName());
        	map.put("value", compSaleRule.getId());
        	saleRuleList.add(map);
        }
        json.put("list",saleRuleList);
        return json;
    } 
    
    /**
     * 根据ID获取规则详细
     * @param id
     * @return
     */
    @RequestMapping("getSaleRuleAreaById")
    @ResponseBody
    public JSONObject getSaleRuleAreaById(String id){
        JSONObject json = new JSONObject();
        List<CompSaleRuleArea> l = this.companyService.getRuleAreaByRuleId(id);
        List areaName = new ArrayList();
        List areaCode = new ArrayList();
        for(CompSaleRuleArea compSaleRuleArea : l){
        	StringBuffer name = new StringBuffer(); 
        	StringBuffer code = new StringBuffer(); 
        	if(compSaleRuleArea.getSheng() != null && !"".equals(compSaleRuleArea.getSheng())){
        		name.append(compSaleRuleArea.getSheng());
        		code.append(compSaleRuleArea.getShengId());
        	}
        		
        	if(compSaleRuleArea.getCity() !=null && !"".equals(compSaleRuleArea.getCity())){
        		name.append("-"+compSaleRuleArea.getCity());
        		code.append("-"+compSaleRuleArea.getCityId());
        	}
        	if(compSaleRuleArea.getXian() !=null && !"".equals(compSaleRuleArea.getXian())){
        		name.append("-"+compSaleRuleArea.getXian());
        		code.append("-"+compSaleRuleArea.getXianId());
        	}
        	areaName.add(name);
        	areaCode.add(code);
        }
        json.put("nameArray",areaName);
        json.put("codeArray", areaCode);
        return json;
    } 
    
    /**
     * 根据ID获取规则详细
     * @param id
     * @return
     */
    @RequestMapping("getSaleRuleById")
    @ResponseBody
    public JSONObject getSaleRuleById(String id){
        JSONObject json = new JSONObject();
        CompSaleRuleBean compSaleRuleBean = this.companyRuleSV.getSaleRuleById(id,"1312312313");
        json.put("compSaleRuleBean", compSaleRuleBean);
        return json;
    } 

    @RequestMapping("getMainProductList")
    @ResponseBody
    public Grid getMainProductList(PageFilter pageFilter,MainProductBean mainProductBean){
        if (pageFilter!=null){
            mainProductBean.setOrderStr(pageFilter.getOrderString());
        }
        return this.mainProductService.getMainProductList(mainProductBean);
    }


    @RequestMapping("updateMainProduct")
    @ResponseBody
    public Grid updateMainProduct(MainProductBean mainProductBean){
        this.mainProductService.updateMainProduct(mainProductBean);
        mainProductBean.setId("");
        return this.mainProductService.getMainProductList(mainProductBean);
    }

    @RequestMapping("deleteMainProduct")
    @ResponseBody
    public JSONObject deleteMainProduct(MainProductBean mainProductBean){
        JSONObject obj = new JSONObject();
        try{
            this.mainProductService.delMainProductById(mainProductBean);
            obj.put("success",true);
            obj.put("msg","删除成功！");
        }catch (Exception e){
            obj.put("success",false);
            obj.put("msg","删除失败！");
        }
        return obj;
    }

    @RequestMapping("updatePage")
    public ModelAndView updatePage(MainProductBean mainProductBean){
        ModelAndView model = new ModelAndView("../xiaoshou/xs_cpfb");
        List<MainProductBean> mainProductBeanList = this.mainProductService.getMainProductById(mainProductBean);
        if (mainProductBeanList.size()!=0){
            mainProductBean = mainProductBeanList.get(0);
        }
        Map map = new HashMap();
        map.put("json",JSONObject.toJSON(mainProductBean));
        model.addObject("mainProductBean",map);
        return model;
    }
    

    /**
     * 新增或更新品牌
     * @param compBrandBean
     * @return
     */
    @RequestMapping("addOrUpdateCompBrand")
    @ResponseBody
    public String addOrUpdateCompBrand(CompBrandBean  compBrandBean){
	    try {
	        	//判断ID是否新增数据
	        	if(compBrandBean.getId().toString().indexOf("99001") == 0){
	        		//封装新增数据
	        		compBrandBean.setId(String.valueOf(this.globalIdService.getGlobalId()));
	        		compBrandBean.setCreateTime(new Date());
	        		this.mainProductService.addBrand(compBrandBean);
	        	}
	        	else{
	        		this.mainProductService.updateBrand(Long.valueOf( compBrandBean.getId()),compBrandBean.getBrandName());
	        	}
	        return "操作成功！";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "操作失败！";
		}

    
    }
    
    /**
     * 删除品牌
     * @param compBrandBean
     * @return
     */
    @RequestMapping("delCompBrand")
    @ResponseBody
    public String delCompBrand(CompBrandBean  compBrandBean){
	    try {
            this.mainProductService.delBrand(compBrandBean);
	        return "操作成功！";
		} catch (Exception e) {
			e.printStackTrace();
			return "操作失败！";
		}

    
    }
    
    /**
     * 获取该企业品牌List
     * @param companyId
     * @return
     */
    @RequestMapping("getBrandList")
    @ResponseBody
    public String getBrandList(String companyId ){
    	StringBuffer data = new StringBuffer();
    	try {
			List<CompBrandBean> list = this.mainProductService.getBrandList(Long.valueOf(companyId));
			data.append(JSONObject.toJSONString(list));
			return data.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
    	
    }
    
    /**
     * 品牌下拉框List
     * @param companyId
     * @return
     */
    @RequestMapping("getBrandSelectList")
    @ResponseBody
    public JSONObject getBrandSelectList(String companyId ){
    	StringBuffer data = new StringBuffer();
    	List newlist = new ArrayList();
        JSONObject json = new JSONObject();
    	try {
			List<CompBrandBean> list = this.mainProductService.getBrandList(Long.valueOf(companyId));
			for(CompBrandBean compBrandBean:list){
				HashMap map = new HashMap();
				map.put("label", compBrandBean.getBrandName());
				map.put("value", compBrandBean.getId());
				newlist.add(map);
			}
		    json.put("list",newlist);
		    return json;
		} catch (Exception e) {
			e.printStackTrace();
			return json;
		}
    }

    /**
     * 厂家计划 推送物流
     */
    private static void CompanyPlan(final Map companyPlan){
        Runnable runnable = new Runnable() {
            public void run() {
                CompBaseInfo compBaseInfo = (CompBaseInfo) RedisUtil.hget("CompBaseInfoList", companyPlan.get("companyId").toString());
                if (compBaseInfo!=null){
                    companyPlan.put("CompanyName",compBaseInfo.getCompanyName());
                    companyPlan.put("CompanyTel",compBaseInfo.getTel());
                }else {
                    compBaseInfo = companyService.getCompanyInfoById(companyPlan.get("companyId").toString());
                    companyPlan.put("CompanyName",compBaseInfo.getCompanyName());
                    companyPlan.put("CompanyTel",compBaseInfo.getTel());
                }
                if (companyPlan.get("GoodsName")==null){
                    companyPlan.put("GoodsName","DELL");
                }
                if (companyPlan.get("GoodsUnit")==null){
                    companyPlan.put("GoodsUnit","台");
                }
                InfoPublishUtil.CompanyPlan(companyPlan);
            }
        };
        pool.execute(runnable);
    }

    /**
     * 推送贸易
     */
    private static void pushBusiness(final MainProductBean mainProductBean,final MainProductService mainProductService,final ProductCenterService maoyiService,final  CompanyService companyService){
        Runnable runnable = new Runnable() {
            public void run() {
                //赋值
                MainProductOutBean outbean =  new MainProductOutBean();
                outbean.setId(Long.valueOf(mainProductBean.getId()));
                outbean.setCompanyId(Long.valueOf(mainProductBean.getCompanyId()));
                outbean.setMainProductName(mainProductBean.getProductName());
                outbean.setBrandName(mainProductBean.getBrandName());
                outbean.setSetIntroduce(mainProductBean.getSetIntroduce());
                outbean.setIndustryId(Long.valueOf(10010101));
                outbean.setIndustry("平板电视");
                CompBaseInfo compBaseInfo = companyService.getCompanyInfoById(String.valueOf(mainProductBean.getCompanyId())) ;
                outbean.setCompanyName(compBaseInfo.getCompanyName());
                //封装产品信息
                List<ProductBean> productList = mainProductBean.getProductBeanList();
                List productOutList = new ArrayList();
                for(ProductBean productBean : productList){
                    ProductOutBean productOutBean = new ProductOutBean();
                    productOutBean.setProductId(productBean.getId());
                    productOutBean.setProductName(productBean.getProductName());
                    productOutBean.setIndustryName(productBean.getIndustryName());
                    productOutBean.setKucun(String.valueOf(productBean.getWarehouseBalance()));
                    List<ProductDocBean> productDocList = mainProductService.getProductDocListByFilter(Long.valueOf(productBean.getId()) ,"", "");
                    List productOutDocList = new ArrayList();
                    for(ProductDocBean productDocBean : productDocList){
                        DocOutBean docOutBean = new DocOutBean();

                        if(productDocBean.getFileType() !=null)
                            docOutBean.setFileType(productDocBean.getFileType().toString());
                        else
                            docOutBean.setFileType("");
                        docOutBean.setFileUrl(productDocBean.getFileUrl());
                        if(productDocBean.getIsMain() != null)
                            docOutBean.setIsMain(productDocBean.getIsMain().toString());
                        else
                            docOutBean.setIsMain("");
                        productOutDocList.add(docOutBean);

                    }

                    productOutBean.setDocList(productOutDocList);
                    List<ProductParameterBean> paraList = productBean.getProductParameterBeanList();
                    List paraOutList =new ArrayList();
                    for(ProductParameterBean productParameterBean : paraList){
                        ParamOutBean paramOutBean = new ParamOutBean();
                        paramOutBean.setParameterName(productParameterBean.getParameterName());
                        paramOutBean.setParameterValue(productParameterBean.getParameterValue());
                        paraOutList.add(paramOutBean);
                    }
                    productOutBean.setParaList(paraOutList);
                    productOutBean.setListedTime(productBean.getIpoTime());
                    productOutBean.setProductModelSize(productBean.getProductModelSize());
                    productOutBean.setProductCode(productBean.getProductCode());
                    productOutList.add(productOutBean);
                }
                outbean.setProductOutList(productOutList);

                //封装主营产品附件
                List<MainDocBean> MainDocList = mainProductService.getMainProductDocListByFilter(Long.valueOf(mainProductBean.getId()), "", "");
                List MainOutDocList = new ArrayList();
                for(MainDocBean mainDocBean : MainDocList){
                    DocOutBean docOutBean = new DocOutBean();
                    if(mainDocBean.getFileType() != null)
                        docOutBean.setFileType(mainDocBean.getFileType().toString());
                    else
                        docOutBean.setFileType("");
                    docOutBean.setFileUrl(mainDocBean.getFileUrl());
                    if(mainDocBean.getIsMain() != null)
                        docOutBean.setIsMain(mainDocBean.getIsMain().toString());
                    else
                        docOutBean.setIsMain("");
                    MainOutDocList.add(docOutBean);
                }
                outbean.setDocList(MainOutDocList);

                //封装销售规则
                List ruleOutList =new ArrayList();
                List<ProductSellRuleBean> list = mainProductBean.getProductSellRuleBeanList();
                for(ProductSellRuleBean productSellRuleBean : list){
                    ProductSellRuleOutBean ruleOutBean = new ProductSellRuleOutBean();
                    ruleOutBean.setId(Long.valueOf(productSellRuleBean.getId()));
                    ruleOutBean.setAftermarketExplain(productSellRuleBean.getAftermarketExplain());
                    ruleOutBean.setMainProductId(Long.valueOf(productSellRuleBean.getMainProductId()));
                    ruleOutBean.setUpdateTime(productSellRuleBean.getUpdateTime());
                    ruleOutBean.setUpdator(productSellRuleBean.getUpdator());
                    ruleOutBean.setSellType(productSellRuleBean.getSellType());
                    ruleOutBean.setPayType(productSellRuleBean.getPayType());
                    ruleOutBean.setDeposit(productSellRuleBean.getDeposit());
                    ruleOutBean.setProduceDutyExplain(productSellRuleBean.getProduceDutyExplain());
                    ruleOutBean.setTraderDutyExplain(productSellRuleBean.getTraderDutyExplain());
                    ruleOutBean.setProductSellRuleAreaBeanList(productSellRuleBean.getProductSellRuleAreaBeanList());
                    List pricelist = mainProductService.getProductPricListByRuleId(Long.valueOf(productSellRuleBean.getId()));
                    ruleOutBean.setPriceList(pricelist);
                    ruleOutList.add(ruleOutBean);
                }
                outbean.setProductSellRuleOutBeanList(ruleOutList);
              HashMap map = new HashMap();
              map.put("outbean", outbean);
              maoyiService.insert(map);
            }
        };
        pool.execute(runnable);
    }
}
