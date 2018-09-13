package com.metacube.training.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.dao.query.UserRoleQuery;
import com.metacube.training.model.UserRole;

@Repository
@Transactional
public class UserRoleDAOImplementaion implements UserRoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UserRole getUserRoleById(int id) {
		try {
			TypedQuery<UserRole> query = sessionFactory.getCurrentSession()
					.createQuery(UserRoleQuery.GET_USER_ROLE_BY_ID);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			emptyResultDataAccessException.printStackTrace();
			return null;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		TypedQuery<UserRole> query = sessionFactory.getCurrentSession()
				.createQuery(UserRoleQuery.GET_ALL_USER_ROLES);
		return query.getResultList();
	}

	@Override
	public boolean deleteUserRole(UserRole userRole) {
		try {
			TypedQuery<UserRole> query = sessionFactory.getCurrentSession()
					.createQuery(UserRoleQuery.DELETE_USER_ROLE_BY_ID);
			query.setParameter("id", userRole.getId());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUserRole(UserRole userRole) {
		try {
			TypedQuery<UserRole> query = sessionFactory.getCurrentSession()
					.createQuery(UserRoleQuery.UPDATE_USER_ROLE_BY_ID);
			query.setParameter("username", userRole.getUsername());
			query.setParameter("role", userRole.getRole());
			query.setParameter("id", userRole.getId());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean createUserRole(UserRole userRole) {
		try {
			sessionFactory.getCurrentSession().save(userRole);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}
