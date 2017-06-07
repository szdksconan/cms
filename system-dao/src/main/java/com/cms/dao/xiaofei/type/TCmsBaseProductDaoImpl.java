package com.cms.dao.xiaofei.type;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.xiaofei.type.TCmsBaseProductMapper;
import com.cms.model.xiaofei.type.TCmsBaseProduct;
@Component
public class TCmsBaseProductDaoImpl implements TCmsBaseProductDao {
	@Autowired
	private TCmsBaseProductMapper tCmsBaseProductMapper;

	public TCmsBaseProduct getProductLevel1ById() {
		// TODO Auto-generated method stub
		return this.tCmsBaseProductMapper.getProductLevel1ById();
	}

	public List<Map<String, Object>> getProductLevel2ById(String id) {
		// TODO Auto-generated method stub
		return this.tCmsBaseProductMapper.getProductLevel2ById(id);
	}

	public List<Map<String, Object>> getProductCodeOrderAsc(String code, String codes) {
		// TODO Auto-generated method stub
		return this.tCmsBaseProductMapper.getProductCodeOrderAsc(code, codes);
	}

	public List<Map<String, Object>> getProduct2LevelById(String id) {
		// TODO Auto-generated method stub
		return this.tCmsBaseProductMapper.getProduct2LevelById(id);
	}

	public List<Map<String, Object>> getProduct3LevelById(String id) {
		// TODO Auto-generated method stub
		return this.tCmsBaseProductMapper.getProduct3LevelById(id);
	}
	
	public List<Map<String, Object>> industry(String industryId, Integer start, Integer pagesize,Integer type){
		
		if(type==0)
			return tCmsBaseProductMapper.industry0(industryId,start,pagesize);
		else 
			return tCmsBaseProductMapper.industry1(industryId,start,pagesize);
	}

}
