package com.demo.springapp.interfaceimpl;

import org.springframework.stereotype.Component;

@Component("demo")
public class ImplOpenDAO implements OpenDAO{

	public void printOpenDAO() {
       System.out.println("Inside ImplOpenDAO method");		
	}

}
