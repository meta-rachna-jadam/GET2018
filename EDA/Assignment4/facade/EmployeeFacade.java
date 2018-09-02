package com.facade;

import java.util.List;

import com.enums.Status;
import com.CustomException.NotValidEmployeeException;
import com.dao.EmployeeDAO;
import com.model.Employee;
import com.model.LoginInformation;

public class EmployeeFacade {

	private static EmployeeFacade employeeFacade = new EmployeeFacade();
	EmployeeDAO employeeDAO = new EmployeeDAO();

    public static EmployeeFacade getInstance() {
        return employeeFacade;
    }
    public Status create(Employee employee) {
    	int state = employeeDAO.addEmployee(employee);
        if (state > 0) {
        	return Status.CREATED;
        } else if (state < 0) {
        	return Status.ERROR;
        } else {
        	return Status.NOT_CREATED;
        }
    }
    
    public LoginInformation validateLoginInformation(String emailId){
    	return employeeDAO.getPasswordByEmailId(emailId);
    }
    
    public Employee getEmployeeByEmailId(String emailId) throws NotValidEmployeeException {
    	return employeeDAO.getEmployeeDetailByEmailId(emailId);
    }
    
    public String getEmployeeCompanyNameByCompanyId(int id) {
    	return employeeDAO.getCompanyNameByComapnyId(id);
    }
    
    public List<Integer> getFriendListOfEmployeeById(int id) {
    	return employeeDAO.getFriendListOfEmployeeById(id);
    }
    
    public Employee getEmployeeId(int id) {
    	return employeeDAO.getEmployeeById(id);
    }
    public Status update(Employee Employee) {
    	return Status.UPDATED;
    }

    public Status delete(Employee Employee) {
    	return Status.DELETED;
    }

}
