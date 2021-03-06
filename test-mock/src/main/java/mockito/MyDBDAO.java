package mockito;

/**
 *
 */
class MyDBDAO {

  /**
   * @param s a string
   * @return query result
   */
  String query(String s) {

    return "John";
  }

  /**
   * @param s a string
   * @return false value
   */
  Boolean update(String s) {

    return Boolean.FALSE;

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
  MetaInfo getMetaInfo() {
    return new MetaInfo();
  }

  /**
   * @param p person object
   * @return returns id of inserted item
   */
  String insert(Person p) {
    // actual DB would return table index or ID of inserted item
    return Double.toString(Math.random());
  }
}
