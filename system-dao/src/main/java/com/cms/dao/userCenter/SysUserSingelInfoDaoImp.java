package com.cms.dao.userCenter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.userCenter.SysUserSingelInfoMapper;
import com.cms.model.userCenter.SysUser;
import com.cms.model.userCenter.SysUserSingelInfo;

@Repository
public class SysUserSingelInfoDaoImp implements SysUserSingelInfoDao{
	@Autowired
	private SysUserSingelInfoMapper sysUserSingelInfoMapper;
	//保存用户信息
	public void insert(SysUserSingelInfo sysUserSingelInfo){
		this.sysUserSingelInfoMapper.insert(sysUserSingelInfo);
	}
	//删除用户信息
	public void delete(Long pid){
		this.sysUserSingelInfoMapper.delete(pid);
	}
	//更新用户信息
	public void update(SysUserSingelInfo sysUserSingelInfo){
		this.sysUserSingelInfoMapper.update(sysUserSingelInfo);
	}
	//获得用户信息
	public Map<String,Object>  get(Long uid){
		return this.sysUserSingelInfoMapper.get(uid);
	}
	//获得所有的用户信息
	public List<SysUserSingelInfo> getAll(){
		return this.sysUserSingelInfoMapper.getAll();
	}
	public void updateBasicInfoPer(SysUser sysUser) {
		this.sysUserSingelInfoMapper.updateBasicInfoPer(sysUser);
	}
	public void updatePhone(SysUser sysUser) {
		this.sysUserSingelInfoMapper.updatePhone(sysUser);
	}
	public Map<String,Object> getSysUser(Long uid) {
		return this.sysUserSingelInfoMapper.getSysUser(uid);
	}
	public void updateEmail(SysUser sysUser) {
		this.sysUserSingelInfoMapper.updateEmail(sysUser);
	}
	public void updateImgPath(JSONObject obj) {
		this.sysUserSingelInfoMapper.updateImgPath(obj);
	}
}
