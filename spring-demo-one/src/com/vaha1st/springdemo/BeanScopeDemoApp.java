package com.vaha1st.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beanScope-applicationContext2.xml");

		// retrieve the bean
		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check if they are the same
		boolean isSame = (theCoach == alphaCoach);
		System.out.println("\n"+isSame);
		
		System.out.println("\nMemory loction for theCoach: "+theCoach);
		System.out.println("\nMemory loction for alphaCoach: "+alphaCoach+"\n");


		// close context
		context.close();
	}

}
