//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2014
//------------------------------------------------------------------------------

package patterns.observer.headfirst.weatherstation;

/**
 * @author z003d3hv
 *
 */
public interface Subject {
  public void registerObserver(Observer o);

  public void removeObserver(Observer o);

  public void notifyObservers();

}
