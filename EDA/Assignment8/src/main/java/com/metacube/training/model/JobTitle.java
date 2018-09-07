package com.metacube.training.model;

public class JobTitle {

    private int jobCode;
    private String jobTitle;
    
	public JobTitle(int jobCode, String jobTitle) {
		this.jobCode = jobCode;
		this.jobTitle = jobTitle;
	}
	public JobTitle(String jobTitle) {
		super();
		this.jobTitle = jobTitle;
	}
	public int getJobCode() {
		return jobCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
}
