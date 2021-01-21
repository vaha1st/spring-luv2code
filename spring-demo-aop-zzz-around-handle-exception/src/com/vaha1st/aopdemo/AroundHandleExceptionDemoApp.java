package com.vaha1st.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vaha1st.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from context
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain app ... AroundDemoApp");
		
		myLogger.info("Calling getfortune()");
		
		boolean tripWire = true;
		
		String data = trafficFortuneService.getFortune(tripWire);
		
		myLogger.info("My fortune is: "+data);
		
		

		// close the context
		context.close();
	}

}
