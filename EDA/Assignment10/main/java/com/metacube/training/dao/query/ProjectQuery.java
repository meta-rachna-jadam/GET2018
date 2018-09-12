package com.metacube.training.dao.query;

public interface ProjectQuery {
	
	String SQL_FIND_PROJECT = "select project_id, description, start_date, end_date, project_logo "
			                + "from project where project_id = ?";
	String SQL_DELETE_PROJECT = "update project set enabled = false where project_id = ?";
	String SQL_UPDATE_PROJECT = "update project set description = ?, start_date  = ?,"
			                  + " end_date  = ? where project_id = ?";
	String SQL_GET_ALL = "select project_id, description, start_date, end_date, project_logo from project";
	String SQL_INSERT_PROJECT = "insert into project(description, start_date, end_date) "
			                  + "values(?,?,?)";
}
