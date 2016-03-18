package com.apress.springrecipes.calculator.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by tk3sy on 18.03.2016.
 */
@Aspect
public class SomeAspect {

  @Before("execution(public double add(..))")
  public void doubleAdvice(){
    System.out.println("Executing Advice on_---=================================");
  }
}
