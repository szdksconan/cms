package com.cms.controller.xiaofei;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.model.User;
import com.cms.service.activemq.util.MQUtil;
import com.cms.service.exception.ServiceException;
import com.cms.service.log4j.LogTool;
import com.cms.controller.xiaofei.MQreceive;

@Controller
@RequestMapping("/test")
public class TestController {
	
	
	@RequestMapping("/test")
	@ResponseBody
	public void test(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		LogTool.log_exception(new Exception());
		
		User user=new User();
		user.setLoginName("test user");
		MQUtil.send("xiaofei_test", user);
		MQUtil.receive("xiaofei_test", new MQreceive() );
		LogTool.log_login("Test the log_login");
		System.out.println("Test the log_in------------");
		throw new ServiceException("没有行内机构号,交易失败...");
	}
}
