package com.metacube.training.model;

public class Address {
	
	private int id;
	private int emp_code;
	private String add_line_1;
	private String add_line_2;
	private String city;
	private String state;
	private String pincode;
	
	public int getId() {
		return id;
	}
	public int getEmp_code() {
		return emp_code;
	}
	public String getAdd_line_1() {
		return add_line_1;
	}
	public String getAdd_line_2() {
		return add_line_2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}
	public void setAdd_line_1(String add_line_1) {
		this.add_line_1 = add_line_1;
	}
	public void setAdd_line_2(String add_line_2) {
		this.add_line_2 = add_line_2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
