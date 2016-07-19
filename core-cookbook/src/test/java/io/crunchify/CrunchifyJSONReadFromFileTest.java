package io.crunchify;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import io.crunchify.CrunchifyJSONReadFromFile;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by tk3sy on 23.06.2016.
 */
public class CrunchifyJSONReadFromFileTest {

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void parseJsonFile() throws Exception {

    CrunchifyJSONReadFromFile crunchifyJSONReadFromFile = new CrunchifyJSONReadFromFile();

    // String fileOneName = "file1.json";
    String fileOneName = "failed_messages.log.json";

    JSONObject jsonObject = crunchifyJSONReadFromFile.parseJsonFile(fileOneName);

    JSONObject message = (JSONObject) jsonObject.get("message");

    // String jsonInput = CrunchifyJSONReadFromFile.class.getClassLoader().getResource("failed_messages.log.json").toString();

    System.out.println(jsonObject.toString());
    System.out.println("Size of object: " + jsonObject.size());

    // String message = (String) jsonObject.get("message.header");
    // String author = (String) jsonObject.get("Author");
    // JSONArray companyList = (JSONArray) jsonObject.get("Company List");
    //
    System.out.println("message: " + message);
    // System.out.println("Author: " + author);
    // System.out.println("\nCompany List:");
    // Iterator<String> iterator = companyList.iterator();
    // while (iterator.hasNext()) {
    // System.out.println(iterator.next());
    // }

    assertThat(message.size(), is(equalTo(2)));

  }

}