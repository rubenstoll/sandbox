package patterns.adapter.dzone;

import java.util.logging.Logger;

/**
 * https://dzone.com/articles/design-patterns-explained-adapter-pattern-with-cod
 */
public class FilterCoffeeApp {

  private Logger log = Logger.getLogger(FilterCoffeeApp.class.getSimpleName());
  private FilterCoffeeMachine coffeeMachine;

  public FilterCoffeeApp(FilterCoffeeMachine coffeeMachine) {
    this.coffeeMachine = coffeeMachine;
  }

  public Coffee prepareCoffee() {
    Coffee coffee = this.coffeeMachine.brewCoffee();
    log.info("Coffee is ready!");
    log.info(" -> " + coffee);
    return coffee;
  }
}