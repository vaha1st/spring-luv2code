package com.vaha1st.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vaha1st.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from context
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain app ... AroundDemoApp");
		
		System.out.println("Calling getfortune()");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("My fortune is: "+data);
		
		

		// close the context
		context.close();
	}

}
