package com.demo.springapp.interfaceimpl;

import org.springframework.stereotype.Component;

@Component("demo2")
public class ImplOpenDAO2 implements OpenDAO{

	public void printOpenDAO() {

		System.out.println("Inside in ImplOpenDAO2");
		
	}

}
