package lambdas.examples;

import java.util.List;
import java.util.TreeSet;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class ListProcessorTest {

  @Test
  public void remove_element_from_array_to_arraylist_java8() throws Exception {

    List daysOfWeekAsList = new ListProcessor().remove_element_from_array_to_arraylist_java8();

    // Assert.assertTrue(removed);
    Assert.assertTrue(daysOfWeekAsList.size() == 6);

  }

}