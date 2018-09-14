package com.metacube.training.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity class map with employee table of database
 * @author Rachna Jadam
 *
 */

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "emp_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "first_name")
    private String firstName;
	
	@Column(name = "middle_name")
    private String middelName;
	
	@Column(name = "dob")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
    private Date dob;
	
	@Column(name = "gender")
    private String gender;
	
	@Column(name = "primary_contact_no")
    private String primaryContactNumber;
	
	@Column(name = "secondary_contact_no")
    private String secondaryContactNumber;
	
	@Column(name = "email_id")
    private String emailId;
    //email id use as username
    
	@Column(name = "skype_id")
    private String skypeId;
	
	@Column(name = "profile_picture")
    private String profilePhotoUrl;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "enabled")
    private boolean enabled;
    
    @Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", middelName="
				+ middelName + ", dob=" + dob + ", gender="
				+ gender +", primaryContactNumber"+ primaryContactNumber+ ", secondaryContactNumber"+
				secondaryContactNumber + ", emailId" + emailId + ", skypeId"+ skypeId + 
				", profilePhotoUrl" + profilePhotoUrl + ", password" + password + ", enabled" +
				enabled + "]";
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
    