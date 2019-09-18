package com.demo.springapp.springcollection.set;

import java.util.Set;

public class DemoSet {
	
	private String name;
	private Set<String> subject;
	
	public Set<String> getSubject() {
		return subject;
	}
	public void setSubject(Set<String> subject) {
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "DemoSet [name=" + name + ", subject=" + subject + "]";
	}
	
	
}
