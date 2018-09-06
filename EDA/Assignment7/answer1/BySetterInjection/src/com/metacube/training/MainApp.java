package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] rugumentLis) {
    	
        ApplicationContext contex = new ClassPathXmlApplicationContext("beans.xml");
        TextEditor textEditor = (TextEditor) contex.getBean("textEditor");
        System.out.println("By TextEditer reference "+textEditor.getSpellChecker().getStatus());
        System.out.println("By TextEditer reference "+textEditor.getSpellChecker().getState());
    }
}
