package com.javacodegeeks.snippets.enterprise.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by tk3sy on 16.03.2016.
 */
@Aspect
public class DoBeforeAspect {

  @Before("execution(* com.javacodegeeks.snippets.enterprise.SimpleService.sayHello(..))")
  public void doBefore(JoinPoint joinPoint) {

    System.out.println("***AspectJ*** DoBefore() is running!! intercepted : " + joinPoint.getSignature().getName());
  }
}
