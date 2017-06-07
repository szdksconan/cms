package com.cms.service.manager.department;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.department.departmentService;
import com.cms.model.manager.Tree;
import com.cms.model.manager.departmentBean;
import com.cms.model.util.PageFilter;
import com.cms.dao.manager.department.departmentDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class departmentServiceImpl implements departmentService {
	@Autowired
	private departmentDao departmentDao;

	public List<departmentBean> dataGrid(departmentBean bean, PageFilter ph) {
		JSONObject obj = new JSONObject();
		if (bean != null){
			obj = (JSONObject) JSONObject.toJSON(bean);
		}
		if (ph != null){
			obj.put("order", ph.getOrderString());
		}
		return this.departmentDao.dataGrid(obj);
	}

	public void add(departmentBean department)throws Exception {
		this.departmentDao.add(department);
	}

	public void delete(Long id)throws Exception {
		this.departmentDao.delete(id);
	}

	public void update(departmentBean department)throws Exception {
		this.departmentDao.update(department);
	}

	public departmentBean get(Long id) {
		return this.departmentDao.get(id);
	}

	/**
	 * 树类型转换
	 * @param beanList
	 * @return
	 */
	private List<Tree> buildTree(List<departmentBean> beanList){
		List<Tree> treeList = new ArrayList<Tree>();
		if (beanList != null && beanList.size() != 0){
			for (departmentBean bean : beanList){
				Tree tree = new Tree();
				tree.setId(bean.getId());
				if (bean.getPid()!=null) {
					tree.setPid(bean.getPid());
				}
				tree.setText(bean.getName());
				tree.setIconCls(bean.getIcon());
				treeList.add(tree);
			}
		}
		return treeList;
	}

	public List<departmentBean> getDepartmentList(String json) {
		JSONObject obj = JSONObject.parseObject(json);
		return this.departmentDao.dataGrid(obj);
	}

}
