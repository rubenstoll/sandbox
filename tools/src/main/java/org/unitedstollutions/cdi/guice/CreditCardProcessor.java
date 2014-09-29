/**
 * 
 */
package org.unitedstollutions.cdi.guice;

/**
 * @author rustoll
 *
 */
public interface CreditCardProcessor {

	ChargeResult charge(CreditCard creditCard, PizzaOrder amount);


}
