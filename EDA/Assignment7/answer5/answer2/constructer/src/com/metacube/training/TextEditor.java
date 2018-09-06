package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

    private SpellChecker spellChecker;
    
    @Autowired
    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }
    
    
    public SpellChecker getSpellChecker() {
        return spellChecker;
    }
}
