package com.metacube.training.dao.query;

public interface EmployeeQuery {
    
    String UPDATE_EMPLOYEE_BY_ID = "UPDATE Employee SET first_name = :first_name, "
    		                      + "middle_name = :middle_name, dob = :dob, "
    		                      + "gender = :gender, primary_contact_no = :primary_contact_no, "
    		                     + "secondary_contact_no = :secondary_contact_no, "
    		                     + "email_id = :email_id, skype_id = :skype_id "
    		                     + "WHERE emp_code = :id";
    
    String DELETE_EMPLOYEE_BY_ID = "UPDATE Employee SET enabled = false WHERE emp_code = :id";
    
    String GET_ALL_EMPLOYEES = "FROM Employee WHERE enabled = true";
    
    String GET_EMPLOYEE_BY_ID = "FROM Employee WHERE emp_code = :id";
    
   String GET_EMPLOYEE_ID_BY_EMAIL_ID = "from Employee WHERE email_id = :email_id";
   
   String SEARCH_EMPLOYEE_BY_NAME = "from Employee WHERE first_name = :first_name";
   
}