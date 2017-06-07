package com.cms.iservice.xiaofei;

import java.util.List;
import java.util.Map;

import com.cms.mapper.xiaofei.CmsXReqRecMapper;
import com.cms.model.xiaofei.CmsXReqRec;

public interface CmsXReqRecService {
	
	/**
	 * 添加用户发布的创新定制信息
	 * 作者： 郑泽
	 * 日期：2016年4月23日
	 * @param cmsXReqRec
	 */
	public void addUserReleaseAndInnovationCustomGetInfo(CmsXReqRec cmsXReqRec);
	
	/**
     * 查看全部创新定制信息
     * 作者： 郑泽
     * 日期：2016年4月27日
     * @return
     */
	public List<CmsXReqRec> selectAllCmsXReqRecGetInfo(String loclCode,String typeCode,Integer page,Integer pageSize);

}
