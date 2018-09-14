package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

/**
 * class provide services related to employee
 * @author Rachna Jadam
 *
 */

@Service
public class EmployeeServiceImpementation implements EmployeeService {

	@Autowired
    private EmployeeRepository<Employee> employeeRepository;

	/**
	 * To get employee by id
	 */
	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findOne(id);
	}

	/**
	 * To get employee list 
	 */
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	/**
	 * To delete employee by id
	 */
	@Override
	public boolean deleteEmployee(int id) {
		employeeRepository.delete(id);
		return true;
	}

	/**
	 * To update employee by id
	 */
	@Override
	public boolean updateEmployee(Employee employee) {
		employee.setProfilePhotoUrl("D:\\HTML Pages\\Capture.PNG");
		employeeRepository.saveAndFlush(employee);
		return true;
	}

	/**
	 * To create employee entry in database
	 */
	@Override
	public boolean createEmployee(Employee employee) {
		employee.setProfilePhotoUrl("D:\\HTML Pages\\Capture.PNG");
		employeeRepository.save(employee);
		return true;
	}
	
	/**
	 * To get employee by email id
	 */
	@Override
	public Employee getEmployeeByEmailId(String emailId) {
		return employeeRepository.findByEmailId(emailId);
	}

	/**
	 * To get employee list by firstName
	 */
	@Override
	public List<Employee> searchByName(String name) {
		return employeeRepository.findByFirstName(name);
	}
}