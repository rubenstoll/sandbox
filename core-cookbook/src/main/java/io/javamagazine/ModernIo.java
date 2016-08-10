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
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes;

/**
 * Created by tk3sy on 10.08.2016.
 */
public class ModernIo {

  void copyOperation() {

    File inputFile = new File("input.txt");
    try (InputStream in = new FileInputStream(inputFile)) {
      Files.copy(in, Paths.get("output.txt"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  void variousFileOperations() throws IOException {
    Path source = Paths.get("/home/ruben"), target = Paths.get("/home/ruben/target");
    Attributes attr = null;
    Charset cs = StandardCharsets.UTF_8;


    // Creating files
    //***************************************************************
    //
    // Example of path --> /home/ben/.profile
    // Example of attributes --> rw-rw-rw-
    Files.createFile(null, null);
    // Files.createFile(target, attr);

    // Deleting files
    //***************************************************************
    Files.delete(target);
    boolean deleted = Files.deleteIfExists(target);

    // Copying/Moving files
    //***************************************************************
    Files.copy(source, target);
    Files.move(source, target);

    // Utility methods to retrieve information
    //***************************************************************
    long size = Files.size(target);
    FileTime fTime = Files.getLastModifiedTime(target);
    System.out.println(fTime.to(TimeUnit.SECONDS));
    Map<String, ?> attrs = Files.readAttributes(target, "*");
    System.out.println(attrs);

    // Methods to deal with file types
    //***************************************************************
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
}
