package com.cms.mapper.maoyi;

import com.cms.model.maoyi.NetworkBean;
import com.cms.model.maoyi.NetworkTemp;


public interface NetworkTempMapper {
	
    int insert(NetworkTemp record);
    
    int update(NetworkTemp record);

    int delete(Long id);
    
    NetworkBean selectNetworkTempById(Long id);
}