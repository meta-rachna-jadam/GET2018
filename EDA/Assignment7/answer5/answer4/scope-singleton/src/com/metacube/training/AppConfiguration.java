package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * A configuration class which define all configuration required to create 
 * object by BeanFactory or ApplicationContext  
 * @author Rachna Jadam
 *
 */
@Configuration
public class AppConfiguration {
	
    @Bean
    public Shape shape() {
    	Shape shape = new Shape();
        shape.setType("Circle");
        return shape;
    }
}
