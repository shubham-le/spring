package com.aop.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.aop.app.points.PointCuts;

@Aspect
@Component
public class FunctionAspects implements PointCuts {

	@Before("execution(public String live())")
	public void onEachRequest() {
		System.out.println("Befor executing live()");
	}

	@Before("within(com.aop.app.api.Api)")
	public void onEachRequest(JoinPoint joinPoint) {
		System.out.println("within(com.aop.app.api.Api): %s:".formatted(joinPoint));
	}

	@Before("eachApi()")
	public void before(JoinPoint joinPoint) {
		System.out.println("PointCut eachApi(): " + joinPoint);
	}

	@AfterReturning("eachApi()")
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println(joinPoint + " Returning..");
	}
	
	@Before("userApi()")
	public void beforEachUserApi(JoinPoint joinPoint) {
		System.out.println("PointCut userApi(): " + joinPoint);
	}
	
//	@AfterReturning("args(name)")
//	public void argId(String name) {
//		System.out.println("PointCut argId(): " + name);
//	}
}
