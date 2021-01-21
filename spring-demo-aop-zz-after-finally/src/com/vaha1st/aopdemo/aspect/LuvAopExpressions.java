package com.vaha1st.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

	// Declare pointcuts
	
		@Pointcut("execution(* com.vaha1st.aopdemo.dao.*.*(..))")
		public void forDaoPackage() {}
		
		@Pointcut("execution(* get*())")
		public void getter() {}
		
		@Pointcut("execution(* set*(..))")
		public void setter() {}
		
		// Combination of pointcuts with && || !
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		public void forDaoPackageNoGetterSetter() {}
}
