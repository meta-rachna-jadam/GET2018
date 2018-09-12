package com.metacube.training.dao.query;

public interface UserRoleQuery {

    String UPDATE_USER_ROLE_BY_ID = "UPDATE userRoles SET username = :username, "
    		+ "role = :role WHERE user_role_id = :id";

    String DELETE_USER_ROLE_BY_ID = "DELETE FROM userRoles WHERE user_role_id = :id";

    String GET_ALL_USER_ROLES = "FROM userRoles";

    String GET_USER_ROLE_BY_ID = "FROM userRoles WHERE user_role_id = :id"; 
}
