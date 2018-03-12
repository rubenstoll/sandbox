package io.excelcsv;

import persistence.jpa.tutorialspoint.model.Student;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by tk3sy on 24.12.2015.
 */
public class CSVReaderTest {

  @Test
  public void testGetRecods() throws Exception {

    List<Student> students = CSVReader.getRecords("testrecords.csv");
    // CSVReader.getRecords("testrecords.xls");

    assertThat(students, is(not(empty())));

    students.forEach(s -> System.out.println(s.getFirstName().concat(", ").concat(s.getLastName())));
  }
}