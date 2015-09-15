package org.unitedstollutions.testing.mock.mocktesting;

/**
 * Created by z003d3hv on 6/27/2014.
 */
public class MyDBDAO {

  /**
   * @param s
   * @return query result
   */
  public String query(String s) {

    return "John";
  }

  /**
   * @param s
   * @return false value
   */
  public Boolean update(String s) {

    return new Boolean(false);

  }

  void doSomeCheck() {
    // nothing
  }

  void doSomeOtherCheck() {
    // nothing

  }

  /**
   * @return newly created object
   */
  public org.unitedstollutions.testing.mock.mocktesting.MetaInfo getMetaInfo() {

    return new MetaInfo();

  }

  /**
   * @param p
   * @return returns id of inserted item
   */
  public String insert(Person p) {
    // actual DB would return table index or ID of inserted item
    return Double.toString(Math.random());
  }
}
