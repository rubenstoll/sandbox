package com.apress.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * http://proquest.techbus.safaribooksonline.de/book/programming/java/9781430265337
*/
public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new GenericXmlApplicationContext("beans.xml");

    SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");

    System.out.println(generator.getSequence());
    System.out.println(generator.getSequence());
  }
}