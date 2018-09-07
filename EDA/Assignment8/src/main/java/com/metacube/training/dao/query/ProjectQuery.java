package com.metacube.training.dao.query;

public interface ProjectQuery {

    String CREATE_PROJECT = "INSERT INTO project (description, start_date, end_date, project_logo)"
    		              + " VALUES (?, ?, ?, ?)";

    String UPDATE_PROJECT_BY_ID = "UPDATE project SET description = ?, start_date = ?, end_date = ?, project_logo = ? "
                                 + "WHERE project_id = ?";

    String DELETE_PROJECT_BY_ID = "UPDATE project SET enabled = ? WHERE project_id = ?";

    String GET_ALL_PROJECTS = "SELECT project_id, description, start_date, end_date, project_logo FROM project "
    		                + "WHERE enabled = true";;

    String GET_PROJECT_BY_ID = "SELECT project_id, description, start_date, end_date, project_logo, enabled FROM project"
                              + "WHERE project_id = ?";
}
