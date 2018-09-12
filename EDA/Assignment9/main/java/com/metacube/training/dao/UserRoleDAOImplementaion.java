package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.query.ProjectQuery;
import com.metacube.training.dao.query.UserRoleQuery;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.mappers.UserRoleMapper;
import com.metacube.training.model.Project;
import com.metacube.training.model.UserRole;

@Repository
public class UserRoleDAOImplementaion implements UserRoleDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserRoleDAOImplementaion(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public UserRole getUserRoleById(int id) {
		return jdbcTemplate.queryForObject(UserRoleQuery.GET_USER_ROLE_BY_ID, new Object[] { id }, 
			    new UserRoleMapper());
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		return jdbcTemplate.query(UserRoleQuery.GET_ALL_USER_ROLES, new UserRoleMapper());
	}

	@Override
	public boolean deleteUserRole(UserRole userRole) {
		return jdbcTemplate.update(UserRoleQuery.DELETE_USER_ROLE_BY_ID, userRole.getId()) > 0;
	}

	@Override
	public boolean updateUserRole(UserRole userRole) {
		return jdbcTemplate.update(UserRoleQuery.UPDATE_USER_ROLE_BY_ID, userRole.getUsername(), 
			    userRole.getRole(), userRole.getId()) > 0;
	}

	@Override
	public boolean createUserRole(UserRole userRole) {
		return jdbcTemplate.update(UserRoleQuery.CREATE_USER_ROLE, userRole.getUsername(), 
			    userRole.getRole()) > 0;
	}
}
