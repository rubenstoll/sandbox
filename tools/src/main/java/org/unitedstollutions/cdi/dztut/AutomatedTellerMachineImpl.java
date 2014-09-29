/**
 * 
 */
package org.unitedstollutions.cdi.dztut;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author rustoll
 * 
 */
@Named("atm")
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine {

//	@Inject @SuperFast @StandardFrameRelaySwitchingFlubber
//	@Inject @Transport(type=TransportType.STANDARD, priorityLevel=1)
//	private ATMTransport transport;
//	
	@Inject  
	private Instance<ATMTransport> allTransports;

//	@Inject
//	@Soap
//	@Inject @Transport(type=TransportType.SOAP)
//	private ATMTransport soapTransport;

//	@Inject
//	@Json
//	@Inject @Transport(type=TransportType.JSON)
//	private ATMTransport jsonTransport;

//	@Inject
//	@Json
//	@Inject @SuperFast @StandardFrameRelaySwitchingFlubber
//	@Inject @Transport(type=TransportType.STANDARD)
//	private ATMTransport standardTransport;

	// These could be looked up in a DB, JNDI or a properties file.
//	private boolean useJSON = true;
//	private boolean behindFireWall = true;

	@PostConstruct
	protected void init() {
		// Look up values for useJSON and behindFireWall
		
		System.out.println("Is this ambigous? " + allTransports.isAmbiguous() );
		System.out.println("Is this unsatisfied? " + allTransports.isUnsatisfied() );
		
//		TransportFactory tf = new TransportFactory();
//		transport = tf.createTransport();

//		if (!behindFireWall) {
//			transport = standardTransport;
//		} else {
//			if (useJSON) {
//				transport = jsonTransport;
//			} else {
//				transport = soapTransport;
//			}
//		}

	}

	// public AutomatedTellerMachineImpl() {
	//
	// }

	// @Inject
	// public AutomatedTellerMachineImpl(@Soap ATMTransport transport) {
	// this.transport = transport;
	// }
	//
	//
	// public ATMTransport getTransport() {
	// return transport;
	// }

	// @Inject
	// public void setTransport(ATMTransport transport) {
	// this.transport = transport;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.unitedstollutions.cdi.dztut.AutomatedTellerMachine#deposit(java.math
	 * .BigDecimal)
	 */
	@Override
	public void deposit(BigDecimal bd) {
		
		System.out.println("deposit called");
		
		for (ATMTransport transport : this.allTransports) {
			transport.communicateWithBank(null);
		}
//		transport.communicateWithBank(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.unitedstollutions.cdi.dztut.AutomatedTellerMachine#withdraw(java.
	 * math.BigDecimal)
	 */
	@Override
	public void withdraw(BigDecimal bd) {
		System.out.println("withdraw called");
//		transport.communicateWithBank(null);
		
		for (ATMTransport transport : this.allTransports) {
			transport.communicateWithBank(null);
		}
		
	}

}
