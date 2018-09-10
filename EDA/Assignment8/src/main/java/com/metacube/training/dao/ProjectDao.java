package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metacube.training.constants.DatabaseConstant;
import com.metacube.training.dao.query.ProjectQuery;
import com.metacube.training.model.CustomException;
import com.metacube.training.model.Project;

public class ProjectDao implements AdminDao<Project> {

	@Override
	public Project getFieldById(int id) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetProject = 
                connection.prepareStatement(ProjectQuery.GET_PROJECT_BY_ID);){
			
            preparedStatementToGetProject.setInt(1, id);
            ResultSet projectResultSet = preparedStatementToGetProject.executeQuery();
            
            if (projectResultSet.next()) {
                return new Project(projectResultSet.getInt("project_id"), projectResultSet.getString("description"), 
                		projectResultSet.getDate("start_date"), projectResultSet.getDate("end_date"), 
                		projectResultSet.getString("project_logo"));
            }
            return null;
        } catch (SQLException sqlException) {
        	new CustomException("ProjectDao", sqlException.toString(), sqlException.getMessage());
        	return null;
        }        
    }

	@Override
	public List<Project> getListOfField() {
    	
        List<Project> projectList = new ArrayList<Project>();
		try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetProjects = 
                connection.prepareStatement(ProjectQuery.GET_ALL_PROJECTS);){
			
            ResultSet projectResultSet = preparedStatementToGetProjects.executeQuery();
            
            if (projectResultSet.next()) {
                projectList.add(new Project(projectResultSet.getInt("project_id"), projectResultSet.getString("description"), 
                		projectResultSet.getDate("start_date"), projectResultSet.getDate("end_date"), 
                		projectResultSet.getString("project_logo")));
            }
            return projectList;
        } catch (SQLException sqlException) {
        	new CustomException("ProjectDao", sqlException.toString(), sqlException.getMessage());
        	return null;
        }        
    }

	@Override
	public boolean deleteFieldById(int id) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetProject = 
                connection.prepareStatement(ProjectQuery.DELETE_PROJECT_BY_ID);){
			
            preparedStatementToGetProject.setBoolean(1, false);
            preparedStatementToGetProject.setInt(2, id);
            
            return (preparedStatementToGetProject.executeUpdate() > 0);
            
        } catch (SQLException sqlException) {
        	new CustomException("ProjectDao", sqlException.toString(), sqlException.getMessage());
        	return false;
        }        
    }

	@Override
	public boolean updateFieldById(Project project) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetProject = 
                connection.prepareStatement(ProjectQuery.UPDATE_PROJECT_BY_ID);){
			
            preparedStatementToGetProject.setString(1, project.getDescription());
            
            Date utilProjectStartDate = project.getStartDate();
            java.sql.Date sqlProjectStartDate = new java.sql.Date(utilProjectStartDate.getTime());
        	preparedStatementToGetProject.setDate(2, sqlProjectStartDate);
        	Date utilProjectEndDate = project.getStartDate();
            java.sql.Date sqlProjecEndDate = new java.sql.Date(utilProjectEndDate.getTime());
        	preparedStatementToGetProject.setDate(3, sqlProjecEndDate);
        	
            preparedStatementToGetProject.setString(4, project.getProjectLogoUrl());
            preparedStatementToGetProject.setInt(5, project.getId());
            
            return (preparedStatementToGetProject.executeUpdate() > 0);
            
        } catch (SQLException sqlException) {
        	new CustomException("ProjectDao", sqlException.toString(), sqlException.getMessage());
        	return false;
        }        
    }

	@Override
	public boolean createField(Project project) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetProject = 
                connection.prepareStatement(ProjectQuery.CREATE_PROJECT);){
			
            preparedStatementToGetProject.setString(1, project.getDescription());
            
            Date utilProjectStartDate = project.getStartDate();
            java.sql.Date sqlProjectStartDate = new java.sql.Date(utilProjectStartDate.getTime());
        	preparedStatementToGetProject.setDate(2, sqlProjectStartDate);
        	Date utilProjectEndDate = project.getStartDate();
            java.sql.Date sqlProjecEndDate = new java.sql.Date(utilProjectEndDate.getTime());
        	preparedStatementToGetProject.setDate(3, sqlProjecEndDate);
        	
            preparedStatementToGetProject.setString(4, project.getProjectLogoUrl());
            
            return (preparedStatementToGetProject.executeUpdate() > 0);
            
        } catch (SQLException sqlException) {
        	new CustomException("ProjectDao", sqlException.toString(), sqlException.getMessage());
        	return false;
        }        
    }
}
