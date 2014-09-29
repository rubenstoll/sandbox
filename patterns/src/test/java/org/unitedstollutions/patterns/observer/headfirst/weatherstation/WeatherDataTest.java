//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2014
//------------------------------------------------------------------------------

package org.unitedstollutions.patterns.observer.headfirst.weatherstation;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.unitedstollutions.patterns.observer.headfirst.weatherstation.CurrentConditionsDisplay;
import org.unitedstollutions.patterns.observer.headfirst.weatherstation.DisplayElement;
import org.unitedstollutions.patterns.observer.headfirst.weatherstation.StatisticsDisplay;
import org.unitedstollutions.patterns.observer.headfirst.weatherstation.WeatherData;

/**
 * @author z003d3hv
 *
 */
public class WeatherDataTest {

  private static WeatherData weatherData;

  private static DisplayElement currentDisplay;

  private static DisplayElement statsDisplay;

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    weatherData = new WeatherData();

    currentDisplay = new CurrentConditionsDisplay(weatherData);

    statsDisplay = new StatisticsDisplay(weatherData);
  }

  //
  // /**
  // * @throws java.lang.Exception
  // */
  // @Before
  // public void setUp() throws Exception {
  // }

  /**
   * Test method for
   * {@link org.unitedstollutions.patterns.observer.headfirst.weatherstation.WeatherData#registerObserver(org.unitedstollutions.patterns.observer.headfirst.weatherstation.Observer)}
   * .
   */
  @Ignore
  @Test
  public void testRegisterObserver() {
    Assert.fail("Not yet implemented");
  }

  /**
   * Test method for
   * {@link org.unitedstollutions.patterns.observer.headfirst.weatherstation.WeatherData#removeObserver(org.unitedstollutions.patterns.observer.headfirst.weatherstation.Observer)}
   * .
   */
  @Ignore
  @Test
  public void testRemoveObserver() {
    Assert.fail("Not yet implemented");
  }

  /**
   * Test method for {@link org.unitedstollutions.patterns.observer.headfirst.weatherstation.WeatherData#notifyObservers()}.
   */
  @Ignore
  @Test
  public void testNotifyObservers() {
    Assert.fail("Not yet implemented");
  }

  /**
   * Test method for {@link org.unitedstollutions.patterns.observer.headfirst.weatherstation.WeatherData#setMeasurements(float, float, float)}.
   */
  @Test
  public void testSetMeasurements() {

    weatherData.setMeasurements(80, 65, 4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.3f);
  }

  /**
   * Test method for {@link org.unitedstollutions.patterns.observer.headfirst.weatherstation.WeatherData#measurementsChanged()}.
   */
  @Ignore
  @Test
  public void testMeasurementsChanged() {
    Assert.fail("Not yet implemented");

  }

}
