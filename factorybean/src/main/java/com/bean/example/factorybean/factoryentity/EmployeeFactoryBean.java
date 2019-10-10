package com.bean.example.factorybean.factoryentity;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import com.bean.example.factorybean.entity.Employee;

public class EmployeeFactoryBean extends AbstractFactoryBean<Object> {

	private String designation;

	@Override
	public Class<Employee> getObjectType() {
		// TODO Auto-generated method stub
		return Employee.class;
	}

	@Override
	protected Object createInstance() throws Exception {
		Employee employee = new Employee();
		employee.setId(-1);
		employee.setFirstname("Amit");
		employee.setLastname("Singh");
		employee.setDesignation(designation);
		return employee;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
