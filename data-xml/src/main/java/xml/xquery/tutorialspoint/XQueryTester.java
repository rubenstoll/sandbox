package xml.xquery.tutorialspoint;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import com.saxonica.xqj.SaxonXQDataSource;

/**
 * http://www.tutorialspoint.com/xquery/index.htm
 */
public class XQueryTester {

  public static void main(String[] args) {
    try {
      execute();
    } catch (FileNotFoundException | XQException e) {
      e.printStackTrace();
    }
  }

  private static void execute() throws FileNotFoundException, XQException {
    InputStream inputStream = XQueryTester.class.getClassLoader().getResourceAsStream("books.xqy");
    XQDataSource ds = new SaxonXQDataSource();
    XQConnection conn = ds.getConnection();
    XQPreparedExpression exp = conn.prepareExpression(inputStream);
    XQResultSequence result = exp.executeQuery();

    while (result.next()) {
      System.out.println(result.getItemAsString(null));
    }
  }
}