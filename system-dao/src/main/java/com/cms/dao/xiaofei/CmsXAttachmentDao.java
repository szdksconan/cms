package com.cms.dao.xiaofei;

import java.util.List;
import java.util.Map;

import com.cms.model.xiaofei.CmsXAttachment;

public interface CmsXAttachmentDao {
	
	/**
	 * 附件信息
	 * @param cmsXShopApplyAttachment
	 */
    public void addShopApplyAndUploadGetAttachmentInfo(CmsXAttachment cmsXShopApplyAttachment);
    /**
	 * 根据code查询相关附件信息
	 * 作者： 郑泽
	 * 日期：2016年5月27日
	 * @param code
	 * @return
	 */
	public CmsXAttachment selectGetCodeAndAttachment(String code);
	/**
	 * 根据ID查询开店关联的附件信息并且推送给贸易平台
	 * 作者： 郑泽
	 * 日期：2016年5月27日
	 * @param Id
	 * @return
	 */
	public List<CmsXAttachment> selectGetByIdAndmentInfo(String Id);

}
