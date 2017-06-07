package com.cms.iservice.xiaofei;

import com.cms.model.xiaofei.CmsXLocalDict;

public interface CmsXLocalDictService {
	
	/**
	 * 根据地理位置获取code
	 * 作者： 郑泽
	 * 日期：2016年4月22日
	 * @param localStr
	 * @return
	 */
	CmsXLocalDict selectByLoclCodeGetLoclCode(String localStr);

}
