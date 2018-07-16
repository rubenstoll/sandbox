package functional.lambdas.examples;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.sun.org.apache.bcel.internal.generic.LADD;

/**
 */
// Read more: http://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html#ixzz3pOHaT4uq
// Read more: http://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html#ixzz3pOJyqrQE
public class LambdaTopTen {

  static Logger LOGGER = LoggerFactory.getLogger(LambdaTopTen.class);

  /**
   *
   */
  public void iterationExample() {

    // Prior Java 8 :
    List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    for (String feature : features) {
      System.out.println(feature);
    }

    // In Java 8:
    // List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    features.forEach(n -> System.out.println(n)); // Even better use

    // Method reference feature of Java 8
    // method reference is denoted by :: (double colon) operator
    // looks similar to score resolution operator of C++
    features.forEach(System.out::println);

    filterPlay();

    funcInterfacePredicate();

    Collection<String> c = Arrays.asList("One", "Two", "Three");
    c.forEach(s -> System.out.println(s));

  }

  public List remove_element_from_array_to_arraylist_java8() {

    String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    List<String> daysOfWeekAsList = Lists.newArrayList(daysOfWeek);

    boolean removed = daysOfWeekAsList.removeIf(p -> p.equalsIgnoreCase("Monday"));

    LOGGER.info(String.valueOf(daysOfWeekAsList));

    return daysOfWeekAsList;

  }

  public static void filterPlay() {
    List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
    System.out.println("Languages which starts with J :");
    // filter(languages, (str) -> str.startsWith("J"));

    System.out.println("Languages which ends with a ");
    // filter(languages, (str) -> str.endsWith("a"));

    System.out.println("Print all languages :");
    filter(languages, (str) -> true);

    System.out.println("Print no language : ");
    filter(languages, (str) -> false);

    System.out.println("Print language whose length greater than 4:");
    // filter(languages, (str) -> str.length() > 4);
  }

  public static void filter(List<String> names, Predicate condition) {
    for (String name : names) {
      if (condition.test(name)) {
        System.out.println(name + " ");
      }
    }
  }

  public void funcInterfacePredicate() {
    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
    System.out.println("Languages which starts with J :");
    Predicate<String> startsWithJ = (n) -> n.startsWith("J");
    Predicate<String> fourLetterLong = (n) -> n.length() == 4;
    languages.stream().filter(startsWithJ.and(fourLetterLong)).forEach((n) -> System.out.print("\nlanguage, which starts with 'J' and four letter long is : " + n));

  }

}