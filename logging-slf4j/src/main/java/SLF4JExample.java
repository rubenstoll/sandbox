import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JExample {

  private static Logger logger = LoggerFactory.getLogger(SLF4JExample.class);

  public static void main(String[] args) {
    logger.debug("Debug log message");
    logger.info("Info log message");
    logger.error("Error log message");

    goodies();
  }

  public static void goodies() {

    // SLF4J provides additional that can make logging more efficient and code more readable. For example, SLF4J provides a very useful interface for working with parameters:
    String variable = "Hello John";
    logger.debug("Printing variable value: {}", variable);

    // Here is the code example of Log4j that doing the same thing:
    logger.debug("Printing variable value: " + variable);

    /*
     * As you can see, Log4j will concatenate Strings regardless of debug level being enabled or not. In high-load applications, this may cause performance issues. SLF4J will
     * concatenate Strings only when the debug level is enabled. To do the same with Log4J you need to add extra if block which will check if debug level is enabled or not:
     */
    if (logger.isDebugEnabled()) {
      logger.debug("Printing variable value: " + variable);
    }

  }
}