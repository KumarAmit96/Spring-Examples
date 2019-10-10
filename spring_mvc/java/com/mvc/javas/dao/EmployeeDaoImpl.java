package com.mvc.javas.dao;

import java.util.ArrayList;
import java.util.List;

import com.mvc.javas.model.EmployeeVO;

public class EmployeeDaoImpl implements EmployeeDAO {

	public List<EmployeeVO> getEmployeeList() {
		List<EmployeeVO> emps = new ArrayList<EmployeeVO>();

		EmployeeVO emp = new EmployeeVO();
		emp.setId(1);
		emp.setFirstname("Amit");
		emp.setLastname("Singh");
		emps.add(emp);

		EmployeeVO empt = new EmployeeVO();
		empt.setId(2);
		empt.setFirstname("Ashish");
		empt.setLastname("Singh");
		emps.add(empt);

		return emps;
	}

}
