package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.JobTitle;

public interface JobTitleService {

	JobTitle getJobTitleById(int id);

	List<JobTitle> getAllJobTitles();

	boolean deleteJobTitle(int id);

	boolean updateJobTitle(JobTitle jobTitle);

	boolean createJobTitle(JobTitle jobTitle);
}
