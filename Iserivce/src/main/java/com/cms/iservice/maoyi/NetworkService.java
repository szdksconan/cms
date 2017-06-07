package com.cms.iservice.maoyi;

import java.util.List;

import com.cms.model.maoyi.Network;
import com.cms.model.maoyi.NetworkBean;
import com.cms.model.maoyi.NetworkTemp;

/**
 * 
 * @author mahu
 *
 */
public interface NetworkService {

	Network selectByPrimaryKey(Long id);
	
	List<NetworkBean> findPage(Long entId);
	
	int findNetwork(Long entId,Long networkId);
	
	int insertNetwork(Network network);
	
	int insertNetworkTemp(NetworkTemp record);
	
	int insertNetworkTemp(Network network,NetworkTemp record);
	    
	int updateNetworkTemp(NetworkTemp record);
	
	int deleteNetwork(Long id);
	
	int deleteNetworkAndTemp(Long id,Long networkTempId);
	
	public NetworkBean selectNetworkTempById(Long id);
	
	public int update(Network record);
}
