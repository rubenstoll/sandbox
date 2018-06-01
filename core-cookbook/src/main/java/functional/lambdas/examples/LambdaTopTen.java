package functional.lambdas.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 */
// Read more: http://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html#ixzz3pOHaT4uq
// Read more: http://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html#ixzz3pOJyqrQE
public class LambdaTopTen {

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

  }

  public static void filterPlay() {
    List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
    System.out.println("Languages which starts with J :");
//    filter(languages, (str) -> str.startsWith("J"));

    System.out.println("Languages which ends with a ");
//    filter(languages, (str) -> str.endsWith("a"));

    System.out.println("Print all languages :");
    filter(languages, (str) -> true);

    System.out.println("Print no language : ");
    filter(languages, (str) -> false);

    System.out.println("Print language whose length greater than 4:");
//    filter(languages, (str) -> str.length() > 4);
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