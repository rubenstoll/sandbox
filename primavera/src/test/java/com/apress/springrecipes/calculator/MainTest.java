package com.apress.springrecipes.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by tk3sy on 14.03.2016.
 */
public class MainTest {

  public static void main(String[] args) {

    // ApplicationContext context = new GenericXmlApplicationContext("appContext.xml");

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ArithmeticConfiguration.class);
//    context.register({"ArithmeticCalculator.class","ArithmeticConfiguration.class"});
//    context.refresh();
//    context.scan("com.apress.springrecipes.calculator");

    ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) context.getBean("arithmeticCalculator");
    arithmeticCalculator.add(1, 2);
    arithmeticCalculator.sub(4, 3);
    arithmeticCalculator.mul(2, 3);
    arithmeticCalculator.div(4, 2);

     UnitCalculator unitCalculator = (UnitCalculator) context.getBean("unitCalculator");
     unitCalculator.kilogramToPound(10);
     unitCalculator.kilometerToMile(5);
  }

}
