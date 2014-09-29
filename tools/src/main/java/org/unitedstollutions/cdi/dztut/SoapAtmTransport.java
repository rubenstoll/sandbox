/**
 * 
 */
package org.unitedstollutions.cdi.dztut;


/**
 * @author rustoll
 * 
 */
//@Alternative
//@Soap
@Transport(type=TransportType.SOAP)
public class SoapAtmTransport implements ATMTransport {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.unitedstollutions.cdi.dztut.ATMTransport#communicateWithBank(byte[])
	 */
	@Override
	public void communicateWithBank(byte[] datapacket) {
		// TODO Auto-generated method stub
		System.out.println("communicating with bank via Soap transport");
	}

}
