package com.vaha1st.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.vaha1st.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloud() {
		System.out.println("\n=====>>> Perform logging to cloud");
	}
}
