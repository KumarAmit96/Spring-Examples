package com.forms.validity.service;

import com.form.validity.model.Employee;

public class EmployeeManagerImpl implements EmployeeManager {

	public int create(Employee emp) {
		// TODO Auto-generated method stub
		if(emp.getId()>0)
			return 1;
		else
			return 0;
	}

}
