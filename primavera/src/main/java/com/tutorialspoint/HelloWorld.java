package com.tutorialspoint;

/**
 * Created by tk3sy on 16.02.2016.
 *
 * http://www.tutorialspoint.com/spring/spring_hello_world_example.htm
 */
public class HelloWorld {

  private String message;

  public void setMessage(String message) {
    this.message = message;
  }

  public void getMessage() {
    System.out.println("Your Message : " + message);
  }
}
