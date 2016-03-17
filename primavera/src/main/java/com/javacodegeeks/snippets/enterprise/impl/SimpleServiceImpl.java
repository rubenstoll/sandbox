package com.javacodegeeks.snippets.enterprise.impl;

import com.javacodegeeks.snippets.enterprise.SimpleService;

/**
 * Created by tk3sy on 16.03.2016.
 */
public class SimpleServiceImpl implements SimpleService {

  private String name;

  private int id;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void printNameId() {
    System.out.println("SimpleService : Method printNameId() : My name is " + name + " and my id is " + id);
  }

  public void checkName() {
    if (name.length() < 20) {
      throw new IllegalArgumentException();
    }
  }

  public String sayHello(String message) {
    System.out.println("SimpleService : Method sayHello() : Hello! " + message);
    return message;
  }
}
