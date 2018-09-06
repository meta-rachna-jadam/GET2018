package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
    @Bean
    public TextEditor textEditor() {
    	TextEditor textEditor = new TextEditor();
        textEditor.setSpellChecker(spellChecker());
    	return textEditor;
    }
    
    @Bean
    public SpellChecker spellChecker() {
    	SpellChecker spellChecker = new SpellChecker();
    	spellChecker.setStatus("Start");
    	spellChecker.setState(true);
    	return spellChecker;
    }

}
