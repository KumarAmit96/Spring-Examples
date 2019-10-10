package com.mvc.javas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mvc.javas.dao.EmployeeDAO;
import com.mvc.javas.model.EmployeeVO;

public class EmployeeManagerImpl implements EmployeeManager {

	@Autowired
	EmployeeDAO employeedao;

	public List<EmployeeVO> getEmployeeList() {
		// TODO Auto-generated method stub
		return employeedao.getEmployeeList();
	}

}
