package com.model;

public class Advertisement {
	
    private int id;
    private String title;
    private String description;
    private int categoryId;
    
    public Advertisement(String title, String description, int categoryId) {
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
    }
    
    public Advertisement(int id, String title, String description, int categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
