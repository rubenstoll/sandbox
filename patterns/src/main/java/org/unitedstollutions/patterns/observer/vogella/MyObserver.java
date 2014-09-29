//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2014
//------------------------------------------------------------------------------

package org.unitedstollutions.patterns.observer.vogella;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyObserver implements PropertyChangeListener {
  public MyObserver(MyModel model) {
    model.addChangeListener(this);
  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    System.out.println("Changed property: " + event.getPropertyName() + " [old -> " + event.getOldValue()
        + "] | [new -> " + event.getNewValue() + "]");
  }
}