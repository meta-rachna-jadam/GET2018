package com.metacube.training.model;

import java.util.Date;

public class Project {

    private int id;
    private String description;
    private Date startDate;
    private Date endDate;
    private String projectLogoUrl;
    
	public Project(int id, String description, Date startDate, Date endDate,
			String projectLogoUrl) {
		super();
		this.id = id;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectLogoUrl = projectLogoUrl;
	}
	
	public Project(String description, Date startDate, Date endDate,
			String projectLogoUrl) {
		super();
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectLogoUrl = projectLogoUrl;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public String getProjectLogoUrl() {
		return projectLogoUrl;
	}
}
