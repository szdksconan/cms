package com.cms.controller.userCenter.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex.getMessage());
		
		// 根据不同错误转向不同页面
		if(ex instanceof ServiceException) {
			return new ModelAndView("exception/error-service", model);
		}else if(ex instanceof DAOException) {
			return new ModelAndView("exception/error-dao", model);
		} else {
			return new ModelAndView("exception/error", model);
		}
	}
}
