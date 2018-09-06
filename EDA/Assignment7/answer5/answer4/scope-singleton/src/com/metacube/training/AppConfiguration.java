package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
    @Bean
    public Shape shape() {
    	Shape shape = new Shape();
        shape.setType("Circle");
        return shape;
    }
}
