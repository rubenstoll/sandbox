package com.adam_bien.interceptors;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 * Created by tk3sy on 11.03.2016.
 */
@Interceptors(TracingInterceptor.class)
@Stateless
public class HelloWorldBean implements HelloWorld {

  public void sayHello() {
    System.out.println("Hello!");
  }
}