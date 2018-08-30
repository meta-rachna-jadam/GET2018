package com.model;
/**
 * Class to maintain employee model
 * @author Rachna Jadam
 */
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	private int age;
	
	public Employee(String firstName, String lastName, String emailId, int age) 
	        throws NullPointerException {
		if (firstName.length() == 0 || lastName.length() == 0 || emailId.length() == 0 || age < 0 || age > 150) {
			throw new NullPointerException();
		} else {
			this.age = age;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailId = emailId;
		}
	}
	
	public Employee(int id, String firstName, String lastName, String emailId, int age) 
	        throws NullPointerException {
		
		if (id < 0 || firstName == null || lastName == null || emailId == null || age < 0) {
			throw new NullPointerException();
		}else {
			this.id = id;
			this.age = age;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailId = emailId;
		}
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
}
