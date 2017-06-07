package com.cms.controller.orderDic;

import java.util.List;

import com.cms.model.manager.Tree;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.manager.OrderDicBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.orderDic.orderDicService;
/**
 * 货物信息字典
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/orderDic")
public class orderDicController {
	@Autowired
	private orderDicService orderDicService;

	/**
	 * 跳转到列表页
	 * @return
	 */
	
	@RequestMapping("/manager")
	public String manager() {
		return "/orderDic/orderDic";
	}
	
	@RequestMapping("/dataGrid")
	@ResponseBody
	public Grid dataGrid(OrderDicBean orderDic, PageFilter ph) {
		return this.orderDicService.dataGrid(orderDic, ph);
	}
	
	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<OrderDicBean> treeGrid(Long pid) {
		return this.orderDicService.treeGrid(pid==null?0:pid);
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "/orderDic/orderDicAdd";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public JSONObject add(OrderDicBean orderDicBean) {
		JSONObject obj = new JSONObject();
		try {
			orderDicService.add(orderDicBean);
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
			orderDicService.delete(id);
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
	@RequestMapping("/updatePage")
	public ModelAndView updatePage(Long id) {
		ModelAndView model = new ModelAndView("/admin/orderDicEdit");
        OrderDicBean orderDicBean = this.orderDicService.get(id);
		model.addObject("orderDic"+"Bean", orderDicBean);
		return model;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject edit(Long id) {
		JSONObject obj = new JSONObject();
        OrderDicBean orderDicBean = orderDicService.get(id);
		String tag = orderDicBean.getTag();
		if("1".equals(tag)){
			tag="0";
		}
		else{
			tag="1";
		}
		orderDicBean.setTag(tag);
		try {
			orderDicService.update(orderDicBean);
			obj.put("success", true);
			obj.put("msg", "更改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/allTree")
	@ResponseBody
	public List<Tree> allTree(boolean flag) {//true获取全部资源,false只获取菜单资源
		return this.orderDicService.allTree(flag);
	}
}
