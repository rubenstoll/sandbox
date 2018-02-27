package generics.jenkov;

/**
 * http://tutorials.jenkov.com/java-generics/classes.html
 */
public class GenGen {

  public static void main(String[] args) {

    try {
      one();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public static void one() throws InstantiationException, IllegalAccessException {

    GenericFactory<MyClass> factory = new GenericFactory<MyClass>(MyClass.class);
    MyClass myClassInstance = factory.createInstance();

    GenericFactory<SomeObject> factory2 = new GenericFactory<SomeObject>(SomeObject.class);
    SomeObject someObjectInstance = factory2.createInstance();

  }

}
