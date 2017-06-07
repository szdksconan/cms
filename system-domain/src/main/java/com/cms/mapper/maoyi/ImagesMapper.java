package com.cms.mapper.maoyi;

import java.util.HashMap;
import java.util.List;

import com.cms.model.maoyi.CmsImages;

public interface ImagesMapper {
	public int insert(HashMap<String,List<CmsImages>> lci);
	public List<CmsImages> getImagesByProductId(String productId) throws Exception;
}
