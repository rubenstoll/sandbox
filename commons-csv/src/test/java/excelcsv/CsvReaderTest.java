package excelcsv;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 *
 */
public class CsvReaderTest {

  @Test
  public void testGetRecods() throws Exception {

    List<Student> students = CsvReader.getRecords("testrecords.csv");
    // CsvReader.getRecords("testrecords.xls");

    assertThat(students, is(not(empty())));

    students.forEach(s -> System.out.println(s.getFirstName().concat(", ").concat(s.getLastName())));
  }
}