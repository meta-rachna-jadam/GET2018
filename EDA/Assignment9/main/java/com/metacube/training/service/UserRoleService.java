package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.UserRole;

public interface UserRoleService {

	UserRole getUserRoleById(int id);

	List<UserRole> getAllUserRoles();

	boolean deleteUserRole(int id);

	boolean updateUserRole(UserRole userRole);

	boolean createUserRole(UserRole userRole);
}
