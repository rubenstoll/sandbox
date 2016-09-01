package lambdas.examples;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

/**
 *
 */
public class ListProcessor {

  static Logger LOGGER = LoggerFactory.getLogger(ListProcessor.class);

  public List remove_element_from_array_to_arraylist_java8() {

    String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    List<String> daysOfWeekAsList = Lists.newArrayList(daysOfWeek);

    boolean removed = daysOfWeekAsList.removeIf(p -> p.equalsIgnoreCase("Monday"));

    LOGGER.info(String.valueOf(daysOfWeekAsList));

    return  daysOfWeekAsList;

  }
}
