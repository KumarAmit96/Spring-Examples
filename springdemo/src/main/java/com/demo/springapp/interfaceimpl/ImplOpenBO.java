package com.demo.springapp.interfaceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("demoCheck")
public class ImplOpenBO implements OpenDAO {

	@Autowired
	@Qualifier("demo")
	private ImplOpenDAO dao;


	public void printValue() {
		System.out.println("Inside ImplOpenBo interface");
		dao.printOpenDAO();
	}

	public void printOpenDAO() {

		System.out.println("Inside OpenDAO Interface");
		dao.printOpenDAO();
	}
}
