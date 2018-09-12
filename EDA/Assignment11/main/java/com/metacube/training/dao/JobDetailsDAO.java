package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.JobDetails;

public interface JobDetailsDAO {

	JobDetails getJobDetailsById(int id);

	List<JobDetails> getAllJobDetails();

	boolean deleteJobDetails(JobDetails jobDetails);

	boolean updateJobDetails(JobDetails jobDetails);

	boolean createJobDetails(JobDetails jobDetails);
}
