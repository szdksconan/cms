package com.cms.controller.car;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.model.wuliu.CarBean;
import com.cms.util.UploadUtil;
/**
 * 车辆
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("/car")
public class carController {
	@Autowired
	private baseService baseService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/car";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(CarBean car, PageFilter ph) {
		return this.baseService.dataGridCar(car, ph);
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/carAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(String json,MultipartHttpServletRequest request) {
		JSONObject obj = JSONObject.parseObject(json);
        CarBean carBean = JSONObject.parseObject(json, CarBean.class);
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(GlobalConstant.SESSION_INFO);
		try {
			Map<String,String> map = UploadUtil.uploadImg(request, carBean.getCarNo(), GlobalConstant.cardFiles);
			//obj.putAll(map);
			carBean.setCarCardUrl(map.get("carCardUrl"));
			carBean.setCarCard2Url(map.get("carCard2Url"));
			carBean.setCarCard3Url(map.get("carCard3Url"));
			carBean.setCarCard4Url(map.get("carCard4Url"));

			carBean.setCarNoUrl (map.get("carPicUrl"));

			baseService.addCar(carBean);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
			
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JSONObject delete(Long id) {
		JSONObject obj = new JSONObject();
		try {
			baseService.deleteCar(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@RequestMapping("/editPage")
	public ModelAndView updatePage(Long id) {
		ModelAndView model = new ModelAndView("/basic/carEdit");
		CarBean carBean = this.baseService.getCar(id);
		model.addObject("carBean", carBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(CarBean carBean) {
		JSONObject obj = new JSONObject();
		try {
			baseService.editCar(carBean);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/dataGrid3")
	@ResponseBody
	public String dataGrid3() {
		JSONObject obj = new JSONObject();
		List<CarBean> list = this.baseService.dataGrid3Car();

		return "callback("+JSONObject.toJSON(list).toString()+")";
	}
}
