package functional.lambdas.dzone;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class StreamsAndCollectorsTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void summing() {

    int sum = StreamsAndCollectors.summing();
    assertThat(sum, equalTo(430));

  }

  @Ignore
  @Test
  public void average() {
  }

  @Ignore
  @Test
  public void maxMin() {
  }

  @Ignore
  @Test
  public void partition() {
  }
}