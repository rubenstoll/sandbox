package util.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

  public static void main(String args[]) {
    // create a linked list
    LinkedList ll = new LinkedList();

    List<String> lu = new ArrayList<>();

    // add elements to the linked list
    ll.add("F");
    ll.add("B");
    ll.add("D");
    ll.add("E");
    ll.add("C");
    ll.addLast("Z");
    ll.addFirst("A");
    ll.add(1, "A2");
    System.out.println("Original contents of ll: " + ll);

    // remove elements from the linked list
    ll.remove("F");
    ll.remove(2);
    System.out.println("Contents of ll after deletion: " + ll);

    // remove first and last elements
    ll.removeFirst();
    ll.removeLast();
    System.out.println("ll after deleting first and last: " + ll);

    // get and set a value
    Object val = ll.get(2);
    ll.set(2, (String) val + " Changed");
    System.out.println("ll after change: " + ll);

    List<Long> numList = new ArrayList<>();

    numList.add(45566L);

    if(numList.contains(45566L)) {
      System.out.println("hurray found number!!!");
    }

    if(!numList.contains(566434L)) {
      System.out.println("FOUND non existent  HURRAY");
    } else {
      System.out.println("NO HURRAY");
    }

  }
}