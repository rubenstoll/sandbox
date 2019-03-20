package io.vogella.java.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * file
 */
public class FilesUtil {

  public static String readTextFile(String fileName) throws IOException {

    File file = new File(FilesUtil.class.getClassLoader().getResource(fileName).getFile());
    List<String> lines = FilesUtil.readTextFileByLines(file.getAbsolutePath());

    lines.forEach(n -> System.out.println(n));

    return lines.toString();

  }

  public static List<String> readTextFileByLines(String fileName) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(fileName));
    return lines;
  }

  public static void writeToTextFile(String fileName, String content) throws IOException {
    Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE);
  }

  public static String getFileName(String absolutePath) {
    return new File(absolutePath).getName();
  }

}
