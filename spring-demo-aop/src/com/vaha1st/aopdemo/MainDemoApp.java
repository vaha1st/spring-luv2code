package com.vaha1st.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vaha1st.aopdemo.dao.AccountDAO;
import com.vaha1st.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from context
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account account = new Account();
		accountDAO.addAccount(account, true);
		
		membershipDAO.addSillyMember();
		
		accountDAO.doWork();
		
		membershipDAO.goToSleep();

		// close the context
		context.close();
	}

}
