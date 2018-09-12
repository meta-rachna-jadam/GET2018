package com.metacube.training.dao.query;

public interface EmployeeQuery {
    
    String UPDATE_EMPLOYEE_BY_ID = "UPDATE employee SET first_name = :first_name, "
    		                      + "middle_name = :middle_name, dob = :dob, "
    		                      + "gender = :gender, primary_contact_no = :primary_contact_no, "
    		                     + "secondary_contact_no = :secondary_contact_no, "
    		                     + "email_id = :email_id, skype_id = :skype_id "
    		                     + "WHERE emp_code = :id";
    
    String DELETE_EMPLOYEE_BY_ID = "UPDATE employee SET enabled = false WHERE emp_code = :id";
    
    String GET_ALL_EMPLOYEES = "FROM employee WHERE enabled = true";
    
    String GET_EMPLOYEE_BY_ID = "FROM employee WHERE emp_code = :id";
    
   String GET_EMPLOYEE_ID_BY_EMAIL_ID = "from employee WHERE email_id = :email_id";
   
   String SEARCH_EMPLOYEE_BY_NAME = "from employee WHERE first_name = :first_name";
   
   String SEARCH_EMPLOYEE_BY_SKILL = "SELECT e.emp_code, e.first_name, e.middle_name, "
   		                           + "e.primary_contact_no, e.email_id from "
   		                           + "employee e RIGHT JOIN employeeSkills es RIGHT "
   		                           + "JOIN skills s WHERE s.skill_name = :skill_name";
   
   String SEARCH_EMPLOYEE_BY_PROJECT = "SELECT e.emp_code, e.first_name, e.middle_name, "
   		                             + "e.primary_contact_no, e.email_id from employee e "
   		                             + "RIGHT JOIN jobDetails j RIGHT JOIN project p WHERE "
   		                             + "p.description = :description";
   
   String SEARCH_EMPLOYEE_BY_TOTAL_EXP = "SELECT e.emp_code, e.first_name, e.middle_name, "
   		                               + "e.primary_contact_no, e.email_id from employee "
   		                               + "e RIGHT JOIN jobDetails j WHERE j.total_exp = :total_exp";
   
}