package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metacube.training.constants.DatabaseConstant;
import com.metacube.training.dao.query.EmployeeQuery;
import com.metacube.training.dao.query.ProjectQuery;
import com.metacube.training.dao.query.SkillsQuery;
import com.metacube.training.model.CustomException;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skills;

public class SkillsDao implements AdminDao<Skills> {

	@Override
	public Skills getFieldById(int id) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetSkill = 
                connection.prepareStatement(SkillsQuery.GET_SKILLS_BY_ID);){
			
        	preparedStatementToGetSkill.setInt(1, id);
            ResultSet skillResultSet = preparedStatementToGetSkill.executeQuery();
            
            if (skillResultSet.next()) {
                return new Skills(skillResultSet.getInt("skill_id"), skillResultSet.getString("skill_name"));
            }
            return null;
        } catch (SQLException sqlException) {
        	new CustomException("SkillsDao", sqlException.toString(), sqlException.getMessage());
        	return null;
        }        
    }
	@Override
	public List<Skills> getListOfField() {
		
    	List<Skills> skillList = new ArrayList<Skills>();
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetSkills = 
                connection.prepareStatement(SkillsQuery.GET_ALL_SKILLS);){
			
            ResultSet skillResultSet = preparedStatementToGetSkills.executeQuery();
            
            if (skillResultSet.next()) {
                skillList.add(new Skills(skillResultSet.getInt("skill_id"), skillResultSet.getString("skill_name")));
            }
            return null;
        } catch (SQLException sqlException) {
        	new CustomException("SkillsDao", sqlException.toString(), sqlException.getMessage());
        	return null;
        }        
    }

	@Override
	public boolean deleteFieldById(int id) {
		return false;
	}

	@Override
	public boolean updateFieldById(Skills skills) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToUpdateSkill = 
                connection.prepareStatement(SkillsQuery.UPDATE_SKILLS_BY_ID);){
			
        	preparedStatementToUpdateSkill.setString(1, skills.getName());
        	preparedStatementToUpdateSkill.setInt(2, skills.getId());
            
            return (preparedStatementToUpdateSkill.executeUpdate() > 0);
        } catch (SQLException sqlException) {
        	new CustomException("SkillsDao", sqlException.toString(), sqlException.getMessage());
        	return false;
        }        
    }

	@Override
	public boolean createField(Skills skills) {
		try (
            Connection connectionInstance = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToAddEmployee = 
                connectionInstance.prepareStatement(SkillsQuery.CREATE_SKILLS);) {
	        	
            preparedStatementToAddEmployee.setString(1, skills.getName());
	        	
	        return (preparedStatementToAddEmployee.executeUpdate() > 0);
	    } catch (SQLException sqlException) {
	    	new CustomException("SkillsDao", sqlException.toString(), sqlException.getMessage());
	        return false;
        }
    }
}
