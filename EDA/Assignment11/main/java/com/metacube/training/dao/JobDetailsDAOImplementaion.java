package com.metacube.training.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.dao.query.JobDetailsQuery;
import com.metacube.training.model.JobDetails;

@Repository
@Transactional
public class JobDetailsDAOImplementaion implements JobDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public JobDetails getJobDetailsById(int id) {
		try {
			TypedQuery<JobDetails> query = sessionFactory.getCurrentSession()
					.createQuery(JobDetailsQuery.GET_JOB_DETAILS_BY_ID);
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
	public List<JobDetails> getAllJobDetails() {
		TypedQuery<JobDetails> query = sessionFactory.getCurrentSession()
				.createQuery(JobDetailsQuery.GET_ALL_JOB_DETAILS);
		return query.getResultList();
	}

	@Override
	public boolean deleteJobDetails(JobDetails jobDetails) {
		try {
			TypedQuery<JobDetails> query = sessionFactory.getCurrentSession()
					.createQuery(JobDetailsQuery.DELETE_JOB_DETAILS);
			query.setParameter("id", jobDetails.getId());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		try {
			TypedQuery<JobDetails> query = sessionFactory.getCurrentSession()
					.createQuery(JobDetailsQuery.UPDATE_JOB_DETAILS_BY_ID);
			query.setParameter("emp_code", jobDetails.getEmpCode());
			query.setParameter("date_of_joining", jobDetails.getDateOfJoining());
			query.setParameter("total_exp", jobDetails.getTotalExperience());
			query.setParameter("job_code", jobDetails.getJobCode());
			query.setParameter("reporting_mgr",	jobDetails.getReportingManagerId());
			query.setParameter("team_lead", jobDetails.getTeamLeaderId());
			query.setParameter("curr_proj_id", jobDetails.getCurrentProjectId());
			query.setParameter("id", jobDetails.getId());
			return query.executeUpdate() > 0;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean createJobDetails(JobDetails jobDetails) {
		try {
			sessionFactory.getCurrentSession().save(jobDetails);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
}