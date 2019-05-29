package pikodat;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextAreaExample {

  // Setup logger
 Logger logger =LogManager.getLogger("My Logger");

  TextAreaExample() {
    JFrame f = new JFrame();
//    JTextArea area = new JTextArea("Welcome to javatpoint");
//    area.setBounds(10, 30, 200, 200);
//    f.add(area);
    f.add(getTextArea());
    f.setSize(300, 300);
    f.setLayout(null);
    f.setVisible(true);

    logger.debug("Hello world!");

    generateLogs();

  }

  private void generateLogs() {
    for (int i = 0; i < 30; i++) {
      logger.info("Rolling file appender example...");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  private JTextArea getTextArea() {
    // Create logging panel
    JTextArea jLoggingConsole = new JTextArea(10, 0); // 5 lines high here
    jLoggingConsole.setLineWrap(true);
    jLoggingConsole.setWrapStyleWord(true);
    jLoggingConsole.setEditable(false);
    jLoggingConsole.setFont(new Font("Courier", Font.PLAIN, 12));

    // Make scrollable console pane
    JScrollPane jConsoleScroll = new JScrollPane(jLoggingConsole);
    jConsoleScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    // Subscribe the text area to JTextAreaAppender
    JTextAreaAppender.addTextArea(jLoggingConsole);

    return jLoggingConsole;

  }


  public static void main(String args[]) {
    new TextAreaExample();
  }
}