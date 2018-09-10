package com.metacube.training.model;

import java.util.Date;

public class Employee {

    private int id;
    private String firstName;
    private String middelName;
    private Date dob;
    private String gender;
    private String primaryContactNumber;
    private String secondaryContactNumber;
    private String emailId;
    //email id use as username
    
    private String skypeId;
    private String profilePhotoUrl;
    private String password;
    private boolean enabled;
    private int[] skills;
    private Date dateOfJoining;
    private int totalExperience;
    private int jobCode;
    private int reportingManagerId;
    private int teamLeaderId;
    private int currentProjectId;
    private String role;
    
    
    public Employee(String firstName, String middelName, Date dob, String gender, String primaryContactNumber,
			String secondaryContactNumber, String emailId, String skypeId, String profilePhotoUrl, String password,
			boolean enabled, int[] skills, Date dateOfJoining, int totalExperience, int jobCode,
			int reportingManagerId, int teamLeaderId, int currentProjectId, String role) {
    	
		this.firstName = firstName;
		this.middelName = middelName;
		this.dob = dob;
		this.gender = gender;
		this.primaryContactNumber = primaryContactNumber;
		this.secondaryContactNumber = secondaryContactNumber;
		this.emailId = emailId;
		this.skypeId = skypeId;
		this.profilePhotoUrl = profilePhotoUrl;
		this.password = password;
		this.enabled = enabled;
		this.skills = skills;
		this.dateOfJoining = dateOfJoining;
		this.totalExperience = totalExperience;
		this.jobCode = jobCode;
		this.reportingManagerId = reportingManagerId;
		this.teamLeaderId = teamLeaderId;
		this.currentProjectId = currentProjectId;
		this.role = role;
	}

	public Employee(int id, String firstName, String middelName, Date dob,
			String gender, String primaryContactNumber,
			String secondaryContactNumber, String emailId, String skypeId,
			String profilePhotoUrl, String password, boolean enabled) {
		
		if (id < 0 || firstName.length() == 0 || dob == null || gender.length() == 0 || primaryContactNumber.length() == 0 ||
				emailId.length() == 0 || profilePhotoUrl == null || password.length() == 0) {
		    	
		}
		
		this.id = id;
		this.firstName = firstName;
		this.middelName = middelName;
		this.dob = dob;
		this.gender = gender;
		this.primaryContactNumber = primaryContactNumber;
		this.secondaryContactNumber = secondaryContactNumber;
		this.emailId = emailId;
		this.skypeId = skypeId;
		this.profilePhotoUrl = profilePhotoUrl;
		this.password = password;
		this.enabled = enabled;
	}

	public Employee(String firstName, String middelName, Date dob,
			String gender, String primaryContactNumber,
			String secondaryContactNumber, String emailId, String skypeId,
			String profilePhotoUrl, String password, boolean enabled) {
		
		if (firstName.length() == 0 || dob == null || gender.length() == 0 || primaryContactNumber.length() == 0 ||
				emailId.length() == 0 || profilePhotoUrl == null || password.length() == 0) {
		    	
		}
		
		this.firstName = firstName;
		this.middelName = middelName;
		this.dob = dob;
		this.gender = gender;
		this.primaryContactNumber = primaryContactNumber;
		this.secondaryContactNumber = secondaryContactNumber;
		this.emailId = emailId;
		this.skypeId = skypeId;
		this.profilePhotoUrl = profilePhotoUrl;
		this.password = password;
		this.enabled = enabled;
	}

    public Employee(int id, String firstName, String middleName, java.sql.Date dob, String gender, String primaryContactNumber,
        String secondaryContactNumber, String emailId, String skipeId, String profilePhotoUrl) {
    	
        this.id = id;
        this.firstName = firstName;
        this.middelName = middleName;
        this.dob = dob;
        this.gender = gender;
        this.primaryContactNumber = primaryContactNumber;
        this.secondaryContactNumber = secondaryContactNumber;
        this.emailId = emailId;
        this.skypeId = skipeId;
        this.profilePhotoUrl = profilePhotoUrl;
    }

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddelName() {
		return middelName;
	}

	public Date getDob() {
		return dob;
	}

	public String getGender() {
		return gender;
	}

	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}

	public String getSecondaryContactNumber() {
		return secondaryContactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public String getProfilePhotoUrl() {
		return profilePhotoUrl;
	}

	public String getPassword() {
		return password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public int[] getSkills() {
		return skills;
	}

	public void setSkills(int[] skills) {
		this.skills = skills;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public int getJobCode() {
		return jobCode;
	}

	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}

	public int getReportingManagerId() {
		return reportingManagerId;
	}

	public void setReportingManagerId(int reportingManagerId) {
		this.reportingManagerId = reportingManagerId;
	}

	public int getTeamLeaderId() {
		return teamLeaderId;
	}

	public void setTeamLeaderId(int teamLeaderId) {
		this.teamLeaderId = teamLeaderId;
	}

	public int getCurrentProjectId() {
		return currentProjectId;
	}

	public void setCurrentProjectId(int currentProjectId) {
		this.currentProjectId = currentProjectId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getUserName() {
		return emailId;
	}
}
    
