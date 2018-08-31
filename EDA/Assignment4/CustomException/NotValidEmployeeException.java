package com.CustomException;

public class NotValidEmployeeException extends Exception {

	private String exception;

	public NotValidEmployeeException(String exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return exception;
	}
    
}
