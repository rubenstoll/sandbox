package io.baeldung;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.baeldung.com/java-list-directory-files
 */
public class FilesDirectories {

  public Set<String> listFilesUsingJavaIO(String dir) {

    return Stream.of(new File(dir).listFiles()).filter(file -> !file.isDirectory()).map(File::getName).collect(Collectors.toSet());

  }


  /**
   * Or, we can list all the files within a directory by walking it to a configured depth.
   * Let?s use java.nio.file.Files#walk to list all the files within a directory to a given depth:
   */
  public Set<String> listFilesUsingFileWalk(String dir, int depth) throws IOException {
    try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
      return stream
//          .filter(file -> !Files.isDirectory(file))
          .map(Path::getFileName)
          .map(Path::toString)
          .collect(Collectors.toSet());
    }
  }

  public Set<String> listFilesUsingFileWalkAndVisitor(String dir) throws IOException {
    Set<String> fileList = new HashSet<>();
    Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
          throws IOException {
        if (!Files.isDirectory(file)) {
          fileList.add(file.getFileName().toString());
        }
        return FileVisitResult.CONTINUE;
      }
    });
    return fileList;
  }


  public Map<String, Path> fileList(String directory) {
//    List<String> fileNames = new ArrayList<>();
    Map<String, Path> filz = new HashMap<>();
    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
      for (Path path : directoryStream) {
//        fileNames.add(path.toString());
        String versionName = path.getFileName().toString();
        filz.put(versionName, path);
      }
    } catch (IOException ex) {
    }
    return filz;
  }


  public List<String> listFolders(String directory) {

    List<String> result = new ArrayList<>();
    try (Stream<Path> walk = Files.walk(Paths.get(directory))) {

      result = walk.filter(Files::isDirectory)
          .map(x -> x.toString()).collect(Collectors.toList());


    } catch (IOException e) {
      e.printStackTrace();
    }
      return result;

  }

}
