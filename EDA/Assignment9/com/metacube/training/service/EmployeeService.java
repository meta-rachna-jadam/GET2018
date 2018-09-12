package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeService {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();

	boolean updateEmployeeById(Employee employee);

}
