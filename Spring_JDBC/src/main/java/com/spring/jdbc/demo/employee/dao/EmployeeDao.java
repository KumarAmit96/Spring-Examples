package com.spring.jdbc.demo.employee.dao;

import java.util.List;

import com.spring.jdbc.demo.employee.dto.Employee;

public interface EmployeeDao {
	
	int create(Employee emp);
	
	int update(Employee emp);
	
	int delete(int id);
	
	Employee read(int id);
	
	List<Employee> readList();

}
