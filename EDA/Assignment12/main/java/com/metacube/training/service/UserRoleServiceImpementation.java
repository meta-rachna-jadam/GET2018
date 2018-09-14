package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.UserRole;
import com.metacube.training.repository.UserRoleRepository;

/**
 * class provide services related to user role
 * @author Rachna Jadam
 *
 */

@Service
public class UserRoleServiceImpementation implements UserRoleService {

	@Autowired
	private UserRoleRepository<UserRole> userRoleRepository;
	
	/**
	 * To get user role by id
	 */
	@Override
	public UserRole getUserRoleById(int id) {
		return userRoleRepository.findOne(id);
	}

	/**
	 * To get user role list
	 */
	@Override
	public List<UserRole> getAllUserRoles() {
		return userRoleRepository.findAll();
	}

	/**
	 * To delete user role by id
	 */
	@Override
	public boolean deleteUserRole(int id) {
		userRoleRepository.delete(id);
		return true;
	}

	/**
	 * To update user role
	 */
	@Override
	public boolean updateUserRole(UserRole userRole) {
		userRoleRepository.saveAndFlush(userRole);
		return true;
	}

	/**
	 * To create user role entry in database
	 */
	@Override
	public boolean createUserRole(UserRole userRole) {
		userRoleRepository.save(userRole);
		return true;
	}
}
