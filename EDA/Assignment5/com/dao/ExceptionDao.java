package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.constant.DBConstants;
import com.constant.ExceptionDBConstants;
import com.model.CustemException;

public class ExceptionDao {

    public int addException(CustemException exception) {
    	
        try (
	        Connection connectionInstance = JDBCConnection.getConnection(ExceptionDBConstants.databaseName, 
                DBConstants.userName, DBConstants.password);
            PreparedStatement preparedStatementToAddException = connectionInstance.prepareStatement(ExceptionQuery.ADD_EXCEPTION_QUERY);) {
    		
        	preparedStatementToAddException.setString(1, exception.getClassName());
        	preparedStatementToAddException.setString(2, exception.getExceptionName());
        	return 1;
        } catch (SQLException sqlException) {
        	new CustemException("ExceptionDao", sqlException.toString(), sqlException.getMessage());
    		return -1;
	    }
    }
}
