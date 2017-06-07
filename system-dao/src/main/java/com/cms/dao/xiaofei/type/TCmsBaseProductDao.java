package com.cms.dao.xiaofei.type;

import java.util.List;
import java.util.Map;

import com.cms.model.xiaofei.type.TCmsBaseProduct;

public interface TCmsBaseProductDao {
	
	//一级
	public TCmsBaseProduct getProductLevel1ById();
	//二级
	public List<Map<String, Object>> getProductLevel2ById(String id);
	//下拉二级
	public List<Map<String, Object>> getProduct2LevelById(String id);
	//下拉三级级
	public List<Map<String, Object>> getProduct3LevelById(String id);
	
	public List<Map<String, Object>> getProductCodeOrderAsc(String code,String codes);
	
	public List<Map<String, Object>> industry(String industryId, Integer start, Integer pagesize,Integer type);

}
