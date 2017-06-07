package com.cms.iservice.manager.province;


import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.ProvinceBean;

import java.util.List;

public interface provinceService {
	public ProvinceBean getInfo(ProvinceBean bean);
	
	public Grid dataGrid(ProvinceBean provinceBean, PageFilter ph);

	public void add(ProvinceBean provinceBean);

	public void delete(String id);

	public ProvinceBean get(String id);
	
	public void edit(ProvinceBean provinceBean);
	
	public List<ProvinceBean> getProvinceByType(String q);
	
	public List<ProvinceBean> getProvinceByType2(String q, String pid1);
}
