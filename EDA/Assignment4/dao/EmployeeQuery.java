package com.dao;

public class EmployeeQuery {

	public static String addEmployeeQuery = "INSERT INTO employee (firstName, lastName, dateOfBirth, emailID, age, "
			+ "contactNumber, password, companyId) values (?, ?, ?, ?, ?, ?, ?, ?)";
	public static String getPasswordByEmailId = "SELECT password FROM employee WHERE emailID = ?";
	
	public static String getEmployeeDetailByEmailId = "SELECT employeeId, age, firstName, lastName, dateOfBirth, emailID, contactNumber, companyId "
			                                        + " FROM employee WHERE emailID = ?";
	public static String getCompanyNameByComanyId = "SELECT companyName FROM company WHERE companyId = ?";
	
	public static String getFriendListOfEmployeeId = "SELECT employeeFriendId FROM friends WHERE employeeId = ?";
	
	public static String getEmployeeById = "SELECT employeeId, age, firstName, lastName, dateOfBirth, emailID, contactNumber, companyId "
                                         + " FROM employee WHERE employeeId = ?";
	
}
