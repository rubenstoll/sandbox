package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by tk3sy on 16.02.2016.
 */
public class
MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

//        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloWorld", HelloWorld.class);

        obj.getMessage();
    }
}
