package com.javacodegeeks.enterprise.ejb.interceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 * Created by tk3sy on 11.03.2016.
 */
@Stateless
@Interceptors(SimpleInterceptor.class)
public class SimpleEJB {

  public String printMessage(String message) {

    System.out.println(" Executing method : printMessage" + message);
    return "Message is " + message;
  }

}