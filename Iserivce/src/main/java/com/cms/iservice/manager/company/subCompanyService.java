package com.cms.iservice.manager.company;


import com.cms.model.manager.Tree;
import com.cms.model.manager.subCompanyBean;

import java.util.List;

public interface subCompanyService {
	public subCompanyBean getInfo(subCompanyBean bean);
	
	public List<subCompanyBean> treeGrid();

	public void add(subCompanyBean subCompanyBean)throws Exception;

	public void delete(Long id)throws Exception;

	public subCompanyBean get(Long id);
	
	public void update(subCompanyBean subCompanyBean)throws Exception;
	
	public List<Tree> tree();
}
