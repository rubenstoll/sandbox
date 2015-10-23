package com.marco.springmockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by tk3sy on 28.09.2015.
 */
@Component
public class SalaryService {
  private static final BigDecimal minimumSalary = new BigDecimal(20000);

  @Autowired
  private EmployeeDAO employeeDAO;

  @Autowired
  private TaxCalculator taxCalculator;

  public BigDecimal getNetSalary(long employeeId) {
    BigDecimal netSalary = null;
    BigDecimal grossSalary = employeeDAO.getAnnualSalary(employeeId);
    BigDecimal taxes = taxCalculator.calculateTaxes(grossSalary);
    if (taxedSalaryIsGreaterThanMinimumSalary(grossSalary)) {
      netSalary = grossSalary.subtract(taxes);
    } else {
      netSalary = grossSalary;
    }

    return netSalary;
  }

  private boolean taxedSalaryIsGreaterThanMinimumSalary(BigDecimal taxedSalary) {
    return taxedSalary.compareTo(minimumSalary) == 1;
  }
}
