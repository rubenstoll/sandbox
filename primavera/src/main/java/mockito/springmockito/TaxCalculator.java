package jpa.springmockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by tk3sy on 28.09.2015.
 */
@Component
public class TaxCalculator {

  @Autowired
  private TaxDao taxDao;

  public BigDecimal calculateTaxes(BigDecimal salary) {
    BigDecimal result = salary.multiply(taxDao.getTaxPercentageForYear(2014));
    // some other weird calculation ....
    return result;
  }
}
