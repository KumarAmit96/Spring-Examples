package com.demo.springapp.springstandalone;

import java.util.List;

public class DemoStandAlone {
	
	private String name;
	private List<String> subject;
	
	@Override
	public String toString() {
		return "DemoStandAlone [name=" + name + ", subject=" + subject + "]";
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
