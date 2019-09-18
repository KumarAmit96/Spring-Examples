package com.spring.jdbc.demo.employee.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.demo.employee.dao.EmployeeDao;
import com.spring.jdbc.demo.employee.dto.Employee;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/demo/employee/test/config.xml");
		EmployeeDao emps=(EmployeeDao)context.getBean("employeeDao");
		/*
		 * Employee emp=new Employee(); emp.setId(2); emp.setFirstname("Akanksha");
		 * emp.setLastname("Singh"); int result=emps.update(emp);
		 */
		
		
		//int result=emps.delete(1);
		
		/*
		 * Employee emp=emps.read(2); System.out.println("Your record is: "+emp);
		 */
		
		List<Employee> list=emps.readList();
		for(int i=0;i<list.size();i++)
			System.out.println(i+") "+list.get(i));
	}

}
