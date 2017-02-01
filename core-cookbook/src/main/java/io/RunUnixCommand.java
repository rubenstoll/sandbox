package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang3.SystemUtils;

/**
 * example on how to run a unix command
 */
public class RunUnixCommand {

  public static void main(String args[]) {

    String s = null;

    try {

      if (SystemUtils.IS_OS_LINUX) {
        // run the Unix "ps -ef" command
        Process p = Runtime.getRuntime().exec("ps -ef");

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        // read the output from the command

        System.out.println("Here is the standard output of the command:\n");
        while ((s = stdInput.readLine()) != null) {
          System.out.println(s);
        }

        // read any errors from the attempted command

        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
          System.out.println(s);
        }

        System.exit(0);
      } else {
        // SystemUtils.IS_OS_WINDOWS
        // TODO execute windows command then instead
        System.out.println("ERROR: OS is not unix. cannot execute command");
      }
    } catch (IOException e) {
      System.out.println("exception happened - here's what I know: ");
      e.printStackTrace();
      System.exit(-1);
    }
  }
}
