package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.constants.DatabaseConstant;
import com.metacube.training.dao.query.EmployeeSkillsQuery;
import com.metacube.training.dao.query.SkillsQuery;
import com.metacube.training.model.CustomException;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.Skills;

public class EmployeeSkillsDao implements AdminDao<EmployeeSkills> {

    @Override
    public EmployeeSkills getFieldById(int id) {
    	
        try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetSkill = 
                connection.prepareStatement(EmployeeSkillsQuery.GET_EMPLOYEE_SKILLS_BY_ID);){
			
        	preparedStatementToGetSkill.setInt(1, id);
            ResultSet skillResultSet = preparedStatementToGetSkill.executeQuery();
            
            if (skillResultSet.next()) {
                return new EmployeeSkills(skillResultSet.getInt("emp_skill_id"), skillResultSet.getInt("emp_code"),
                    skillResultSet.getInt("skill_code"));
            }
            return null;
        } catch (SQLException sqlException) {
        	new CustomException("EmployeeSkillsDao", sqlException.toString(), sqlException.getMessage());
        	return null;
        }        
    }

    @Override
    public List<EmployeeSkills> getListOfField() {
    	
        List<EmployeeSkills> employeeSkillList = new ArrayList<EmployeeSkills>();
    	try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToGetSkill = 
                connection.prepareStatement(EmployeeSkillsQuery.GET_ALL_SKILLS);){
			
            ResultSet skillResultSet = preparedStatementToGetSkill.executeQuery();
            
            if (skillResultSet.next()) {
                employeeSkillList.add(new EmployeeSkills(skillResultSet.getInt("emp_skill_id"), skillResultSet.getInt("emp_code"),
                    skillResultSet.getInt("skill_code")));
            }
            return employeeSkillList;
        } catch (SQLException sqlException) {
        	new CustomException("EmployeeSkillsDao", sqlException.toString(), sqlException.getMessage());
        	return null;
        }        
    }


    @Override
    public boolean deleteFieldById(int id) {
         return false;
    }

    @Override
    public boolean updateFieldById(EmployeeSkills employeeSkills) {
    	
        List<EmployeeSkills> employeeSkillList = new ArrayList<EmployeeSkills>();
    	try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToUpdateSkill = 
                connection.prepareStatement(EmployeeSkillsQuery.UPDATE_EMPLOYEE_SKILLS_BY_ID);){
			
            preparedStatementToUpdateSkill.setInt(1, employeeSkills.getEmployeeId());
            preparedStatementToUpdateSkill.setInt(2, employeeSkills.getSkillId());
            preparedStatementToUpdateSkill.setInt(3, employeeSkills.getId());
    		return (preparedStatementToUpdateSkill.executeUpdate() > 0);
            
        } catch (SQLException sqlException) {
        	new CustomException("EmployeeSkillsDao", sqlException.toString(), sqlException.getMessage());
        	return false;
        }        
    }

    @Override
    public boolean createField(EmployeeSkills employeeSkills) {
    	
    	try(
            Connection connection = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToCreateSkill = 
                connection.prepareStatement(EmployeeSkillsQuery.CREATE_EMPLOYEE_SKILLS);){
			
            preparedStatementToCreateSkill.setInt(1, employeeSkills.getEmployeeId());
            preparedStatementToCreateSkill.setInt(2, employeeSkills.getSkillId());
    		return (preparedStatementToCreateSkill.executeUpdate() > 0);
            
        } catch (SQLException sqlException) {
        	new CustomException("EmployeeSkillsDao", sqlException.toString(), sqlException.getMessage());
        	return false;
        }        
    }
}
