package patterns.abstractfactory;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * abstract factory tests.
 */
public class AbstractSoupFactoryTest {

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void makeChickenSoup() throws Exception {

    AbstractSoupFactory concreteSoupFactory = new BostonConcreteSoupFactory();
    assertThat(concreteSoupFactory.makeChickenSoup(), instanceOf(ChickenSoup.class));
  }

}