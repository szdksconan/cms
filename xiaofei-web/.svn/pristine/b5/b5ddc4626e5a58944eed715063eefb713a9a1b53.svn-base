package com.cms.controller.xiaofei;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.cms.controller.test.HttpRequest;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.xiaofei.logon.CmsXLogonService;
import com.cms.model.xiaofei.DataList;
import com.cms.model.xiaofei.logon.CmsXSysUser;
import com.cms.service.common.redis.RedisUtil;
import com.cms.util.CmsUtil;
import com.cms.util.MD5Util;
import com.cms.util.RandomImageGenerator;

@Controller
@RequestMapping("/logon")
public class CmsXLogonController {
	
	@Autowired
	private CmsXLogonService cls;
	@Autowired
	private GlobalIdService gis;	
	
	
	
	
	
	
	/**
	 * 判断注册信息 是否存在      存在则返回uid
	 * @param sysuser
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/ifinfo")
	@ResponseBody
	public String  ifinfo(String t,CmsXSysUser sysuser) throws IOException {
		System.out.println("-------------"+sysuser.getPhone()+"11111111111111"+sysuser.getUname());
		List<Map<String,Object>> list=cls.ifinfo(sysuser);
		DataList data=new DataList();
		if(t!=null&&t.equals("App"))
		{
			data.setListData(list);
			return data.toString();
		}else
			return JSON.json(list);
	}
	
	/**
	 * 注册
	 * @param sysuser
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Integer  login(CmsXSysUser sysuser,HttpServletRequest request) throws IOException {
		
		List<Map<String,Object>> map=cls.ifinfo(sysuser);
		 if(map.size()>0)
			 return 0;
		 else {
			 sysuser.setUid(gis.getGlobalId().toString());
			 System.out.println("*******************"+sysuser.getPhone()+sysuser.getPassword());
			// sysuser.setPassword(MD5Util.md5(sysuser.getPassword()));
			 Integer list=cls.login(sysuser);
			 if(list==1){
				 try {
					 String IP = HttpRequest.readAddress(request, "msgIp");
					 String getURL="?memberId="+sysuser.getUid()+"&memberName="+sysuser.getUname()+"&memberType=4&phone="+sysuser.getPhone()+"&accountStatus=1";
					 System.out.println(getURL);
					 //发送 POST 请求
					 String sr=HttpRequest.sendHPost("http://"+IP+"/tzyy/member/addMember.do"+getURL, "key=123&v=456");
					 System.out.println(sr+"***********");
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }
			 return list;
		 }
		 
		 
	}
	/**
	 * 登录
	 * @param user
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/logoninfo")
	@ResponseBody
	public String logoninfo(String t,CmsXSysUser sysuser,HttpServletRequest request,HttpServletResponse response) throws IOException{
		// sysuser.setPassword(MD5Util.md5(sysuser.getPassword()));
		 CmsXSysUser list=cls.logoninfo(sysuser);
		System.out.println(list.getUid()+"==="+JSON.json(list));
		 if(list!=null){
			String name= list.getUid()+"";
			if(list.getUid()!=null||!list.getUid().equals("")){
				//map=list.get(0);
				//RedisUtil.hset("ComXiaofeiLoginUserList", list.getUid()+"", sysuser);
				//CmsXSysUser list2 = (CmsXSysUser) RedisUtil.hget("ComXiaofeiLoginUserList", list.getUid()+"");
				System.out.println("list---------------"+list.getUid());

				
				String cookieName="dl_cms_user"; 
				Cookie cookie = new Cookie("dl_cms_user",name);
				cookie.setPath("/");
				cookie.setMaxAge(-1);
				response.addCookie(cookie);
	
			}DataList data=new DataList();
			if(t!=null&&t.equals("App"))
			{
				data.setListData(list);
				return data.toString();
			}else
				return JSON.json(list);
		 }
		 return "";
		
	} 
	/**
	 * 验证密保并修改密码
	 * @param sysuser
	 * @return
	 */
	@RequestMapping("/updatepwd")
	@ResponseBody
	public String updatepwd(CmsXSysUser sysuser,String newpwd){
		 newpwd=MD5Util.md5(newpwd);
		cls.updatepwd(sysuser,newpwd);
		//cls.testing(sysuser);
		
		return "";
	}
	/**
	 * 根据经纬度获取城市
	 * 作者： 李俊霖
	 * 日期：2016年6月21日
	 * @param coordinateAddress
	 * @return
	 */
	@RequestMapping("/coordinateAddress")
	@ResponseBody
	public String coordinateAddress(String coordinateAddress){
		
		return coordinateAddress(coordinateAddress);
	}
	
	/**
	 * 返回redis值
	 * 
	 * @author ywfy
	 * @param request
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	/*@RequestMapping("/CheckLogin")
	@ResponseBody
	public  String CheckLogin(HttpServletRequest request) throws IOException {
		Map<String,Object> map=new HashMap<>();
		System.out.println("0000000000000000");
		String  name=CmsUtil.CheckLogin(request);
		System.out.println("0000000000000000"+name);
		CmsXSysUser list=null;
		if(!name.equals(""))
				cls.CheckLogin(name);
		if(cookie!=null){
			
			}
		map.put("list", list);
		//System.out.println("-------------------CheckLogin="+list.getUname());
		return JSON.json(map);
	}
	*/
	
	/**
	 * 生成验证码图片
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/randomImage")
	@ResponseBody
	public void randomImage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 //获取HttpSession对象
		HttpSession session = request.getSession();
		  //获取随机字符串
		String randomStr = RandomImageGenerator.random(4);
		if(session != null){
			session.setAttribute("randomStr", randomStr);
			//System.out.println(randomStr);
			 //设置响应类型,输出图片客户端不缓存
			response.setDateHeader("Expires", 1L);
			response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
			response.addHeader("Pragma", "no-cache");
			response.setContentType("image/jpeg");
			RandomImageGenerator.render(randomStr, response.getOutputStream(), 70,30);
		}
	}
	/**
	 * 判断验证码
	 * @param request
	 * @param response
	 * @param randomStr
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/CkrandomImage")
	@ResponseBody
	public String checkRandom(HttpServletRequest request,HttpServletResponse response,String randomStr) throws IOException{
		HttpSession session = request.getSession();
		String randomStrBys = session.getAttribute("randomStr").toString();
		if(randomStr.equalsIgnoreCase(randomStrBys)){
			return JSON.json(true);
		}
		return JSON.json(false);
	}	
	
}
