package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class NamespaceResolver implements NamespaceContext {

  //Store the source document to search the namespaces
  private Document sourceDocument;

  public NamespaceResolver(String fileName) throws IOException, SAXException, ParserConfigurationException {
    sourceDocument = getDocument(fileName);
  }

  //The lookup for the namespace uris is delegated to the stored document.
  public String getNamespaceURI(String prefix) {
    if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
      return sourceDocument.lookupNamespaceURI(null);
    } else {
      return sourceDocument.lookupNamespaceURI(prefix);
    }
  }

  public String getPrefix(String namespaceURI) {
    return sourceDocument.lookupPrefix(namespaceURI);
  }

  @SuppressWarnings("rawtypes")
  public Iterator getPrefixes(String namespaceURI) {
    return null;
  }

  private Document getDocument(String fileName) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    return builder.parse(new FileInputStream(new File(fileName)));
  }

  public Document getSourceDocument() {
    return sourceDocument;
  }

}