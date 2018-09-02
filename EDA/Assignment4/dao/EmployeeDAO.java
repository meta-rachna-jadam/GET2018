package com.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.CustomException.NotValidEmployeeException;
import com.CustomException.SQLDatabaseException;
import com.constants.DBConstants;
import com.constants.EmployeeConstants;
import com.model.Employee;
import com.model.LoginInformation;

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
        	Date utilDateOfBirth = employee.getDateOfBirth();
            java.sql.Date sqlDateOfBirth = new java.sql.Date(utilDateOfBirth.getTime());
        	preparedStatementToAddEmployee.setDate(3, sqlDateOfBirth);
        	preparedStatementToAddEmployee.setString(4, employee.getEmailId());
        	preparedStatementToAddEmployee.setInt(5, employee.getAge());
        	preparedStatementToAddEmployee.setString(6, employee.getContactNumber());
        	preparedStatementToAddEmployee.setString(7, employee.getPassword());
        	preparedStatementToAddEmployee.setInt(8, employee.getCompanyId());
    	    return preparedStatementToAddEmployee.executeUpdate();
        } catch (SQLException sqlException) {
        	new SQLDatabaseException("EmployeeDAO", sqlException.toString(), sqlException.getMessage());
    		return -1;
	    }
    }
    
    public LoginInformation getPasswordByEmailId(String emailId) {
    	try (
    	    Connection connectionInstance = JDBCConnection.getConnection(EmployeeConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementTogetPasswordByEmailId = connectionInstance.prepareStatement(EmployeeQuery.getPasswordByEmailId)) {
        	System.out.println(EmployeeQuery.getPasswordByEmailId);
    		LoginInformation loginInformation = null;
            preparedStatementTogetPasswordByEmailId.setString(1, emailId);
            ResultSet loginInfoResultSet = preparedStatementTogetPasswordByEmailId.executeQuery();
            if (loginInfoResultSet.next()) {
            	System.out.println("From if "+emailId+", "+loginInfoResultSet.getString("password"));
                loginInformation = new LoginInformation(emailId, loginInfoResultSet.getString("password"));
            } else {
            	System.out.println("From else "+emailId);
            	return null;
            }
            System.out.println("From outside "+emailId);
            return loginInformation;
        } catch (SQLException sqlException) {
        	System.out.println("From catch "+emailId);
         	new SQLDatabaseException("EmployeeDAO", sqlException.toString(), sqlException.getMessage());
        	return null;
    	}
    }
    
    public Employee getEmployeeDetailByEmailId(String emailId) throws NotValidEmployeeException {
    	Employee empoyee = null;
    	try (
        	Connection connectionInstance = JDBCConnection.getConnection(EmployeeConstants.databaseName, 
               DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementTogetDetailByEmailId = connectionInstance.prepareStatement(EmployeeQuery.getEmployeeDetailByEmailId)) {
            	
        	preparedStatementTogetDetailByEmailId.setString(1, emailId);
            ResultSet employeeResultSet = preparedStatementTogetDetailByEmailId.executeQuery();
            if (employeeResultSet.next()) {
            	System.out.println("employee if ");
                empoyee = new Employee(employeeResultSet.getInt("employeeId"), employeeResultSet.getInt("age"), employeeResultSet.getString("firstName"), employeeResultSet.getString("lastName"),
                    employeeResultSet.getString("emailId"), employeeResultSet.getString("contactNumber"), employeeResultSet.getDate("dateOfBirth"), 
                    employeeResultSet.getInt("companyId"));
            } else {
            	System.out.println("employee else");
                return null;
            }
            return empoyee;
        } catch (SQLException sqlException) {
        	
            System.out.println("employee catch "+sqlException.toString());
            new SQLDatabaseException("EmployeeDAO", sqlException.toString(), sqlException.getMessage());
            return null;
        }
    }
    
    public String getCompanyNameByComapnyId(int id) {
    	String companyName = null;
    	try(
    		Connection connectionInstance = JDBCConnection.getConnection(EmployeeConstants.databaseName, 
    		    DBConstants.userName, DBConstants.password);
    		PreparedStatement preparedStatementToComapnyName = connectionInstance.prepareStatement(EmployeeQuery.getCompanyNameByComanyId)) {
    		
    		preparedStatementToComapnyName.setInt(1, id);
    		ResultSet companyResultSet = preparedStatementToComapnyName.executeQuery();
    		if (companyResultSet.next()) {
    			companyName = companyResultSet.getString("companyName");
    		} else {
    			return null;
    		}
    		return companyName;
    	} catch (SQLException sqlException) {
			// TODO Auto-generated catch block
    		sqlException.printStackTrace();
			return null;
		}
    }
    
    public List<Integer> getFriendListOfEmployeeById(int id) {
    	List<Integer> friendListId = new ArrayList<Integer>();
    	try(
    		Connection connectionInstance = JDBCConnection.getConnection(EmployeeConstants.databaseName, 
      		    DBConstants.userName, DBConstants.password);
    		PreparedStatement preparedStatementForFriendList= connectionInstance.prepareStatement(EmployeeQuery.getFriendListOfEmployeeId)) {
    		
    		preparedStatementForFriendList.setInt(1, id);
    		ResultSet friendListResultSet = preparedStatementForFriendList.executeQuery();
    		while (friendListResultSet.next()) {
    			System.out.println("friend");
    			System.out.println("friend id "+friendListResultSet.getInt("employeeFriendId"));
    			friendListId.add(friendListResultSet.getInt("employeeFriendId"));
    		}
    		return friendListId;
    	} catch (SQLException sqlException) {
    		System.out.println("friend ex "+sqlException.toString());
    		sqlException.printStackTrace();
    		return null;
		}
    }
    
    public Employee getEmployeeById(int id) {
    	Employee employee = null;
    	try(
        	Connection connectionInstance = JDBCConnection.getConnection(EmployeeConstants.databaseName, 
         	    DBConstants.userName, DBConstants.password);
        	PreparedStatement preparedStatementForEmployee= connectionInstance.prepareStatement(EmployeeQuery.getEmployeeById)) {
        		
    		preparedStatementForEmployee.setInt(1, id);
        	ResultSet employeeResultSet = preparedStatementForEmployee.executeQuery();
        	if (employeeResultSet.next()) {
        		employee = new Employee(employeeResultSet.getInt("employeeId"), employeeResultSet.getInt("age"), employeeResultSet.getString("firstName"), employeeResultSet.getString("lastName"),
                        employeeResultSet.getString("emailId"), employeeResultSet.getString("contactNumber"), employeeResultSet.getDate("dateOfBirth"), 
                        employeeResultSet.getInt("companyId"));
        	}
       	} catch (SQLException sqlException) {
       		sqlException.printStackTrace();
       	} catch (NotValidEmployeeException invalidEmployee) {
			// TODO Auto-generated catch block
			invalidEmployee.printStackTrace();
		}
    	return employee;
    }
}
