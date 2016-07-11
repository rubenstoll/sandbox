package com.vogella.java.files;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import ionio.vogella.java.files.FilesUtil;

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
    File file = new File(getClass().getClassLoader().getResource(testFileName).getFile());
    List<String> lines = FilesUtil.readTextFileByLines(file.getAbsolutePath());

    lines.forEach(n -> System.out.println(n));;

  }

  @Test
  public void readTextFileByLines() throws Exception {

  }

  @Test
  public void writeToTextFile() throws Exception {

  }

}