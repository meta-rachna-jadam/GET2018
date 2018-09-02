package com.model;

public class LoginInformation {
    
	private final String emailId;
	private final String password;
	
	public LoginInformation(String emailId, String password) {
	    this.emailId = emailId;
	    this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPassword() {
		return password;
	}
}
