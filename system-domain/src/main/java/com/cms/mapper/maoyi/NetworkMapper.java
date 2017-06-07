package com.cms.mapper.maoyi;

import java.util.List;

import com.cms.model.maoyi.Network;
import com.cms.model.maoyi.NetworkBean;

public interface NetworkMapper {
	
	Network selectByPrimaryKey(Long id);
	
	List<NetworkBean> findPage(Long entId);
	
	int findNetwork(Long entId,Long networkId);
	
	int insert(Network network);
	
	int delete(Long id);
	
	int update(Network record);
}