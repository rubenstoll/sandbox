package util.optional.javacodegeeks;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * https://examples.javacodegeeks.com/core-java/util/optional/java-8-optional-example/
 * 
 * Bunch of misc of usages of the Optional class in Java 8
 * 
 * @author dgutierrez-diez
 */
public class NullPointerExceptionExample {


  static void filterExample() {
    /* filter */

    // if the value is not present
    Optional<Car> carOptionalEmpty = Optional.empty();
    carOptionalEmpty.filter(x -> "250".equals(x.getPrice())).ifPresent(x -> System.out.println(x.getPrice() + " is ok 1!"));

    // if the value does not pass the filter
    Optional<Car> carOptionalExpensive = Optional.of(new Car("3333"));
    carOptionalExpensive.filter(x -> "250".equals(x.getPrice())).ifPresent(x -> System.out.println(x.getPrice() + " is ok 2!"));

    // if the value is present and does pass the filter
    Optional<Car> carOptionalOk = Optional.of(new Car("250"));
    carOptionalOk.filter(x -> "250".equals(x.getPrice())).ifPresent(x -> System.out.println(x.getPrice() + " is ok 3!"));

  }

  static void mapExample() {
    /* map */
    // non empty string map to its length
    Optional<String> stringOptional = Optional.of("loooooooong string");
    Optional<Integer> sizeOptional = stringOptional.map(String::length); // map from Optional<String> to Optional<Integer>

    System.out.println("size of string " + sizeOptional.orElse(0));

    // empty string map to its length -> we get 0 as lenght
    Optional<String> stringOptionalNull = Optional.ofNullable(null);
    Optional<Integer> sizeOptionalNull = stringOptionalNull.map(x -> x.length()); // we can use Lambdas as we want

    System.out.println("size of string " + sizeOptionalNull.orElse(0));

  }

  static void ifPresentExample() {
    /* ifPresent */
    Optional<String> stringToUse = Optional.of("danibuiza2");
    stringToUse.ifPresent(System.out::println);

    /* if not present */
    Optional<String> stringToUseNull = Optional.ofNullable(null);
    stringToUseNull.ifPresent(System.out::println);
  }

  static void isPresentExample() {
    /* isPresent */
    Optional<String> stringToUse = Optional.of("danibuiza1");
    if (stringToUse.isPresent()) {
      System.out.println(stringToUse.get());
    }

  }

  static void orElseThrowExample() {
    try {
      /* orElseThrow */
      Car carNull = null;
      Optional<Car> optionalCarNull = Optional.ofNullable(carNull);
      optionalCarNull.orElseThrow(IllegalStateException::new);
    } catch (IllegalStateException ex) {
      System.out.println("expected IllegalStateException");
    }
  }

  static void orElseExample() {
    /* orElse */
    Car carCreated = new Car("500");
    Car defaultCar = new Car("250");

    // value is there
    Optional<Car> optionalCar = Optional.of(carCreated);
    String price = optionalCar.orElse(defaultCar).getPrice();
    System.out.println("Car price: " + price);

    // else
    Optional<Car> optionalCar2 = Optional.empty();
    price = optionalCar2.orElse(defaultCar).getPrice();
    System.out.println("Car price: " + price);
  }

  static void getExample() {
    /* get */
    try {
      String strNull2 = null;
      // cannot be passed, we should use nullable
      Optional<String> optionalString = Optional.of(strNull2);
      System.out.println(optionalString.get().contains("something"));
    } catch (NullPointerException ex) {
      System.out.println("expected nullpointer");
    }
  }

  static void nullableOptional() {
    try {/* ofNullable */
      String strNull = null;
      Optional<String> nullableOptional = Optional.ofNullable(strNull);
      System.out.println(nullableOptional.get());
    } catch (NoSuchElementException ex) {
      System.out.println("expected NoSuchElementException");
    }
  }

  static void nonEmptyOptional() {
    /* non empty */
    String str = "string";
    Optional<String> nonEmptyOptional = Optional.of(str);
    System.out.println(nonEmptyOptional.get());
  }

  static void emptyOptionalCreation() {
    try {
      /* empty */
      Optional<String> emptyOptional = Optional.empty();
      System.out.println(emptyOptional.get());
    } catch (NoSuchElementException ex) {
      System.out.println("expected NoSuchElementException");
    }
  }

  @SuppressWarnings("null")
  static void typicalNullPointer() {
    try {
      /*
       * typical NullPointerException, even the compiler is saying something: Null pointer access: The variable strNull can only be null at this location
       */
      String strNull0 = null;
      System.out.println(strNull0.contains("something"));
    } catch (NullPointerException ex) {
      System.out.println("expected nullpointer");
    }
  }
}
