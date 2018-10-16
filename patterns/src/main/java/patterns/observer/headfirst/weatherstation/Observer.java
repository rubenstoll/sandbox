//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2014
//------------------------------------------------------------------------------

package patterns.observer.headfirst.weatherstation;

/**
 * @author z003d3hv
 *
 */
public interface Observer {
  public void update(float temperature, float humidity, float pressure);

}
