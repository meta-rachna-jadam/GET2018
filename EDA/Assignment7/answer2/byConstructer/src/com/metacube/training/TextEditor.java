package com.metacube.training;

public class TextEditor {

    private SpellChecker spellChecker;
    
    public TextEditor(SpellChecker spellChecker) {
		super();
		this.spellChecker = spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
        return spellChecker;
    }
}
