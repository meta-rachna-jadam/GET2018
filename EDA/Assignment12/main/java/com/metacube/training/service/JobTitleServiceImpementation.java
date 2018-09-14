package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.JobTitle;
import com.metacube.training.repository.JobTitleRepository;

/**
 * class provide services related to job title
 * @author Rachna Jadam
 *
 */

@Service
public class JobTitleServiceImpementation implements JobTitleService {

	@Autowired
	private JobTitleRepository<JobTitle> jobTitleRepository;
	
	/**
	 * To get job title by id
	 */
	@Override
	public JobTitle getJobTitleById(int id) {
		return jobTitleRepository.findOne(id);
	}

	/**
	 * To get job title list
	 */
	@Override
	public List<JobTitle> getAllJobTitles() {
		return jobTitleRepository.findAll();
	}

	/**
	 * To delete job title by id
	 */
	@Override
	public boolean deleteJobTitle(int id) {
		jobTitleRepository.delete(id);
		return true;
	}

	/**
	 * To update job title
	 */
	@Override
	public boolean updateJobTitle(JobTitle jobTitle) {
		jobTitleRepository.saveAndFlush(jobTitle);
		return true;
	}

	/**
	 * To create job title entry in database
	 */
	@Override
	public boolean createJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
		return true;
	}
}
