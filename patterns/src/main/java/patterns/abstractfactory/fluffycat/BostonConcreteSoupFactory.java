package patterns.abstractfactory.fluffycat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BostonConcreteSoupFactory extends AbstractSoupFactory {

  private static Logger logger = LoggerFactory.getLogger(BostonConcreteSoupFactory.class);

  public BostonConcreteSoupFactory() {
    factoryLocation = "Boston";
  }

  public ClamChowder makeClamChowder() {
    return new BostonClamChowder();
  }

  public FishChowder makeFishChowder() {
    return new BostonFishChowder();
  }
}
