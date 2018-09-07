package com.metacube.training.model;

public class InvalidFieldException extends CustomException {

	public InvalidFieldException(String className, String name, String description) {
		super(className, name, description);
	}
}
