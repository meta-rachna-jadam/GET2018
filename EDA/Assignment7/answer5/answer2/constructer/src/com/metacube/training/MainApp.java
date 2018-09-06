package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] rugumentLis) {
    	
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        System.out.println("By TextEditer reference "+textEditor.getSpellChecker().getStatus());
        System.out.println("By TextEditer reference "+textEditor.getSpellChecker().getState());
    }
}
