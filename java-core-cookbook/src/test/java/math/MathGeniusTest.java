package math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;

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

  @Test
  public void randomNumberGenerator() {

    MathGenius mathGenius = new MathGenius();
    List<Integer> numbers = mathGenius.generateRandomNumber();
    assertThat(numbers, hasSize(10));

  }
}