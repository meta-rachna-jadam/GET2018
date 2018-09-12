package com.metacube.training.dao.query;

public interface JobTitleQuery {

	String CREATE_JOB_TITLE = "INSERT INTO jobTitle (job_title) VALUES (?)";

    String UPDATE_JOB_TITLE_BY_ID = "UPDATE jobTitle SET job_title = ? WHERE job_code = ?";

    String DELETE_JOB_TITLE_BY_ID = "DELETE FROM jobTitle WHERE job_code = ?";

    String GET_ALL_JOB_TITLES = "SELECT job_code, job_title FROM jobTitle";

    String GET_JOB_TITLE_BY_ID = "SELECT job_code, job_title FROM jobTitle WHERE job_code = ?"; 
}
