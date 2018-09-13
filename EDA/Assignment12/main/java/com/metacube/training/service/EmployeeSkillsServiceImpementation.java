package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeSkillsDAO;
import com.metacube.training.model.EmployeeSkills;

@Service
public class EmployeeSkillsServiceImpementation implements EmployeeSkillsService {

	@Autowired
	private EmployeeSkillsDAO employeeSkillsDAO;
	
	@Override
	public EmployeeSkills getEmployeeSkillsById(int id) {
		return employeeSkillsDAO.getEmployeeSkillsById(id);
	}

	@Override
	public List<EmployeeSkills> getAllEmployeeSkills() {
		return employeeSkillsDAO.getAllEmployeeSkills();
	}

	@Override
	public boolean deleteEmployeeSkills(int id) {
		EmployeeSkills employeeSkills = employeeSkillsDAO.getEmployeeSkillsById(id);
		return employeeSkillsDAO.deleteEmployeeSkills(employeeSkills);
	}

	@Override
	public boolean updateEmployeeSkills(EmployeeSkills employeeSkills) {
		return employeeSkillsDAO.updateEmployeeSkills(employeeSkills);
	}

	@Override
	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		return employeeSkillsDAO.createEmployeeSkills(employeeSkills);
	}

}
