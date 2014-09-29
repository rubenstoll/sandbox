/**
 * 
 */
package org.unitedstollutions.cdi.dztut;

import javax.enterprise.inject.Default;



/**
 * @author rustoll
 * 
 */
//@Default
//@Standard
@StandardFrameRelaySwitchingFlubber @Default
//@Transport(type=TransportType.STANDARD, priorityLevel=-1)
public class StandardAtmTransport implements ATMTransport {

	
	private int retries;

	public void setRetries(int retries) {
		this.retries = retries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.unitedstollutions.cdi.dztut.ATMTransport#communicateWithBank(byte[])
	 */
	@Override
	public void communicateWithBank(byte[] datapacket) {
		System.out.println("communicating with bank via Standard transport");
	}

}
