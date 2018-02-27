package matchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * hamcrest matchers https://www.javacodegeeks.com/2015/11/hamcrest-matchers-tutorial.html#simple http://www.baeldung.com/hamcrest-collections-arrays
 */
public class MyMatchersTest {

  @Test
  public void test_any() throws Exception {
    // arrange

    // Given
    String myString = "helloooo";

    // act

    // assert Then
    assertThat(myString, is(any(String.class)));
  }

  @Test
  public void test_anything() throws Exception {
    // Given
    String myString = "hello";
    Integer four = 4;

    // Then
    assertThat(myString, is(anything()));
    assertThat(four, is(anything()));
  }

  @Test
  public void test_arrayContaining_items() throws Exception {
    // Given
    String[] strings = {"why", "hello", "there"};

    // Then
    assertThat(strings, is(arrayContaining("why", "hello", "there")));
  }

  @Test
  public void test_arrayContaining_list_of_matchers() throws Exception {
    // Given
    String[] strings = {"why", "hello", "there"};

    // Then
    java.util.List<org.hamcrest.Matcher<? super String>> itemMatchers = new ArrayList<>();
    itemMatchers.add(equalTo("why"));
    itemMatchers.add(equalTo("hello"));
    itemMatchers.add(endsWith("here"));
    assertThat(strings, is(arrayContaining(itemMatchers)));
  }

  @Test
  public void test_contains_single_matcher() throws Exception {
    // Given
    List<String> strings = Arrays.asList("hello");

    // Then
    assertThat(strings, contains(startsWith("he")));
  }

  @Test
  public void test_closeTo_double() throws Exception {
    // Given
    Double testValue = 6.3;

    // Then
    assertThat(testValue, is(closeTo(6, 0.5)));
  }

  @Test
  public void test_equalTo_value() throws Exception {
    // Given
    String testValue = "value";
    int testVal = 4;

    // Then
    assertThat(testValue, equalTo("value"));
    assertThat(testVal, equalTo(4));
  }

}
