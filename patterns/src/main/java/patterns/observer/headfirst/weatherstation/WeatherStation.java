
package patterns.observer.headfirst.weatherstation;

/**
 * @author z003d3hv
 *
 */
public class WeatherStation {

  /**
   * @param args
   */
  public static void main(String[] args) {

    WeatherData weatherData = new WeatherData();

    DisplayElement currentDisplay = new CurrentConditionsDisplay(weatherData);

    DisplayElement statsDisplay = new StatisticsDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.3f);

  }

}
