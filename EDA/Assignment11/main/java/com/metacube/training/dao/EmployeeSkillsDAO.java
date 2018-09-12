package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.EmployeeSkills;

public interface EmployeeSkillsDAO {
	
	EmployeeSkills getEmployeeSkillsById(int id);

	List<EmployeeSkills> getAllEmployeeSkills();

	boolean deleteEmployeeSkills(EmployeeSkills employeeSkills);

	boolean updateEmployeeSkills(EmployeeSkills employeeSkills);

	boolean createEmployeeSkills(EmployeeSkills employeeSkills);

}
