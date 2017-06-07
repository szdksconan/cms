package com.cms.dao.maoyi;

import java.util.List;

import com.cms.model.maoyi.Network;
import com.cms.model.maoyi.NetworkBean;
import com.cms.model.maoyi.NetworkTemp;

public interface NetworkDao {

	Network selectByPrimaryKey(Long id);
	
	List<NetworkBean> findPage(Long entId);
	
	int findNetwork(Long entId,Long networkId);
	
	int insert(Network network);
	
	int insertNetworkTemp(NetworkTemp record);
	    
	int updateNetworkTemp(NetworkTemp record);
	
	int delete(Long id);
	
	int deleteNetworkTemp(Long id);
	
	NetworkBean selectNetworkTempById(Long id);
	
	int update(Network record);
}
