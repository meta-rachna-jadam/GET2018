package com.metacube.training;

public class SpellChecker {
	
    private String status;
    private boolean state;  
    // true for On, false for Off
    
    public SpellChecker() {
		// TODO Auto-generated constructor stub
	}
    
    public SpellChecker(String status, boolean state) {
        this.status = status;
        this.state = state;
    }
    
    public String getStatus() {
        return status;
    }
    
    public boolean getState() {
        return state;
    }

}
