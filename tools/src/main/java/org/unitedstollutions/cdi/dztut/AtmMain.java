/**
 * 
 */
package org.unitedstollutions.cdi.dztut;

import java.math.BigDecimal;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 * @author rustoll
 * 
 * https://code.google.com/p/jee6-cdi/wiki/DependencyInjectionAnIntroductoryTutorial
 * 
 */
public class AtmMain {
	
	//EJBContainer ec = EJBContainer.createEJBContainer();
	
	@Inject
	AutomatedTellerMachine atmg;
	
	public static void main(String[] args) {
		
		AutomatedTellerMachine atm = new AutomatedTellerMachineImpl();
//		ATMTransport transport = new SoapAtmTransport();
		
//        AutomatedTellerMachine atm = beanContainer.getBeanByType(AutomatedTellerMachine.class);

		
		/* Inject the transport. */
	//	((AutomatedTellerMachineImpl) atm).setTransport(transport);

		atm.withdraw(new BigDecimal("10.00"));

		atm.deposit(new BigDecimal("100.00"));
	}
	
	
	
	public void deposit(@Observes ContainerInitialized event) {

		atmg.deposit(new BigDecimal("1.00"));

	}
	
}
