package com.metacube.training.dao.query;

public interface EmployeeSkillsQuery {

	String CREATE_EMPLOYEE_SKILLS = "INSERT INTO employeeSkills (emp_code, skill_code) VALUES (?, ?)";

    String UPDATE_EMPLOYEE_SKILLS_BY_ID = "UPDATE employeeSkills SET emp_code = ?, skill_code = ? WHERE emp_skill_id = ?";

    //String DELETE_EMPLOYEE_SKILLS_BY_ID = "UPDATE employeeSkills SET enabled = ? WHERE emp_skill_id = ?";

    String GET_ALL_SKILLS_OF_EMPLOYEE_BY_EMPLOYEE_ID = "SELECT emp_skill_id, emp_code, skill_code FROM employeeSkills "
    		                                          + "WHERE emp_code = ?";

    String GET_EMPLOYEE_SKILLS_BY_ID = "SELECT emp_skill_id, emp_code, skill_code FROM employeeSkills "
    		                         + "WHERE emp_skill_id = ?"; 
    
    String GET_ALL_SKILLS_PRESENT_IN_ORGANIZATION = "SELECT DISTINCT skill_code FROM employeeSkills";
    
    String GET_ALL_SKILLS = "SELECT emp_skill_id, emp_code, skill_code FROM employeeSkills";
}
