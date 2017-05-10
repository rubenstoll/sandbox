package generics.javatutorial;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class BoxTest {

  static Logger LOGGER = LoggerFactory.getLogger(BoxTest.class);

  private Box<Integer> integerBox;

  @Before
  public void setUp() throws Exception {
    this.integerBox = new Box<Integer>();
  }

  @Test
  public void setAndGet() throws Exception {
    integerBox.set(5);
    LOGGER.debug("get value from generic box: " + integerBox.get());
  }

}