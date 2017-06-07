package com.cms.iservice.manager.company;


import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.companyBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;

import java.util.List;

public interface companyService {
	public companyBean getInfo(JSONObject obj);
	
	public Grid dataGrid(companyBean companyBean, PageFilter ph);

	public void add(JSONObject obj)throws Exception;

	public void updateFlag(JSONObject obj)throws Exception;

	public companyBean get(Long id);
	
	public void update(JSONObject obj)throws Exception;
	
	public void updatePwd(JSONObject obj)throws Exception;
	
	public List<companyBean> dataGrid2(companyBean companyBean, PageFilter ph);
	
	public void updateaudit(JSONObject obj);
}
