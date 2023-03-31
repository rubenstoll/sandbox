package excelcsv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * reads data from excel.
 */
public class CsvReader {

    public static List<Student> getRecords(String fileName) {

        Reader fileReader = null;
        List<Student> students = new ArrayList<>();

        try {

            fileReader = new FileReader(CsvReader.class.getClassLoader().getResource(fileName).getFile());

            // Create the CSVFormat object with the header mapping
            // CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(TRX_FILE_HEADER_MAPPING);
            CSVFormat csvFileFormat = CSVFormat.EXCEL.withHeader("LastName", "FirstName").withDelimiter(";".charAt(0));

            Iterable<CSVRecord> records = csvFileFormat.parse(fileReader);

            for (CSVRecord record : records) {

                String lastName = record.get("LastName");
                String firstName = record.get("FirstName");

                Student student = new Student(lastName, firstName);
                students.add(student);

            }

        } catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return students;
    }

}
