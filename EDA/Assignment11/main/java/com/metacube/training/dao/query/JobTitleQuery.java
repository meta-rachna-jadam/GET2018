package com.metacube.training.dao.query;

public interface JobTitleQuery {

    String UPDATE_JOB_TITLE_BY_ID = "UPDATE jobTitle SET job_title = :job_title WHERE "
    		+ "job_code = :id";

    String DELETE_JOB_TITLE_BY_ID = "DELETE FROM jobTitle WHERE job_code = :id";

    String GET_ALL_JOB_TITLES = "FROM jobTitle";

    String GET_JOB_TITLE_BY_ID = "FROM jobTitle WHERE job_code = :id"; 
}
