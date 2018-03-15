package mockito.springmockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * tax calculator
 */
@Component
public class TaxCalculator {

  @Autowired
  private jpa.springmockito.TaxDao taxDao;

  public BigDecimal calculateTaxes(BigDecimal salary) {
    // some other weird calculation ....
    return salary.multiply(taxDao.getTaxPercentageForYear(2014));
  }
}
