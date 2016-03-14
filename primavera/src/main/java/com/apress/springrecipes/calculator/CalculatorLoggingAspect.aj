package com.apress.springrecipes.calculator;

import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by tk3sy on 14.03.2016.
 */

@Aspect
@Component
public class CalculatorLoggingAspect {

  private Log log = LogFactory.getLog(this.getClass());

  @Before("execution(* ArithmeticCalculator.add(..))")
  public void logBefore() {
    log.info("The method add() begins");
  }

  @Before("execution(* *.*(..))")
  public void logBefore(JoinPoint joinPoint) {
    log.info("The method " + joinPoint.getSignature().getName()
        + "() begins with " + Arrays.toString(joinPoint.getArgs()));
  }

}
