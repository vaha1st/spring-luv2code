package com.vaha1st.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vaha1st.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from context
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call new method
		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("\n\nMain app: AfterReturningAppDemo\n----");
		System.out.println("Accounts: "+accounts);
		System.out.println("\n");

		// close the context
		context.close();
	}

}
