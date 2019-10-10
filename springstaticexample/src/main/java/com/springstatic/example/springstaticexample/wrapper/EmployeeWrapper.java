package com.springstatic.example.springstaticexample.wrapper;

import com.springstatic.example.springstaticexample.entity.Employee;

public class EmployeeWrapper {

	private Employee manager = null;
	private Employee director = null;

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Employee getDirector() {
		return director;
	}

	public void setDirector(Employee director) {
		this.director = director;
	}

}
