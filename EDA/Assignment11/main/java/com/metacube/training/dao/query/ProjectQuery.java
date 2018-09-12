package com.metacube.training.dao.query;

public interface ProjectQuery {

	String SQL_FIND_PROJECT = "from project where project_id = :id";

	String SQL_DELETE_PROJECT = "update project set enabled = false where project_id = :id";

	String SQL_UPDATE_PROJECT = "update project set description = :description, "
			+ "start_date  = :start_date, end_date  = :end_date where project_id = :id";

	String SQL_GET_ALL = "from project";

}
