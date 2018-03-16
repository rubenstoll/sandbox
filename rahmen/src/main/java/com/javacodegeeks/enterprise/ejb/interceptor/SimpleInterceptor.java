package com.javacodegeeks.enterprise.ejb.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * https://www.javacodegeeks.com/2013/07/java-ee-ejb-interceptors-tutorial-and-example.html
 */
public class SimpleInterceptor {

  @AroundInvoke
  public Object intercept(InvocationContext context) throws Exception {

    System.out.println("SimpleInterceptor - Logging BEFORE calling method :" + context.getMethod().getName());

    Object result = context.proceed();

    System.out.println("SimpleInterceptor - Logging AFTER calling method :" + context.getMethod().getName());

    System.out.println("SimpleInterceptor - Logging again AFTER calling method :" + context.getMethod().getName());
    return result;
  }

}
