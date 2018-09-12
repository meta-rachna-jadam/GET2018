package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.JobDetails;

public class JobDetailsMapper implements RowMapper<JobDetails>{

	@Override
	public JobDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	    JobDetails jobDetails = new JobDetails();
	    jobDetails.setCurrentProjectId(resultSet.getInt("curr_proj_id"));
	    jobDetails.setDateOfJoining(resultSet.getDate("date_of_joining"));
	    jobDetails.setEmpCode(resultSet.getInt("emp_code"));
	    jobDetails.setId(resultSet.getInt("job_detail_id"));
	    jobDetails.setJobCode(resultSet.getInt("job_code"));
	    jobDetails.setReportingManagerId(resultSet.getInt("reporting_mgr"));
	    jobDetails.setTeamLeaderId(resultSet.getInt("team_lead"));
	    jobDetails.setTotalExperience(resultSet.getInt("total_exp"));
		return jobDetails;
	}
}
