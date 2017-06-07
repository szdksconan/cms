package com.cms.iservice.manager.department;


import com.cms.model.manager.departmentBean;
import com.cms.model.util.PageFilter;

import java.util.List;

public interface departmentService {
	public List<departmentBean> dataGrid(departmentBean bean, PageFilter ph);
	
	public void add(departmentBean department)throws Exception;

	public void delete(Long id)throws Exception;

	public void update(departmentBean department)throws Exception;

	public departmentBean get(Long id);
	
	public List<departmentBean> getDepartmentList(String json);

}
