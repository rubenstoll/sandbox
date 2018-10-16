package matchers.vogella;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * http://www.vogella.com/tutorials/Hamcrest/article.html
 */
public class HamcrestListMatcherExamples {

  @Test
  public void listShouldInitiallyBeEmpty() {
    List<Integer> list = Arrays.asList(5, 2, 4);

    assertThat(list, hasSize(3));

    // ensure the order is correct
    assertThat(list, contains(5, 2, 4));

    assertThat(list, containsInAnyOrder(2, 4, 5));

    assertThat(list, everyItem(greaterThan(1)));

  }

}
