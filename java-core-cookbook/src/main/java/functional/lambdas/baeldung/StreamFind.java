package functional.lambdas.baeldung;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * http://www.baeldung.com/java-stream-findfirst-vs-findany
 */
public class StreamFind {

  public static Optional<String> streamFindFirst() {

    List<String> list = Arrays.asList("A", "B", "C", "D");

    Optional<String> result = list.stream().findFirst();

    return result;
  }

  public static Optional<String> streamFindAny() {
    List<String> list = Arrays.asList("A", "B", "C", "D");
    Optional<String> result = list.stream().findAny();

    return result;
  }

}
