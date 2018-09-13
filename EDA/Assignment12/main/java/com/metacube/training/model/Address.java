package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/*@OneToOne
    @JoinColumn(name="emp_code")*/
	@Column(name = "emp_code")
	private int emp_code;
	
	@Column(name = "add_line_1")
	private String add_line_1;
	
	@Column(name = "add_line_2")
	private String add_line_2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private String pincode;
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", emp_code=" + emp_code + ", add_line_1="
				+ add_line_1 + ", add_line_2=" + add_line_2 + ", city="
				+ city +", state"+ state+ ", pincode"+ pincode + "]";
	}
	
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
