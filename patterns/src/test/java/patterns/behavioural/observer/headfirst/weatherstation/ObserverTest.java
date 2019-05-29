//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2014
//------------------------------------------------------------------------------

package patterns.behavioural.observer.headfirst.weatherstation;



import org.junit.Test;
import patterns.behavioural.observer.vogella.MyModel;
import patterns.behavioural.observer.vogella.MyObserver;

/**
 * @author z003d3hv
 *
 */
public class ObserverTest {

  @Test
  public void test() {
    MyModel model = new MyModel();
    MyObserver observer = new MyObserver(model);
    // we change the last name of the person, patterns.behavioural.observer will get notified
    for (MyModel.Person person : model.getPersons()) {
      person.setLastName(person.getLastName() + "1");
    }
    // we change the name of the person, patterns.behavioural.observer will get notified
    for (MyModel.Person person : model.getPersons()) {
      person.setFirstName(person.getFirstName() + "1");
    }
  }

}
