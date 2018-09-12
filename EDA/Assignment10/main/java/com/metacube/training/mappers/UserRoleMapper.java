package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.UserRole;

public class UserRoleMapper implements RowMapper<UserRole> {

	@Override
	public UserRole mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserRole userRole = new UserRole();
		userRole.setId(resultSet.getInt("user_role_id"));
		userRole.setRole(resultSet.getString("role"));
		userRole.setUsername(resultSet.getString("username"));
		return userRole;
	}

}
