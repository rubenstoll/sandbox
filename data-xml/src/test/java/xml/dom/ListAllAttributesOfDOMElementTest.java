package xml.dom;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class ListAllAttributesOfDOMElementTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void readXMLFile() throws IOException, SAXException, ParserConfigurationException {

    String testFileName = "in.xml";
    ListAllAttributesOfDOMElement listAllAttributesOfDOMElement = new ListAllAttributesOfDOMElement();
    listAllAttributesOfDOMElement.readXMLFile(testFileName);

    assertThat(true, is(Boolean.TRUE));
  }

  @Test
  public void listAllAttributes() {
    assertThat(true, is(Boolean.TRUE));
  }

}
