package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
                EmployeeConstants.userName, EmployeeConstants.password);
            PreparedStatement preparedStatementToAddEmployee = connectionInstance.prepareStatement(Query.addEmployeeQuery);) {
    		
        	preparedStatementToAddEmployee.setString(1, employee.getFirstName());
        	preparedStatementToAddEmployee.setString(2, employee.getLastName());
        	preparedStatementToAddEmployee.setString(3, employee.getEmailId());
        	preparedStatementToAddEmployee.setInt(4, employee.getAge());
    	    return preparedStatementToAddEmployee.executeUpdate();
        } catch (SQLException sqlException) {
    		return -1;
			//sqlException.printStackTrace();
	    }
    }
    
    /**
     * To get employee list form DB
     * @return employee list
     */
    public List<Employee> getAllEmployee(){
        List<Employee> employeeList = new ArrayList<Employee>();
        try (
			Connection connectionInstance = JDBCConnection.getConnection(EmployeeConstants.databaseName, 
                EmployeeConstants.userName, EmployeeConstants.password);
            PreparedStatement preparedStatementToGetAllEmployee = connectionInstance.prepareStatement(Query.getAllEmployeeQuery);) {
            ResultSet employeeResultSet = preparedStatementToGetAllEmployee.executeQuery();
    		while (employeeResultSet.next()) {
    			employeeList.add(
    				new Employee(employeeResultSet.getInt("employeeID"), employeeResultSet.getString("firstName"),
    					employeeResultSet.getString("lastName"), employeeResultSet.getString("emailID"), employeeResultSet.getInt("age")));
    		}
    		return employeeList;
    	} catch (SQLException sqlException) {
    		sqlException.printStackTrace();
			return null;
		}
    }
    
    /**
     * To get employee by their last or first name
     * @param name search name
     * @return list of employee match with given name
     */
    public List<Employee> getEmployeesByName(String name){
    	List<Employee> employeeList = new ArrayList<Employee>();
    	try(
    		Connection connectionInstance = JDBCConnection.getConnection(EmployeeConstants.databaseName, 
    			EmployeeConstants.userName, EmployeeConstants.password);
			PreparedStatement preparedStatementToGetEmployeeByName = connectionInstance.prepareStatement(Query.searchEmployeesByNameQurey);){
    		
    		preparedStatementToGetEmployeeByName.setString(1, name);
    		preparedStatementToGetEmployeeByName.setString(2, name);
    		ResultSet employeeResultSet = preparedStatementToGetEmployeeByName.executeQuery();
    		while (employeeResultSet.next()) {
    			employeeList.add(
    				new Employee(employeeResultSet.getInt("employeeID"), employeeResultSet.getString("firstName"), 
    						employeeResultSet.getString("lastName"), employeeResultSet.getString("emailID"), employeeResultSet.getInt("age")));
    		}
    		return employeeList;
    	} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
    }
    
    /**
     * To get employee by it's id
     * @param id search id
     * @return employee match with given id
     */
    
    public Employee getEmployeeById(int id){
    	Employee employee = null;
    	try(Connection connectionInstance = JDBCConnection.getConnection(EmployeeConstants.databaseName, 
    			EmployeeConstants.userName, EmployeeConstants.password);
				PreparedStatement preparedStatementToGetEmployeeById = connectionInstance.prepareStatement(Query.getEmployeeById);){
    		preparedStatementToGetEmployeeById.setInt(1, id);
    		ResultSet employeeResultSet = preparedStatementToGetEmployeeById.executeQuery();
    		while (employeeResultSet.next()) {
    			employee = new Employee(employeeResultSet.getString("firstName"), employeeResultSet.getString("lastName"),
    				employeeResultSet.getString("emailID"), employeeResultSet.getInt("age"));
    		}
    	} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
    	return employee;
    }
    
    /**
     * Update employee by it's id
     * @param id
     * @return 0 when update operation not performed, -1 when error comes, else other
     */
    
    public int updateEmployeeById(int id, Employee employee) {
    	try(
    		Connection connectionInstance = JDBCConnection.getConnection(EmployeeConstants.databaseName, 
    			EmployeeConstants.userName, EmployeeConstants.password);
		    PreparedStatement statement = connectionInstance.prepareStatement(Query.updateEmployeeById);){
	    		statement.setString(1, employee.getFirstName());
				statement.setString(2, employee.getLastName());
				statement.setString(3, employee.getEmailId());
				statement.setInt(4, employee.getAge());
				statement.setInt(5, id);
				return statement.executeUpdate();
    	} catch (SQLException e) {
    		return -1;
			//e.printStackTrace();
		}
    }
}
