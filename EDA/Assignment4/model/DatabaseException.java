package com.model;

import com.controller.ExceptionController;

public class DatabaseException {
    private String className;
    private String exceptionName;
    private String exceptionDescription;
    
	public DatabaseException(String className, String exceptionName,
			String exceptionDescription) {
		
		this.setClassName(className);
		this.setExceptionName(exceptionName);
		this.setExceptionDescription(exceptionDescription);
		new ExceptionController().createExeption(this);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public String getExceptionDescription() {
		return exceptionDescription;
	}

	public void setExceptionDescription(String exceptionDescription) {
		this.exceptionDescription = exceptionDescription;
	}
    
}
