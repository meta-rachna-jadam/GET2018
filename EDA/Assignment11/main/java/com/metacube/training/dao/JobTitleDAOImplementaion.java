package com.metacube.training.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.dao.query.JobTitleQuery;
import com.metacube.training.model.JobTitle;

@Repository
@Transactional
public class JobTitleDAOImplementaion implements JobTitleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public JobTitle getJobTitleById(int id) {
		try {
			TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
					.createQuery(JobTitleQuery.GET_JOB_TITLE_BY_ID);
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
	public List<JobTitle> getAllJobTitles() {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
				.createQuery(JobTitleQuery.GET_ALL_JOB_TITLES);
		return query.getResultList();
	}

	@Override
	public boolean deleteJobTitle(JobTitle jobTitle) {
		try {
			TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
					.createQuery(JobTitleQuery.DELETE_JOB_TITLE_BY_ID);
			query.setParameter("id", jobTitle.getJobCode());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateJobTitle(JobTitle jobTitle) {
		try {
			TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
					.createQuery(JobTitleQuery.UPDATE_JOB_TITLE_BY_ID);
			query.setParameter("job_title", jobTitle.getJobTitle());
			query.setParameter("id", jobTitle.getJobCode());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean createJobTitle(JobTitle jobTitle) {
		try {
			sessionFactory.getCurrentSession().save(jobTitle);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}