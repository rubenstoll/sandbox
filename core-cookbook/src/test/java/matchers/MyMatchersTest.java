package matchers;

import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * hamcrest matchers
 * https://www.javacodegeeks.com/2015/11/hamcrest-matchers-tutorial.html#simple
 */
public class MyMatchersTest {

  @Test
  public void test_any() throws Exception {
    // Given
    String myString = "hello";

    // Then
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

}
