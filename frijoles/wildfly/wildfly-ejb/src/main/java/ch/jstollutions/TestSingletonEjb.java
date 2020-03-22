package ch.jstollutions;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
public class TestSingletonEjb {

  @Lock(LockType.READ)
  public String sayHello(String name) {
    return "Hello, " + name + "!";
  }

  private Map<String, String> elements;
  public TestSingletonEjb() {
    this.elements = new HashMap<>();
  }
  @Lock(LockType.READ)
  public String getElement(String key) {
    return elements.get(key);
  }
  @Lock(LockType.WRITE)
  public void addElement(String key, String value) {
    elements.put(key, value);
  }

}