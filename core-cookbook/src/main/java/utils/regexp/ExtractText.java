/**
 * 
 */
package utils.regexp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rustoll
 * 
 */
public class ExtractText {

  private static final String REGEX = "[a-zA-Z]+ *[a-zA-Z]+ *[a-zA-Z]+ *[0-9]+ *[a-zA-Z]+";
  private static final String INPUT = "employe moulliard          Male 43 BE";

  /**
   * @param args
   */
  public static void main(String[] args) {

    patternMatcherIndexes();

    randomExample();

  }

  /**
	 * 
	 */
  private static void patternMatcherIndexes() {
    Pattern p = Pattern.compile(REGEX);
    // get a matcher object
    Matcher m = p.matcher(INPUT);
    int count = 0;
    while (m.find()) {
      count++;
      System.out.println("Match number " + count);
      System.out.println("start(): " + m.start());
      System.out.println("end(): " + m.end());
    }
  }

  private static void randomExample() {

    Double number = Math.random() * 5;

    System.out.println("number is: " + number);

  }

  private static void randomExample2() {

    Double number = Math.random() * 5;

    System.out.println("number is: " + number);

  }

  public static boolean replaceText(File fileToParse) throws IOException {

    List<String> fileLines = Files.readAllLines(fileToParse.toPath());
    List<String> cleanedFileLines = new ArrayList<>();

    Pattern replacePtrn1 = Pattern.compile("\"\\{");
    Matcher matcher1 = null;

    for (String line : fileLines) {
      // replace the following patters in every line
      matcher1 = replacePtrn1.matcher(line);
      // 1. "{\
      // 2. \
      // 3. }"

    }

    return false;

  }

}
