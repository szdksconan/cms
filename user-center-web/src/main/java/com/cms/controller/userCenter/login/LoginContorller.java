package com.cms.controller.userCenter.login;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.cms.controller.userCenter.exception.CodeConst;
import com.cms.controller.userCenter.exception.ServiceException;
import com.cms.iservice.userCenter.SysUserService;
import com.cms.model.userCenter.SysUser;
import com.cms.service.fastdfs.FastdfsClient;
import com.cms.service.fastdfs.FastdfsClientFactory;

/**
 * login
 * @author st
 *
 */
@Controller
@RequestMapping("/login")
public class LoginContorller {
	
	@Autowired
	private SysUserService sysUserService;
	/**
	 * 跳转首页
	 * @param request
	 * @return
	 */
	@RequestMapping("/register")
	public String index(HttpServletRequest request) {
		return "/register";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return"redirect:/";
	}
	@RequestMapping("/checklogin")
	@ResponseBody
	public String check(SysUser user,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		String msg = "";
		String type = "";
		try{
			List ls = sysUserService.getByName(user);
			if(ls.size() >0){
				List ls1 = sysUserService.loginCheck(user);
				if(ls1.size()>0){
					obj.put("type", "3");
					LogTool.log_login("登录成功");
				}else{
					obj.put("type", "2");
					msg = "账户名与密码不匹配，请重新输入";
					LogTool.log_login(msg);
				}
			}else{
				obj.put("type", "1");
				msg = "账户名不存在，请重新输入";
				LogTool.log_login(msg);
			}
			obj.put("success", true);
			obj.put("msg", msg);
			
		}catch(Exception e){
			obj.put("success", false);
			LogTool.log_exception(e);
			obj.put("msg", "登录异常");
		}
		return obj.toString();
	}
	@RequestMapping("/upload")  
	@ResponseBody  
	public String upload(@RequestParam CommonsMultipartFile file){  
		DiskFileItem fi = (DiskFileItem) file.getFileItem();
        File f = fi.getStoreLocation();
		FastdfsClient client = FastdfsClientFactory.getFastdfsClient();
		String url = "";
		try {
			url = client.getUrl(client.upload(f));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;

	} 
	
	
}
