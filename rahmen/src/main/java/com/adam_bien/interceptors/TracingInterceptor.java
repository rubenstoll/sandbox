package com.adam_bien.interceptors;

/**
 * Created by tk3sy on 11.03.2016.
 */
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class TracingInterceptor {

  @AroundInvoke
  public Object logCall(InvocationContext context) throws Exception {
    System.out.println("Invoking method: " + context.getMethod());
    return context.proceed();
  }
}