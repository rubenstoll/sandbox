package util.collections.jenkov;

import java.util.HashSet;
import java.util.Set;


/**
 * http://tutorials.jenkov.com/java-collections/set.html
 */
public class SetDemo {

    public void setItOff() {
        Set<String> setA = new HashSet<>();

        String element = "element 1";

        setA.add(element);

        System.out.println(setA.contains(element));
    }
}
