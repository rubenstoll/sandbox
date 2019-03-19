package xml.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ListAllAttributesOfDOMElement {

  private File getFile(String testFileName) {
    return new File(getClass().getClassLoader().getResource(testFileName).getFile());
  }


  public void readXMLFile(String testFileName) throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setValidating(false);
    DocumentBuilder db = dbf.newDocumentBuilder();

    ListAllAttributesOfDOMElement listAllAttributesOfDOMElement = new ListAllAttributesOfDOMElement();

    File file = listAllAttributesOfDOMElement.getFile(testFileName);

    Document doc = db.parse(new FileInputStream(file));

    NodeList entries = doc.getElementsByTagName("entry");

    int num = entries.getLength();

    for (int i = 0; i < num; i++) {
      Element node = (Element) entries.item(i);
      listAllAttributes(node);
    }

  }

  public void listAllAttributes(Element element) {

    System.out.println("List attributes for node: " + element.getNodeName());

    // get a map containing the attributes of this node
    NamedNodeMap attributes = element.getAttributes();

    // get the number of nodes in this map
    int numAttrs = attributes.getLength();

    for (int i = 0; i < numAttrs; i++) {
      Attr attr = (Attr) attributes.item(i);

      String attrName = attr.getNodeName();
      String attrValue = attr.getNodeValue();

      System.out.println("Found attribute: " + attrName + " with value: " + attrValue);

    }
  }

  public static void main(String[] args) throws Exception {
    // nada for now
  }


}