package com.metacube.training.model;

public class CustomException extends Exception {

    private String className;
    private String name;
    private String description;
    
	public CustomException(String className, String name, String description) {
		super();
		this.className = className;
		this.name = name;
		this.description = description;
	}
	
	public String getClassName() {
		return className;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
}
