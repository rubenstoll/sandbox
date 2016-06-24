package com.vogella.java.files;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by tk3sy on 24.06.2016.
 */
public class FilesUtilTest {


  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void readTextFile() throws Exception {

    String testFileName = "file.txt";
    String testFile = getClass().getClassLoader().getResource(testFileName).getPath();
    FilesUtil.readTextFileByLines(testFile);
  }

  @Test
  public void readTextFileByLines() throws Exception {

  }

  @Test
  public void writeToTextFile() throws Exception {

  }

}