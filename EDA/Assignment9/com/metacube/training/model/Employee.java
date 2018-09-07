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
    private String skypeId;
    private String profilePhotoUrl;
    private String password;
    private boolean enabled;
    
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
	
	
}
    