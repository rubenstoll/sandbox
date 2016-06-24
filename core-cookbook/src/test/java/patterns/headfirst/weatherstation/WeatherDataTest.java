//------------------------------------------------------------------------------
// Copyright Siemens Switzerland Ltd., 2014
//------------------------------------------------------------------------------

package patterns.headfirst.weatherstation;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import patterns.observer.headfirst.weatherstation.CurrentConditionsDisplay;
import patterns.observer.headfirst.weatherstation.DisplayElement;
import patterns.observer.headfirst.weatherstation.StatisticsDisplay;
import patterns.observer.headfirst.weatherstation.WeatherData;

/**
 * @author z003d3hv
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
     */
    @Ignore
    @Test
    public void testRegisterObserver() {
        Assert.fail("Not yet implemented");
    }

    /**
     * Test method for
     */
    @Ignore
    @Test
    public void testRemoveObserver() {
        Assert.fail("Not yet implemented");
    }

    /**
     */
    @Ignore
    @Test
    public void testNotifyObservers() {
        Assert.fail("Not yet implemented");
    }

    /**
     */
    @Test
    public void testSetMeasurements() {

        weatherData.setMeasurements(80, 65, 4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.3f);
    }

    /**
     */
    @Ignore
    @Test
    public void testMeasurementsChanged() {
        Assert.fail("Not yet implemented");

    }

}
