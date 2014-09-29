/**
 * 
 */
package org.unitedstollutions.cdi.guice;

/**
 * @author rustoll
 *
 */
public class PaypalCreditCardProcessor implements CreditCardProcessor {

    @Override
    public ChargeResult charge(CreditCard creditCard, PizzaOrder amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
