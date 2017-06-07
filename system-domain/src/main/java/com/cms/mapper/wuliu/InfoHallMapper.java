package com.cms.mapper.wuliu;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.HuoyuanBean;

public interface InfoHallMapper {
	public List<CheyuanBean> cheyuanList(JSONObject json);
	
	public List<HuoyuanBean> huoyuanList(JSONObject json);
	
	public int cheyuanListCot(JSONObject json);
	
	public int huoyuanListCot(JSONObject json);
	
	public List<HuoyuanBean> getHuoyuanRecommondList(JSONObject json);
	
	public List<CheyuanBean> getCheyuanRecommondList(JSONObject json);

    public HuoyuanBean getHuoyuanInfo(Map map);

    public CheyuanBean getCheyuanInfo(Map map);

    public List getMarryCheyuanList(Map map);

    public List getMarryHuoyuanList(Map map);

    public List<CheyuanBean> marryListForHuoyuan(JSONObject obj);

    public List<HuoyuanBean> marryListForCheyuan(JSONObject obj);

    public List<CheyuanBean> getHuoyuanRecommond_cheyuanList(JSONObject obj);

    public Long getRecommond_vaseId(JSONObject obj);

    public List<HuoyuanBean> getCheyuanRecommond_huoyuanList(JSONObject obj);
}
