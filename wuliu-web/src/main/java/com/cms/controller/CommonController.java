package com.cms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.wuliu.CommonService;
import com.cms.iservice.wuliu.MyCarService;
import com.cms.model.User;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.SessionInfo;
import com.cms.model.wuliu.AreaBean;
import com.cms.model.wuliu.CityBean;
import com.cms.model.wuliu.MyCarBean;
import com.cms.model.wuliu.ProvinceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 公共信息
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("common")
public class CommonController {
	@Autowired
	private CommonService commonService;
    @Autowired
    private MyCarService myCarService;
	
	/**
	 * 获取省区域、县市信息
	 * @return
	 */
	@RequestMapping("getAreaInfo")
	@ResponseBody
	public String getAreaInfo(){
		ProvinceBean province = new ProvinceBean();
		CityBean city = new CityBean();
		AreaBean area = new AreaBean();
		JSONObject obj = new JSONObject();
		JSONArray provinceList = (JSONArray) JSONArray.toJSON(this.commonService.getProvince(province));
		JSONArray areaList = (JSONArray) JSONArray.toJSON(this.commonService.getArea(area));
		JSONArray cityList = (JSONArray) JSONArray.toJSON(this.commonService.getCity(city));
		obj.put("province", provinceList);
		obj.put("area", areaList);
		obj.put("city", cityList);
		return obj.toString();
	}
	
	/**
	 * 获取字典表信息
	 * @param pid
	 * @return
	 */
	@RequestMapping("getGoodsDicInfoList")
	@ResponseBody
	public String getGoodsDicInfoList(String pid){
		return JSONObject.toJSON(this.commonService.getGoodsDicInfoList(pid)).toString();
	}

    /**
     * 获取车辆表
     * @param json
     * @return
     */
	@RequestMapping("getCarList")
    @ResponseBody
	public String getCarList(String json,HttpSession session){
		JSONObject obj = new JSONObject();
//        SessionInfo info = (SessionInfo) session.getAttribute(GlobalConstant.SESSION_INFO);
        User loginUser = (User)session.getAttribute("sso:loginUser");
		if (json!=null && !"".equals(json)){
			obj = JSONObject.parseObject(json);
		}
        obj.put("companyId",loginUser.getCompanyId());
		return JSONObject.toJSON(this.commonService.getCarList(obj)).toString();
	}

    /**
     * 获取价格区间
     * @return
     */
    @RequestMapping("getQuoteList")
    @ResponseBody
    public String getQuoteList() {
        List<Map> list = this.commonService.getQuoteList();
        return JSONObject.toJSON(list).toString();
    }

    /**
     * 获取重量区间
     * @return
     */
    @RequestMapping("getWeightList")
    @ResponseBody
    public String getWeightList(){
        return JSONObject.toJSON(this.commonService.getWeightList()).toString();
    }

    /**
     * 获取车辆字典
     * @param pid
     * @return
     */
    @RequestMapping("getCarDic")
    @ResponseBody
    public List<MyCarBean> getCarDic(String pid){
        List<MyCarBean> list = this.myCarService.getCarDic(Long.parseLong(pid));
        return list;
    }
}
