package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImpementation implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee employee = employeeDAO.getEmployeeById(id);
		return employeeDAO.deleteEmployeeById(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public boolean createEmployee(Employee employee) {
		employee.setProfilePhotoUrl("D:\\HTML Pages\\Capture.PNG");
		return employeeDAO.createEmployee(employee);
	}
	
	@Override
	public Employee getEmployeeByEmailId(String emailId) {
		return employeeDAO.getEmployeeByEmailId(emailId);
	}

	@Override
	public Employee searchByName(String name) {
		return employeeDAO.searchByName(name);
	}
}