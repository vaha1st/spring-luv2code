package com.vaha1st.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vaha1st.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	
	
	// Use that pointcut for advices
	
	@Before("com.vaha1st.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
		// display the method signature
		System.out.println(joinPoint.getSignature());
		
		// display the method arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object o : args) {
			System.out.println(o.toString());
			
			if (o instanceof Account) {
				Account acc = (Account) o;
				System.out.println("Account name: "+acc.getName());
				System.out.println("Account level: "+acc.getLevel());
			}
		}
	}
	
	// Add a new advice for after returning
	@AfterReturning(
		pointcut="execution(* com.vaha1st.aopdemo.dao.AccountDAO.findAccounts(..))",
		returning="result"	
			)
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we advising on
		System.out.println(joinPoint.getSignature().toShortString());
		
		// print out the results of the method call
		System.out.println("Results: "+result );
		
		// modify return data
		
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);
		
		// print out the results after modifying
				System.out.println("Modified Results: "+result );
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		if (!result.isEmpty()) {
			
			for (Account acc : result) {
				acc.setName(acc.getName().toUpperCase());
			}
			
		}
	}
	
}
