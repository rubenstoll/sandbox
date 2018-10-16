package patterns.templatemethod;

/**
 * https://dzone.com/articles/design-patterns-template-method
 * <p />
 * GoF Definition: Defines the skeleton of an algorithm in a method, deferring some steps to subclasses.
 * Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithms structure.
 */
public class Client {

  /**
   * java doc missing.
   * @param args arguments
   */
  public static void main(String[] args) {
    CrossCompiler iphone = new IPhoneCompiler();
    iphone.crossCompile();
    CrossCompiler android = new AndroidCompiler();
    android.crossCompile();
  }
}