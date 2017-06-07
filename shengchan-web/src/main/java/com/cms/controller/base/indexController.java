package com.cms.controller.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.model.util.GlobalUtil;
import com.cms.util.demoBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("index")
public class indexController {
	/**
	 * 测试页面跳转DEMO
	 * @param request
	 * @return
	 */
	@RequestMapping("header")
	public ModelAndView topPage(HttpServletRequest request){
		ModelAndView model = new ModelAndView("layout/header");
        model.addObject("menuList",JSONArray.parseArray(GlobalUtil.SHENGCHAN));
		return model;
	}
	
	/**
	 * 加载center叶
	 * @param request
	 * @return
	 */
	@RequestMapping("center")
	public ModelAndView centerPage(HttpServletRequest request){
		ModelAndView model = new ModelAndView("layout/center");
		return model;
	}
	
	/**
	 * 加载left菜单页
	 * @param request
	 * @return
	 */
	@RequestMapping("left")
	public ModelAndView leftPage(HttpServletRequest request,int menuId){
		ModelAndView model = new ModelAndView("layout/left");
        JSONArray array = new JSONArray();
        switch (menuId){
            case 2:
                array = JSONArray.parseArray(GlobalUtil.WZCG);
                break;
            case 3:
//            	array = JSONArray.parseArray(GlobalContent.SALE);
            case 4:
            	array = JSONArray.parseArray(GlobalUtil.CYGL);
            	
            	
            default:
                break;
        }
        model.addObject("menuList",array);
		return model;
	}
	
	/**
	 * 动态下拉框
	 * @return
	 */
	@RequestMapping("/demo")
	@ResponseBody
	public JSONObject getDemo(String province,String city,HttpServletRequest request) {
		
		JSONObject json = new JSONObject();
		List list = new ArrayList();
		for(int i=0;i<3;i++){
			demoBean bean = new demoBean();
			bean.setLabel(String.valueOf(i));
			bean.setTitle(String.valueOf(i));
			bean.setValue(String.valueOf(i));
			list.add(bean);
		}
		json.put("list", list);
		return json;
	}
}
