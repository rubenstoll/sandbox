package com.journaldev.spring.service;

import com.journaldev.spring.model.Employee;

/**
 * Created by tk3sy on 11.03.2016.
 */
public class EmployeeService {

  private Employee employee;

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee e) {
    this.employee = e;
  }

}
