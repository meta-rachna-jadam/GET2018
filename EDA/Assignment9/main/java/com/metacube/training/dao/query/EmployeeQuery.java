package com.metacube.training.dao.query;

public interface EmployeeQuery {
	
    String CREATE_EMPLOYEE = "INSERT INTO employee (first_name, middle_name, dob, gender, "
    		               + "primary_contact_no, secondary_contact_no, email_id, skype_id,"
    		               + " password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    String UPDATE_EMPLOYEE_BY_ID = "UPDATE employee SET first_name = ?, middle_name = ?, dob = ?, gender = ?, "
    		                     + "primary_contact_no = ?, secondary_contact_no = ?, "
    		                     + "email_id = ?, skype_id = ? "
    		                     + "WHERE emp_code = ?";
    
    String DELETE_EMPLOYEE_BY_ID = "UPDATE employee SET enabled = ? WHERE emp_code = ?";
    
    String GET_ALL_EMPLOYEES = "SELECT emp_code, first_name, middle_name, dob, gender, primary_contact_no, "
    		                 + "secondary_contact_no, email_id, skype_id, password, enabled FROM employee "
    		                 + "WHERE enabled = true";
    
    String GET_EMPLOYEE_BY_ID = "SELECT emp_code, first_name, middle_name, dob, gender, primary_contact_no, "
                              + "secondary_contact_no, email_id, skype_id, password, enabled FROM employee "
    		                  + "WHERE emp_code = ?";
    
   String GET_EMPLOYEE_ID_BY_EMAIL_ID = "SELECT emp_code, first_name, middle_name, dob, gender, primary_contact_no, "
                              + "secondary_contact_no, email_id, skype_id, password, enabled from employee WHERE email_id = ?";
   
   String SEARCH_EMPLOYEE_BY_NAME = "SELECT emp_code, first_name, middle_name, primary_contact_no, email_id from employee WHERE first_name = ?";
   
   String SEARCH_EMPLOYEE_BY_SKILL = "SELECT e.emp_code, e.first_name, e.middle_name, e.primary_contact_no, e.email_id from "
   		+ "employee e RIGHT JOIN employeeSkills es RIGHT JOIN skills s WHERE s.skill_name = ?";
   
   String SEARCH_EMPLOYEE_BY_PROJECT = "SELECT e.emp_code, e.first_name, e.middle_name, e.primary_contact_no, e.email_id from employee e "
   		+ "RIGHT JOIN jobDetails j RIGHT JOIN project p WHERE p.description = ?";
   
   String SEARCH_EMPLOYEE_BY_TOTAL_EXP = "SELECT e.emp_code, e.first_name, e.middle_name, e.primary_contact_no, e.email_id "
   		+ " from employee e RIGHT JOIN jobDetails j WHERE j.total_exp = ?";
   
}
