package com.cms.mapper.maoyi;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.maoyi.CompCooperate;
import java.util.List;

public interface CompCooperateMapper {
	
	List<CompCooperate> getCompCooperateByEntId(Long entId);
	
	List<CompCooperate> findPage(JSONObject obj);
	Integer findPageTotal(JSONObject obj);
	
}