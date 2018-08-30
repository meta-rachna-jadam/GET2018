package com.DAO;

/**
 * This class contain all queries use in project
 * @author Rachna Jadam
 */
public class Query {
	
	public static String addEmployeeQuery = "INSERT INTO employee (firstName, lastName, emailID, age) values (?,?,?,?)";
    public static String getAllEmployeeQuery = "SELECT employeeID, firstName, lastName, emailID, age FROM employee";
    public static String searchEmployeesByNameQurey = "SELECT employeeID, firstName, lastName, emailID, age " +
                                                      "FROM employee " +
                                                      "WHERE CONCAT(firstName,' ',lastName) like CONCAT('%',?,'%') " +
                                                      "OR CONCAT(lastName,' ',firstName) like CONCAT('%',?,'%')";
    public static String getEmployeeById = "SELECT firstName, lastName, emailID, age FROM employee "+
                                           "WHERE employeeID = ?";
    public static String updateEmployeeById = "UPDATE employee SET firstName = ?, lastName = ?, emailID = ?, age = ? WHERE employeeID = ?";
}
