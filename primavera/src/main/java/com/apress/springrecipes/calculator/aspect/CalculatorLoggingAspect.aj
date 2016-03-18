package com.apress.springrecipes.calculator.aspect;


import org.aspectj.lang.annotation.Aspect;

/**
 * Created by tk3sy on 14.03.2016.
 */

@Aspect
public class CalculatorLoggingAspect {

//  private Log log = LogFactory.getLog(this.getClass());

//  @Before("execution(* com.apress.springrecipes.calculator.ArithmeticCalculator.add(..))")
//  public void logBefore() {
//    System.out.println("+++++++++++++++++++++++The method add() begins");
////    log.info("+++++++++++++++++++++++The method add() begins");
//  }
//
//  @Before("execution(* *.*(..))")
//  public void logBefore(JoinPoint joinPoint) {
//
////    log.info("********************** The method " + joinPoint.getSignature().getName()
////        + "() begins with " + Arrays.toString(joinPoint.getArgs()));
//  }
//
//  @After("execution(public * *(..))")
//  public void anyPublic() {
//    System.out.println("?????????????????????????????????????????????????????");
////    log.info("?????????????????????????????????????????????????????");
//
//  }
//
//  @After("execution(* *.*(..))")
//  public void logAfter(JoinPoint joinPoint) {
////    log.info("The method " + joinPoint.getSignature().getName()
////        + "() ends");
//  }
//
//  @AfterReturning("execution(* *.*(..))")
//  public void logAfterReturning(JoinPoint joinPoint) {
////    log.info("The method " + joinPoint.getSignature().getName()
////        + "() ends");
//  }

}
