package math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by tk3sy on 14.04.2016.
 */
public class MathExerciseMain {

  public static void main(String[] args) {

    doRounding();

  }

  private static void doRounding() {

    BigDecimal myNum = new BigDecimal("333.336333");

    System.out.println("precision: " + myNum.precision());

    // myNum.setScale(2);
    BigDecimal roundedNum = myNum.round(new MathContext(3));
    System.out.println(roundedNum);

    BigDecimal scaled = myNum.setScale(2, RoundingMode.HALF_UP);
    System.out.println(scaled);
  }

}
