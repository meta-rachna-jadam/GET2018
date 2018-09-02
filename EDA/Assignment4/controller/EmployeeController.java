package com.controller;

import java.util.List;

import com.CustomException.NotValidEmployeeException;
import com.enums.Status;
import com.facade.EmployeeFacade;
import com.model.Employee;
import com.model.LoginInformation;

public class EmployeeController {

    private EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
    
    public Status createEmployee(Employee employee) {
        return employeeFacade.create(employee);
    }
    
    public LoginInformation validateLoginInformation(String emailId) {
    	return employeeFacade.validateLoginInformation(emailId);
    }
    
    public Employee getEmployeeByEmailId(String emailId) throws NotValidEmployeeException {
    	return employeeFacade.getEmployeeByEmailId(emailId);
    }
    
    public String getEmployeeCompanyNameByCompanyId(int id) {
    	return employeeFacade.getEmployeeCompanyNameByCompanyId(id);
    }
    
    public List<Integer> getFriendListOfEmployeeById(int id) {
    	return employeeFacade.getFriendListOfEmployeeById(id);
    }
    
    public Employee getEmployeeyId(int id) {
    	return employeeFacade.getEmployeeId(id);
    }
}
