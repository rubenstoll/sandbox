package generics.javacodegeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.javacodegeeks.com/2011/04/java-generics-quick-tutorial.html
 */
public class Quickie {

  public static void main(String[] args) {

//    public interface List<E> extends Collection<E>
    List list = new ArrayList();

    list.add(2);
    list.add("a String");

  }

}
