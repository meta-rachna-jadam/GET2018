package com.metacube.training.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {

    private int id;
    private String firstName;
    private String middelName;
    @DateTimeFormat(pattern= "yyyy-MM-dd")
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
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMiddelName(String middelName) {
		this.middelName = middelName;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}
	public void setSecondaryContactNumber(String secondaryContactNumber) {
		this.secondaryContactNumber = secondaryContactNumber;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public void setProfilePhotoUrl(String profilePhotoUrl) {
		this.profilePhotoUrl = profilePhotoUrl;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
    
