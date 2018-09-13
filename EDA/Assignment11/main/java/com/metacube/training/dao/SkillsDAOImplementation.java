package com.metacube.training.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.dao.query.SkillsQuery;
import com.metacube.training.model.Skills;

@Repository
@Transactional
public class SkillsDAOImplementation implements SkillsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Skills getSkillsById(int id) {
		try {
			TypedQuery<Skills> query = sessionFactory.getCurrentSession()
					.createQuery(SkillsQuery.SQL_FIND_SKILLS);
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
	public List<Skills> getAllSkills() {
		TypedQuery<Skills> query = sessionFactory.getCurrentSession()
				.createQuery(SkillsQuery.SQL_GET_ALL);
		return query.getResultList();
	}

	@Override
	public boolean deleteSkills(Skills skills) {
		return false;
	}

	@Override
	public boolean updateSkills(Skills skills) {
		try {
			TypedQuery<Skills> query = sessionFactory.getCurrentSession()
					.createQuery(SkillsQuery.SQL_UPDATE_SKILLS);
			query.setParameter("skill_name", skills.getName());
			query.setParameter("id", skills.getId());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean createSkills(Skills skills) {
		try {
			sessionFactory.getCurrentSession().save(skills);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}
