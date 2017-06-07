package com.cms.controller.purchase;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.shengchan.CompanyRuleSV;
import com.cms.iservice.shengchan.MainProductService;
import com.cms.iservice.shengchan.PurchaseNeedService;
import com.cms.iservice.shengchan.ShengchanRecommendService;
import com.cms.iservice.shengchan.shengchanCommonService;
import com.cms.model.dict.BaseIndustry;
import com.cms.model.shengchang.CompBuyRule;
import com.cms.model.shengchang.CompBuyRuleBean;
import com.cms.model.shengchang.MainProductBean;
import com.cms.model.shengchang.ProductSellRuleBean;
import com.cms.model.shengchang.PurchaseNeedBean;
import com.cms.model.shengchang.PurchaseNeedDetailBean;
import com.cms.model.shengchang.PurchaseNeedDetailDocBean;
import com.cms.model.shengchang.PurchaseNeedLinkman;
import com.cms.model.shengchang.PurchaseNeedRuleAreaBean;
import com.cms.model.shengchang.PurchaseNeedRuleBean;
import com.cms.model.util.GlobalOrderTypeEnum;
import com.cms.model.util.GlobalTypeEnum;
import com.cms.model.util.GlobalUtil;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.util.FileOperate;
import com.cms.web.util.s3.S3Util;

/**
 * Created by liuxin on 2016/3/25.
 */
@Controller
@RequestMapping("purchase")
public class 	PurchaseController {
    private String url="purchase/need/";

    @Autowired
    private PurchaseNeedService purchaseNeedService;
    
    @Autowired
    private CompanyRuleSV companyRuleSV;
    
    @Autowired
    private GlobalIdService globalIdService;
    
    @Autowired
    private shengchanCommonService shengchanCommonService;
    
    @Autowired
    private MainProductService mainProductService;
    
//    @Autowired
    private ShengchanRecommendService shengchanRecommendService;
    
//    @Autowired
//    private InfoHallService infoHallService;
//    @RequestMapping("test")
//    @ResponseBody
//    public Grid test(ChppQueryParam queryParam,PageFilter ph,HttpSession httpSession){
//        User loginUser = (User)httpSession.getAttribute("sso:loginUser");
//        return this.infoHallService.huoyuanList(queryParam,ph,loginUser);
//    }

    /**
     * 采购意向
     * @return
     */
    @RequestMapping("purchaseIntent")
    public String modelPurchaseIntent(){
        return url+"purchaseIntent";
    }

    /**
     * 采购意向list
     * @return
     */
    @RequestMapping("getPurchaseIntentList")
    @ResponseBody
    public Grid getPurchaseIntentList(){
        return this.purchaseNeedService.getPurchaseIntentList();
    }

    /**
     * 物资需求发布
     * @return
     */
    @RequestMapping("needReleaseListPage")
    public String needReleaseListPage(){
        return url+"needReleaseList";
    }

    /**
     * 采购意向发布历史
     * @return
     */
    @RequestMapping("needReleaseHistoryList")
    @ResponseBody
    public Grid needReleaseHistoryList(){
        return new Grid();
    }

    

    /**
     * 物资需求List
     * @return
     */
    @RequestMapping("getPurchaseNeddList")
    @ResponseBody
    public Grid getPurchaseNeddList(PageFilter pageFilter, PurchaseNeedBean purchaseNeedBean){
	        if (pageFilter!=null){
	        	
	        	purchaseNeedBean.setOrderStr(pageFilter.getOrderString());
	        	
	        }
	        
	        String needState = purchaseNeedBean.getPurchaseNeedState();

    	   Grid grid = new Grid();
    	   
    	   this.purchaseNeedService.getPurchaseNeedList(purchaseNeedBean);
    	   
           List<PurchaseNeedBean> list = this.purchaseNeedService.getPurchaseNeedList(purchaseNeedBean);
           
           int total = this.purchaseNeedService.getPurchaseNeedListNum(purchaseNeedBean);
           
           List outlist = new ArrayList();
           
    	   Date nowdate =  new Date();
    	   
   	    	Calendar rightNow = Calendar.getInstance();
   	    
   	    	rightNow.setTime(nowdate);
   	    
   	    	rightNow.add(Calendar.DAY_OF_YEAR, -1);
   	    	
   	    	nowdate = rightNow.getTime();
           
           for(PurchaseNeedBean outPurchaseNeedBean : list){
        
        	   outPurchaseNeedBean.setPurchaseNeedState(GlobalOrderTypeEnum.getName(Integer.valueOf(outPurchaseNeedBean.getPurchaseNeedState())));
        	   
        	   outPurchaseNeedBean.setPurchaseNeedType(GlobalTypeEnum.getName(Integer.valueOf(outPurchaseNeedBean.getPurchaseNeedType())));
        	    
        	   if(outPurchaseNeedBean.getFailTime().before(nowdate)){
        		   
        		   outPurchaseNeedBean.setPurchaseNeedState(outPurchaseNeedBean.getPurchaseNeedState()+",失效");
        		   
        	   }
          
        	   outlist.add(outPurchaseNeedBean);
           }
           
           grid.setRows(outlist);
           
           grid.setTotal(total);
           
           return grid;
    }
    

    /**
     * 物资需求DEL
     * @return
     */
    @RequestMapping("delPurchaseNeddById")
    @ResponseBody
    public JSONObject delPurchaseNeddById(String id){
        JSONObject obj = new JSONObject();
    	try {
			this.purchaseNeedService.delPurchaseNeedById(id);
		      obj.put("success",true);
	            obj.put("msg","删除成功！");
		
		} catch (Exception e) {
			  obj.put("success",false);
	            obj.put("msg","删除失败！");
		}
    	return obj;
    }
    

    /**
     * 物资采购需求新增或更新页面跳转
     * @return
     */
    @RequestMapping("purchaseNeddAddOrUpdate")
    public ModelAndView purchaseNeddAddOrUpdate(PurchaseNeedBean purchaseNeedBean){
        ModelAndView model = new ModelAndView("../caigou/c_wuzixuqiu_fb");
    	if(!"".equals(purchaseNeedBean.getId())){
    		String pid = purchaseNeedBean.getId();
    		PurchaseNeedBean needBean =	this.purchaseNeedService.getPurchaseNeedById(pid);
    		List<PurchaseNeedDetailBean> detailList = this.purchaseNeedService.getPurchaseNeedDetailBeanByPid(pid);
    		List<PurchaseNeedLinkman> linkList = this.purchaseNeedService.getPurchaseNeedLinkmanByPurchaseNeedId(pid);
    		PurchaseNeedRuleBean ruleBean = this.purchaseNeedService.getPurchaseNeedRuleBeanById(needBean.getPurchaseRuleId());
    		needBean.setNeedDetailJson(JSONObject.toJSONString(detailList));
    		needBean.setNeedRuleJson(JSONObject.toJSONString(ruleBean));
    		needBean.setNeedLinkJson(JSONObject.toJSONString(linkList));
    		model.addObject("needBean", needBean);
    	}
        return model;
    }
    

    
    /**
     * 获取所有基础采购规则
     * @param request
     * @return
     */
    @RequestMapping("getAllBuyRule")
    @ResponseBody
    public JSONObject getAllBuyRule(HttpServletRequest request){
        JSONObject json = new JSONObject();
        List<CompBuyRule> list = this.companyRuleSV.getAllBuyRule("1312312313");
        List BuyRuleList = new ArrayList();
        for(CompBuyRule compBuyRule:list){
        	HashMap map = new HashMap();
        	map.put("label", compBuyRule.getRuleName());
        	map.put("value", compBuyRule.getId());
        	BuyRuleList.add(map);
        }
        json.put("list",BuyRuleList);
        return json;
    } 
    
    /**
     * 根据Id获取所需要的采购规则信息
     *
     */
    @RequestMapping("getBuyRuleById")
    @ResponseBody
    public JSONObject getBuyRuleById(String ruleId){
        JSONObject json = new JSONObject();
        CompBuyRuleBean compBuyRuleBean = this.companyRuleSV.getBuyRuleById(ruleId,"1312312313");
        json.put("ruleBean",compBuyRuleBean);
        return json;
    } 
    
    /**
     * 新增或更新物资需求
     */
    @RequestMapping("addOrUpdatePurchaseNeed")
    @ResponseBody
    public String addOrUpdatePurchaseNeed(PurchaseNeedBean purchaseNeedBean){
    	
    	JSONObject json = new JSONObject();
    	

    	
    	try {
    		
    	//将状态转变成已有枚举值
    	String state = purchaseNeedBean.getPurchaseNeedState();
    	if("5".equals(state))
    		purchaseNeedBean.setPurchaseNeedState(String.valueOf(GlobalOrderTypeEnum.ZC.getCode()));
    	else
    		purchaseNeedBean.setPurchaseNeedState(String.valueOf(GlobalOrderTypeEnum.FB.getCode()));
			
    	//初始化联系人 时间 公司ID
    
    	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
    		
    	Date date=new Date();
    	
    	Date failTime = new Date();
    	
        String needType =  purchaseNeedBean.getPurchaseNeedType();
        
        if("".equals(needType))
        	
        	purchaseNeedBean.setPurchaseNeedType("34");
        	
        Calendar rightNow = Calendar.getInstance();
        
    	if("34".equals(needType)){
    		
    	rightNow.setTime(date);
    	
        rightNow.add(Calendar.MONTH,24);
        
        failTime = rightNow.getTime();
        
    	}
    	else if("35".equals(needType)){
    		
    	 	rightNow.setTime(date);
        	
            rightNow.add(Calendar.MONTH,12);
            
            failTime = rightNow.getTime();
            
    	}
    	else if("36".equals(needType)){
    		
    		rightNow.setTime(date);
        	
            rightNow.add(Calendar.MONTH,6);
            
            failTime = rightNow.getTime();
    		
    	}
    	else if("37".equals(needType)){
    		
    		rightNow.setTime(date);
        	
            rightNow.add(Calendar.MONTH,3);
            
            failTime = rightNow.getTime();
    		
    	}
    	else if("38".equals(needType)){
    		
    		rightNow.setTime(date);
        	
            rightNow.add(Calendar.MONTH,1);
            
            failTime = rightNow.getTime();
    		
    	}
    	else if("39".equals(needType)){
    		
    		rightNow.setTime(date);
        	
            rightNow.add(Calendar.DAY_OF_YEAR,15);
            
            failTime = rightNow.getTime();
    		
    	}
    	
    	String createTime = dateFormater.format(date);
    	
    	String companyId = "1312312313";
    	
    	String createUser = "刘鑫";
    	
    	//转换物资明细数据
    	List<PurchaseNeedDetailBean> detaillist = JSONObject.parseArray(purchaseNeedBean.getNeedDetailJson(),PurchaseNeedDetailBean.class);
    	
    	//转换联系人数据
    	List<PurchaseNeedLinkman> linklist = JSONObject.parseArray(purchaseNeedBean.getNeedLinkJson(),PurchaseNeedLinkman.class);
    	
    	//转换规则数据
    	PurchaseNeedRuleBean purchaseNeedRuleBean = JSONObject.parseObject(purchaseNeedBean.getNeedRuleJson(), PurchaseNeedRuleBean.class);
    	
    	//新增
    	if( "".equals(purchaseNeedBean.getId())){

    		//生成ID
    		String purchaseNeedId = String.valueOf(this.globalIdService.getGlobalId());
    		
    		String needRuleId = String.valueOf(this.globalIdService.getGlobalId());
    		
    		//新增主表数据
    		purchaseNeedBean.setPurchaseRuleId(needRuleId);
    		
    		purchaseNeedBean.setCreateTime(createTime);
    		
    		purchaseNeedBean.setCompanyId(companyId);
    		
    		purchaseNeedBean.setCreateUser(createUser);
    		
    		purchaseNeedBean.setId(purchaseNeedId);
    		
    		purchaseNeedBean.setFailTime(failTime);
    		
    		//新增联系人数据
    		List addLinklist = new ArrayList();
    		
    		for(PurchaseNeedLinkman purchaseNeedLinkman : linklist){
    			
    			purchaseNeedLinkman.setPurchaseNeedId(purchaseNeedId);
    			
    			purchaseNeedLinkman.setId(String.valueOf(this.globalIdService.getGlobalId()));
    			
    			addLinklist.add(purchaseNeedLinkman);
    		}
    		
    		//新增采购规则数据
    		purchaseNeedRuleBean.setId(needRuleId);
    		
    		List<PurchaseNeedRuleAreaBean> areaList = purchaseNeedRuleBean.getAreaList();
    		
    		List areaoutList = new ArrayList();
    		
    		for(PurchaseNeedRuleAreaBean areaBean : areaList){
    			
    			areaBean.setId(String.valueOf(this.globalIdService.getGlobalId()));
    			
    			areaBean.setRuleId(needRuleId);
    			
    			areaBean.setCompanyId(companyId);
    			
    			areaoutList.add(areaBean);
    		}
    		
    		purchaseNeedRuleBean.setAreaList(areaoutList);
    		
    		//新增物资明细数据
    		List addDetaillist =  new ArrayList();
    		
    		for(PurchaseNeedDetailBean purchaseNeedDetailBean : detaillist){
    			
    			
    			purchaseNeedDetailBean.setId( String.valueOf(this.globalIdService.getGlobalId()));
    			
    			purchaseNeedDetailBean.setPid(purchaseNeedId);
    			
    			purchaseNeedDetailBean.setCompanyId(purchaseNeedBean.getCompanyId());
    			
    			purchaseNeedDetailBean.setFailTime(failTime);
    			
    			//封装文档附件信息
    			List<PurchaseNeedDetailDocBean> doclist= purchaseNeedDetailBean.getNeedDetailDoc();
    			
    			List addDoclist =  new ArrayList();
    			
    			for(PurchaseNeedDetailDocBean purchaseNeedDetailDocBean : doclist){
    				
    				purchaseNeedDetailDocBean.setId(String.valueOf(this.globalIdService.getGlobalId()));
    				
    				purchaseNeedDetailDocBean.setPid(purchaseNeedDetailBean.getId());
    				
    				addDoclist.add(purchaseNeedDetailDocBean);
    			
    			}
    			
    			purchaseNeedDetailBean.setNeedDetailDoc(addDoclist);
    			
    			addDetaillist.add(purchaseNeedDetailBean);
    			
    		}
    		
    		HashMap m =  new HashMap();
    		
    		m.put("purchaseNeedBean", purchaseNeedBean);
    		
    		m.put("addLinklist", addLinklist);
    		
    		m.put("addDetaillist", addDetaillist);
    		
    		m.put("purchaseNeedRuleBean", purchaseNeedRuleBean);
    		
    		this.purchaseNeedService.savePurchaseNeed(m);

    		json.put("msg","操作成功");
    	}
    	else{
    		
    		String purchaseNeedId = purchaseNeedBean.getId();
    		
    		String needRuleId = purchaseNeedRuleBean.getId();
       		
    		//更新主表数据
    		
    		purchaseNeedBean.setCreateTime(createTime);
    		
    		purchaseNeedBean.setCompanyId(companyId);
    		
    		purchaseNeedBean.setCreateUser(createUser);
    		
    		purchaseNeedBean.setFailTime(failTime);
    		
    		//更新联系人数据
    		
    		List editLinklist = new ArrayList();
    		
    		for(PurchaseNeedLinkman purchaseNeedLinkman : linklist){
    			
    			if("".equals(purchaseNeedLinkman.getId())){
    				
    				purchaseNeedLinkman.setId(String.valueOf(this.globalIdService.getGlobalId()));
    				
    			
    			}
    			
    			purchaseNeedLinkman.setPurchaseNeedId(purchaseNeedId);
    			
    			editLinklist.add(purchaseNeedLinkman);
    			
    		}
    		
    		//更新物资明细数据
    		List editDetaillist =  new ArrayList();
    		
    		for(PurchaseNeedDetailBean purchaseNeedDetailBean : detaillist){
    			
    			if(purchaseNeedDetailBean.getId().indexOf("needDtail") > -1)
    			
    			purchaseNeedDetailBean.setId( String.valueOf(this.globalIdService.getGlobalId()));
    			
    			purchaseNeedDetailBean.setPid(purchaseNeedId);
    			
    			purchaseNeedDetailBean.setCompanyId(purchaseNeedBean.getCompanyId());
    			
    			purchaseNeedDetailBean.setFailTime(failTime);
    			
    			//封装文档附件信息
    			List<PurchaseNeedDetailDocBean> doclist= purchaseNeedDetailBean.getNeedDetailDoc();
    			
    			List editDoclist =  new ArrayList();
    			
    			for(PurchaseNeedDetailDocBean purchaseNeedDetailDocBean : doclist){
    				
    				purchaseNeedDetailDocBean.setId(String.valueOf(this.globalIdService.getGlobalId()));
    				
    				purchaseNeedDetailDocBean.setPid(purchaseNeedDetailBean.getId());
    				
    				editDoclist.add(purchaseNeedDetailDocBean);
    			
    			}
    			
    			purchaseNeedDetailBean.setNeedDetailDoc(editDoclist);
    			
    			editDetaillist.add(purchaseNeedDetailBean);
    			
    		}
    		
    		//更新采购规则数据
    		
    		List<PurchaseNeedRuleAreaBean> areaList = purchaseNeedRuleBean.getAreaList();
    		
    		List areaoutList = new ArrayList();
    		
    		for(PurchaseNeedRuleAreaBean areaBean : areaList){
    			
    			areaBean.setId(String.valueOf(this.globalIdService.getGlobalId()));
    			
    			areaBean.setRuleId(needRuleId);
    			
    			areaBean.setCompanyId(companyId);
    			
    			areaoutList.add(areaBean);
    		}
    		
    		purchaseNeedRuleBean.setAreaList(areaoutList);
    		
    		HashMap m =  new HashMap();
    		
    		m.put("purchaseNeedBean", purchaseNeedBean);
    		
    		m.put("editLinklist", editLinklist);
    		
    		m.put("editDetaillist", editDetaillist);
    		
    		m.put("purchaseNeedRuleBean", purchaseNeedRuleBean);
    		
    		this.purchaseNeedService.editPurchaseNeed(m);
    		
    		json.put("msg","更新成功");
    	}
    	
    	} catch (Exception e) {
    		
			e.printStackTrace();
			
			json.put("msg","操作失败");
			
		}
    	
    	 return "<script>window.name='"+json+"'</script>";
    } 
    
	@RequestMapping("uploadNeedDetailDoc")
    @ResponseBody
    public JSONObject uploadNeedDetailDoc(MultipartHttpServletRequest request){
        JSONObject json = new JSONObject();
        List<MultipartFile> l =  request.getFiles("fileupload");
        Map _filePara = new HashMap();
        String _now = GlobalUtil.getCreateTime().substring(0,10);
        //上传系列主图
        _filePara.put("fileList",l);
        _filePara.put("fileKey","NeedDetailDoc/"+_now);
        _filePara.put("everyone",true);
        List fileList = FileOperate.FileUploadMultipartFile(_filePara);
        
        List  doclist = new ArrayList();
        
        for(int i=0;i<fileList.size();i++){
        	
        	PurchaseNeedDetailDocBean docbean = new PurchaseNeedDetailDocBean();
        	
        	HashMap map = (HashMap)fileList.get(i);
        	
        	docbean.setFileKey(map.get("key").toString());
        	
        	docbean.setFilePath(map.get("path").toString());
        	
        	doclist.add(docbean);
        	
        }
        json.put("list", doclist);
        
        return json;
	}
	
	@RequestMapping("delNeedDetailDoc")
    @ResponseBody
    public JSONObject delNeedDetailDoc(String  delKeys){
        JSONObject json = new JSONObject();
        String[] keys = delKeys.split(",");
        for(int i=0;i<(keys.length);i++){
        	S3Util.deleteObject(S3Util.producerBucketName, keys[i]);
        }
        json.put("keys", keys);
        json.put("msg", "操作成功");
        return json;
     
	}
	
	
    /**
     * 获取需求类型下拉框
     * @param request
     * @return
     */
    @RequestMapping("getPurchaseNeedTypeList")
    @ResponseBody
    public JSONObject getPurchaseNeedTypeList(HttpServletRequest request,String tag){
        JSONObject json = new JSONObject();
        List list = GlobalTypeEnum.getListByTeamId(9);
        List needTypeList = new ArrayList();
        if("1".equals(tag)){
        	HashMap outMap = new HashMap();
         	outMap.put("label","全部");
        	outMap.put("value","");
        	needTypeList.add(outMap);
        }
        for(int i=0;i<list.size();i++){
        	HashMap outMap = new HashMap();
        	Map map = (Map)list.get(i);
        	outMap.put("label",map.get("name"));
        	outMap.put("value",map.get("code"));
        	needTypeList.add(outMap);
        }
        json.put("list",needTypeList);
        return json;
    } 
    
    /**
     * 获取所属行业下拉框
     * @param request
     * @return
     */
    @RequestMapping("getIndustryList")
    @ResponseBody
    public JSONObject getIndustryList(HttpServletRequest request){
        JSONObject json = new JSONObject();
        List<BaseIndustry> list = this.shengchanCommonService.getBaseIndustryList();
        List industryList = new ArrayList();
        for(BaseIndustry baseIndustry : list){
        	HashMap outMap = new HashMap();
        	
        	outMap.put("label",baseIndustry.getName());
        	outMap.put("value",baseIndustry.getCode());
        	industryList.add(outMap);
        }
        json.put("list",industryList);
        return json;
    } 
    
    /**
     * 获取联系人下拉框
     * @param request
     * @return
     */
    @RequestMapping("getPurchaseLinkmanList")
    @ResponseBody
    public JSONObject getPurchaseLinkmanList(HttpServletRequest request){
        JSONObject json = new JSONObject();
        List list = GlobalTypeEnum.getListByTeamId(10);
        List needTypeList = new ArrayList();
        for(int i=0;i<list.size();i++){
        	HashMap outMap = new HashMap();
        	Map map = (Map)list.get(i);
        	outMap.put("label",map.get("name"));
        	outMap.put("value",map.get("code"));
        	needTypeList.add(outMap);
        }
        json.put("list",needTypeList);
        return json;
    } 
    
    /**
     * 获取发布状态下拉框
     * @param request
     * @return
     */
    @RequestMapping("getPurchaseNeedStateList")
    @ResponseBody
    public JSONObject getPurchaseNeedStateList(HttpServletRequest request,String tag){
        JSONObject json = new JSONObject();
        List list = GlobalOrderTypeEnum.getListByTeamId(2);
        List needTypeList = new ArrayList();
        if("1".equals(tag)){
        	HashMap outMap = new HashMap();
         	outMap.put("label","全部");
        	outMap.put("value","");
        	needTypeList.add(outMap);
        }
        for(int i=0;i<list.size();i++){
        	HashMap outMap = new HashMap();
        	Map map = (Map)list.get(i);
        	outMap.put("label",map.get("name"));
        	outMap.put("value",map.get("code"));
        	needTypeList.add(outMap);
        }
        json.put("list",needTypeList);
        return json;
    } 
    
    /**
     * 获取发票状态下拉框
     * @param request
     * @return
     */
    @RequestMapping("getBillStateList")
    @ResponseBody
    public JSONObject getBillStateList(HttpServletRequest request,String tag){
        JSONObject json = new JSONObject();
        List list = GlobalOrderTypeEnum.getListByTeamId(4);
        List needTypeList = new ArrayList();
        if("1".equals(tag)){
        	HashMap outMap = new HashMap();
         	outMap.put("label","全部");
        	outMap.put("value","");
        	needTypeList.add(outMap);
        }
        for(int i=0;i<list.size();i++){
        	HashMap outMap = new HashMap();
        	Map map = (Map)list.get(i);
        	outMap.put("label",map.get("name"));
        	outMap.put("value",map.get("code"));
        	needTypeList.add(outMap);
        }
        json.put("list",needTypeList);
        return json;
    } 
    
    /**
     * 获取交易状态下拉框
     * @param request
     * @return
     */
    @RequestMapping("getTradeStateList")
    @ResponseBody
    public JSONObject getTradeStateList(HttpServletRequest request,String tag){
        JSONObject json = new JSONObject();
        List list = GlobalOrderTypeEnum.getListByTeamId(3);
        List needTypeList = new ArrayList();
        if("1".equals(tag)){
        	HashMap outMap = new HashMap();
         	outMap.put("label","全部");
        	outMap.put("value","");
        	needTypeList.add(outMap);
        }
        for(int i=0;i<list.size();i++){
        	HashMap outMap = new HashMap();
        	Map map = (Map)list.get(i);
        	outMap.put("label",map.get("name"));
        	outMap.put("value",map.get("code"));
        	needTypeList.add(outMap);
        }
        json.put("list",needTypeList);
        return json;
    } 
    /**
     * 获取物资类型下拉框
     * @param request
     * @return
     */
    @RequestMapping("getNeedDetailNoList")
    @ResponseBody
    public JSONObject getNeedDetailNoList(HttpServletRequest request,String tag){
        JSONObject json = new JSONObject();
        List list = GlobalTypeEnum.getListByTeamId(11);
        List needTypeList = new ArrayList();
        if("1".equals(tag)){
        	HashMap outMap = new HashMap();
         	outMap.put("label","全部");
        	outMap.put("value","");
        	needTypeList.add(outMap);
        }
        for(int i=0;i<list.size();i++){
        	HashMap outMap = new HashMap();
        	Map map = (Map)list.get(i);
        	outMap.put("label",map.get("name"));
        	outMap.put("value",map.get("code"));
        	needTypeList.add(outMap);
        }
        json.put("list",needTypeList);
        return json;
    } 
    /**
     * 采购订单List
     * @return
     */
    @RequestMapping("getPurchaseBillList")
    @ResponseBody
    public Grid getPurchaseBillList(PageFilter pageFilter, PurchaseNeedBean purchaseNeedBean){
	        if (pageFilter!=null){
	        	
	        	purchaseNeedBean.setOrderStr(pageFilter.getOrderString());
	        	
	        }
    	   Grid grid = new Grid();
    	   
    	   this.purchaseNeedService.getPurchaseNeedList(purchaseNeedBean);
    	   
           List<PurchaseNeedBean> list = this.purchaseNeedService.getPurchaseNeedList(purchaseNeedBean);
           
           int total = this.purchaseNeedService.getPurchaseNeedListNum(purchaseNeedBean);
           
           List outlist = new ArrayList();
           
           for(PurchaseNeedBean outPurchaseNeedBean : list){
        
        	   outPurchaseNeedBean.setPurchaseNeedState(GlobalOrderTypeEnum.getName(Integer.valueOf(outPurchaseNeedBean.getPurchaseNeedState())));
        	   
        	   outPurchaseNeedBean.setPurchaseNeedType(GlobalTypeEnum.getName(Integer.valueOf(outPurchaseNeedBean.getPurchaseNeedType())));
          
        	   outlist.add(outPurchaseNeedBean);
           }
           
           grid.setRows(outlist);
           
           grid.setTotal(total);
           
           return grid;
    }
    
    /**
     * 封装筛选条件data
     * @param request
     * @return
     */
    @RequestMapping("getFilterList")
    @ResponseBody
    public String  getFilterList(HttpServletRequest request){
     	 JSONObject json = new JSONObject();
     	 List outList = new ArrayList();
    	 List list = GlobalTypeEnum.getListByTeamId(11);
    	 //封装物资类型数据
    	 Map needTypeMap = new HashMap();
         List needTypeList = new ArrayList();
         
      
         for(int i=0;i<list.size();i++){
         	HashMap outMap = new HashMap();
         	Map map = (Map)list.get(i);
         	outMap.put("name",map.get("name"));
         	outMap.put("value",map.get("code"));
         	needTypeList.add(outMap);
         }
         needTypeMap.put("name", "物资类型");
         needTypeMap.put("list",needTypeList);
         outList.add(needTypeMap);
         //封装所在地数据
//         String cityCode[] ={"001001","001002","001003","001004","001005","001006","001007",
//        		 			 "001008","001009","001010","001011","001012","001013","001014",
//        		 			 "001015","001016","001017","001018","001019","001020","001021",
//        		 			 "001022","001023","001024","001025","001026","001027","001028",
//        		 			 "001029","001030","001031","001032","001033","001034"};
//         String cityName[] ={"北京","天津","河北","山西","内蒙古","辽宁","吉林","黑龙江","上海","江苏","浙江","安徽","福建","江西",
//        		 			"山东","河南","湖北","湖南","广东","广西","海南","重庆","四川","贵州","云南","西藏","陕西","甘肃","青海",
//        		 			"宁夏","新疆","香港","澳门","台湾"};
//         
//      	  Map provinceMap = new HashMap();
//          List provinceList = new ArrayList();
//         for(int i=0;i<cityName.length;i++){
//          	HashMap outMap = new HashMap();
//          	outMap.put("name",cityName[i]);
//          	outMap.put("value",cityCode[i]);
//          	provinceList.add(outMap);
//          }
//         provinceMap.put("name", "所在地");
//         provinceMap.put("list",provinceList);
//         outList.add(provinceMap);
    	return JSONObject.toJSONString(outList);

    }
    
    
    /**
     * 获取物资列表
     * @param request
     * @return
     */
    @RequestMapping("getPurchaseList")
    @ResponseBody
    public JSONObject  getPurchaseList(PageFilter pageFilter,String brandName,String productType,String area){
    	
    	MainProductBean mainProductBean = new MainProductBean();
    	
    	mainProductBean.setState(GlobalTypeEnum.NORMALSELL.getCode());
    	
    	mainProductBean.setBrandName(brandName);
    	
//    	mainProductBean.setProductStyleId(Integer.valueOf(productType));
    	
    	pageFilter.setRows(50);
    	
    	mainProductBean.setOrderStr(pageFilter.getOrderString());
    	
    	String areaList[] = area.split("-");
    	
    	String areaId = "";
    	
    	String cityId = "";
    	
    	String provinceId = "";
    	
    	if(areaList.length == 1){
    		
    		provinceId = areaList[0];
    		
    	}
    	else if(areaList.length == 2){
    		
    		provinceId = areaList[0];
    		
    		cityId = areaList[1];
    		
    	}
    	else{
    		
    		provinceId = areaList[0];
    		
    		cityId = areaList[1];
    		
    		areaId = areaList[2];
    	}
    	
    	JSONObject json = this.mainProductService.getPurchaseHall(mainProductBean,areaId,cityId,provinceId,pageFilter.getRows());
    	
    	json.put("page", pageFilter.getPage());
    	
//    	this.shengchanRecommendService.getGoodsRecommend("1312312313",1,10);
    	
//    	this.shengchanRecommendService.getSupplierRecommend("1312312313", 0, 9);
    
//    	return JSONObject.toJSONString(outList);
    	
    	return json;
    	
    }
}
