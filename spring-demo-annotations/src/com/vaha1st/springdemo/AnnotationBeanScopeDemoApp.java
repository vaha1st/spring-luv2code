package com.vaha1st.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// retrieve bean from context
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		
		// check if they are same
		System.out.println("\nPointing to the same object: "+(theCoach == alphaCoach));
		System.out.println("\n"+theCoach+" vs "+alphaCoach+"\n");
		
		// close context
		context.close();
	}

}
