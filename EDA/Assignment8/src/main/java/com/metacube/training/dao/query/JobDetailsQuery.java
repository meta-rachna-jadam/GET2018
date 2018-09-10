package com.metacube.training.dao.query;

public interface JobDetailsQuery {

	String CREATE_JOB_DETAILS = "INSERT INTO jobDetails (emp_code, date_of_joining, total_exp, job_code, "
			                  + "reporting_mgr, team_lead, curr_proj_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

    String UPDATE_JOB_DETAILS_BY_ID = "UPDATE jobDetails SET emp_code = ?, date_of_joining = ?, "
    		                        + "total_exp = ?, job_code = ?, reporting_mgr = ?, team_lead = ?"
    		                        + " curr_proj_id = ? WHERE job_detail_id = ?";
    
    String GET_JOB_DETAILS_BY_ID = "SELECT job_detail_id, emp_code, date_of_joining, total_exp, job_code, "
    		                     + "reporting_mgr, team_lead, curr_proj_id FROM jobDetails WHERE job_detail_id = ?";
    
    String GET_JOB_DETAILS_BY_EMPLOYEE_ID = "SELECT job_detail_id, emp_code, date_of_joining, total_exp, job_code, "
                                        + "reporting_mgr, team_lead, curr_proj_id FROM jobDetails WHERE emp_code = ?";
    
    String GET_ALL_JOB_DETAILS = "SELECT job_detail_id, emp_code, date_of_joining, total_exp, job_code, "
                               + "reporting_mgr, team_lead, curr_proj_id FROM jobDetails";
}
