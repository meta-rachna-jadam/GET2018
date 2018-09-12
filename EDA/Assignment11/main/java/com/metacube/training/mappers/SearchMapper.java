package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class SearchMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(resultSet.getInt("emp_code"));
		employee.setFirstName(resultSet.getString("first_name"));
		employee.setMiddelName(resultSet.getString("middle_name"));
		employee.setPrimaryContactNumber(resultSet.getString("primary_contact_no"));
		employee.setEmailId(resultSet.getString("email_id"));
		return employee;
	}

}
