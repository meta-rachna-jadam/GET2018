package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
    @Bean
    public TextEditor textEditor() {
    	return new TextEditor(spellChecker());
    }
    
    @Bean
    public SpellChecker spellChecker() {
    	return new SpellChecker("Start",true);
    }

}
