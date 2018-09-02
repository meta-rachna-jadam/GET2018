package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.CustomException.SQLDatabaseException;
import com.constants.DBConstants;
import com.constants.EmployeeConstants;
import com.constants.ExceptionDBConstants;
import com.model.DatabaseException;
import com.model.Employee;

public class ExceptionDao {

    public int addException(DatabaseException exception) {
    	
        try (
	        Connection connectionInstance = JDBCConnection.getConnection(ExceptionDBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToAddException = connectionInstance.prepareStatement(ExceptionQuery.addExceptionQuery);) {
    		
        	preparedStatementToAddException.setString(1, exception.getClassName());
        	preparedStatementToAddException.setString(2, exception.getExceptionName());
        	return 1;
        } catch (SQLException sqlException) {
        	new SQLDatabaseException("ExceptionDao", sqlException.toString(), sqlException.getMessage());
    		return -1;
	    }
    }
}
