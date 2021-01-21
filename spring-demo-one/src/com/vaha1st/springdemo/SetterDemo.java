package com.vaha1st.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemo {
public static void main(String[] args) {
		
		// load a spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");		
		
		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("MyCricketCoach", CricketCoach.class);

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		System.out.println("email: "+theCoach.getEmail()+", team: "+theCoach.getTeam());
		
		// close the context
		context.close();
	}
}
