package com.metacube.training.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity class map with jobDetails table of database
 * @author Rachna Jadam
 *
 */

@Entity
@Table(name = "jobDetails")
public class JobDetails {

	
	@Column(name = "emp_code")
	private int empCode;
    
    @Id
	@Column(name = "job_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "date_of_joining")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
    private Date dateOfJoining;
    
    @Column(name = "total_exp")
    private int totalExperience;
    
    @Column(name = "job_code")
    private int jobCode;
    
    @Column(name = "reporting_mgr")
    private int reportingManagerId;
    
    @Column(name = "team_lead")
    private int teamLeaderId;
    
    @Column(name = "curr_proj_id")
    private int currentProjectId;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_code", insertable = false, updatable = false)
    private Employee employee;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curr_proj_id", insertable = false, updatable = false)
    private Project project;
    
    @Override
	public String toString() {
		return "Job Detail [id=" + id + ", dateOfJoining=" + dateOfJoining + ", totalExperience="
				+ totalExperience + ", teamLeaderId=" + teamLeaderId + ", reportingManagerId="
				+ reportingManagerId +", currentProjectId"+ currentProjectId + "]";
	}
    
	public int getEmpCode() {
		return empCode;
	}
	public int getId() {
		return id;
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
		this.id = id;
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
