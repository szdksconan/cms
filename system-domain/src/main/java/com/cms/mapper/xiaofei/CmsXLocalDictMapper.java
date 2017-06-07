package com.cms.mapper.xiaofei;

import com.cms.model.xiaofei.CmsXLocalDict;

public interface CmsXLocalDictMapper {
    
	/**
	 * 查询地理位置表获取code
	 * 作者： 郑泽
	 * 日期：2016年4月22日
	 * @param localStr
	 * @return
	 */
	CmsXLocalDict selectByLoclCodeGetLoclCode(String localStr);
}