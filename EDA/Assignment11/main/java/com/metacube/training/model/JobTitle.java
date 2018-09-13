package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobTitle")
public class JobTitle {

	@Id
	@Column(name = "job_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobCode;
	
	@Column(name = "job_title")
    private String jobTitle;
	
	@Override
	public String toString() {
		return "Job Title [jobCode=" + jobCode + ", jobTitle=" + jobTitle + "]";
	}
    
	public int getJobCode() {
		return jobCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
}
