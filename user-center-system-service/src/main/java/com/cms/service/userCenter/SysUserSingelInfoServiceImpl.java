package com.cms.service.userCenter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.dao.userCenter.SysUserSingelInfoDao;
import com.cms.iservice.userCenter.SysUserSingelInfoService;
import com.cms.model.userCenter.SysUser;
import com.cms.model.userCenter.SysUserSingelInfo;
public class SysUserSingelInfoServiceImpl implements SysUserSingelInfoService {
	@Autowired
	private SysUserSingelInfoDao sysUserSingelInfoDao;
	//保存个人用户信息
	public void insert(SysUserSingelInfo sysUserSingelInfo) {
		this.sysUserSingelInfoDao.insert(sysUserSingelInfo);
	}
	//删除个人用户信息
	public void delete(Long pid) {
		this.delete(pid);
	}
	//更新个人用户信息
	public void update(SysUserSingelInfo sysUserSingelInfo) {
		this.sysUserSingelInfoDao.update(sysUserSingelInfo);

	}
	//获得个人用户信息
	public Map<String,Object>  get(Long uid) {
		
		return this.sysUserSingelInfoDao.get(uid);
	}
	//活得所有的用户信息
	public List<SysUserSingelInfo> getAll() {
		
		return this.sysUserSingelInfoDao.getAll();
	}
	public void updateBasicInfoPer(SysUser sysUser) {
		this.sysUserSingelInfoDao.updateBasicInfoPer(sysUser);
	}
	public void updatePhone(SysUser sysUser) {
		//对获得的验证码进行判断
		//模拟获得的手机验证码:
		this.sysUserSingelInfoDao.updatePhone(sysUser);

	}
	public void checkCode(String safeCode) {
		String tempCode = "1234";
		if(!tempCode.equals(safeCode)){
			throw new RuntimeException("你输入的验证码不正确");
		}
	}
	public Map<String,Object> getSysUser(Long uid) {
		return this.sysUserSingelInfoDao.getSysUser(uid);
	}
	public void updateEmail(SysUser sysUser) {
		this.sysUserSingelInfoDao.updateEmail(sysUser);
	}
	public void updateImgPath(String profileImage,Long uid) {
		JSONObject obj = new JSONObject();
		obj.put("profileImage", profileImage);
		obj.put("uid", uid);
		this.sysUserSingelInfoDao.updateImgPath(obj);
	}
}
