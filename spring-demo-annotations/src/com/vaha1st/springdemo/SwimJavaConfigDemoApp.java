package com.vaha1st.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// use java configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//Coach homeworkCoach = context.getBean("freakingCoach", Coach.class);
		
		// call methods
		System.out.println(theCoach.getDailyWorkout());
		//System.out.println(homeworkCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		context.close();
		
	}

}
