package com.metacube.training.dao.query;

public interface UserRoleQuery {

    String UPDATE_USER_ROLE_BY_ID = "UPDATE UserRoles SET username = :username, "
    		+ "role = :role WHERE user_role_id = :id";

    String DELETE_USER_ROLE_BY_ID = "DELETE FROM UserRoles WHERE user_role_id = :id";

    String GET_ALL_USER_ROLES = "FROM UserRoles";

    String GET_USER_ROLE_BY_ID = "FROM UserRoles WHERE user_role_id = :id"; 
}
