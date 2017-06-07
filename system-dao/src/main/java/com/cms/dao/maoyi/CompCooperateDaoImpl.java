package com.cms.dao.maoyi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.maoyi.CompCooperateMapper;
import com.cms.model.maoyi.CompCooperate;

@Component
public class CompCooperateDaoImpl implements CompCooperateDao{

	@Autowired
	private CompCooperateMapper compCooperateMapper;
	
	
	public List<CompCooperate> getCompCooperateByEntId(Long entId){
		return compCooperateMapper.getCompCooperateByEntId(entId);
	}
	
	public List<CompCooperate> findPage(JSONObject obj){
		return compCooperateMapper.findPage(obj);
	}
	
	public Integer findPageTotal(JSONObject obj){
		return compCooperateMapper.findPageTotal(obj);
	}
	
}
