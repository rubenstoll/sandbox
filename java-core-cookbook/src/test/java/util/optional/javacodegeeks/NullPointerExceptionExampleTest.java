package util.optional.javacodegeeks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NullPointerExceptionExampleTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void examples() {

    NullPointerExceptionExample.typicalNullPointer();
    NullPointerExceptionExample.emptyOptionalCreation();
    NullPointerExceptionExample.nonEmptyOptional();
    NullPointerExceptionExample.nullableOptional();
    NullPointerExceptionExample.getExample();
    NullPointerExceptionExample.orElseExample();
    NullPointerExceptionExample.orElseThrowExample();
    NullPointerExceptionExample.isPresentExample();
    NullPointerExceptionExample.ifPresentExample();
    NullPointerExceptionExample.filterExample();
    NullPointerExceptionExample.mapExample();

  }
}