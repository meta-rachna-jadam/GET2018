package com.metacube.training.dao.query;

public interface JobTitleQuery {

    String UPDATE_JOB_TITLE_BY_ID = "UPDATE JobTitle SET job_title = :job_title WHERE "
    		+ "job_code = :id";

    String DELETE_JOB_TITLE_BY_ID = "DELETE FROM JobTitle WHERE job_code = :id";

    String GET_ALL_JOB_TITLES = "FROM JobTitle";

    String GET_JOB_TITLE_BY_ID = "FROM JobTitle WHERE job_code = :id"; 
}
