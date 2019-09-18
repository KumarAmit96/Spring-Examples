package com.web.app.spingmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestParamController {

	@RequestMapping("/showData")
	public ModelAndView showData(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam(value="salary",required=false, defaultValue="10.2") double salary)
	{
		System.out.println("ID: "+id);
		System.out.println("NAME: "+name);
		System.out.println("SALARY: "+salary);

		return new ModelAndView("userReg");
		
	}
	
}
