package utils.regexp;

import java.io.File;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by tk3sy on 24.06.2016.
 */
public class ExtractTextTest {

  @Test
  public void replaceText() throws Exception {

    String testFileName = "failed_messages-raw.log.json";
    File file = new File(getClass().getClassLoader().getResource(testFileName).getFile());

    boolean result = ExtractText.replaceText(file);

    assertTrue(result);

  }

}