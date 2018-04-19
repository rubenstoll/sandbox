package com.javacodegeeks.snippets.enterprise;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring config
 */
@Configuration
public class App {

  public static void main(String[] args) {

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
    SimpleService simpleService = (SimpleService) context.getBean("simpleServiceBean");
    simpleService.printNameId();
    System.out.println("---------------");
    try {
      simpleService.checkName();
    } catch (Exception e) {
      System.out.println("SimpleService checkName() : Exception thrown..");
    }
    System.out.println("---------------");
    simpleService.sayHello("Javacodegeeks");
    System.out.println("---------------");
    context.close();
  }
}
