package com.cms.service.manager.company;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.company.subCompanyService;
import com.cms.model.manager.Tree;
import com.cms.model.manager.subCompanyBean;
import com.cms.dao.manager.company.subCompanyDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class subCompanyServiceImpl implements subCompanyService {
	@Autowired
	private subCompanyDao subCompanyDao;

	public subCompanyBean getInfo(subCompanyBean bean) {
		return this.subCompanyDao.getInfo(bean);
	}

	public List<subCompanyBean> treeGrid() {
		return this.subCompanyDao.dataGrid();
	}

	public void add(subCompanyBean subCompanyBean)throws Exception {
		this.subCompanyDao.add(subCompanyBean);

	}

	public void delete(Long id) throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		obj.put("subcompanyId", id);
		if (this.subCompanyDao.getRelationDataRole(obj).size()>0){
			throw new Exception("不能删除此网点，因为它还在被使用！");
		}
		this.subCompanyDao.delete(obj);
	}

	public subCompanyBean get(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		return	this.subCompanyDao.get(id);
	}

	public void update(subCompanyBean subCompanyBean)throws Exception {
		this.subCompanyDao.update(subCompanyBean);
	}

	public List<Tree> tree() {
		List<subCompanyBean> beanList = this.subCompanyDao.dataGrid();
		return this.buildTree(beanList);
	}

	/**
	 * 树类型转换
	 * @param beanList
	 * @return
	 */
	private List<Tree> buildTree(List<subCompanyBean> beanList){
		List<Tree> treeList = new ArrayList<Tree>();
		if (beanList != null && beanList.size() != 0){
			for (subCompanyBean bean : beanList){
				Tree tree = new Tree();
				tree.setId(bean.getId());
				if (bean.getPid()!=null) {
					tree.setPid(bean.getPid());
				}
				tree.setText(bean.getName());
				treeList.add(tree);
			}
		}
		return treeList;
	}
}
