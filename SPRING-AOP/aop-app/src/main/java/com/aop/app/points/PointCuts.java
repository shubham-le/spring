package com.aop.app.points;

import org.aspectj.lang.annotation.Pointcut;

public interface PointCuts {

	@Pointcut("execution(* com.aop.app.api.Api.*(..))")
	default void eachApi() {};
	
	@Pointcut("execution(* com.aop.app.api.Api.getUser*(..))")
	default void userApi() {};
}
