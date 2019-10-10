package com.resource.java.entity;

import org.springframework.core.io.Resource;

public class CustomResourceLoader {

	private Resource resource;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}

/*
 * public class CustomResourceLoader implements ResourceLoaderAware {
 * 
 * private ResourceLoader resourceLoader;
 * 
 * public void setResourceLoader(ResourceLoader resourceLoader) { // TODO
 * Auto-generated method stub this.resourceLoader = resourceLoader;
 * 
 * }
 * 
 * public void showResourceData() throws Exception { Resource resource =
 * resourceLoader.getResource("file:C:/Users/Ajay_triffort/Desktop/answer.txt");
 * InputStream io = resource.getInputStream(); BufferedReader br = new
 * BufferedReader(new InputStreamReader(io)); while (true) { String line =
 * br.readLine(); if (line == null) break; System.out.println(line); }
 * br.close(); }
 * 
 * }
 */