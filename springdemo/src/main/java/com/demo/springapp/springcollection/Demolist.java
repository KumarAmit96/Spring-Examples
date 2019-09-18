package com.demo.springapp.springcollection;

import java.util.List;

public class Demolist {
	
	private String name;
	private List<String> subject;
	
	@Override
	public String toString() {
		return "Demolist [name=" + name + ", subject=" + subject + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getSubject() {
		return subject;
	}
	public void setSubject(List<String> subject) {
		this.subject = subject;
	}
	
	
}
