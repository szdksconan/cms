package com.cms.iservice.maoyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cms.model.maoyi.CompCooperate;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;

public interface CompCooperateService {

	List<CompCooperate> getCompCooperateByEntId(Long entId);
	
	Grid<CompCooperate> findPage(PageFilter pageFilter,CompCooperate compCooperate);
	
	ArrayList<HashMap> findCompAndNet(Long entId);
}
