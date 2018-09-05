package com.model;

public class CustemException {
    private String className;
    private String exceptionName;
    private String exceptionDescription;
    
	public CustemException(String className, String exceptionName,
			String exceptionDescription) {
		
		this.setClassName(className);
		this.setExceptionName(exceptionName);
		this.setExceptionDescription(exceptionDescription);
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
