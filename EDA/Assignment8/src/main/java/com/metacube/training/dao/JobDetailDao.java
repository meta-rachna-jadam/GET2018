package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metacube.training.constants.DatabaseConstant;
import com.metacube.training.dao.query.EmployeeSkillsQuery;
import com.metacube.training.dao.query.JobDetailsQuery;
import com.metacube.training.model.CustomException;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;

public class JobDetailDao implements AdminDao<JobDetails>{
	
    @Override
    public JobDetails getFieldById(int id) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToJobDetail = 
                connection.prepareStatement(JobDetailsQuery.GET_JOB_DETAILS_BY_ID);){
			
        	preparedStatementToJobDetail.setInt(1, id);
            ResultSet jobDetailResultSet = preparedStatementToJobDetail.executeQuery();
            
            if (jobDetailResultSet.next()) {
                return new JobDetails(jobDetailResultSet.getInt("job_detail_id"), jobDetailResultSet.getInt("emp_code"),
                    jobDetailResultSet.getDate("date_of_joining"), jobDetailResultSet.getInt("total_exp"), 
                    jobDetailResultSet.getInt("job_code"), jobDetailResultSet.getInt("reporting_mgr"),
                    jobDetailResultSet.getInt("team_lead"), jobDetailResultSet.getInt("curr_proj_id"));
            }
            return null;
        } catch (SQLException sqlException) {
        	new CustomException("JobDetailDao", sqlException.toString(), sqlException.getMessage());
        	return null;
        }        
    }

    @Override
    public List<JobDetails> getListOfField() {
    	
        List<JobDetails> jobDetailList = new ArrayList<JobDetails>();
    	try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToJobDetail = 
                connection.prepareStatement(JobDetailsQuery.GET_ALL_JOB_DETAILS);){
			
            ResultSet jobDetailResultSet = preparedStatementToJobDetail.executeQuery();
            
            if (jobDetailResultSet.next()) {
                jobDetailList.add(new JobDetails(jobDetailResultSet.getInt("job_detail_id"), jobDetailResultSet.getInt("emp_code"),
                    jobDetailResultSet.getDate("date_of_joining"), jobDetailResultSet.getInt("total_exp"), 
                    jobDetailResultSet.getInt("job_code"), jobDetailResultSet.getInt("reporting_mgr"),
                    jobDetailResultSet.getInt("team_lead"), jobDetailResultSet.getInt("curr_proj_id")));
            }
            return jobDetailList;
        } catch (SQLException sqlException) {
        	new CustomException("JobDetailDao", sqlException.toString(), sqlException.getMessage());
        	return null;
        }        
    }

    @Override
    public boolean deleteFieldById(int id) {
         return false;
    }

    @Override
    public boolean updateFieldById(JobDetails jobDetails) {
        
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToUpdateJobDetail = 
                connection.prepareStatement(JobDetailsQuery.UPDATE_JOB_DETAILS_BY_ID);){
			
            preparedStatementToUpdateJobDetail.setInt(1, jobDetails.getEmpCode());
            Date utilDateOfJoining = jobDetails.getDateOfJoining();
            java.sql.Date sqlDateOfJoining = new java.sql.Date(utilDateOfJoining.getTime());
            preparedStatementToUpdateJobDetail.setDate(2, sqlDateOfJoining);
        	
            preparedStatementToUpdateJobDetail.setInt(3, jobDetails.getTotalExperience());
            preparedStatementToUpdateJobDetail.setInt(4, jobDetails.getJobCode());
            preparedStatementToUpdateJobDetail.setInt(5, jobDetails.getReportingManagerId());
            preparedStatementToUpdateJobDetail.setInt(6, jobDetails.getTeamLeaderId());
            preparedStatementToUpdateJobDetail.setInt(7, jobDetails.getCurrentProjectId());
            preparedStatementToUpdateJobDetail.setInt(8, jobDetails.getId());
            
            return (preparedStatementToUpdateJobDetail.executeUpdate() > 0);
        } catch (SQLException sqlException) {
        	new CustomException("JobDetailDao", sqlException.toString(), sqlException.getMessage());
        	return false;
        }        
    }


    @Override
    public boolean createField(JobDetails jobDetails) {
        
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToUpdateJobDetail = 
                connection.prepareStatement(JobDetailsQuery.CREATE_JOB_DETAILS);){
			
            preparedStatementToUpdateJobDetail.setInt(1, jobDetails.getEmpCode());
            Date utilDateOfJoining = jobDetails.getDateOfJoining();
            java.sql.Date sqlDateOfJoining = new java.sql.Date(utilDateOfJoining.getTime());
            preparedStatementToUpdateJobDetail.setDate(2, sqlDateOfJoining);
        	
            preparedStatementToUpdateJobDetail.setInt(3, jobDetails.getTotalExperience());
            preparedStatementToUpdateJobDetail.setInt(4, jobDetails.getJobCode());
            preparedStatementToUpdateJobDetail.setInt(5, jobDetails.getReportingManagerId());
            preparedStatementToUpdateJobDetail.setInt(6, jobDetails.getTeamLeaderId());
            preparedStatementToUpdateJobDetail.setInt(7, jobDetails.getCurrentProjectId());
            
            return (preparedStatementToUpdateJobDetail.executeUpdate() > 0);
        } catch (SQLException sqlException) {
        	new CustomException("JobDetailDao", sqlException.toString(), sqlException.getMessage());
        	return false;
        }        
    }
}

