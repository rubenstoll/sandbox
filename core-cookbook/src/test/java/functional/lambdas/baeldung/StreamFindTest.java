package functional.lambdas.baeldung;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class StreamFindTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void streamFindFirst() {

    Optional<String> result = StreamFind.streamFindFirst();

    assertTrue(result.isPresent());
    assertThat(result.get(), is("A"));
  }

  @Test
  public void findAny() {

    Optional<String> result = StreamFind.streamFindAny();
    assertTrue(result.isPresent());
//    assertThat(result.get(), anyOf(is("A"), is("B"), is("C"), is("D")));

  }
}