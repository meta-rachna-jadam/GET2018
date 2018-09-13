package com.metacube.training.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.dao.query.ProjectQuery;
import com.metacube.training.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Project getProjectById(int id) {
		try {
			TypedQuery<Project> query = sessionFactory.getCurrentSession()
					.createQuery(ProjectQuery.SQL_FIND_PROJECT);
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

	public List<Project> getAllProjects() {
		TypedQuery<Project> query = sessionFactory.getCurrentSession()
				.createQuery(ProjectQuery.SQL_GET_ALL);
		return query.getResultList();
	}

	public boolean deleteProject(Project project) {
		try {
			TypedQuery<Project> query = sessionFactory.getCurrentSession()
					.createQuery(ProjectQuery.SQL_DELETE_PROJECT);
			query.setParameter("id", project.getId());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean updateProject(Project project) {
		try {
			TypedQuery<Project> query = sessionFactory.getCurrentSession()
					.createQuery(ProjectQuery.SQL_UPDATE_PROJECT);
			query.setParameter("description", project.getDescription());
			query.setParameter("start_date", project.getStartDate());
			query.setParameter("end_date", project.getEndDate());
			query.setParameter("id", project.getId());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean createProject(Project project) {
		try {
			sessionFactory.getCurrentSession().save(project);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}