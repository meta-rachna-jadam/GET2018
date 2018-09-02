package com.CustomException;

import com.model.DatabaseException;

public class SQLDatabaseException extends Exception{

	public SQLDatabaseException(String className, String exceptionNam, String exceptionDescription) {
	    new DatabaseException(className, exceptionNam, exceptionDescription);
	}
}
