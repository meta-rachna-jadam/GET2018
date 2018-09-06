package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] arguments) {
        ApplicationContext context =  new AnnotationConfigApplicationContext(AppConfiguration.class);
        CollectionInjectionImplementation collectionInjectionImplementation = 
            (CollectionInjectionImplementation)context.getBean("collectionInjectionImplementation");

        collectionInjectionImplementation.getCategoryList();
        collectionInjectionImplementation.getCategorySet();
        collectionInjectionImplementation.getCategoryMap();
    }
}