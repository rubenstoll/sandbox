package functional.lambdas.misc;

import java.util.List;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

public class LambdaTopTenTest {

  @Test
  public void removeElementFromArrayToArraylistJava8() {

    String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    List<String> resultList = LambdaTopTen.removeElementFromArrayToArraylistJava8(daysOfWeek);

    assertThat(resultList, hasSize(6));

  }

  @Test
  public void filterPlay() {
  }

  @Test
  public void filter() {
  }
}