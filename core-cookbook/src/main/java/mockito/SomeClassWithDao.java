package mockito;

import java.util.ArrayList;
import java.util.List;
import persistence.jpa.tutorialspoint.model.Person;

/**
 * class to mock dao
 */
class SomeClassWithDao {

  private MyDBDAO dao;

  private List<String> iList;

  /**
   * @param daoIS database DAO
   */
  SomeClassWithDao(MyDBDAO daoIS) {
    this.dao = daoIS;

    // initialize list with bogus stuff
    iList = new ArrayList<>();
    iList.add("one");
    iList.add("two");
    iList.add("three");
  }

  /**
   * @param s string of item to find
   * @return nada
   */
  String findItem(String s) {
    return dao.query(s);
  }

  /**
   * @param s item to renew
   * @return nada
   */
  Boolean renewItem(String s) {

    dao.doSomeCheck();
    dao.doSomeOtherCheck();
    return dao.update(s);
  }

  /**
   * @param index index of list
   * @return nada
   */
  String getItemFromList(Integer index) {

    return iList.get(index);
  }

  /**
   * @param p person object
   */
  void addItem(Person p) {

    // insert object in DB and assign the index to the object's ID
    String newId = dao.insert(p);
    p.setId(newId);

  }

}
