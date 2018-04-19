package com.apress.springrecipes.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *
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
