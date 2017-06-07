package com.cms.controller.baseInfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.baseInfo.baseService;
import com.cms.model.manager.Tree;
import com.cms.model.manager.menuBean;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.SessionInfo;

/**
 * 车货匹配菜单
 * @author 韦天宇
 *
 */
@Controller
@RequestMapping("menu")
public class menuController {
	@Autowired
	private baseService baseService;
	
	
	@RequestMapping("/manager")
	public String manager() {
		return "/basic/menu";
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(GlobalConstant.SESSION_INFO);
		try{
			return this.baseService.treeMenu(sessionInfo);
		}finally {
			
		}
		
	}

	@RequestMapping("/allTree")
	@ResponseBody
	public List<Tree> allTree(Boolean flag) {//true获取全部资源,false只获取菜单资源
		
		try{
			return this.baseService.allTreeMenu(flag);
		}finally {
			
		}
	}

	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<menuBean> treeGrid() {
        return this.baseService.treeGridMenu();
	}

	@RequestMapping("/get")
	@ResponseBody
	public menuBean get(Long id) {
		
		try{
			return baseService.getMenu(id);
		}finally {
			
		}
		
	}
	
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request,Long id) {
		
		try{
			request.setAttribute("access", this.baseService.getMenu(id));
			return "/basic/menuEdit";
		}finally {
			
		}

	}


	@RequestMapping("/edit")
	@ResponseBody
	public String edit(menuBean access) throws InterruptedException {
		JSONObject obj = new JSONObject();
		
		try{
			this.baseService.updateMenu(access);
			obj.put("success", true);
			obj.put("msg", "修改成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally {
			
		}

			
		return obj.toString();
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Long id) {
		JSONObject obj = new JSONObject();
		
		try{
			baseService.deleteMenu(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally {
			
		}
		return obj.toString();
	}
	
	@RequestMapping("/addPage")
	public String addPage() {
		return "/basic/menuAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add(menuBean access) {
		JSONObject obj = new JSONObject();
		
		try{
			baseService.addMenu(access);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}finally {
			
		}
		return obj.toString();
	}
}
