package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.repository.EmployeeSkillsRepository;

/**
 * class provide services related to employee skills
 * @author Rachna Jadam
 *
 */

@Service
public class EmployeeSkillsServiceImpementation implements EmployeeSkillsService {

	@Autowired
	private EmployeeSkillsRepository<EmployeeSkills> employeeSkillsRepository;
	
	/**
	 * To get employee skills by id
	 */
	@Override
	public EmployeeSkills getEmployeeSkillsById(int id) {
		return employeeSkillsRepository.findOne(id);
	}

	/**
	 * To get employee skills list
	 */
	@Override
	public List<EmployeeSkills> getAllEmployeeSkills() {
		return employeeSkillsRepository.findAll();
	}

	/**
	 * To delete employee skills by id
	 */
	@Override
	public boolean deleteEmployeeSkills(int id) {
		employeeSkillsRepository.delete(id);
		return true;
	}

	/**
	 * To update employee skills
	 */
	@Override
	public boolean updateEmployeeSkills(EmployeeSkills employeeSkills) {
		employeeSkillsRepository.saveAndFlush(employeeSkills);
		return true;
	}

	/**
	 * To create employee skills entry in database
	 */
	@Override
	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		employeeSkillsRepository.save(employeeSkills);
		return true;
	}
}
