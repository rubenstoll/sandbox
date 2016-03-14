package com.journaldev.spring.model;

import com.journaldev.spring.aspect.Loggable;

/**
 * http://www.journaldev.com/2583/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations-xml-configuration
 */
public class Employee {

  private String name;

  public String getName() {
    return name;
  }

  @Loggable
  public void setName(String nm) {
    this.name = nm;
  }

  public void throwException() {
    throw new RuntimeException("Dummy Exception");
  }

}
