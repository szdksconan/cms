package com.cms.controller.storage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("storage")
public class StorageController {
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("storage/yunshutiqi");
		return model;
	}
	@RequestMapping("/stock")
	public ModelAndView stock(){
		ModelAndView model = new ModelAndView("storage/stock");
		return model;
	}
}
