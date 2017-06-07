package com.cms.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.wuliu.InfoHallService;
import com.cms.model.User;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.ChppQueryParam;
import com.cms.model.wuliu.HuoyuanBean;
import com.cms.service.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 信息大厅
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("infohall")
public class InfoHallController {
	@Autowired
	private InfoHallService infoHallService;
	
	@RequestMapping("infohall")
	public ModelAndView infoHall(HttpServletRequest request){
		ModelAndView model = new ModelAndView("infohall/infohall");
//        ModelAndView model = new ModelAndView("infohall/tableTest");
//		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
        User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
		int different = 600 ;
		String userId = loginUser.getId()+"";
        List<Map> list = new ArrayList<Map>();
        Map map = new HashMap();
        map.put("id",1);
        map.put("name","华东地区");
        list.add(map);
        map = new HashMap();
        map.put("id",2);
        map.put("name","华南地区");
        list.add(map);
        map = new HashMap();
        map.put("id",3);
        map.put("name","华中地区");
        list.add(map);
        map = new HashMap();
        map.put("id",4);
        map.put("name","华北地区");
        list.add(map);
        map = new HashMap();
        map.put("id",5);
        map.put("name","西北地区");
        list.add(map);
        map = new HashMap();
        map.put("id",6);
        map.put("name","西南地区");
        list.add(map);
        map = new HashMap();
        map.put("id",7);
        map.put("name","东北地区");
        list.add(map);
        Map temp = list.get(loginUser.getBelongAreaId()-1);
        list.remove(loginUser.getBelongAreaId()-1);
        list.add(0,temp);
		if("0".equals(userId))
			different = 0;
		model.addObject("different", different);
        model.addObject("list",list);
		return model;
	}
	

	/**
	 * 获取车源列表
	 * @param ph
	 * @return
	 */
	@RequestMapping("getCheyuanList")
	@ResponseBody
	public Grid getCheyuanList(ChppQueryParam queryParam,PageFilter ph,HttpSession httpSession){
        User loginUser = (User)httpSession.getAttribute("sso:loginUser");
		return this.infoHallService.cheyuanList(queryParam,ph,loginUser);
	}
	
	/**
	 * 获取货源列表
	 * @param ph
	 * @return
	 */
	@RequestMapping("getHuoyuanList")
	@ResponseBody
	public Grid getHuoyuanList(ChppQueryParam queryParam,PageFilter ph,HttpSession httpSession){
        User loginUser = (User)httpSession.getAttribute("sso:loginUser");
		return this.infoHallService.huoyuanList(queryParam,ph,loginUser);
	}
	
	/**
	 * 获取推荐货源
	 * @param request
	 * @return
	 */
	@RequestMapping("getHuoyuanRecommondList")
	@ResponseBody
	public Grid getHuoyuanRecommondList(HttpServletRequest request){
//		SessionInfo info = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
        User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
		return this.infoHallService.getHuoyuanRecommondList(loginUser);
	}
	
	/**
	 * 获取推荐车源
	 * @param request
	 * @return
	 */
	@RequestMapping("getCheyuanRecommondList")
	@ResponseBody
	public Grid getCheyuanRecommondList(HttpServletRequest request){
//        SessionInfo info = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
        User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
		return this.infoHallService.getCheyuanRecommondList(loginUser);
	}
	
	/**
	 * 详情界面
	 * @param json
	 * @param type
	 * @return
	 */
	@RequestMapping("infoHallPage")
	@ResponseBody
	public ModelAndView infoHallPage(String json,String type,boolean viewflag){
		String url=type.equals("huoyuan")?"info_huoyuan":"info_cheyuan";
		ModelAndView model = new ModelAndView("infohall/"+url);
		Map<String,Object> map = (Map<String, Object>) JSON.parse(json);
        map.put("viewflag",viewflag);
		model.addObject("map", map);
		return model;
	}

    /**
     * 获取车货源信息
     * @param id
     * @param type
     * @return
     */
    @RequestMapping("getInfoById")
    @ResponseBody
    public JSONObject getInfoById(String id,String type){
        HashMap map = new HashMap();
        map.put("id",Long.parseLong(id));
        JSONObject obj = new JSONObject();
        try {
            if ("huoyuan".equals(type)){
                obj.put("data",this.infoHallService.getHuoyuanInfo(map));
            }
            if ("cheyuan".equals(type)){
                obj.put("data",this.infoHallService.getCheyuanInfo(map));
            }
            obj.put("success",true);
        }catch (Exception e){
            obj.put("msg",e.getMessage());
        }
        return obj;
    }

    /**
     * 获取匹配信息
     * @param id
     * @param type
     * @return
     */
    @RequestMapping("getMarryList")
    @ResponseBody
    public JSONObject getMarryList(String id,String type,HttpSession session){
        HashMap map = new HashMap();
        map.put("id",Long.parseLong(id)+"");
        map.put("type",type);
        map.put("userId",((User)session.getAttribute("sso:loginUser")).getId());
        JSONObject obj = new JSONObject();
        try{
            Grid grid = new Grid();
            List list = this.infoHallService.getMarryList(map);
            grid.setRows(list);
            grid.setTotal(list.size());
            obj.put("data",grid);
            obj.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            obj.put("msg",e.getMessage());
        }
        return obj;
    }
}
