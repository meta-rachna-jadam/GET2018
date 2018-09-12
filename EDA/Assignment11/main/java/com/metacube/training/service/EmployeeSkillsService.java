package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.EmployeeSkills;

public interface EmployeeSkillsService {

	EmployeeSkills getEmployeeSkillsById(int id);

	List<EmployeeSkills> getAllEmployeeSkills();

	boolean deleteEmployeeSkills(int id);

	boolean updateEmployeeSkills(EmployeeSkills employeeSkills);

	boolean createEmployeeSkills(EmployeeSkills employeeSkills);
}
