package com.cms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.regions.Region;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.regions.Region;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.ObjectMetadata;
import com.cms.iservice.wuliu.CommonService;
import com.cms.iservice.wuliu.InfoHallService;
import com.cms.iservice.wuliu.InfoPublishService;
import com.cms.iservice.wuliu.MyCarService;
import com.cms.model.User;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.Grid;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.ChppQueryParam;
import com.cms.model.wuliu.HuoyuanBean;
import com.cms.model.wuliu.chppSaveParam;
import com.cms.service.common.secure.AesTools;
import com.cms.util.UploadUtil;


/**
 * 发布信息
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("infopublish")
public class InfoPublishController {
    private static Logger logger = LoggerFactory.getLogger(InfoPublishController.class);

	@Autowired
	private InfoPublishService infoPublishService;
	@Autowired
	private InfoHallService infoHallService;
    @Autowired
    private CommonService commonService;
    
    @Autowired
    private MyCarService myCarService;

	@RequestMapping("infopublish")
	public ModelAndView infoPublish(HttpSession httpSession){
		ModelAndView model = new ModelAndView("infopublish/infopublish");
//		SessionInfo session = (SessionInfo) httpSession.getAttribute(GlobalConstant.SESSION_INFO);
        User loginUser = (User)httpSession.getAttribute("sso:loginUser");
//        if (session==null){
//            session = new SessionInfo();
//        }
//		session.setName("张三");
//		session.setTel("18600967102");
//		session.setTel1("18600967102");
//		session.setTel2("18600967102");
//		session.setCompanyName("产贸送软件");
//		session.setCompanyGarden("测试物流园");
        model.addObject("session", loginUser);
		int different = 600 ;
		String userId = loginUser.getId()+"";
		if("0".equals(userId))
			different = 0;
		model.addObject("different", different);
		return model;
	}

    /**
     * 获取价格区间
     * @param offer
     * @return
     */
    private Long getQuoteId(Double offer){
        if (offer==0){
            return null;
        }else {
            List<Map> list = this.commonService.getQuoteList();
            Long maxid=0L;
            for (Map map : list){
                if ((Double)map.get("min")<=offer && offer <= (Double)map.get("max")){
                    return (Long)map.get("id");
                }
                if ((Double)map.get("min")!=0 && (Double)map.get("max")==0){
                    maxid = (Long)map.get("id");
                }
            }
            return maxid;
        }
    }

    /**
     * 获取质量区间
     * @param weight
     * @return
     */
    private Long getWeightId(Double weight){
        if (weight==0){
            return null;
        }else {
            List<Map> list = this.commonService.getWeightList();
            Long maxid=0L;
            for (Map map : list){
                if ((Double)map.get("min")<=weight && weight <= (Double)map.get("max")){
                    return (Long)map.get("id");
                }
                if ((Double)map.get("min")!=0 && (Double)map.get("max")==0){
                    maxid = (Long)map.get("id");
                }
            }
            return maxid;
        }
    }

    /**
     * 处理货源加密属性
     * @param bean
     * @return
     */
    private HuoyuanBean encryptHuoyuan(HuoyuanBean bean){
        try{
            if (bean.getLinkMan()!=null && !"".equals(bean.getLinkMan())){
                bean.setLinkManCipher(AesTools.aesEncrypt(bean.getLinkMan(), GlobalConstant.CHPPKEY));
            }
            if (bean.getTel()!=null && !"".equals(bean.getTel())){
                bean.setTelCipher(AesTools.aesEncrypt(bean.getTel(), GlobalConstant.CHPPKEY));
            }
            if (bean.getTel1()!=null && !"".equals(bean.getTel1())){
                bean.setTel1Cipher(AesTools.aesEncrypt(bean.getTel1(), GlobalConstant.CHPPKEY));
            }
            if (bean.getTel2()!=null && !"".equals(bean.getTel2())){
                bean.setTel2Cipher(AesTools.aesEncrypt(bean.getTel2(), GlobalConstant.CHPPKEY));
            }
            if (bean.getConsigneeMan()!=null && !"".equals(bean.getConsigneeMan())){
                bean.setConsigneeManCipher(AesTools.aesEncrypt(bean.getConsigneeMan(), GlobalConstant.CHPPKEY));
            }
            if (bean.getConsigneeAdd()!=null && !"".equals(bean.getConsigneeAdd())){
                bean.setConsigneeAddCipher(AesTools.aesEncrypt(bean.getConsigneeAdd(), GlobalConstant.CHPPKEY));
            }
            if (bean.getConsigneeTel()!=null && !"".equals(bean.getConsigneeTel())){
                bean.setConsigneeTelCipher(AesTools.aesEncrypt(bean.getConsigneeTel(), GlobalConstant.CHPPKEY));
            }
            if (bean.getConsigneeTel1()!=null && !"".equals(bean.getConsigneeTel1())){
                bean.setConsigneeTel1Cipher(AesTools.aesEncrypt(bean.getConsigneeTel1(), GlobalConstant.CHPPKEY));
            }
            if (bean.getConsigneeTel2()!=null && !"".equals(bean.getConsigneeTel2())){
                bean.setConsigneeTel2Cipher(AesTools.aesEncrypt(bean.getConsigneeTel2(), GlobalConstant.CHPPKEY));
            }
        }catch (Exception e){

        }
        return bean;
    }

    /**
     * 处理车源加密
     * @param bean
     * @return
     */
    private CheyuanBean encryptCheyuan(CheyuanBean bean){
        try{
            if (bean.getLinkMan()!=null && !"".equals(bean.getLinkMan())){
                bean.setLinkManCipher(AesTools.aesEncrypt(bean.getLinkMan(), GlobalConstant.CHPPKEY));
            }
            if (bean.getTel()!=null && !"".equals(bean.getTel())){
                bean.setTelCipher(AesTools.aesEncrypt(bean.getTel(), GlobalConstant.CHPPKEY));
            }
            if (bean.getTel1()!=null && !"".equals(bean.getTel1())){
                bean.setTel1Cipher(AesTools.aesEncrypt(bean.getTel1(), GlobalConstant.CHPPKEY));
            }
            if (bean.getTel2()!=null && !"".equals(bean.getTel2())){
                bean.setTel2Cipher(AesTools.aesEncrypt(bean.getTel2(),GlobalConstant.CHPPKEY));
            }
        }catch (Exception e){

        }
        return bean;
    }

	/**
	 * 新增货源
	 * @param bean
	 * @param request
	 * @return
	 */
	@RequestMapping("addHuoyuan")
	@ResponseBody
	public JSONObject addHuoyuan(HuoyuanBean bean,MultipartHttpServletRequest request){
		JSONObject obj = new JSONObject();
		try{
			Map<String,String> map = UploadUtil.uploadImg(request, bean.getUserId()+"", new String[]{"huoyuan"});
			if (map.get("huoyuan")!=null){
				bean.setGoodsImg(map.get("huoyuan"));
			}
//            SessionInfo info = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
            User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
            bean.setUserId(loginUser.getId() + "");
            bean.setQuoteRegionId(this.getQuoteId(bean.getOffer()));
            bean.setWeightRegionId(this.getWeightId(bean.getWeight()));
            this.encryptHuoyuan(bean);
			String id = this.infoPublishService.addHuoyuan(bean);
            bean.setIsHall(false);
            bean.setId(id);
			obj.put("success", true);
            obj.put("huoyuanId",id);
//			obj.put("data", this.infoHallService.marryListForHuoyuan(bean));
			obj.put("msg", "发布成功！");
		}catch(Exception e){
            logger.debug("新增货源错误\n"+e.getMessage());
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 新增车源
	 * @param bean
	 * @param request
	 * @return
	 */
	@RequestMapping("addCheyuan")
	@ResponseBody
	public JSONObject addCheyuan(CheyuanBean bean,MultipartHttpServletRequest request){
		JSONObject obj = new JSONObject();
		try{
			Map<String,String> map = UploadUtil.uploadImg(request, bean.getUserId()+"", new String[]{"cheyuan"});
			if (map.get("cheyuan")!=null){
				bean.setCarImg(map.get("cheyuan"));
			}
//            SessionInfo info = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
            User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
            bean.setUserId(loginUser.getId() +"");
            bean.setCreateUser(loginUser.getUserName());
            bean.setQuoteRegionId(this.getQuoteId(bean.getOffer()));
            bean.setWeightRegionId(this.getWeightId(bean.getWeight()));
            this.encryptCheyuan(bean);
			String id = this.infoPublishService.addCheyuan(bean);
            bean.setIsHall(false);
            bean.setId(id);
			obj.put("success", true);
            obj.put("cheyuanId",id);
//			obj.put("data", this.infoHallService.marryListForCheyuan(bean));
			obj.put("msg", "发布成功！");
		}catch(Exception e){
            logger.debug("新增车源错误\n"+e.getMessage());
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 发布历史记录
	 * @return
	 */
	@RequestMapping("getHistoryList")
	@ResponseBody
	public Grid getHistoryList(String type,HttpSession httpSession){
//		SessionInfo info = (SessionInfo) httpSession.getAttribute(GlobalConstant.SESSION_INFO);.
        User user = (User) httpSession.getAttribute("sso:loginUser");
        HashMap map = new HashMap();
        map.put("userId",user.getId());
        map.put("type",type);
		return this.infoPublishService.getHistoryList(map);
	}
	
	/**
	 * 重新发布
	 * @param type
	 * @return
	 */
	@RequestMapping("rePublish")
	@ResponseBody
	public JSONObject rePublish(String json,String type){
		JSONObject obj = JSONObject.parseObject(json);
		try{
			HashMap map = new HashMap();
			map.put("id", obj.getString("id"));
			map.put("type", type);
			this.infoPublishService.updateRePublish(map);
			obj.put("success", true);
			if ("huoyuan".equals(type)){
                HuoyuanBean bean = new HuoyuanBean();
                bean.setBeginProvinceId(obj.getLong("beginProvinceId"));
                bean.setBeginAreaId(obj.getLong("beginAreaId"));
                bean.setBeginCityId(obj.getLong("beginCityId"));
                bean.setEndProvinceId(obj.getLong("endProvinceId"));
                bean.setEndAreaId(obj.getLong("endAreaId"));
                bean.setEndCityId(obj.getLong("endCityId"));
                bean.setWeight(obj.getDouble("weight"));
                bean.setVolume(obj.getDouble("volume"));
                bean.setIsHall(false);
				obj.put("data", this.infoHallService.marryListForHuoyuan(bean));
			}
			if ("cheyuan".equals(type)){
                CheyuanBean bean = new CheyuanBean();
                bean.setBeginProvinceId(obj.getLong("beginProvinceId"));
                bean.setBeginAreaId(obj.getLong("beginAreaId"));
                bean.setBeginCityId(obj.getLong("beginCityId"));
                bean.setEndProvinceId(obj.getLong("endProvinceId"));
                bean.setEndAreaId(obj.getLong("endAreaId"));
                bean.setEndCityId(obj.getLong("endCityId"));
                bean.setWeight(obj.getDouble("weight"));
                bean.setVolume(obj.getDouble("volume"));
                bean.setIsHall(false);
				obj.put("data", this.infoHallService.marryListForCheyuan(bean));
			}
			obj.put("msg", "发布成功！");
		}catch(Exception e){
			obj.put("msg", e.getMessage());
		}
		return obj;
	}

    /**
     * 加载货源页面
     * @return
     */
	@RequestMapping("loadHuoyuan")
	public ModelAndView loadHuoyuan(HuoyuanBean bean,HttpSession httpSession){
		ModelAndView model = new ModelAndView("infopublish/infopublish_huoyuan");
        try {
            if (bean.getGoodsName()!=null){
                bean.setGoodsName(URLDecoder.decode(bean.getGoodsName(),"utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (bean==null){
            bean = new HuoyuanBean();
        }
        User user = (User) httpSession.getAttribute("sso:loginUser");
        bean.setUserId(user.getId() + "");
        bean.setLinkMan(user.getUserName());
        bean.setCompanyName(user.getCompanyName());
        bean.setTel(user.getTel());
        bean.setTel1(user.getTel1());
        bean.setTel2(user.getTel2());
		model.addObject("bean", bean);
		return model;
	}

    /**
     * 获取推荐
     * @param json
     * @param type 前端传入cheyuan就匹配货源信息
     * @return
     */
    @RequestMapping("getMarryList")
    @ResponseBody
    public JSONObject getMarryList(String json,String type,HttpSession httpSession){
        JSONObject obj = JSONObject.parseObject(json);
//        SessionInfo info = (SessionInfo) httpSession.getAttribute(GlobalConstant.SESSION_INFO);
        User loginUser = (User)httpSession.getAttribute("sso:loginUser");
        if ("cheyuan".equals(type)){
            HuoyuanBean bean = new HuoyuanBean();
            bean.setBeginProvinceId(obj.getLong("beginProvinceId"));
            bean.setBeginAreaId(obj.getLong("beginAreaId"));
            bean.setBeginCityId(obj.getLong("beginCityId"));
            bean.setEndProvinceId(obj.getLong("endProvinceId"));
            bean.setEndAreaId(obj.getLong("endAreaId"));
            bean.setEndCityId(obj.getLong("endCityId"));
            bean.setWeight(obj.getDouble("weight"));
            bean.setVolume(obj.getDouble("volume"));
            obj = new JSONObject();
            if (loginUser!=null){
                bean.setUserId(loginUser.getId()+"");
            }
            bean.setIsHall(false);
            obj.put("data", this.infoHallService.marryListForHuoyuan(bean));
        }
        if ("huoyuan".equals(type)){
            CheyuanBean bean = new CheyuanBean();
            bean.setBeginProvinceId(obj.getLong("beginProvinceId"));
            bean.setBeginAreaId(obj.getLong("beginAreaId"));
            bean.setBeginCityId(obj.getLong("beginCityId"));
            bean.setEndProvinceId(obj.getLong("endProvinceId"));
            bean.setEndAreaId(obj.getLong("endAreaId"));
            bean.setEndCityId(obj.getLong("endCityId"));
            bean.setWeight(obj.getDouble("weight"));
            bean.setVolume(obj.getDouble("volume"));
            obj = new JSONObject();
            if (loginUser!=null){
                bean.setUserId(loginUser.getId()+"");
            }
            bean.setIsHall(false);
            obj.put("data", this.infoHallService.marryListForCheyuan(bean));
        }
        return obj;
    }

    /**
     * 信息确认
     * @param json
     * @return
     */
    @RequestMapping("infoconfirm")
    @ResponseBody
    public JSONObject infoconfirm(String json){
        JSONObject obj = JSONObject.parseObject(json);
        HashMap map = new HashMap();
        map.put("cheyuanId",obj.getString("cheyuanId"));
        map.put("huoyuanId",obj.getString("huoyuanId"));
        map.put("cheyuanState",obj.getBoolean("cheyuanState"));
        map.put("huoyuanState",obj.getBoolean("huoyuanState"));
        try{
            this.infoPublishService.updateconfirm(map);
            obj.put("success",true);
            obj.put("msg","修改成功！");
        }catch (Exception e){
            obj.put("msg",e.getMessage());
        }
        return obj;
    }

    /**
     * 模拟产贸平台提交
     * @return
     */
    @RequestMapping("canmao")
    public ModelAndView canmao(){
        ModelAndView model = new ModelAndView("infopublish/canmaohuoyuan");
        return model;
    }

    /**
     * 货源确认信息列
     * @param id
     * @return
     */
    @RequestMapping("showRelationList")
    @ResponseBody
    public JSONObject showRelationList(String id,String type){
        JSONObject obj = new JSONObject();
        HashMap map = new HashMap();
        map.put("id",Long.parseLong(id));
        map.put("type", type);
        obj.put("data",this.infoPublishService.showRelationList(map));
        return obj;
    }

    /**
     * 信息确认更新状态，修改车辆状态，车货源id互写
     * @param cheyuanId
     * @param huoyuanId
     * @return
     */
    @RequestMapping("updateRelation")
    @ResponseBody
    public JSONObject updateRelation(String cheyuanId,String huoyuanId,String carId,Boolean huoyuanState,Boolean cheyuanState){
        JSONObject obj = new JSONObject();
        HashMap map = new HashMap();
        map.put("cheyuanId",Long.parseLong(cheyuanId));
        map.put("huoyuanId",Long.parseLong(huoyuanId));
        map.put("carId",Long.parseLong(carId));
        map.put("cheyuanState",cheyuanState);
        map.put("huoyuanState",huoyuanState);
        try {
            this.infoPublishService.updateRelation(map);
            obj.put("success",true);
            obj.put("msg","修改成功！");
        }catch (Exception e){
            obj.put("msg",e.getMessage());
        }
        return obj;
    }

    /**
     * 删除信息
     * @param id
     * @param type
     * @return
     */
    @RequestMapping("delInfo")
    @ResponseBody
    public JSONObject delInfo(String id,String type){
        HashMap map = new HashMap();
        map.put("id",Long.parseLong(id));
        map.put("type",type);
        JSONObject obj = new JSONObject();
        try {
            this.infoPublishService.delInfo(map);
            obj.put("success",true);
            obj.put("msg","删除成功！");
        }catch (Exception e){
            obj.put("msg",e.getMessage());
        }
        return obj;
    }

//    @RequestMapping("uploadFileTest")
//    public void uploadFileTest(MultipartHttpServletRequest request) throws Exception {
//        List<MultipartFile> fileList = request.getFiles("cheyuan");
//        FastdfsClient client = FastdfsClientFactory.getFastdfsClient();
//        if(fileList!=null && fileList.size()>0){
//            for (int i=0;i<fileList.size();i++){
//                MultipartFile multipartFile = fileList.get(i);
//                if (multipartFile!=null){
//                    BufferedInputStream bi = new BufferedInputStream(multipartFile.getInputStream());
//                    CommonsMultipartFile cf= (CommonsMultipartFile)multipartFile;
//                    DiskFileItem fi = (DiskFileItem)cf.getFileItem();
//                    File file = fi.getStoreLocation();
//                    System.out.println(client.upload(file));
//                }
//            }
//        }
//        client.close();
//    }

    /**
     * 保存常用地址
     */
    @RequestMapping("saveAddress")
    @ResponseBody
    public JSONObject saveAddress(chppSaveParam saveParam,HttpSession session){
        JSONObject obj = (JSONObject) JSONObject.toJSON(saveParam);
//        SessionInfo info = (SessionInfo) session.getAttribute(GlobalConstant.SESSION_INFO);
        User loginUser = (User)session.getAttribute("sso:loginUser");
        obj.put("userId",Long.parseLong(loginUser.getId()+""));
        obj.put("companyId",loginUser.getCompanyId());
        if ("huoyuan".equals(obj.getString("type"))){
            obj.put("infoType",1);
        }else {
            obj.put("infoType",2);
        }
        if (this.infoPublishService.getUserAddress(obj).size()>=5){
            obj.put("msg","最多可以保存5个常用地址！");
            return obj;
        }
        try {
            this.infoPublishService.saveAddress(obj);
            obj.put("success",true);
            obj.put("msg","保存成功！");
        }catch (Exception e){
            obj.put("msg",e.getMessage());
        }
        return obj;
    }

    /**
     * 获取常用地址
     * @param queryParam
     * @param session
     * @return
     */
    @RequestMapping("getUserAddress")
    @ResponseBody
    public Grid getUserAddress(ChppQueryParam queryParam,HttpSession session){
//        SessionInfo info = (SessionInfo)session.getAttribute(GlobalConstant.SESSION_INFO);
        User loginUser = (User)session.getAttribute("sso:loginUser");
        JSONObject obj = new JSONObject();
        obj.put("infoType",queryParam.getInfoType());
        obj.put("carId",queryParam.getCarId());
        obj.put("userId",loginUser.getId()+"");
        obj.put("companyId",loginUser.getCompanyId());
        Grid grid = new Grid();
        List<Map> list = this.infoPublishService.getUserAddress(obj);
        grid.setRows(list);
        grid.setTotal(list.size());
        return grid;
    }

    /**
     * 删除地址
     * @param id
     * @return
     */
    @RequestMapping("deleteAdd")
    @ResponseBody
    public JSONObject deleteAdd(String id,String type,HttpSession session){
        JSONObject obj = new JSONObject();
        obj.put("id",id);
        obj.put("infoType","huoyuan".equals(type)?1:2);
        obj.put("userId", ((User) session.getAttribute("sso:loginUser")).getId());
        try {
            this.infoPublishService.deleteAdd(obj);
            List<Map> list = this.infoPublishService.getUserAddress(obj);
            Grid grid = new Grid();
            grid.setRows(list);
            grid.setTotal(list.size());
            obj.put("success",true);
            obj.put("data",grid);
        }catch (Exception e){
            obj.put("msg",e.getMessage());
        }
        return obj;
    }

    /**
     * 推送货源到物流平台
     * @param id
     * @return
     */
    @RequestMapping("updatePlatformLogistics")
    @ResponseBody
    public JSONObject updatePlatformLogistics(String id){
        JSONObject obj = new JSONObject();
        try{
            this.infoPublishService.updatePlatformLogistics(id);
            obj.put("success",true);
            obj.put("msg","推送成功！");
        }catch (Exception e){
            obj.put("msg",e.getMessage());
        }
        return obj;
    }

    /**
     * 加载货源页面
     * @return
     */
	@RequestMapping("loadCheyuan")
	public ModelAndView loadCheyuan(String id,HttpServletRequest request){
		ModelAndView model = new ModelAndView("infopublish/infopublish_cheyuan");
//		SessionInfo session =  (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		if(!"".equals(id)){
		//MyCarBean myCarBean =  this.myCarService.getId(id);
		//model.addObject("myCarBean",myCarBean);
		}
		model.addObject("session", request.getSession().getAttribute("sso:loginUser"));
	    JSONObject obj = new JSONObject();
     //   obj.put("id",id);
      //  obj.put("mainTag","1");
      //  Map map = this.infoPublishService.getMainLine(obj);
      //  obj.put("map", map);
		model.addObject("carId", id);
		return model;
	}



    /**
     * 加载重发界面
     * @return
     */
    @RequestMapping("loadPublish")
    public ModelAndView loadPublish(){
        ModelAndView model = new ModelAndView("infopublish/loadPublish");
        return model;
    }


    /**
     * 获取主要线路
     * @param id
     * @return
     */
    @RequestMapping("getMainLine")
    @ResponseBody
    public Map getMainLine(String id){
        HashMap map = new HashMap();
        map.put("id",id);
        map.put("mainTag","1");
        return this.infoPublishService.getMainLine(map);
    }
    
    /**
     * AWS S3上传测试
     * @param request
     */
//    public void AWSS3Test(MultipartHttpServletRequest request){
//    	try{
//    		List<MultipartFile> list = request.getFiles("huoyuan");
//            if(list!=null && list.size()>0){
//                for (int i=0;i<list.size();i++){
//                    MultipartFile multipartFile = list.get(i);
//                    AmazonS3 s3Client = new AmazonS3Client(new BasicAWSCredentials("AKIAOMP5LPVPCWSQDLBA", "FDAaKkjlYBA2xoM5V4+pa+Z/vyH9cVr+L4oZS6sB"));
//                    Region north = Region.getRegion(Regions.CN_NORTH_1);
//                    String bucketName = "chpp";
//                    String key = "chpp_upload_test";
//                    s3Client.setRegion(north);
//                    ObjectMetadata metadata = new ObjectMetadata();
////                    File file = new File("c:/123.png");
////                    metadata.setContentType(Files.probeContentType(file.toPath()));
////                    metadata.setContentLength(file.length());
//                    metadata.setContentType(multipartFile.getContentType());
//                    metadata.setContentLength(multipartFile.getSize());
////                    s3Client.putObject(new PutObjectRequest(bucketName, key, new FileInputStream(file), metadata).withCannedAcl(CannedAccessControlList.PublicRead));
//                    s3Client.putObject(bucketName,key,multipartFile.getInputStream(),metadata);
//                    GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(bucketName, key);
//                    URL url = s3Client.generatePresignedUrl(urlRequest);
//                    System.out.println(url);
//                }
//            }
//    	}catch(Exception e){
//    		e.printStackTrace();
//    	}
//    }

}
