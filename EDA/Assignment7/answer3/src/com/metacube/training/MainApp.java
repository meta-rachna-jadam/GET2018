package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] arguments) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CollectionInjectionImplementation collectionInjectionImplementation = 
            (CollectionInjectionImplementation)context.getBean("collectionInjectionImplementation");

        collectionInjectionImplementation.getCategoryList();
        collectionInjectionImplementation.getCategorySet();
        collectionInjectionImplementation.getCategoryMap();
    }
}
