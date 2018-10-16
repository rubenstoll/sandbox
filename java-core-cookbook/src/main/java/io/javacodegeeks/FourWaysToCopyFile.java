package io.javacodegeeks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * https://examples.javacodegeeks.com/core-java/io/file/4-ways-to-copy-file-in-java/
 */
public class FourWaysToCopyFile {

  static void copyFileUsingFileStreams(File source, File dest) throws IOException {

        try (InputStream input = new FileInputStream(source); OutputStream output = new FileOutputStream(dest)) {
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        }
    }

  public static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        try (FileChannel inputChannel = new FileInputStream(source).getChannel(); FileChannel outputChannel = new FileOutputStream(dest).getChannel()) {
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        }
    }

  // static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
  // FileUtils.copyFile(source, dest);
  // }

  protected static void copyFileUsingJava7Files(File source, File dest) throws IOException {
    Files.copy(source.toPath(), dest.toPath());
  }

}
