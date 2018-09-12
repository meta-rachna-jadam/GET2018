package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.JobTitle;

public interface JobTitleDAO {
	
	JobTitle getJobTitleById(int id);

	List<JobTitle> getAllJobTitles();

	boolean deleteJobTitle(JobTitle jobTitle);

	boolean updateJobTitle(JobTitle jobTitle);

	boolean createJobTitle(JobTitle jobTitle);

}
