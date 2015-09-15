//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2014
//------------------------------------------------------------------------------

package org.unitedstollutions.patterns.observer.vogella;


import org.junit.Test;
import org.unitedstollutions.patterns.observer.vogella.MyModel.Person;

/**
 * @author z003d3hv
 *
 */
public class ObserverTest {

  @Test
  public void test() {
    MyModel model = new MyModel();
    MyObserver observer = new MyObserver(model);
    // we change the last name of the person, observer will get notified
    for (Person person : model.getPersons()) {
      person.setLastName(person.getLastName() + "1");
    }
    // we change the name of the person, observer will get notified
    for (Person person : model.getPersons()) {
      person.setFirstName(person.getFirstName() + "1");
    }
  }

}
