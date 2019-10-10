package com.springstatic.example.springstaticexample.entity;

public class Employee {
	
	public static final Employee MANAGER=new Employee("manager");
	public static final Employee DIRECTOR=new Employee("director");


	public Employee(String designation) {
		this.id = -1;
		this.name = "dummy";
		this.designation = designation;
	}

	private int id;
	private String name;
	private String designation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + "]";
	}

}
