package com.vaha1st.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// use java configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//Coach homeworkCoach = context.getBean("freakingCoach", Coach.class);
		
		// call methods
		System.out.println(theCoach.getDailyWorkout());
		//System.out.println(homeworkCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		context.close();
		
	}

}
