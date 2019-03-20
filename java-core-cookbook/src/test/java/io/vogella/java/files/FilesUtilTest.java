package io.vogella.java.files;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.List;
import java.util.Objects;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 */
public class FilesUtilTest {


  private String filename;

  @Before
  public void setUp() throws Exception {

    this.filename = "file.txt";

  }

  @Test
  public void readTextFile() throws Exception {

    String readInFile = FilesUtil.readTextFile(filename);

    assertThat(readInFile, is(not(nullValue())));

  }

  @Test
  public void readTextFileByLines() throws Exception {

    ClassLoader classLoader = getClass().getClassLoader();
//    File file = new File(classLoader.getResource(this.filename).getFile());
    File file = new File(Objects.requireNonNull(classLoader.getResource(this.filename)).getFile());

    List<String> lines = FilesUtil.readTextFileByLines(file.getAbsolutePath());
    assertThat(lines, Matchers.not(empty()));

  }

  @Ignore
  @Test
  public void writeToTextFile() throws Exception {

  }

  @Ignore
  @After
  public void tearDown() throws Exception {


  }
}