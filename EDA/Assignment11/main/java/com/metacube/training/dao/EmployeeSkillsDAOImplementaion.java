package com.metacube.training.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.dao.query.EmployeeSkillsQuery;
import com.metacube.training.model.EmployeeSkills;


@Repository
@Transactional
public class EmployeeSkillsDAOImplementaion implements EmployeeSkillsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EmployeeSkills getEmployeeSkillsById(int id) {
		try {
			TypedQuery<EmployeeSkills> query = sessionFactory.getCurrentSession()
					.createQuery(EmployeeSkillsQuery.GET_EMPLOYEE_SKILLS_BY_ID);
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
	public List<EmployeeSkills> getAllEmployeeSkills() {
		TypedQuery<EmployeeSkills> query = sessionFactory.getCurrentSession()
				.createQuery(EmployeeSkillsQuery.GET_ALL_SKILLS);
		return query.getResultList();
	}

	@Override
	public boolean deleteEmployeeSkills(EmployeeSkills employeeSkills) {
		try {
			TypedQuery<EmployeeSkills> query = sessionFactory.getCurrentSession()
					.createQuery(EmployeeSkillsQuery.DELETE_EMPLOYEE_SKILLS_BY_ID);
			query.setParameter("id", employeeSkills.getId());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEmployeeSkills(EmployeeSkills employeeSkills) {
		try {
			TypedQuery<EmployeeSkills> query = sessionFactory.getCurrentSession()
					.createQuery(EmployeeSkillsQuery.UPDATE_EMPLOYEE_SKILLS_BY_ID);
			query.setParameter("emp_code", employeeSkills.getEmployeeId());
			query.setParameter("skill_code", employeeSkills.getSkillId());
			query.setParameter("id", employeeSkills.getId());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean createEmployeeSkills(EmployeeSkills employeeSkills) {
		try {
			sessionFactory.getCurrentSession().save(employeeSkills);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}