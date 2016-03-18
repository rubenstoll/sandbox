package com.apress.springrecipes.calculator.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by tk3sy on 18.03.2016.
 */
@Aspect
public class DummyAspect {

  @Pointcut("execution( public double kilogramToPound(..))")
  public void methodPointcut() {}

  @Before("methodPointcut()")
  public void aroundControllerMethod(JoinPoint joinPoint) throws Throwable {
    System.out.println("========================================");
  }


}
