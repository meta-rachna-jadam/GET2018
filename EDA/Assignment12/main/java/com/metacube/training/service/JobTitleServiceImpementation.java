package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobTitleDAO;
import com.metacube.training.model.JobTitle;

@Service
public class JobTitleServiceImpementation implements JobTitleService {

	@Autowired
	private JobTitleDAO jobTitleDAO;
	
	@Override
	public JobTitle getJobTitleById(int id) {
		return jobTitleDAO.getJobTitleById(id);
	}

	@Override
	public List<JobTitle> getAllJobTitles() {
		return jobTitleDAO.getAllJobTitles();
	}

	@Override
	public boolean deleteJobTitle(int id) {
		JobTitle jobTitle = jobTitleDAO.getJobTitleById(id);
		return jobTitleDAO.deleteJobTitle(jobTitle);
	}

	@Override
	public boolean updateJobTitle(JobTitle jobTitle) {
		return jobTitleDAO.updateJobTitle(jobTitle);
	}

	@Override
	public boolean createJobTitle(JobTitle jobTitle) {
		return jobTitleDAO.createJobTitle(jobTitle);
	}
}
