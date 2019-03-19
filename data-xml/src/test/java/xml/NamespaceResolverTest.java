package xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import org.xml.sax.SAXException;

public class NamespaceResolverTest {

  @Test
  public void getNamespaceURI() throws ParserConfigurationException, IOException, SAXException {

    //Parse XML file
    String fileName = "sample.xml";
    File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

    NamespaceResolver namespaceResolver = new NamespaceResolver(file.getAbsolutePath());
    namespaceResolver.getNamespaceURI(file.getAbsolutePath());
  }


  @Test
  public void getPrefix() {
  }

  @Test
  public void getPrefixes() {
  }
}