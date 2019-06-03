package io.javacodegeeks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.lang.invoke.MethodHandles;
import java.util.List;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirectoryOperationsTest {

  private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private static final File TEMP_DIRECTORY = new File(System.getProperty("java.io.tmpdir"));
  private DirectoryOperations directoryOperations;

  @Before
  public void setUp() throws Exception {

    this.directoryOperations = new DirectoryOperations();
  }



  @Test
  public void createDirectory() {

    File newDirectory = new File(TEMP_DIRECTORY, "new_directory");
    if (newDirectory.delete()) {
       assertFalse(newDirectory.exists());
    };

//    directoryOperations.createDirectory(TEMP_DIRECTORY);

    boolean dirCreated = newDirectory.mkdir();
    assertTrue(dirCreated);

    // todo add delete recursively to clean-up after running

  }

  @Ignore
  @Test
  public void createMultipleNestedDirectories() {

    File newDirectory = new File(TEMP_DIRECTORY, "new_directory");
    File nestedDirectory = new File(newDirectory, "nested_directory");

    // delete from previous run
    nestedDirectory.delete();
    newDirectory.delete();

    assertFalse(newDirectory.exists());
    directoryOperations.createMultipleNestedDirectories(newDirectory, nestedDirectory);

    assertTrue(newDirectory.exists());
    assertTrue(nestedDirectory.exists());

    // todo add delete recursively to clean-up after running


  }

}