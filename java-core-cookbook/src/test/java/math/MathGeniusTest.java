package math;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by tk3sy on 18.11.2015.
 */
public class MathGeniusTest {

  @Test
  public void testDivideTwoNumber() throws Exception {

    MathGenius mg = new MathGenius();

    Float result = mg.divideTwoNumber(new BigDecimal(1), new BigDecimal(2));
    assertEquals("Expected", new Float(50), result);

    BigDecimal resultBd = mg.divide(new BigDecimal(1), new BigDecimal(3));
    // assertEquals("Expected big decimal result", BigDecimal.valueOf(.33d), resultBd);

    resultBd = mg.divideNformat(new BigDecimal(1), new BigDecimal(3));
    assertEquals("Expected big decimal result", BigDecimal.valueOf(33.33d), resultBd);

    resultBd = mg.divideNformat(new BigDecimal(555), new BigDecimal(9));
    // assertEquals("Expected big decimal result", BigDecimal.valueOf(33.33d), resultBd);

  }
}