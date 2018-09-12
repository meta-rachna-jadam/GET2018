package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.query.JobTitleQuery;
import com.metacube.training.dao.query.ProjectQuery;
import com.metacube.training.mappers.JobTitleMapper;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;

@Repository
public class JobTitleDAOImplementaion implements JobTitleDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobTitleDAOImplementaion(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public JobTitle getJobTitleById(int id) {
		return jdbcTemplate.queryForObject(JobTitleQuery.GET_JOB_TITLE_BY_ID, new Object[] { id }, 
			    new JobTitleMapper());
	}

	@Override
	public List<JobTitle> getAllJobTitles() {
		return jdbcTemplate.query(JobTitleQuery.GET_ALL_JOB_TITLES, new JobTitleMapper());
	}

	@Override
	public boolean deleteJobTitle(JobTitle jobTitle) {
		return jdbcTemplate.update(JobTitleQuery.DELETE_JOB_TITLE_BY_ID, jobTitle.getJobCode()) > 0;
	}

	@Override
	public boolean updateJobTitle(JobTitle jobTitle) {
		return jdbcTemplate.update(JobTitleQuery.UPDATE_JOB_TITLE_BY_ID, jobTitle.getJobTitle(),
			    jobTitle.getJobCode()) > 0;
	}

	@Override
	public boolean createJobTitle(JobTitle jobTitle) {
		return jdbcTemplate.update(JobTitleQuery.CREATE_JOB_TITLE, jobTitle.getJobTitle()) > 0;
	}
}