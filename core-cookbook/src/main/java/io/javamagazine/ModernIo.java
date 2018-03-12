package io.javamagazine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * references http://docs.oracle.com/javase/tutorial/essential/io/ https://docs.oracle.com/javase/tutorial/essential/io/index.html
 *
 */
public class ModernIo {

  String inputFileName = "file.txt";

  void copyOperation() {

    String outputFileName = "output.txt";
    File inputFile = new File(getClass().getClassLoader().getResource(inputFileName).getFile());
    // todo delete previously created file before reading and writing again
    try (InputStream in = new FileInputStream(inputFile)) {
      Files.copy(in, Paths.get(inputFile.getParent().concat(File.separator).concat(outputFileName)));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * NIO file operations
   * @throws IOException
   */
  void nioFileOperations() throws IOException {

    Path source = Paths.get(getClass().getClassLoader().getResource(inputFileName).getPath());
    Path target = Paths.get(getClass().getClassLoader().getResource(inputFileName).getPath().concat(File.separator).concat("target"));

    Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
    FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);

    Charset cs = StandardCharsets.UTF_8;

    // Creating files
    // ***************************************************************
    //
    // Example of path --> /home/ben/.profile
    // Example of attributes --> rw-rw-rw-
    // todo add path to something
    Files.createFile(target, attr);

    // Deleting files
    // ***************************************************************
    Files.delete(target);
    boolean deleted = Files.deleteIfExists(target);

    // Copying/Moving files
    // ***************************************************************
    Files.copy(source, target);
    Files.move(source, target);

    // Utility methods to retrieve information
    // ***************************************************************
    long size = Files.size(target);
    FileTime fTime = Files.getLastModifiedTime(target);
    System.out.println(fTime.to(TimeUnit.SECONDS));
    Map<String, ?> attrs = Files.readAttributes(target, "*");
    System.out.println(attrs);

    // Methods to deal with file types
    // ***************************************************************
    boolean isDir = Files.isDirectory(target);
    boolean isSym = Files.isSymbolicLink(target);
    // Methods to deal with reading and writing
    List<String> lines = Files.readAllLines(target, cs);
    byte[] b = Files.readAllBytes(target);
    BufferedReader br = Files.newBufferedReader(target, cs);
    BufferedWriter bwr = Files.newBufferedWriter(target, cs);
    InputStream is = Files.newInputStream(target);
    OutputStream os = Files.newOutputStream(target);

  }

  void readBienStyle() throws IOException {
    // http://www.adam-bien.com/roller/abien/entry/java_8_reading_a_file

    // "duke.java"
    String fileName = getClass().getClassLoader().getResource(inputFileName).getFile();
    // todo set encoding charset
    String content = new String(Files.readAllBytes(Paths.get(fileName)));

  }

  // https://docs.oracle.com/javase/tutorial/essential/io/file.html
  void readUsingBufferedReader() {

    // todo correct path - use get resources
    Path file = Paths.get("/tmp/foo");;

    Charset charset = Charset.forName("US-ASCII");
    try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }
  }

}
