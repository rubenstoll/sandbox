//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2014
//------------------------------------------------------------------------------

package patterns.behavioural.observer.headfirst.weatherstation;

/**
 * @author z003d3hv
 *
 */
public class StatisticsDisplay implements DisplayElement, Observer {

  private float temperature;

  private float humidity;

  private Subject weatherData;

  public StatisticsDisplay(Subject weatherData) {

    this.weatherData = weatherData;
    weatherData.registerObserver(this);

  }

  /*
   * (non-Javadoc)
   * 
   * @see DisplayElement#display()
   */
  @Override
  public void display() {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(float temperature, float humidity, float pressure) {
    // TODO Auto-generated method stub

  }

}
