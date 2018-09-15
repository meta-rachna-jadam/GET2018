package com.metacube.training.model;

import java.util.Date;

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

@Entity
@Table(name = "jobDetails")
public class JobDetails {

	/*@OneToOne
    @JoinColumn(name="emp_code")*/
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
    
    /*@OneToOne
    @JoinColumn(name="job_code")*/
    @Column(name = "job_code")
    private int jobCode;
    
    /*@OneToOne
    @JoinColumn(name="reporting_mgr")*/
    @Column(name = "reporting_mgr")
    private int reportingManagerId;
    
    /*@OneToOne
    @JoinColumn(name="team_lead")*/
    @Column(name = "team_lead")
    private int teamLeaderId;
    
    /*@OneToOne
    @JoinColumn(name="curr_proj_id")*/
    @Column(name = "curr_proj_id")
    private int currentProjectId;
    
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