package xml;

import java.util.ArrayList;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;

public class Main {
  public static void main(String[] args) throws Exception {
    //Want to read all book names from XML
    ArrayList<String> bookNames = new ArrayList<String>();

    //Parse XML file
    NamespaceResolver namespaceResolver = new NamespaceResolver("sample.xml");


    //Get XPath expression
    XPathFactory xpathfactory = XPathFactory.newInstance();
    XPath xpath = xpathfactory.newXPath();
    xpath.setNamespaceContext(new NamespaceResolver("sample.xml"));
    XPathExpression expr = xpath.compile("//ns2:bookStore/ns2:book/ns2:name/text()");

    //Search XPath expression
    Object result = expr.evaluate(namespaceResolver.getSourceDocument(), XPathConstants.NODESET);

    //Iterate over results and fetch book names
    NodeList nodes = (NodeList) result;
    for (int i = 0; i < nodes.getLength(); i++) {
      bookNames.add(nodes.item(i).getNodeValue());
    }

    //Verify book names
    System.out.println(bookNames);
  }
}