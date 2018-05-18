package functional.lambdas.examples;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * https://dzone.com/articles/using-java-collectors
 */
public class StreamsAndCollectors {

  public static void summing() {

    List<Integer> numbers = Arrays.asList(9, 5, 66, 56, 4, 8, 9);
    // int sum = numbers.stream().reduce(0, (x, y) -> x + y);

    Random random = new Random();
    numbers = random.ints(1, 100).limit(10).boxed().collect(Collectors.toList());

    int sum = numbers.stream().collect(Collectors.summingInt(x -> x));

  }

  public static double average(List<Integer> numbers) {
    return numbers.stream().collect(Collectors.averagingInt(x -> x));
  }

  public static double maxMin(List<Integer> numbers) {
    IntSummaryStatistics r = numbers.stream().collect(Collectors.summarizingInt(x -> x));
    return numbers.stream().collect(Collectors.averagingInt(x -> x));
  }

  public static void partition(List<Integer> numbers) {

    Map<Boolean, List<Integer>> parts = numbers.stream().collect(Collectors.partitioningBy(x -> x > 50));
    System.out.println(numbers + " =>\n" + "   true: " + parts.get(true) + "\n" + "  false: " + parts.get(false) + "\n");

  }

}
