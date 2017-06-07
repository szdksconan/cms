package com.cms.controller.base;

import com.alibaba.fastjson.JSONArray;
import com.cms.model.util.GlobalUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("chuyun")
public class ChuyunController {
	/**
	 *储运管理-运输提请管理
	 * @param request
	 * @return
	 */
	@RequestMapping("tansRequestManage")
	public ModelAndView topPage(HttpServletRequest request){
		ModelAndView model = new ModelAndView("storage/tansRequest");
        model.addObject("menuList",JSONArray.parseArray(GlobalUtil.CYGL));
		return model;
	}
	/**
	 *储运管理-运输提请管理
	 * @param request
	 * @return
	 */
	@RequestMapping("stockManage")
	public ModelAndView stockPage(HttpServletRequest request){
		ModelAndView model = new ModelAndView("storage/stock");
        model.addObject("menuList",JSONArray.parseArray(GlobalUtil.CYGL));
		return model;
	}
	/**
	 *储运管理-物流合作申请管理
	 * @param request
	 * @return
	 */
	@RequestMapping("wuliuhezuo")
	public ModelAndView wuliuhezuo(HttpServletRequest request){
		ModelAndView model = new ModelAndView("storage/wuliuhezuo");
        model.addObject("menuList",JSONArray.parseArray(GlobalUtil.CYGL));
		return model;
	}
	
	
	
}
