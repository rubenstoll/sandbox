
package patterns.behavioural.observer.headfirst.weatherstation;

/**
 * @author z003d3hv
 *
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

  private float temperature;

  private float humidity;

  private Subject weatherData;

  /**
   * @param weatherData
   */
  public CurrentConditionsDisplay(Subject weatherData) {

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
    System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
  }

  /*
   * (non-Javadoc)
   *
   * @see Observer#update(float, float, float)
   */
  @Override
  public void update(float temp, float hum, float pressure) {

    this.temperature = temp;
    this.humidity = hum;
    display();

  }

}
