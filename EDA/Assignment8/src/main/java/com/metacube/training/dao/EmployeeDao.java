package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metacube.training.constants.DatabaseConstant;
import com.metacube.training.dao.query.EmployeeQuery;
import com.metacube.training.model.CustomException;
import com.metacube.training.model.Employee;

public class EmployeeDao implements AdminDao<Employee> {

    @Override
    public Employee getFieldById(int id) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetEmployee = 
                connection.prepareStatement(EmployeeQuery.GET_EMPLOYEE_BY_ID);){
			
        	preparedStatementToGetEmployee.setInt(1, id);
            ResultSet employeeResultSet = preparedStatementToGetEmployee.executeQuery();
            if (employeeResultSet.next()) {
                return new Employee(employeeResultSet.getInt("emp_code"),employeeResultSet.getString("first_name"),
                        employeeResultSet.getString("middle_name"), employeeResultSet.getDate("dob"), 
                        employeeResultSet.getString("gender"),employeeResultSet.getString("primary_contact_no"), 
                        employeeResultSet.getString("secondary_contact_no"), employeeResultSet.getString("email_id"),
                        employeeResultSet.getString("skype_id"), employeeResultSet.getString("profile_picture"));
            }
            return null;
        } catch (SQLException sqlException) {
        	new CustomException("EmployeeDao", sqlException.toString(), sqlException.getMessage());
        	return null;
        }
    }

    @Override
    public List<Employee> getListOfField() {
    	
    	List<Employee> employeeList = new ArrayList<Employee>();
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetEmployees = 
                connection.prepareStatement(EmployeeQuery.GET_ALL_EMPLOYEES);){
			
        	ResultSet employeeResultSet = preparedStatementToGetEmployees.executeQuery();
            if (employeeResultSet.next()) {
                employeeList.add(new Employee(employeeResultSet.getInt("emp_code"),employeeResultSet.getString("first_name"),
                    employeeResultSet.getString("middle_name"), employeeResultSet.getDate("dob"), employeeResultSet.getString("gender"), 
                    employeeResultSet.getString("primary_contact_no"), employeeResultSet.getString("secondary_contact_no"), employeeResultSet.getString("email_id"),
                    employeeResultSet.getString("skype_id"), employeeResultSet.getString("profile_picture")));
            }
			return employeeList;
        } catch (SQLException sqlException) {
        	new CustomException("EmployeeDao", sqlException.toString(), sqlException.getMessage());
        	return null;
        }
        
     }


    @Override
    public boolean deleteFieldById(int id) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToDeleteEmployee = 
                connection.prepareStatement(EmployeeQuery.DELETE_EMPLOYEE_BY_ID);){
        	
            preparedStatementToDeleteEmployee.setBoolean(1, false);
            preparedStatementToDeleteEmployee.setInt(2, id);
			
            return (preparedStatementToDeleteEmployee.executeUpdate() > 0);
			
        } catch (SQLException sqlException) {
        	new CustomException("EmployeeDao", sqlException.toString(), sqlException.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateFieldById(Employee employee) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToUpdateEmployee = 
                connection.prepareStatement(EmployeeQuery.UPDATE_EMPLOYEE_BY_ID);){
			
        	preparedStatementToUpdateEmployee.setString(1, employee.getFirstName());
        	preparedStatementToUpdateEmployee.setString(2, employee.getMiddelName());
        	Date utilDateOfBirth = employee.getDob();
            java.sql.Date sqlDateOfBirth = new java.sql.Date(utilDateOfBirth.getTime());
        	preparedStatementToUpdateEmployee.setDate(3, sqlDateOfBirth);
        	preparedStatementToUpdateEmployee.setString(4, employee.getGender());
        	preparedStatementToUpdateEmployee.setString(5, employee.getPrimaryContactNumber());
        	preparedStatementToUpdateEmployee.setString(6, employee.getSecondaryContactNumber());
        	preparedStatementToUpdateEmployee.setString(7, employee.getEmailId());
        	preparedStatementToUpdateEmployee.setString(8, employee.getSkypeId());
        	preparedStatementToUpdateEmployee.setString(9, employee.getProfilePhotoUrl());
        	preparedStatementToUpdateEmployee.setString(10, employee.getPassword());
        	preparedStatementToUpdateEmployee.setInt(11, employee.getId());
        	
            return (preparedStatementToUpdateEmployee.executeUpdate() > 0);
			
        } catch (SQLException sqlException) {
        	new CustomException("EmployeeDao", sqlException.toString(), sqlException.getMessage());
            return false;
        }
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
        	
        	return (preparedStatementToAddEmployee.executeUpdate() > 0);
        }catch (SQLException sqlException) {
        	new CustomException("EmployeeDao", sqlException.toString(), sqlException.getMessage());
		    return false;
		}
	}
    
    public int getEmployeeIdByEmailId(String emailId) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetEmployeeId = 
                connection.prepareStatement(EmployeeQuery.GET_EMPLOYEE_ID_BY_EMAIL_ID);){
			
        	preparedStatementToGetEmployeeId.setString(1, emailId);
            ResultSet employeeResultSet = preparedStatementToGetEmployeeId.executeQuery();
            if (employeeResultSet.next()) {
                return employeeResultSet.getInt("emp_code");
            }
            return 0;
        } catch (SQLException sqlException) {
        	new CustomException("EmployeeDao", sqlException.toString(), sqlException.getMessage());
        	return 0;
        }
    }
}
		        
