package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.constants.DBConstants;
import com.constants.EmployeeConstants;
import com.model.Employee;

public class EmployeeDAO {

	/**
     * To add employee in database
     * @param employee that you want to insert in DB
     * @return
     */
    public int addEmployee(Employee employee) {
    	
        try (
	        Connection connectionInstance = JDBCConnection.getConnection(EmployeeConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToAddEmployee = connectionInstance.prepareStatement(EmployeeQuery.addEmployeeQuery);) {
    		
        	preparedStatementToAddEmployee.setString(1, employee.getFirstName());
        	preparedStatementToAddEmployee.setString(2, employee.getLastName());
        	preparedStatementToAddEmployee.setDate(3, (Date) employee.getDateOfBirth());
        	preparedStatementToAddEmployee.setString(4, employee.getEmailId());
        	preparedStatementToAddEmployee.setInt(5, employee.getAge());
        	preparedStatementToAddEmployee.setString(6, employee.getContactNumber());
        	preparedStatementToAddEmployee.setString(7, employee.getPassword());
        	preparedStatementToAddEmployee.setInt(8, employee.getCompanyId());
    	    return preparedStatementToAddEmployee.executeUpdate();
        } catch (SQLException sqlException) {
    		return -1;
			//sqlException.printStackTrace();
	    }
    }
}
