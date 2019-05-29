package io.javacodegeeks;

import java.io.File;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * https://www.baeldung.com/java-create-directory
 */
public class DirectoryOperations {

  private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  public static void main(String[] args) {

    new DirectoryOperations().directoryExists("C://directory");

  }


  boolean directoryExists(String directory) {

    File dir = new File(directory);

    // Tests whether the directory denoted by this abstract pathname exists.
    // check directory exists
    boolean exists = dir.exists();

    System.out.println("Directory " + dir.getPath() + " exists: " + exists);

    return exists;
  }

  void createDirectory(File newDirectory) {

    logger.debug("creating new directory");
    newDirectory.mkdir();

  }

  void createMultipleNestedDirectories(File... directories) {

    logger.debug("creating multiple nested directories");
    for (File dir : directories) {
      dir.mkdir();
    }

  }

}