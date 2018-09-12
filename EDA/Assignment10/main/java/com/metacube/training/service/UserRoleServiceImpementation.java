package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.UserRoleDAO;
import com.metacube.training.model.UserRole;

@Service
public class UserRoleServiceImpementation implements UserRoleService {

	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@Override
	public UserRole getUserRoleById(int id) {
		return userRoleDAO.getUserRoleById(id);
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		return userRoleDAO.getAllUserRoles();
	}

	@Override
	public boolean deleteUserRole(int id) {
		UserRole userRole = userRoleDAO.getUserRoleById(id);
		return userRoleDAO.deleteUserRole(userRole);
	}

	@Override
	public boolean updateUserRole(UserRole userRole) {
		return userRoleDAO.updateUserRole(userRole);
	}

	@Override
	public boolean createUserRole(UserRole userRole) {
		return userRoleDAO.createUserRole(userRole);
	}
}
