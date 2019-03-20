package math;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by tk3sy on 18.11.2015.
 */
public class MathGenius {

  public Float divideTwoNumber(BigDecimal one, BigDecimal two) {

    BigDecimal result = one.divide(two); //.setScale(2, RoundingMode.CEILING);
    return Float.parseFloat(result.movePointRight(2).toString());
  }

  public BigDecimal divide(BigDecimal one, BigDecimal two) {

    double calc = one.doubleValue() / two.doubleValue();
    DecimalFormat df = new DecimalFormat("0.00");

    BigDecimal result = null;//BigDecimal.valueOf(calc).setScale(2);
    //BigDecimal result = one.divide(two);//.setScale(2, RoundingMode.CEILING);

    return result;
  }

  public BigDecimal divideNformat(BigDecimal one, BigDecimal two) {

    DecimalFormat myFormatter = new DecimalFormat(".####");
    String output = myFormatter.format(one.doubleValue() / two.doubleValue());

    BigDecimal result = BigDecimal.valueOf(Double.parseDouble(output)).movePointRight(2);

    return result;

  }

  public List<Integer> generateRandomNumber() {

    Random random = new Random();
    List<Integer> numbers = random.ints(1, 100).limit(10).boxed().collect(Collectors.toList());

    return numbers;
  }
}
