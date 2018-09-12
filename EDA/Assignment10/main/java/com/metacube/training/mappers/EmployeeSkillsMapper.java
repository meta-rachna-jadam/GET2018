package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.EmployeeSkills;

public class EmployeeSkillsMapper implements RowMapper<EmployeeSkills> {

	@Override
	public EmployeeSkills mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		EmployeeSkills employeeSkills = new EmployeeSkills();
		employeeSkills.setEmployeeId(resultSet.getInt("emp_code"));
		employeeSkills.setId(resultSet.getInt("emp_skill_id"));
		employeeSkills.setSkillId(resultSet.getInt("skill_code"));
		return employeeSkills;
	}

}
