package com.metacube.training.dao.query;

public interface UserRoleQuery {

	String CREATE_USER_ROLE = "INSERT INTO userRoles (username, role) VALUES (?, ?)";

    String UPDATE_USER_ROLE_BY_ID = "UPDATE userRoles SET username = ?, role = ? WHERE user_role_id = ?";

    String DELETE_USER_ROLE_BY_ID = "DELETE FROM userRoles WHERE user_role_id = ?";

    String GET_ALL_USER_ROLES = "SELECT user_role_id, username, role FROM userRoles";

    String GET_USER_ROLE_BY_ID = "SELECT user_role_id, username, role FROM userRoles WHERE user_role_id = ?"; 
}
