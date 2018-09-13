package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userRoles")
public class UserRole {

	@Id
	@Column(name = "user_role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "username")
    private String username;
	
	@Column(name = "role")
    private String role;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", role=" + role + "]";
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
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
    
}
