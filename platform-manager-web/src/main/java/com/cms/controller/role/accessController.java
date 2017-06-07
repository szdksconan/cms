package com.cms.controller.role;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cms.model.manager.Tree;
import com.cms.model.util.GlobalConstant;
import com.cms.model.util.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.role.accessService;
import com.cms.model.manager.accessBean;
/**
 * 系统资源
 * @author 刘鑫
 *
 */
@Controller
@RequestMapping("access")
public class accessController {
	@Autowired
	private accessService accessService;
	
	
	@RequestMapping("/manager")
	public String manager() {
		return "/admin/access";
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(GlobalConstant.SESSION_INFO);
		return this.accessService.tree(sessionInfo);
	}

	@RequestMapping("/allTree")
	@ResponseBody
	public List<Tree> allTree(Boolean flag) {//true获取全部资源,false只获取菜单资源
		return this.accessService.allTree(flag);
	}

	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<accessBean> treeGrid() {
		return this.accessService.treeGrid();
	}

	@RequestMapping("/get")
	@ResponseBody
	public accessBean get(Long id) {
		return accessService.get(id);
	}
	
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request,Long id) {
		request.setAttribute("access", this.accessService.get(id));
		return "/admin/accessEdit";
	}


	@RequestMapping("/edit")
	@ResponseBody
	public String edit(accessBean access) throws InterruptedException {
		JSONObject obj = new JSONObject();
		try {
			this.accessService.update(access);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj.toString();
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Long id) {
		JSONObject obj = new JSONObject();
		try {
			accessService.delete(id);
			obj.put("success", true);
			obj.put("msg", "删除成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj.toString();
	}
	
	@RequestMapping("/addPage")
	public String addPage() {
		return "/admin/accessAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add(accessBean access) {
		JSONObject obj = new JSONObject();
		try {
			accessService.add(access);
			obj.put("success", true);
			obj.put("msg", "添加成功！");
		} catch (Exception e) {
			obj.put("msg", e.getMessage());
		}
		return obj.toString();
	}
}
