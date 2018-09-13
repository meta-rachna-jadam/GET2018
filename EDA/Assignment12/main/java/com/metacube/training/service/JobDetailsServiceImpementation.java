package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobDetailsDAO;
import com.metacube.training.model.JobDetails;

@Service
public class JobDetailsServiceImpementation implements JobDetailsService {

	@Autowired
	private JobDetailsDAO jobDetailsDAO;
	
	@Override
	public JobDetails getJobDetailsById(int id) {
		return jobDetailsDAO.getJobDetailsById(id);
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		return jobDetailsDAO.getAllJobDetails();
	}

	@Override
	public boolean deleteJobDetails(int id) {
		JobDetails jobDetails = jobDetailsDAO.getJobDetailsById(id);
		return jobDetailsDAO.deleteJobDetails(jobDetails);
	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		return jobDetailsDAO.updateJobDetails(jobDetails);
	}

	@Override
	public boolean createJobDetails(JobDetails jobDetails) {
		return jobDetailsDAO.createJobDetails(jobDetails);
	}
}
