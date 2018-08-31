package com.dao;

public class EmployeeQuery {

	public static String addEmployeeQuery = "INSERT INTO employee (firstName, lastName, dateOfBirth, emailID, age, "
			+ "contactNumber, password, companyId) values (?, ?, ?, ?, ?, ?, ?, ?)";
}
