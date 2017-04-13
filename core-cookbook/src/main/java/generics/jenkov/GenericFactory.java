package generics.jenkov;

/**
 * http://tutorials.jenkov.com/java-generics/classes.html
 */
public class GenericFactory<T> {

  Class theClass = null;

  public GenericFactory(Class theClass) {
    this.theClass = theClass;
  }

  public T createInstance() throws IllegalAccessException, InstantiationException {
    return (T) this.theClass.newInstance();
  }
}