package com.journaldev.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.journaldev.spring.model.Employee;
import com.journaldev.spring.service.EmployeeService;

/**
 * Created by tk3sy on 11.03.2016.
 */
public class SpringMain {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

//    System.out.println(employeeService.getEmployee().getName());
//
//    employeeService.getEmployee().setName("Pankaj");
//
//    employeeService.getEmployee().throwException();

    Employee employee = employeeService.getEmployee();

    employee.getName();

    ctx.close();
  }
}
