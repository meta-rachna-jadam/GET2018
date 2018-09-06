package com.metacube.training;

public class SpellChecker {
	
    private String status;
    private boolean state;  
    // true for On, false for Off
    
    public void setStatus(String status) {
		this.status = status;
	}


	public void setState(boolean state) {
		this.state = state;
	}


	public String getStatus() {
        return status;
    }
    
    public boolean getState() {
        return state;
    }

}
