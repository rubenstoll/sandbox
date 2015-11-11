package collections.lambdas;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by ruben on 23/07/14.
 */
public class IterableForEach {

    public static void main(String[] args) {
        Collection<String> c =
                Arrays.asList("One", "Two", "Three");
        c.forEach(s -> System.out.println(s));
    }
}
