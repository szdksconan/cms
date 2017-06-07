package com.cms.service.manager.orderDic;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.orderDic.orderDicService;
import com.cms.model.manager.OrderDicBean;
import com.cms.model.manager.Tree;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.dao.manager.orderDic.orderDicDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class orderDicServiceImpl implements orderDicService {
	@Autowired
	private orderDicDao orderDicDao;

	public OrderDicBean getInfo(OrderDicBean bean) {
		return this.orderDicDao.getInfo(bean);
	}

	public Grid dataGrid(OrderDicBean orderDicBean, PageFilter ph) {
		JSONObject obj = (JSONObject) JSONObject.toJSON(orderDicBean);
		obj.put("order", ph.getOrderString());
		Grid grid = new Grid();
		grid.setRows(this.orderDicDao.dataGrid(obj));
		grid.setTotal(this.orderDicDao.dataGridCot(obj));
		return grid;
	}

	public void add(OrderDicBean orderDicBean) {
		this.orderDicDao.add(orderDicBean);

	}

	public void delete(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		this.orderDicDao.delete(obj);
	}

	public OrderDicBean get(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		return	this.orderDicDao.get(id);
	}

	public void update(OrderDicBean orderDicBean) {
		this.orderDicDao.edit(orderDicBean);
	}

	public List<OrderDicBean> treeGrid(Long pid) {
		JSONObject obj = new JSONObject();
		if (pid!=null && pid!=0){
			obj.put("pid", pid);
		}
		return this.orderDicDao.getAllDic(obj);
	}

	public List<Tree> allTree(boolean flag) {
		JSONObject obj = new JSONObject();
		obj.put("flag", flag?1:0);
		List<OrderDicBean> accessList = this.orderDicDao.getAllDic(obj);
		return this.buildTree(accessList);
	}

	/**
	 * 构建树列表
	 * @param accessList
	 * @return
	 */
	private List<Tree> buildTree(List<OrderDicBean> accessList){
		List<Tree> treeList = new ArrayList<Tree>();
		if ((accessList != null) && (accessList.size() > 0)) {
			for (OrderDicBean bean : accessList) {
				Tree tree = new Tree();
				tree.setId(bean.getId());
				if (bean.getPid() != null&&!bean.getPid().equals("")) {
					tree.setPid(bean.getPid());
				}
				tree.setText(bean.getName());
				//tree.setIconCls(bean.getIcon());
				Map<String, Object> attr = new HashMap<String, Object>();
				//attr.put("url", bean.getUrl());
				tree.setAttributes(attr);
				treeList.add(tree);
			}
		}
		return treeList;
	}
}
