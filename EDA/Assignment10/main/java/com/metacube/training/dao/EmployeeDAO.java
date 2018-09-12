package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();

	boolean deleteEmployeeById(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);
	
	Employee getEmployeeByEmailId(String emailId);
	
	Employee searchByName(String name);
}
