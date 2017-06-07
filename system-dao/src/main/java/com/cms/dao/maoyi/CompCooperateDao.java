package com.cms.dao.maoyi;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.maoyi.CompCooperate;

public interface CompCooperateDao {
	
	List<CompCooperate> getCompCooperateByEntId(Long entId);
	
	public List<CompCooperate> findPage(JSONObject obj);
	
	public Integer findPageTotal(JSONObject obj);
}
