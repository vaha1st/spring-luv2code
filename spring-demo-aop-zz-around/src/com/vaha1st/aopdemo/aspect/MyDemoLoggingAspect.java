package com.vaha1st.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	// Add an advice for after throwing
	@AfterThrowing(
			pointcut="execution(* com.vaha1st.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
		
		// print which method throwing an exception
		System.out.println("\n=====>>> Executing @AfterThrowing advice on method: "+joinPoint.getSignature().toShortString());

		// log the exception
		System.out.println("\nThe exception is: "+theExc);
		
	}
	
	// Add an advice for after finally
	@After("execution(* com.vaha1st.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		System.out.println("\n=====>>> Executing @After (finally) advice on method: "+joinPoint.getSignature().toShortString());
		
		
		
	}
	
	// Add an advice for around
	@Around("execution(* com.vaha1st.aopdemo.service.*.getFortune())")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print out which method we advising on
		System.out.println("\n=====>>> Executing @Around advice on method: "+proceedingJoinPoint.getSignature().toShortString());
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
				
		// execute the method
		Object result = proceedingJoinPoint.proceed();
		
		// get finish timestamp
		long end = System.currentTimeMillis();
		
		// compute duration
		System.out.println("\n====>Duration: "+(end-begin)/1000.0+"seconds");
		
		return result;
	}
	
	

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		if (!result.isEmpty()) {
			
			for (Account acc : result) {
				acc.setName(acc.getName().toUpperCase());
			}
			
		}
	}
	
}
