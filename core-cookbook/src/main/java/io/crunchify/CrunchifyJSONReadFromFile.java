package io.crunchify;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * http://crunchify.com/how-to-read-json-object-from-file-in-java/
 *
 */
public class CrunchifyJSONReadFromFile {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
  }

  /**
   * parse json fileNameToParse
   *
   * @param fileNameToParse
   */
  public JSONObject parseJsonFile(String fileNameToParse) {
    JSONParser parser = new JSONParser();

    JSONObject jsonObject = null;
    try {

      String fileOneName = fileNameToParse;

      File fileOne = new File(CrunchifyJSONReadFromFile.class.getClassLoader().getResource(fileOneName).getFile());

      Object obj = parser.parse(new FileReader(fileOne));

      jsonObject = (JSONObject) obj;

    } catch (Exception e) {
      e.printStackTrace();
    }

    return jsonObject;
  }
}
