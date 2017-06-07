package com.cms.iservice.xiaofei.type;

import java.util.List;
import java.util.Map;

import com.cms.model.elasticsearch.cm.PageProduce;
import com.cms.model.xiaofei.type.TCmsBaseProduct;

public interface TCmsBaseProductService {

	public List<Map<String, Object>> getProductLevelById();
	
	public List<Map<String, Object>> getProductCodeOrderAsc(String code,String codes);
	
	//下拉二级
	public List<Map<String, Object>> getProduct2LevelById(String id);
	//下拉三级级
	public List<Map<String, Object>> getProduct3LevelById(String id);


	public List<Map<String, Object>> industry(String industryId, Integer start, Integer pagesize,Integer type);
	
}
