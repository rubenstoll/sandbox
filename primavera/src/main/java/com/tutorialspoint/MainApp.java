package com.tutorialspoint;

/**
 * Created by tk3sy on 16.02.2016.
 */
public class MainApp {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

    obj.getMessage();
  }
}
