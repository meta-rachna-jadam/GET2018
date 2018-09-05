package com.metacube.training;

public class SpellChecker {
	
    public String status;
    public boolean state;  
    // true for On, false for Off
    
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
