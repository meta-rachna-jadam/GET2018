package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.metacube.training.constants.DatabaseConstant;
import com.metacube.training.dao.query.EmployeeQuery;
import com.metacube.training.model.Employee;

public class EmployeeDao implements AdminDao<Employee> {

	@Override
	public Employee getFieldById(int id) {
		try(
		    Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
	            DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
			PreparedStatement preparedStatementToGetEmployee = 
			    connection.prepareStatement(EmployeeQuery.GET_EMPLOYEE_BY_ID);){
			
			ResultSet employeeResultSet = preparedStatementToGetEmployee.executeQuery();
			if (employeeResultSet.next()) {
				return new Employee(employeeResultSet.getString(""), employeeResultSet.getString(""), employeeResultSet.getString(""), gender, primaryContactNumber, secondaryContactNumber, emailId, skypeId, profilePhotoUrl, password, enabled)
			}
			
		} catch (SQLException sqlException) {
		}
	}

	@Override
	public List<Employee> getListOfField() {
		return null;
	}

	@Override
	public boolean deleteFieldById(int id) {
		return false;
	}

	@Override
	public boolean updateFieldById(Employee employee) {
		return false;
	}

	@Override
	public boolean createField(Employee employee) {
        try (
            Connection connectionInstance = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
        	PreparedStatement preparedStatementToAddEmployee = 
        	    connectionInstance.prepareStatement(EmployeeQuery.CREATE_EMPLOYEE);) {
        	
        	preparedStatementToAddEmployee.setString(1, employee.getFirstName());
        	preparedStatementToAddEmployee.setString(2, employee.getMiddelName());
        	Date utilDateOfBirth = employee.getDob();
            java.sql.Date sqlDateOfBirth = new java.sql.Date(utilDateOfBirth.getTime());
        	preparedStatementToAddEmployee.setDate(3, sqlDateOfBirth);
        	preparedStatementToAddEmployee.setString(4, employee.getGender());
        	preparedStatementToAddEmployee.setString(5, employee.getPrimaryContactNumber());
        	preparedStatementToAddEmployee.setString(6, employee.getSecondaryContactNumber());
        	preparedStatementToAddEmployee.setString(7, employee.getEmailId());
        	preparedStatementToAddEmployee.setString(8, employee.getSkypeId());
        	preparedStatementToAddEmployee.setString(9, employee.getProfilePhotoUrl());
        	preparedStatementToAddEmployee.setString(10, employee.getPassword());
        	
        	if (preparedStatementToAddEmployee.executeUpdate() > 0) {
        		return true;
        	}
        	return false;
        }catch (SQLException sqlException) {
		    return false;
		}
	}
}
		        
