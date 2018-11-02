package io.javacodegeeks;

import static io.javacodegeeks.FourWaysToCopyFile.copyFileUsingFileChannels;
import static io.javacodegeeks.FourWaysToCopyFile.copyFileUsingFileStreams;
import static io.javacodegeeks.FourWaysToCopyFile.copyFileUsingJava7Files;

import java.io.File;
import java.io.IOException;
import org.junit.Before;

/**
 */
public class FourWaysToCopyFileTest {

  @Before
  public void setUp() throws Exception {

  }

  public static void main(String[] args) throws InterruptedException, IOException {

    // todo find files to copy and use get resources
    File source = new File("C:\\Users\\nikos7\\Desktop\\files\\sourcefile1.txt");
    File dest = new File("C:\\Users\\nikos7\\Desktop\\files\\destfile1.txt");

    // copy file using FileStreams
    long start = System.nanoTime();
    long end;
    copyFileUsingFileStreams(source, dest);
    System.out.println("Time taken by FileStreams Copy = " + (System.nanoTime() - start));

    // todo find files to copy and use get resources
    // copy files using java.nio.FileChannel
    source = new File("C:\\Users\\nikos7\\Desktop\\files\\sourcefile2.txt");
    dest = new File("C:\\Users\\nikos7\\Desktop\\files\\destfile2.txt");
    start = System.nanoTime();
    copyFileUsingFileChannels(source, dest);
    end = System.nanoTime();
    System.out.println("Time taken by FileChannels Copy = " + (end - start));

    // todo find files to copy and use get resources
    // copy file using Java 7 Files class
    source = new File("C:\\Users\\nikos7\\Desktop\\files\\sourcefile3.txt");
    dest = new File("C:\\Users\\nikos7\\Desktop\\files\\destfile3.txt");
    start = System.nanoTime();
    copyFileUsingJava7Files(source, dest);
    end = System.nanoTime();
    System.out.println("Time taken by Java7 Files Copy = " + (end - start));

    // todo find files to copy and use get resources
    // copy files using apache commons io
    source = new File("C:\\Users\\nikos7\\Desktop\\files\\sourcefile4.txt");
    dest = new File("C:\\Users\\nikos7\\Desktop\\files\\destfile4.txt");
    start = System.nanoTime();
//    FourWaysToCopyFile.copyFileUsingApacheCommonsIO(source, dest);
    end = System.nanoTime();
    System.out.println("Time taken by Apache Commons IO Copy = " + (end - start));

  }


}