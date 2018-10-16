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

    randomExample();

    randomExample2();

    compareNumbers();

  }

  private static void compareNumbers() {

    Integer a = 10;
    Integer b = 10;
    System.out.println(a == b); // prints true
    // compares reference returns false

    Integer c = new Integer(10);
    Integer d = new Integer(10);

    System.out.println(c == d); // prints false

    // ******************** next example
    Integer x = 10;
    Integer y = 10;

    if ((x == y)) {
      System.out.println("comparing references results in true for some reason - autoboxing causes the effect");
    }

    if (x.intValue() == y.intValue()) {
      System.out.println("number equal");
    }

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

  private static void randomExample() {

    Double number = Math.random() * 5;

    System.out.println("number is: " + number);

  }

  private static void randomExample2() {

    Double number = Math.random() * 5;

    System.out.println("number is: " + number);

  }

}
