package util.regexp;

import java.io.File;
import java.nio.file.Files;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by tk3sy on 24.06.2016.
 */
public class ExtractTextTest {

  @Test
  public void replaceText() throws Exception {

    String testFileName = "failed_messages-raw.log.json";
    File testFile = new File(getClass().getClassLoader().getResource(testFileName).getFile());
    String exptectedJsonFile = "failed_messages.log.json.expected";

    File expectedJson = new File(getClass().getClassLoader().getResource(exptectedJsonFile).getFile());
    String firstLineOfExpected = Files.readAllLines(expectedJson.toPath()).get(0); // read fist line
    String result = ExtractText.replaceText(testFile);

    assertEquals(firstLineOfExpected,result);

  }


  @Test
  public void fixText() throws Exception {

    String testFileName = "failed_messages-raw.log.json";
    File file = new File(getClass().getClassLoader().getResource(testFileName).getFile());

    StringBuilder text = ExtractText.fixLog(file);

    assertFalse(text.toString().isEmpty());

  }

}