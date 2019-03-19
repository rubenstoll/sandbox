package programcreek;

import static org.apache.logging.log4j.LogManager.getRootLogger;
import static org.junit.Assert.assertEquals;

import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.test.appender.ListAppender;
import org.junit.Before;
import org.junit.Test;

public class ProgramCreekLog4jTest {

    @Before
    public void setUp() throws Exception {
    }
    /**
     * Tests logger.trace(Object, Exception).
     */
    @Test
    public void testTraceWithException() {
//        final ListAppender appender = new ListAppender("List");
//        appender.start();
//        final Logger root = LogManager.getRootLogger();
//        root.getLogger().addAppender(appender);
//        root.setLevel(Level.INFO);
//
//        final Logger tracer = Logger.getLogger("com.example.Tracer");
//        tracer.setLevel(Level.TRACE);
//        final NullPointerException ex = new NullPointerException();
//
//        tracer.trace("Message 1", ex);
//        root.trace("Discarded Message", ex);
//        root.trace("Discarded Message", ex);
//
//        final List<LogEvent> msgs = appender.getEvents();
//        assertEquals(1, msgs.size());
//        final LogEvent event = msgs.get(0);
//        assertEquals(org.apache.logging.log4j.Level.TRACE, event.getLevel());
//        assertEquals("Message 1", event.getMessage().getFormattedMessage());
//        appender.stop();
//        root.getLogger().removeAppender(appender);
    }

}