package patterns.fluffycat.abstractfactory;
class BostonConcreteSoupFactory extends AbstractSoupFactory {
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

