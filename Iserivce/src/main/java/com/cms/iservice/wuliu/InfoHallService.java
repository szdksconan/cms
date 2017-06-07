package com.cms.iservice.wuliu;

import com.cms.model.User;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.model.wuliu.CheyuanBean;
import com.cms.model.wuliu.ChppQueryParam;
import com.cms.model.wuliu.HuoyuanBean;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InfoHallService {
    /**
     * 获取车源
     * @param ph
     * @return
     */
	public Grid cheyuanList(ChppQueryParam queryParam,PageFilter ph, User loginUser);

    /**
     * 获取货源
     * @param ph
     * @return
     */
	public Grid huoyuanList(ChppQueryParam queryParam,PageFilter ph, User loginUser);

    /**
     * 获取推荐货源
     * @param user
     * @return
     */
	public Grid getHuoyuanRecommondList(User user);

    /**
     * 获取推荐车源
     * @param user
     * @return
     */
	public Grid getCheyuanRecommondList(User user);
	
	/**
	 * 匹配货源
	 * @param bean
	 * @return
	 */
	public Grid marryListForHuoyuan(HuoyuanBean bean);
	
	/**
	 * 匹配车源
	 * @param bean
	 * @return
	 */
	public Grid marryListForCheyuan(CheyuanBean bean);

    /**
     * 获取车源信息
     * @param map
     * @return
     */
    public CheyuanBean getCheyuanInfo(HashMap map);

    /**
     * 货源信息
     * @param map
     * @return
     */
    public HuoyuanBean getHuoyuanInfo(HashMap map);

    public List getMarryList(HashMap map);
}
