package com.spring.jdbc.demo.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.jdbc.demo.employee.dao.EmployeeDao;
import com.spring.jdbc.demo.employee.dao.rowmapper.EmployeeRowMapper;
import com.spring.jdbc.demo.employee.dto.Employee;

@Component("employeeDao")
public class EmpployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int create(Employee emp) {
		String url="Insert into employee values (?,?,?)";
		int result=jdbcTemplate.update(url, emp.getId(),emp.getFirstname(),emp.getLastname());
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int update(Employee emp)
	{
		String url="update employee set firstname=?,lastname=? where id=?";
		int result=jdbcTemplate.update(url, emp.getFirstname(),emp.getLastname(),emp.getId());
		return result;	
	}

	public int delete(int id) {
		String url="delete from employee where id=?";
		int result=jdbcTemplate.update(url, id);
		return result;	}

	public Employee read(int id) {
		EmployeeRowMapper rowMapper=new EmployeeRowMapper();
		String url="Select * from employee where id=?";
		Employee emp=jdbcTemplate.queryForObject(url, rowMapper,id);
		return emp;
	}

	public List<Employee> readList() {
		String url="Select * from employee";
		EmployeeRowMapper rowMapper=new EmployeeRowMapper();
		List<Employee> list=jdbcTemplate.query(url, rowMapper);
		return list;
	}
	
}
