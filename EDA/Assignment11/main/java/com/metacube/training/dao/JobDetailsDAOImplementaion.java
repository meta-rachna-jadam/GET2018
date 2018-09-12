package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.query.JobDetailsQuery;
import com.metacube.training.dao.query.ProjectQuery;
import com.metacube.training.mappers.JobDetailsMapper;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Project;

@Repository
public class JobDetailsDAOImplementaion implements JobDetailsDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobDetailsDAOImplementaion(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public JobDetails getJobDetailsById(int id) {
		return jdbcTemplate.queryForObject(JobDetailsQuery.UPDATE_JOB_DETAILS_BY_ID, new Object[] { id }, 
			    new JobDetailsMapper());
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		return jdbcTemplate.query(JobDetailsQuery.GET_ALL_JOB_DETAILS, new JobDetailsMapper());
	}

	@Override
	public boolean deleteJobDetails(JobDetails jobDetails) {
		return jdbcTemplate.update(JobDetailsQuery.DELETE_JOB_DETAILS, jobDetails.getId()) > 0;
	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		return jdbcTemplate.update(JobDetailsQuery.UPDATE_JOB_DETAILS_BY_ID, 
			    jobDetails.getEmpCode(), jobDetails.getDateOfJoining(), jobDetails.getTotalExperience(),
			    jobDetails.getJobCode(), jobDetails.getReportingManagerId(), jobDetails.getTeamLeaderId(),
			    jobDetails.getCurrentProjectId(), jobDetails.getId()) > 0;
	}

	@Override
	public boolean createJobDetails(JobDetails jobDetails) {
		return jdbcTemplate.update(JobDetailsQuery.CREATE_JOB_DETAILS, 
			    jobDetails.getEmpCode(), jobDetails.getDateOfJoining(), jobDetails.getTotalExperience(),
			    jobDetails.getJobCode(), jobDetails.getReportingManagerId(), jobDetails.getTeamLeaderId(),
			    jobDetails.getCurrentProjectId()) > 0;
	}
}