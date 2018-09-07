package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.metacube.training.constants.DatabaseConstant;
import com.metacube.training.dao.query.EmployeeQuery;
import com.metacube.training.dao.query.SkillsQuery;
import com.metacube.training.model.Skills;

public class SkillsDao implements AdminDao<Skills> {

	@Override
	public Skills getFieldById(int id) {
		return null;
	}

	@Override
	public List<Skills> getListOfField() {
		return null;
	}

	@Override
	public boolean deleteFieldById(int id) {
		return false;
	}

	@Override
	public boolean updateFieldById(Skills skills) {
		return false;
	}

	@Override
	public boolean createField(Skills skills) {
		try (
            Connection connectionInstance = JDBCConnection.getConnection(DatabaseConstant.DATABASE_NAME, 
                DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
            PreparedStatement preparedStatementToAddEmployee = 
                connectionInstance.prepareStatement(SkillsQuery.CREATE_SKILLS);) {
	        	
            preparedStatementToAddEmployee.setString(1, skills.getName());
	        	
	        if (preparedStatementToAddEmployee.executeUpdate() > 0) {
	            return true;
	        }
	        return false;
	    } catch (SQLException sqlException) {
	        return false;
        }
    }
}
