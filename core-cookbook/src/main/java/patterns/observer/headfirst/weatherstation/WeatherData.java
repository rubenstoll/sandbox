//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2014
//------------------------------------------------------------------------------

package patterns.observer.headfirst.weatherstation;

import java.util.ArrayList;

/**
 * @author z003d3hv
 *
 */
public class WeatherData implements Subject {

  private ArrayList<Observer> observers;

  private float temperature;

  private float humidity;

  private float pressure;

  public WeatherData() {
    observers = new ArrayList<>();
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * Subject#registerObserver(Observer)
   */
  @Override
  public void registerObserver(Observer o) {
    observers.add(o);

  }

  /*
   * (non-Javadoc)
   *
   * @see
   * Subject#removeObserver(Observer)
   */
  @Override
  public void removeObserver(Observer o) {
    int i = observers.indexOf(o);
    if (i > 0) {
      observers.remove(i);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see Subject#notifyObservers()
   */
  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(temperature, humidity, pressure);
    }

  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.humidity = humidity;
    this.pressure = pressure;
    this.temperature = temperature;
    measurementsChanged();
  }

  public void measurementsChanged() {

    notifyObservers();

  }

}
