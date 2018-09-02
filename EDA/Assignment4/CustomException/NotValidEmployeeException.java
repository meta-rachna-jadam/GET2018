package com.CustomException;

import com.model.DatabaseException;

public class NotValidEmployeeException extends Exception {

	public NotValidEmployeeException(String className, String exceptionNam, String exceptionDescription) {
	    new DatabaseException(className, exceptionNam, exceptionDescription);
	}
}
