package math;

import java.math.BigDecimal;

/**
 * Created by tk3sy on 18.11.2015.
 */
public class MathGenius {

  public Float divideTwoNumber(BigDecimal one, BigDecimal two) {

    BigDecimal result = one.divide(two);
    return Float.parseFloat(result.movePointRight(2).toString());
  }

}
