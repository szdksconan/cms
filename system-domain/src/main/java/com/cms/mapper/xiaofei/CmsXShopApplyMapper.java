package com.cms.mapper.xiaofei;

import java.util.List;
import java.util.Map;

import com.cms.model.xiaofei.CmsXShopApply;

public interface CmsXShopApplyMapper {
    
	/**
	 * 申请开店的基本信息
	 * 作者： 郑泽
	 * 日期：2016年4月18日
	 * @param cmsXShopApply
	 */
    public void addOpenShopApplyAndBasicInfo(CmsXShopApply cmsXShopApply);
    
    /**
     * 查询全部开店信息
     * 作者： 郑泽
     * 日期：2016年4月21日
     * @return
     */
    public List<CmsXShopApply> selectAllUserAndShopAndAttachmentGetInfo(String loclCode,String typeCode,Integer page,Integer pageSize);
    /**
     * 根据ID查询开店信息并且推送给贸易平台
     * 作者： 郑泽
     * 日期：2016年5月27日
     * @param Id
     * @return
     */
    public CmsXShopApply selectGetCmsXShopApplyByIdAndInfo(String Id);

}