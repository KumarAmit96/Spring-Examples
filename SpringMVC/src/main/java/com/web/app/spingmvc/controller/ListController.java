package com.web.app.spingmvc.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.app.spingmvc.dto.Employee;

@Controller
public class ListController {

	@RequestMapping("/readList")
	public ModelAndView sendobject() {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("displayList");
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setId(123);
		employee.setName("Amit Kumar Singh");
		employee.setSalary(10000);
		employees.add(employee);

		Employee emp = new Employee();
		emp.setId(13);
		emp.setName("Amit Kumar");
		emp.setSalary(20000);
		employees.add(emp);

		modelandview.addObject("employees", employees);
		return modelandview;
	}

}
