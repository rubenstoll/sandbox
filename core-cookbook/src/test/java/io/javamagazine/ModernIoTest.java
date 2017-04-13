package io.javamagazine;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 */
public class ModernIoTest {

  private ModernIo modernIo;

  @Before
  public void setUp() throws Exception {

    this.modernIo = new ModernIo();
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void copyOperation() throws Exception {

    modernIo.copyOperation();
  }

  @Ignore
  @Test
  public void nioFileOperations() throws Exception {

    modernIo.nioFileOperations();
  }

  @Ignore
  @Test
  public void readBienStyle() throws Exception {

    // todo fix java.nio.file.InvalidPathException: Illegal char <:> at index 2: /C:/local/projects/playground/sandbox/core-cookbook/target/test-classes/file.txt
    modernIo.readBienStyle();

  }
}