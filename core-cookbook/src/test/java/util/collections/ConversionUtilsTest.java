package util.collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import functional.lambdas.misc.LambdaTopTen;

public class ConversionUtilsTest {

  static Logger LOGGER = LoggerFactory.getLogger(LambdaTopTen.class);

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void convertArrayToListJava8() {
    String[] names = new String[]{"pedro","john","stacey"};
    List<String> convertedList = ConversionUtils.convertArrayToListJava8(names);
    convertedList.forEach(n -> LOGGER.info(n));

    assertThat(convertedList, containsInAnyOrder("stacey","pedro","john"));

  }
}