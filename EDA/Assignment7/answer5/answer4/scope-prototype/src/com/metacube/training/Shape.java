package com.metacube.training;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Shape {
	
    private String type;
    
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}