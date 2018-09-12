package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.UserRole;

public interface UserRoleDAO {
	
	UserRole getUserRoleById(int id);

	List<UserRole> getAllUserRoles();

	boolean deleteUserRole(UserRole userRole);

	boolean updateUserRole(UserRole userRole);

	boolean createUserRole(UserRole userRole);

}
