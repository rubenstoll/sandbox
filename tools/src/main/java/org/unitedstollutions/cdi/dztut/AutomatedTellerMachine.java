/**
 * 
 */
package org.unitedstollutions.cdi.dztut;

import java.math.BigDecimal;

/**
 * @author rustoll
 *
 */
public interface AutomatedTellerMachine {

	public abstract void deposit(BigDecimal bd);

    public abstract void withdraw(BigDecimal bd);
}
