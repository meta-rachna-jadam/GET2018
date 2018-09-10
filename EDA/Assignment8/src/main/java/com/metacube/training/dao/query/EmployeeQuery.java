package com.metacube.training.dao.query;

public interface EmployeeQuery {
	
    String CREATE_EMPLOYEE = "INSERT INTO employee (first_name, middle_name, dob, gender, "
    		               + "primary_contact_no, secondary_contact_no, email_id, skype_id,"
    		               + " profile_picture, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    String UPDATE_EMPLOYEE_BY_ID = "UPDATE employee SET first_name = ?, middle_name = ?, dob = ?, gender = ?, "
    		                     + "primary_contact_no = ?, secondary_contact_no = ?, "
    		                     + "email_id = ?, skype_id = ?, profile_picture = ?, password = ?"
    		                     + "WHERE emp_code = ?";
    
    String DELETE_EMPLOYEE_BY_ID = "UPDATE employee SET enabled = ? WHERE emp_code = ?";
    
    String GET_ALL_EMPLOYEES = "SELECT emp_code, first_name, middle_name, dob, gender, primary_contact_no, "
    		                 + "secondary_contact_no, email_id, skype_id, profile_picture FROM employee "
    		                 + "WHERE enabled = true";
    
    String GET_EMPLOYEE_BY_ID = "SELECT emp_code, first_name, middle_name, dob, gender, primary_contact_no, "
                              + "secondary_contact_no, email_id, skype_id, profile_picture, enabled FROM employee "
    		                  + "WHERE emp_code = ?";
    
   String GET_EMPLOYEE_ID_BY_EMAIL_ID = "SELECT emp_code from employee WHERE email_id = ?";
}
