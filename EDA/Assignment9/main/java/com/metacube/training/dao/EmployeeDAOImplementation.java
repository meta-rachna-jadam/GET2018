package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.query.EmployeeQuery;
import com.metacube.training.dao.query.ProjectQuery;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.mappers.SearchMapper;
import com.metacube.training.model.Employee;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	@Autowired
	public EmployeeDAOImplementation(DataSource dataSource) {
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public Employee getEmployeeById(int id) {
		return jdbcTemplate.queryForObject(EmployeeQuery.GET_EMPLOYEE_BY_ID, new Object[] { id }, 
			    new EmployeeMapper());
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(EmployeeQuery.GET_ALL_EMPLOYEES, new EmployeeMapper());
	}

	@Override
	public boolean deleteEmployeeById(Employee employee) {
		return jdbcTemplate.update(EmployeeQuery.DELETE_EMPLOYEE_BY_ID, employee.getId()) > 0;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return jdbcTemplate.update(EmployeeQuery.UPDATE_EMPLOYEE_BY_ID, 
		     employee.getFirstName(), employee.getMiddelName(), employee.getDob(), employee.getGender(),
			 employee.getPrimaryContactNumber(), employee.getSecondaryContactNumber(), employee.getEmailId(),
			 employee.getSkypeId(), employee.getId()) > 0;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return jdbcTemplate.update(EmployeeQuery.CREATE_EMPLOYEE, 
			     employee.getFirstName(), employee.getMiddelName(), employee.getDob(), employee.getGender(),
				 employee.getPrimaryContactNumber(), employee.getSecondaryContactNumber(), employee.getEmailId(),
				 employee.getSkypeId(), employee.getPassword()) > 0;
	}
	@Override
	public Employee getEmployeeByEmailId(String emailId) {
		return jdbcTemplate.queryForObject(EmployeeQuery.GET_EMPLOYEE_ID_BY_EMAIL_ID, new Object[] { emailId }, 
			    new EmployeeMapper());
	}
	@Override
	public Employee searchByName(String name) {
		return jdbcTemplate.queryForObject(EmployeeQuery.SEARCH_EMPLOYEE_BY_NAME, new Object[] { name }, 
			    new SearchMapper());
	}

}
