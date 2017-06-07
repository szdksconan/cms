package com.cms.dao.maoyi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.NetworkMapper;
import com.cms.mapper.maoyi.NetworkTempMapper;
import com.cms.model.maoyi.Network;
import com.cms.model.maoyi.NetworkBean;
import com.cms.model.maoyi.NetworkTemp;

@Component
public class NetworkDaoImp implements NetworkDao{

	@Autowired
	private NetworkMapper networkMapper;
	@Autowired
	private NetworkTempMapper networkTempMapper;

	public Network selectByPrimaryKey(Long id){
		return networkMapper.selectByPrimaryKey(id);
	}
	
	public List<NetworkBean> findPage(Long entId){
		return networkMapper.findPage(entId);
	}
	
	public int findNetwork(Long entId,Long networkId){
		return networkMapper.findNetwork(entId, networkId);
	}
	
	public int insert(Network network){
		return networkMapper.insert(network);
	}
	
	public int insertNetworkTemp(NetworkTemp record){
		return networkTempMapper.insert(record);
	}
	    
	public int updateNetworkTemp(NetworkTemp record){
		return networkTempMapper.update(record);
	}
	
	public int delete(Long id){
		return networkMapper.delete(id);
	}
	
	public int deleteNetworkTemp(Long id){
		return networkTempMapper.delete(id);
	}
	
	public NetworkBean selectNetworkTempById(Long id){
		return networkTempMapper.selectNetworkTempById(id);
	}
	
	public int update(Network record){
		return networkMapper.update(record);
	}
}
