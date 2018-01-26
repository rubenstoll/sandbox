package lambdas.examples;

import persistence.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tk3sy on 23.10.2015.
 *
 * http://www.dreamsyssoft.com/java-8-lambda-tutorial/filter-tutorial.php
 */
public class UserFilterTest {

  private static List<User> users = Arrays
    .asList(new User(1, "Steve", "Vai", 40), new User(4, "Joe", "Smith", 32), new User(3, "Steve", "Johnson", 57), new User(9, "Mike", "Stevens", 18),
      new User(10, "George", "Armstrong", 24), new User(2, "Jim", "Smith", 40), new User(8, "Chuck", "Schneider", 34), new User(5, "Jorje", "Gonzales", 22), new User(6, "Jane", "Michaels", 47), new User(7, "Kim", "Berlie", 60));

  public static void main(String[] args) {
    oldJavaWay();
    newJavaWay();
  }

  private static void oldJavaWay() {
    List<User> olderUsers = new ArrayList<>();

    for (User u : users) {
      if (u.getAge() > 30) {
        olderUsers.add(u);
      }
    }

    printListNewWay("Old way older users", olderUsers);
  }

  private static void newJavaWay() {
    List<User> olderUsers = users.stream().filter(u -> u.getAge() > 30).collect(Collectors.toList());
    printListNewWay("New way older users", olderUsers);
  }

  private static void printListNewWay(String type, List<User> users) {
    System.out.println(type + ":");

    users.forEach(u -> System.out.println("\t" + u));

    System.out.println();
  }
}
