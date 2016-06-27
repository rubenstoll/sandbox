/**
 *
 */
package utils.regexp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rustoll
 */
public class ExtractText {

  private static final String REGEX = "[a-zA-Z]+ *[a-zA-Z]+ *[a-zA-Z]+ *[0-9]+ *[a-zA-Z]+";
  private static final String INPUT = "employe moulliard          Male 43 BE";

  /**
   * @param args
   */
  public static void main(String[] args) {

    patternMatcherIndexes();

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

  public static String replaceText(File fileToParse) throws IOException {

    // // \"message.*\}\}\",
    // String messageRegexp = "\\\"message.*\\}\\}\\\",";
    // // \{\\\"header.*\\\"\},
    // String headerRegexp = "\\\"header.*\\\\\\\"\\},";
    // // \\\"body.*\}\}\"
    // String bodyRegexp = "\\\\\\\"body.*\\}\\}\\\"";

    // (.*),(\"message\":\"(\{.*header.*\\\".*),(\\\"body.*\}\}\")),(.*\})
    String msgHeadBdyRegexp = "(.*),(\\\"message\\\":\\\"(\\{.*header.*\\\\\\\".*),(\\\\\\\"body.*\\}\\}\\\")),(.*\\})";

    String fixedLine = "";

    List<String> fileLines = Files.readAllLines(fileToParse.toPath());
    for (String line : fileLines) {

      // List<String> splittedLine = Arrays.asList(line.split("\\\""));
      //
      // boolean matchFound = false;
      // matchFound = line.matches(messageRegexp);
      // matchFound = line.matches(headerRegexp);
      // matchFound = line.matches(bodyRegexp);
      //
      // String modifiedString = "";
      // modifiedString = line.replaceFirst(messageRegexp, "");

      String messageString = "";
      Pattern messagePattern;
      Matcher messageMatcher;
      boolean matchfound = false;
      // messagePattern = Pattern.compile(messageRegexp);
      // messageMatcher = messagePattern.matcher(line);
      // matchfound = messageMatcher.find();

      messagePattern = Pattern.compile(msgHeadBdyRegexp);
      messageMatcher = messagePattern.matcher(line);
      matchfound = messageMatcher.find();

      StringBuilder modTxt = new StringBuilder();
      String message = null;
      String header = null;
      String body = null;
      if (matchfound) {
        messageMatcher.group();
        message = messageMatcher.group(2);
        header = messageMatcher.group(3);
        body = messageMatcher.group(4);

        // }}","
        String replace0 = "\"\\{";
        String replace1 = "}}\",";
        String replace2 = "\\\\";
        fixedLine = messageMatcher.group().replaceFirst(replace0,"{").replaceFirst(replace1, "}},").replaceAll(replace2, "");
      }


    }

    return fixedLine;

  }

  public static StringBuilder fixLog(File fileName) {

    StringBuilder builder = new StringBuilder();
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
      String s;

      while ((s = bufferedReader.readLine()) != null) {
        String f = fixLine(s);
        builder.append(f);
      }

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return builder;

  }

  public static String fixLine(String line) throws IOException {

    String fixedLine = "";

    // replace first curly brace
    String headerBegin = "message\":\"\\{\"header";
    String headerBeginReplace = "{{header";
    Pattern header = Pattern.compile(Pattern.quote(headerBegin));
    Matcher matcher = header.matcher(line);
    boolean matchedFound = matcher.find();
    fixedLine = line.replaceAll(headerBegin, headerBeginReplace);

    // replace ending curly brace
    String messageEnd = "\\}\\}\",";
    String messageEndReplace = "}},";
    // Pattern messageEndPattern = Pattern.compile("\"message\".*\\}\\}\",");
    // Matcher messageEndMatcher = messageEndPattern.matcher(line);
    fixedLine = line.replaceAll(messageEnd, messageEndReplace);

    // replace all forward slashes
    fixedLine = line.replaceAll("\\\"", "\"");

    System.out.println(line);
    System.out.println(fixedLine);

    return fixedLine;

  }
}
