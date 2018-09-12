package com.metacube.training.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class JobDetails {

    private int empCode;
    private int Id;
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date dateOfJoining;
    private int totalExperience;
    private int jobCode;
    private int reportingManagerId;
    private int teamLeaderId;
    private int currentProjectId;
    
	public int getEmpCode() {
		return empCode;
	}
	public int getId() {
		return Id;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public int getTotalExperience() {
		return totalExperience;
	}
	public int getJobCode() {
		return jobCode;
	}
	public int getReportingManagerId() {
		return reportingManagerId;
	}
	public int getTeamLeaderId() {
		return teamLeaderId;
	}
	public int getCurrentProjectId() {
		return currentProjectId;
	}
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	public void setReportingManagerId(int reportingManagerId) {
		this.reportingManagerId = reportingManagerId;
	}
	public void setTeamLeaderId(int teamLeaderId) {
		this.teamLeaderId = teamLeaderId;
	}
	public void setCurrentProjectId(int currentProjectId) {
		this.currentProjectId = currentProjectId;
	}
}
