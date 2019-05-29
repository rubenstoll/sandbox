package patterns.creational.abstractfactory.fluffycat;

import java.util.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.fluffycat.com/Java-Design-Patterns/Abstract-Factory/
 */
public class TestAbstractSoupFactory {

  private static Logger logger = LoggerFactory.getLogger(TestAbstractSoupFactory.class);


  private static Soup MakeSoupOfTheDay(AbstractSoupFactory concreteSoupFactory) {
    Calendar todayCalendar = Calendar.getInstance();
    // int dayOfWeek = todayCalendar.get(Calendar.DAY_OF_WEEK);

    logger.debug("Debug log message");
    logger.info("Info log message");
    logger.error("Error log message");

    int dayOfWeek = Calendar.TUESDAY;

    if (dayOfWeek == Calendar.MONDAY) {
      return concreteSoupFactory.makeChickenSoup();
    } else if (dayOfWeek == Calendar.TUESDAY) {
      return concreteSoupFactory.makeClamChowder();
    } else if (dayOfWeek == Calendar.WEDNESDAY) {
      return concreteSoupFactory.makeFishChowder();
    } else if (dayOfWeek == Calendar.THURSDAY) {
      return concreteSoupFactory.makeMinnestrone();
    } else if (dayOfWeek == Calendar.SATURDAY) {
      return concreteSoupFactory.makePastaFazul();
    } else if (dayOfWeek == Calendar.FRIDAY) {
      return concreteSoupFactory.makeTofuSoup();
    } else {
      return concreteSoupFactory.makeVegetableSoup();
    }
  }

  public static void main(String[] args) {
    AbstractSoupFactory concreteSoupFactory = new BostonConcreteSoupFactory();
    Soup soupOfTheDay = MakeSoupOfTheDay(concreteSoupFactory);
    System.out.println("The Soup of the day " + concreteSoupFactory.getFactoryLocation() + " is " + soupOfTheDay.getSoupName());

    concreteSoupFactory = new HonoluluConcreteSoupFactory();
    soupOfTheDay = MakeSoupOfTheDay(concreteSoupFactory);
    System.out.println("The Soup of the day " + concreteSoupFactory.getFactoryLocation() + " is " + soupOfTheDay.getSoupName());
  }
}