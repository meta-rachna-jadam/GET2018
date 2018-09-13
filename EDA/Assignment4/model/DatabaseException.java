package com.model;

public class DatabaseException {
    private String className;
    private String exceptionNam;
    private String exceptionDescription;
    
	public DatabaseException(String className, String exceptionNam,
			String exceptionDescription) {
		
		this.className = className;
		this.exceptionNam = exceptionNam;
		this.exceptionDescription = exceptionDescription;
	}
    
}
