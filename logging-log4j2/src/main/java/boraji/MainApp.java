package boraji;

import java.lang.invoke.MethodHandles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * https://www.boraji.com/log4j-2-rollingfileappender-example
 */
public class MainApp {
    private static final Logger LOGGER = LogManager.getLogger(MainApp.class);

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {
            LOGGER.info("Rolling file appender example...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
