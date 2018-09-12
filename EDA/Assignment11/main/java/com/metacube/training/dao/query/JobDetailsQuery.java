package com.metacube.training.dao.query;

public interface JobDetailsQuery {

	String UPDATE_JOB_DETAILS_BY_ID = "UPDATE jobDetails SET emp_code = :emp_code, "
			+ "date_of_joining = :date_of_joining, "
			+ "total_exp = :total_exp, job_code = :job_code, "
			+ "reporting_mgr = :reporting_mgr, team_lead = :team_lead"
			+ " curr_proj_id = :curr_proj_id WHERE job_detail_id = :id";

	String DELETE_JOB_DETAILS = "DELETE FROM jobDetails WHERE job_detail_id = :id";

	String GET_JOB_DETAILS_BY_ID = "FROM jobDetails WHERE job_detail_id = :id";

	String GET_JOB_DETAILS_BY_EMPLOYEE_ID = "FROM jobDetails WHERE emp_code = :emp_code";

	String GET_ALL_JOB_DETAILS = "FROM jobDetails";
}
