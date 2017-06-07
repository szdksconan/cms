package com.cms.service.manager.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.dao.manager.role.accessDao;
import com.cms.dao.manager.user.userShortCutMenuDao;
import com.cms.iservice.manager.login.loginService;
import com.cms.iservice.manager.user.userGradeService;
import com.cms.model.manager.Tree;
import com.cms.model.manager.accessBean;
import com.cms.model.manager.userBean;
import com.cms.model.manager.userShortcutMenuBean;
import com.cms.model.util.SessionInfo;
import com.cms.util.MD5Util;

public class loginServiceImpl implements loginService {
	
	@Autowired
	private userGradeService userGradeService;

	public userBean login(userBean bean)throws Exception {
		userBean user = this.userGradeService.getUserInfo(bean);
		if (user==null){
			throw new Exception("用户名不存在！");
		}
		if (!user.getLoginPwd().equals(MD5Util.md5(bean.getLoginPwd()))){
			throw new Exception("密码不正确！");
		}
		return user;
	}
	
	@Autowired
	private userShortCutMenuDao userShortCutMenuDao;

	@Autowired
	private accessDao accessDao;

	public List<userShortcutMenuBean> treeGrid(Long userId) {
		return this.userShortCutMenuDao.treeGrid(userId);
	}

	public void add(userShortcutMenuBean bean)throws Exception {
		this.userShortCutMenuDao.add(bean);
	}

	public void delete(Long id)throws Exception {
		this.userShortCutMenuDao.delete(id);
	}

	public List<Tree> userMenuTree(SessionInfo sessionInfo) {
		String userId = sessionInfo.getUserId();
		JSONObject obj = new JSONObject();
		obj.put("accessType", 0);
		obj.put("userId", userId);
		obj.put("flag", 0);
		obj.put("urlFlag", true);
		List<accessBean> userAccessList = this.accessDao.userAccessGrid(Long.parseLong(userId));
		Map<String,String> map = new HashMap<String, String>();
		for (accessBean bean:userAccessList){
			map.put(bean.getId().toString(), bean.getId().toString());
		}
		List<accessBean> accessList = null;
		List<Tree> treeList = new ArrayList<Tree>();
		if ("1".equals(sessionInfo.getUserId())){//admin 拥有所有资源
			accessList = this.accessDao.getAllAccess(obj);
		}else {
			accessList = this.accessDao.getAccessListForUser(obj);
		}
		for (accessBean bean:accessList){
			if (map.get(bean.getId().toString())==null){
				Tree tree = new Tree();
				tree.setId(bean.getId());
				if (bean.getPid() != null&&!bean.getPid().equals("")) {
					tree.setPid(bean.getPid());
				}
				tree.setText(bean.getName());
				tree.setIconCls(bean.getIcon());
				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put("url", bean.getUrl());
				tree.setAttributes(attr);
				treeList.add(tree);
			}
		}
		return treeList;
	}

}
