package excelcsv;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 */
public class CsvReaderTest {

    @Test
    public void testGetRecods() throws Exception {

        List<Student> students = CsvReader.getRecords("testrecords.csv");
        // CsvReader.getRecords("testrecords.xls");

        // TODO replace with
        assertAll(
                "heading",
                () -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
                () -> assertEquals("java", "JAVA".toLowerCase()),
                () -> assertNull(students, "students list is null")
        );

        students.forEach(s -> System.out.println(s.getFirstName().concat(", ").concat(s.getLastName())));
    }
}