package com.metacube.training.model;

public class Skills {

    private int id;
    private String name;
	public Skills(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Skills(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
    
    

}
