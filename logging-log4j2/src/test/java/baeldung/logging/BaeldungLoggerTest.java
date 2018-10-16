package baeldung.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * https://www.baeldung.com/log4j2-appenders-layouts-filters
 */
public class BaeldungLoggerTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void givenLoggerWithDefaultConfig_whenLogToConsole_thanOK() throws Exception {
    Logger logger = LogManager.getLogger(getClass());
    Exception e = new RuntimeException("This is only a test!");

    logger.info("This is a simple message at INFO level. " + "It will be hidden.");
    logger.error("This is a simple message at ERROR level. " + "This is the minimum visible level.", e);
  }
}
