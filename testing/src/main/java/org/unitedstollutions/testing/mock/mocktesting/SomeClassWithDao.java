package org.unitedstollutions.testing.mock.mocktesting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z003d3hv on 6/27/2014.
 */
public class SomeClassWithDao {

  MyDBDAO dao;

  List<String> iList;

  /**
   * @param daoIS
   */
  public SomeClassWithDao(MyDBDAO daoIS) {
    this.dao = daoIS;

    // initialize list with bogus stuff
    iList = new ArrayList<>();
    iList.add("one");
    iList.add("two");
    iList.add("three");
  }

  /**
   * @param s
   * @return nada
   */
  public String findItem(String s) {
    return dao.query(s);
  }

  /**
   * @param s
   * @return nada
   */
  public Boolean renewItem(String s) {

    dao.doSomeCheck();
    dao.doSomeOtherCheck();
    return dao.update(s);
  }

  /**
   * @param index
   * @return nada
   */
  public String getItemFromList(Integer index) {

    return iList.get(index.intValue());
  }

  /**
   * @param p
   */
  public void addItem(Person p) {

    // insert object in DB and assign the index to the object's ID
    String newId = dao.insert(p);
    p.setId(newId);

  }

}
