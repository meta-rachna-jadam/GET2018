package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.metacube.training.dao.query.EmployeeSkillsQuery;
import com.metacube.training.mappers.EmployeeSkillsMapper;
import com.metacube.training.model.EmployeeSkills;
/**
 * It implements Employee skills
 * @author Rachna Jadam
 *
 */
@Repository
public class EmployeeSkillsDAOImplementaion implements EmployeeSkillsDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeSkillsDAOImplementaion(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * get employee skills by skill id
	 */
	@Override
	public EmployeeSkills getEmployeeSkillsById(int id) {
		return jdbcTemplate.queryForObject(EmployeeSkillsQuery.GET_EMPLOYEE_SKILLS_BY_ID, 
				new Object[] { id }, new EmployeeSkillsMapper());
	}
    /**
     * To get employee skills list
     */
	@Override
	public List<EmployeeSkills> getAllEmployeeSkills() {
		return jdbcTemplate.query(EmployeeSkillsQuery.GET_ALL_SKILLS, new EmployeeSkillsMapper());
	}

	/**
	 * To delete employee skills
	 */
	@Override
	public boolean deleteEmployeeSkills(EmployeeSkills employeeSkills) {
		return jdbcTemplate.update(EmployeeSkillsQuery.DELETE_EMPLOYEE_SKILLS_BY_ID, employeeSkills.getId()) > 0;
	}

	/**
	 * To update employee skills
	 */
	@Override
	public boolean updateEmployeeSkills(EmployeeSkills employeeSkills) {
		return jdbcTemplate.update(EmployeeSkillsQuery.UPDATE_EMPLOYEE_SKILLS_BY_ID, 
				employeeSkills.getEmployeeId(), employeeSkills.getSkillId(), employeeSkills.getId()) > 0;
	}

	/**
	 * To create employee skills
	 */
	@Override
	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		return jdbcTemplate.update(EmployeeSkillsQuery.CREATE_EMPLOYEE_SKILLS, 
			    employeeSkills.getEmployeeId(), employeeSkills.getSkillId()) > 0;
	}
}