package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setId(resultSet.getInt("emp_code"));
		employee.setFirstName(resultSet.getString("first_name"));
		employee.setMiddelName(resultSet.getString("middle_name"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setGender(resultSet.getString("gender"));
		employee.setPrimaryContactNumber(resultSet.getString("primary_contact_no"));
        employee.setSecondaryContactNumber(resultSet.getString("secondary_contact_no"));
		employee.setEmailId(resultSet.getString("email_id"));
		employee.setSkypeId(resultSet.getString("skype_id"));
		//employee.setProfilePhotoUrl(resultSet.getString("profile_picture"));
		employee.setPassword(resultSet.getString("password"));
		employee.setEnabled(resultSet.getBoolean("enabled"));
		return employee;
	}
}
