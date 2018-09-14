package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.JobDetails;
import com.metacube.training.repository.JobDetailsRepository;

/**
 * class provide services related to job details
 * @author Rachna Jadam
 *
 */

@Service
public class JobDetailsServiceImpementation implements JobDetailsService {

	@Autowired
	private JobDetailsRepository<JobDetails> jobDetailsRepository;
	
	/**
	 * To get job detail by id
	 */
	@Override
	public JobDetails getJobDetailsById(int id) {
		return jobDetailsRepository.findOne(id);
	}

	/**
	 * To get job detail list
	 */
	@Override
	public List<JobDetails> getAllJobDetails() {
		return jobDetailsRepository.findAll();
	}

	/**
	 * To delete job detail by id
	 */
	@Override
	public boolean deleteJobDetails(int id) {
		jobDetailsRepository.delete(id);
		return true;
	}

	/**
	 * To update job detail
	 */
	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		jobDetailsRepository.saveAndFlush(jobDetails);
		return true;
	}

	/**
	 * To create job detail entry in database
	 */
	@Override
	public boolean createJobDetails(JobDetails jobDetails) {
		jobDetailsRepository.save(jobDetails);
		return true;
	}
}
