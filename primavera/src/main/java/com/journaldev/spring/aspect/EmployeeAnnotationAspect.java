package com.journaldev.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by tk3sy on 11.03.2016.
 */
@Aspect
public class EmployeeAnnotationAspect {
  @Before("@annotation(com.journaldev.spring.aspect.Loggable)")
  public void myAdvice(){
    System.out.println("Executing myAdvice!!");
  }
}
