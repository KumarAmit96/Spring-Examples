package com.web.app.spingmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView hello()
	{
		ModelAndView modelandView =new ModelAndView();
		modelandView.addObject("ID", 1);
		modelandView.addObject("NAME", "Amit Kumar Singh");
		modelandView.addObject("SALARY", 10000);
		modelandView.setViewName("Hello");
		return modelandView;
	}
	

}
