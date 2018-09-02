package com.model;

import java.util.Date;

import com.CustomException.NotValidEmployeeException;

public class Employee {

     private int id;
     private int age;
     private String firstName;
     private String lastName;
     private String emailId;
     private String password;
     private String contactNumber;
     private Date dateOfBirth;
     private int companyId;
     
     public Employee(int id,int age, String firstName, String lastName, String emailId,
 			String contactNumber, Date dateOfBirth, int companyId) throws NotValidEmployeeException {
 		
 		if (id < 0 || firstName.length() == 0 || lastName.length() == 0 || emailId.length() == 0 || contactNumber.length() == 0 || age < 18 || age > 99) {
 			
 			throw new NotValidEmployeeException("Employee", "Invalid Employee", "Employee entry is not valid");
 		}
 		this.id = id;
 		this.age = age;
 		this.firstName = firstName;
 		this.lastName = lastName;
 		this.emailId = emailId;
 		this.contactNumber = contactNumber;
 		this.dateOfBirth = dateOfBirth;
 		this.companyId = companyId;
 	}
     
	public Employee(int age, String firstName, String lastName, String emailId,
			String password, String contactNumber, Date dateOfBirth, int companyId) throws NotValidEmployeeException {
		
		if (firstName.length() == 0 || lastName.length() == 0 || emailId.length() == 0 || password.length() == 0 || 
				contactNumber.length() == 0 || age < 18 || age > 99) {
			
			throw new NotValidEmployeeException("Employee", "Invalid Employee", "Employee entry is not valid");
		}
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.contactNumber = contactNumber;
		this.dateOfBirth = dateOfBirth;
		this.companyId = companyId;
	}

	public Employee(int id, int age, String firstName, String lastName, String emailId, String password, 
			String contactNumber, Date dateOfBirth, int companyId) throws NotValidEmployeeException {
		
		if (firstName.length() == 0 || lastName.length() == 0 || emailId.length() == 0 || password.length() == 0 || 
				contactNumber.length() == 0 || age < 18 || age > 99 || id < 0) {
			
			throw new NotValidEmployeeException("Employee", "Invalid Employee", "Employee entry is not valid");
		}
		this.id = id;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.contactNumber = contactNumber;
		this.dateOfBirth = dateOfBirth;
		this.companyId = companyId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getId() {
		return id;
	}

}
