package com.cms.mapper.wuliu;

import java.util.List;
import java.util.Map;

import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.HuoyuanBean;

public interface InfoPublishMapper {
	public void addHuoyuan(HuoyuanBean bean);
	
	public void addCheyuan(CheyuanBean bean);
	
	public List<Map> getHistoryList(Map map);
	
	public Integer getHistoryListCot(Map map);
	
	public void updateRePublish(Map map);

    public void updateconfirm(Map map);

    public List<Map> showRelationList(Map map);

    public void updateHuoyuanCheyuanId(Map map);

    public void updateCheyuanHuoyuanId(Map map);

    public void delInfo(Map map);

    public void saveAddress(Map map);

    public List<Map> getUserAddress(Map map);

    public void deleteAdd(Map map);

    public void updatePlatformLogistics(Map map);

    public Map getMainLine(Map map);

    public Integer getLastCheyuanCot(Map map);
    
    public Integer getLastCheyuanCot2(Map map);
}
