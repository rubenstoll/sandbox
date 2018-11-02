package functional.lambdas.misc;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 */
// Read more: http://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html#ixzz3pOHaT4uq
// Read more: http://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html#ixzz3pOJyqrQE
public class LambdaTopTen {

  static Logger LOGGER = LoggerFactory.getLogger(LambdaTopTen.class);

  /**
   *
   */
  public static void main(String[] args) {

    // Prior Java 8 :
    List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    for (String feature : features) {
      LOGGER.info(feature);
    }

    // In Java 8:
    // List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    features.forEach(n -> LOGGER.info(n)); // Even better use

    // Method reference feature of Java 8
    // method reference is denoted by :: (double colon) operator
    // looks similar to score resolution operator of C++
    features.forEach(System.out::println);

    filterPlay();

    funcInterfacePredicate();

    Collection<String> c = Arrays.asList("One", "Two", "Three");
    c.forEach(s -> LOGGER.info(s));

  }

   List<String> removeElementFromArrayToArraylistJava8(String[] daysOfWeek) {

    List<String> daysOfWeekAsList = Arrays.asList(daysOfWeek);

    daysOfWeekAsList.removeIf(p -> p.contains("Monday"));
    LOGGER.info(String.valueOf(daysOfWeekAsList));

    return daysOfWeekAsList;

  }

  public static void filterPlay() {
    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

    LOGGER.info("Languages which starts with J :");
    filter(languages, (p) -> p.startsWith("J"));

    LOGGER.info("Languages which ends with a ");
    filter(languages, (str) -> str.endsWith("a"));

    LOGGER.info("Print all languages :");
    filter(languages, (str) -> true);

    LOGGER.info("Print no language : ");
    filter(languages, (str) -> false);

    LOGGER.info("Print language whose length greater than 4:");
    filter(languages, (str) -> str.length() > 4);
  }

  public static void filter(List<String> names, Predicate<String> condition) {
    for (String name : names) {
      if (condition.test(name)) {
        LOGGER.info(name + " ");
      }
    }
  }

  public static void funcInterfacePredicate() {
    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
    LOGGER.info("Languages which starts with J :");
    Predicate<String> startsWithJ = (n) -> n.startsWith("J");
    Predicate<String> fourLetterLong = (n) -> n.length() == 4;
    languages.stream().filter(startsWithJ.and(fourLetterLong)).forEach((n) -> System.out.print("\nlanguage, which starts with 'J' and four letter long is : " + n));

  }

}