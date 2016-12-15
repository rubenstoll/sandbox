package mockito.javacodegeeks;

import java.util.List;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * 
 * https://www.javacodegeeks.com/2015/11/getting-started-with-mockito.html
 */
@RunWith(MockitoJUnitRunner.class)
public class MyTest {

  @Mock
  private List<String> mockList;

}