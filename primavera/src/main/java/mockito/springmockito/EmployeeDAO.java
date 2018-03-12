package jpa.springmockito;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by tk3sy on 28.09.2015.
 */
@Component
public class EmployeeDAO {

  public BigDecimal getAnnualSalary(long employeeId) {
    // conncetTODB
    // run select for employeeId;
    return new BigDecimal(70000);
  }
}
