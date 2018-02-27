package generics.oracle;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/types.html
 *
 * The most commonly used type parameter names are: <br />
 * E - Element (used extensively by the Java Collections Framework)<br />
 * K - Key<br />
 * N - Number<br />
 * T - Type<br />
 * V - Value<br />
 * S,U,V etc. - 2nd, 3rd, 4th types Generic version of the Box class. <br />
 * <br />
 * @param <T> the type of the value being boxed
 *
 */
public class Box<T> {

  // T stands for "Type"
  private T t;

  public void set(T t) {
    this.t = t;
  }

  public T get() {
    return t;
  }
}
