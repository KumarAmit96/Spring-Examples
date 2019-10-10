package com.utilstatic.java.staticutil.wrapper;

import com.utilstatic.java.staticutil.entity.Employee;

public class Employeewrapper {

	public static Employee getDesignation(String des)
	{
		if(des.equals("Director") || des.equals("Manager"))
		{
			Employee emp=new Employee();
			emp.setId(1);
			emp.setName("Amit Kumar Singh");
			emp.setDesignation(des);
			return emp;
		}
		else 
		{
			throw new IllegalArgumentException("Class not matched...");
		}
		
	}

}
