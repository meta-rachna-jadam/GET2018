package com.metacube.training.dao.query;

public interface EmployeeSkillsQuery {

    String UPDATE_EMPLOYEE_SKILLS_BY_ID = "UPDATE employeeSkills SET emp_code = :emp_code, "
    		                            + "skill_code = :skill_code WHERE emp_skill_id = :id";

    String DELETE_EMPLOYEE_SKILLS_BY_ID = "DELETE FROM employeeSkills where emp_skill_id = :id";

    String GET_ALL_SKILLS_OF_EMPLOYEE_BY_EMPLOYEE_ID = "FROM employeeSkills WHERE emp_code = :emp_code";

    String GET_EMPLOYEE_SKILLS_BY_ID = "FROM employeeSkills WHERE emp_skill_id = :id"; 
    
    String GET_ALL_SKILLS = "FROM employeeSkills";
}
