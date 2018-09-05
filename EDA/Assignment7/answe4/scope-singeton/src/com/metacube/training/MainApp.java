package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
    public static void main(String[] aruments) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	Shape shapeInstance = (Shape)context.getBean("shape");
    	System.out.println("Before change instance1 "+shapeInstance.getType());
    	
    	Shape shapeInstance2 = (Shape)context.getBean("shape");
    	shapeInstance2.setType("Trainge");
    	System.out.println("instance2 "+shapeInstance2.getType());
    	System.out.println("After change instance1 "+shapeInstance.getType());
    }

}
