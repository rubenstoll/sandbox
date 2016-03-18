package com.apress.springrecipes.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * Created by tk3sy on 18.03.2016.
 */
@Configuration
//@EnableSpringConfigured
//@EnableLoadTimeWeaving
//@EnableAspectJAutoProxy
@ImportResource("classpath:aop-config.xml")
public class ArithmeticConfiguration {

  @Bean
  public ArithmeticCalculator arithmeticCalculator() {
    return new ArithmeticCalculatorImpl();
  }

  @Bean
  public UnitCalculator unitCalculator() {
    return new UnitCalculatorImpl();
  }

//  @Bean
//  public CalculatorLoggingAspect calculatorLoggingAspect() {
//    return new CalculatorLoggingAspect();
//  }

}
