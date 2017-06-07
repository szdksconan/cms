package com.cms.iservice.xiaofei;

import com.cms.model.xiaofei.CmsXAttachment;

public interface CmsXAttachmentService {
	
	/**
	 * 添加开店申请上传附件的信息
	 * @param cmsXShopApplyAttachment
	 */
    public void addShopApplyAndUploadGetAttachmentInfo(CmsXAttachment cmsXShopApplyAttachment);

}
