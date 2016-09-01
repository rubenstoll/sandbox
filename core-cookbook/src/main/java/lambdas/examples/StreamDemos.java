package lambdas.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * lambdas examples
 */
public class StreamDemos {

  public static void main(String[] args) {

    doConcatDemo();
    doCountDemo();
    doSortedDemo();
    doDistinctDemo();

  }

  public static void doConcatDemo() {
    List<String> list1 = Arrays.asList("A1", "A2", "A3");
    List<String> list2 = Arrays.asList("B1", "B2", "B3");
    Stream<String> resStream = Stream.concat(list1.stream(), list2.stream());
    resStream.forEach(s -> System.out.println(s));

  }

  public static void doCountDemo() {
    List<String> list = Arrays.asList("AA", "AB", "CC");
    Predicate<String> predicate = s -> s.startsWith("A");
    long l = list.stream().filter(predicate).count();
    System.out.println("Number of Matching Element:" + l);
  }

  public static void doSortedDemo() {
    List<String> list = Arrays.asList("DC", "CD", "AD");
    list.stream().sorted().forEach(s -> System.out.println(s));
  }

  public static void doDistinctDemo() {
    List<String> list = Arrays.asList("AA", "AA", "BB");
    long l = list.stream().distinct().count();
    System.out.println("Number of distinct element:" + l);
  }

}
