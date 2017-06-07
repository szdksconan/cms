package com.cms.service.manager.role;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.role.accessService;
import com.cms.model.manager.Tree;
import com.cms.model.manager.accessBean;
import com.cms.model.manager.dataRoleBean;
import com.cms.model.manager.roleBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.dao.manager.role.accessDao;
import com.cms.dao.manager.role.dataRoleDao;
import com.cms.dao.manager.role.roleDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class accessServiceImpl implements accessService {
	@Autowired
	private accessDao accessDao;

	@Autowired
	private roleDao roleDao;
	
	@Autowired
	private dataRoleDao dataRoleDao;

	public List<accessBean> treeGrid() {
		JSONObject obj = new JSONObject();
		obj.put("flag", 1);
		return this.accessDao.getAllAccess(obj);
	}

	public void add(accessBean bean)throws Exception {
		this.accessDao.add(bean);
	}

	public void delete(Long id)throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("type", "access");
		obj.put("id", id);
		this.roleDao.delGrant(obj);
		this.accessDao.delete(id);
	}

	public void update(accessBean bean)throws Exception {
		this.accessDao.update(bean);
	}

	public accessBean get(Long id) {
		return this.accessDao.getAccessById(id);
	}

	public List<Tree> tree(SessionInfo sessionInfo) {
		List<accessBean> accessList = null;
		JSONObject obj = new JSONObject();
		obj.put("accessType", 0);
		obj.put("userId", sessionInfo.getUserId());
		obj.put("flag", 0);
		if ("1".equals(sessionInfo.getUserId())){
			accessList = this.accessDao.getAllAccess(obj);
		}else {
			accessList = this.accessDao.getAccessListForUser(obj);
		}
		return this.buildTree(accessList);
	}

	public List<Tree> allTree(Boolean flag) {
		JSONObject obj = new JSONObject();
		obj.put("flag", flag?1:0);
		List<accessBean> accessList = this.accessDao.getAllAccess(obj);
		return this.buildTree(accessList);
	}

	public List<String> accessList(Long userId) {
		return this.accessDao.accessList(userId);
	}

	/**
	 * 构建树列表
	 * @param accessList
	 * @return
	 */
	private List<Tree> buildTree(List<accessBean> accessList){
		List<Tree> treeList = new ArrayList<Tree>();
		if ((accessList != null) && (accessList.size() > 0)) {
			for (accessBean bean : accessList) {
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

	public List<String> getAllAccessList() {
		return this.accessDao.accessList(null);
	}
	


	public dataRoleBean getInfo(dataRoleBean bean) {
		JSONObject obj = (JSONObject) JSONObject.toJSON(bean);
		return this.dataRoleDao.getInfo(obj);
	}

	public Grid dataGrid(dataRoleBean dataRoleBean, PageFilter ph) {
		JSONObject obj = new JSONObject();
		if (dataRoleBean!=null){
			obj = (JSONObject) JSONObject.toJSON(dataRoleBean);
		}
		if (ph != null){
			obj.put("order", ph.getOrderString());
		}
		Grid grid = new Grid();
		grid.setRows(this.dataRoleDao.dataGrid(obj));
		grid.setTotal(this.dataRoleDao.dataGridCot(obj));
		return grid;
	}

	public void add(dataRoleBean dataRoleBean) {
		this.dataRoleDao.add(dataRoleBean);

	}

	public void deleteDataRole(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		this.dataRoleDao.delete(obj);
	}

	public dataRoleBean getDataRole(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		return	this.dataRoleDao.get(id);
	}

	public void update(dataRoleBean dataRoleBean) {
		this.dataRoleDao.update(dataRoleBean);
	}

	public void addGrant(dataRoleBean role) throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("id", role.getId());
		obj.put("type", "dataRole");
		this.dataRoleDao.delGrant(obj);
		if (!"".equals(role.getSubIds())){
			obj.put("array", role.getSubIds().split(","));
			this.dataRoleDao.addGrant(obj);
		}
	}
	


	public Grid dataGridRole(JSONObject obj, PageFilter ph) {
		if (ph!=null){
			obj.put("order", ph.getOrderString());
		}
		Grid grid = new Grid();
		grid.setRows(this.roleDao.dataGrid(obj));
		grid.setTotal(this.roleDao.dataGridCot(obj));
		return grid;
	}

	public roleBean getRole(Long id) {
		return this.roleDao.get(id);
	}

	public void update(roleBean bean)throws Exception {
		this.roleDao.update(bean);
	}

	public void add(roleBean bean) throws Exception {
		this.roleDao.add(bean);
	}

	public void deleteRole(Long id) throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("type", "role");
		obj.put("id", id);
		this.roleDao.delGrant(obj);
		this.roleDao.delete(id);
	}

	public void addGrant(roleBean role) throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("id", role.getId());
		obj.put("type", "role");
		this.roleDao.delGrant(obj);
		if (!"".equals(role.getAccessIds())){
			obj.put("array", role.getAccessIds().split(","));
			this.roleDao.addGrant(obj);
		}
	}
}
