package com.vaha1st.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {

		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beanLifecycle-applicationContext.xml");

		// retrieve the bean
		Coach theCoach = context.getBean("myCoach", Coach.class);
		System.out.println(theCoach.getDailyFortune());

		// close context
		context.close();
	}

}
 