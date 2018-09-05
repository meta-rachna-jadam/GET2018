package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] rugumentLis) {
    	
        ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
        SpellChecker spellChecker = (SpellChecker) factory.getBean("spellChecker");
        TextEditor textEditor = (TextEditor) factory.getBean("textEditor");
        System.out.println("By TextEditer reference "+textEditor.getSpellChecker().getStatus());
        System.out.println("By TextEditer reference "+textEditor.getSpellChecker().getState());
        System.out.println("By SpellChecker reference "+spellChecker.getStatus());
        System.out.println("By SpellChecker reference "+spellChecker.getState());
    }
}
