package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.EmployeeDao;
import com.metacube.training.dao.EmployeeSkillsDao;
import com.metacube.training.dao.JobDetailDao;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;

public class EmployeeService implements AdminService<Employee>{

	@Override
	public Employee getFieldById(int id) {
		return new EmployeeDao().getFieldById(id);
	}

	@Override
	public List<Employee> getListOfField() {
		return new EmployeeDao().getListOfField();
	}

	@Override
	public boolean updateFieldById(Employee employee) {
		return new EmployeeDao().updateFieldById(employee);
	}

	@Override
	public boolean deleteFieldById(int id) {
		return new EmployeeDao().deleteFieldById(id);
	}

	@Override
	public boolean createField(Employee employee) {
		EmployeeDao employeeDao = new EmployeeDao();
		EmployeeSkillsDao employeeSkillsDao = new EmployeeSkillsDao();
		boolean employeeResult = employeeDao.createField(employee);
		int employeeId = employeeDao.getEmployeeIdByEmailId(employee.getEmailId());
		boolean jobDetailResult = new JobDetailDao().createField(new JobDetails(employeeId, employee.getDateOfJoining(),
				employee.getTotalExperience(), employee.getJobCode(), employee.getReportingManagerId() ,
				employee.getTeamLeaderId(), employee.getCurrentProjectId()));
		int[] employeeSkills =  employee.getSkills();
		for (int index = 0; index < employeeSkills.length; index++) {
		    employeeSkillsDao.createField(new EmployeeSkills(employeeId, employeeSkills[index]));
		}
		
		return (employeeResult && jobDetailResult);
	}

}
