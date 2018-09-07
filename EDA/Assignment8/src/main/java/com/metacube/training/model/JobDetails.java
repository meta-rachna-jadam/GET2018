package com.metacube.training.model;

import java.util.Date;

public class JobDetails {

    private int empCode;
    private int Id;
    private Date dateOfJoining;
    private int totalExperience;
    private int jobCode;
    private int reportingManagerId;
    private int teamLeaderId;
    private int currentProjectId;
    
	public JobDetails(int empCode, int id, Date dateOfJoining,
			int totalExperience, int jobCode, int reportingManagerId,
			int teamLeaderId, int currentProjectId) {
		super();
		this.empCode = empCode;
		Id = id;
		this.dateOfJoining = dateOfJoining;
		this.totalExperience = totalExperience;
		this.jobCode = jobCode;
		this.reportingManagerId = reportingManagerId;
		this.teamLeaderId = teamLeaderId;
		this.currentProjectId = currentProjectId;
	}

	public JobDetails(int empCode, Date dateOfJoining, int totalExperience,
			int jobCode, int reportingManagerId, int teamLeaderId,
			int currentProjectId) {
		super();
		this.empCode = empCode;
		this.dateOfJoining = dateOfJoining;
		this.totalExperience = totalExperience;
		this.jobCode = jobCode;
		this.reportingManagerId = reportingManagerId;
		this.teamLeaderId = teamLeaderId;
		this.currentProjectId = currentProjectId;
	}

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
}
