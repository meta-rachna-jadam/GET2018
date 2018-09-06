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
    public TextEditor textEditor() {
    	return new TextEditor();
    }
    
    @Bean
    public SpellChecker spellChecker() {
    	SpellChecker spellChecker = new SpellChecker();
    	spellChecker.setStatus("Start");
    	spellChecker.setState(true);
    	return spellChecker;
    }

}
