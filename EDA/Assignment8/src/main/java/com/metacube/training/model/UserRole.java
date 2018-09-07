package com.metacube.training.model;

public class UserRole {

    private int id;
    private String username;
    private String role;
	public UserRole(int id, String username, String role) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
	}
	public UserRole(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getRole() {
		return role;
	}
    
    

}
