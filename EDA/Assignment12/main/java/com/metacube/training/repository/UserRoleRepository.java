package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.training.model.UserRole;

public interface UserRoleRepository<P> extends JpaRepository<UserRole, Integer> {

}
