/**
 * 
 */
package org.unitedstollutions.cdi.dztut;


/**
 * @author rustoll
 *
 */
//@Alternative
//@Json
@Transport(type=TransportType.JSON)
public class JsonRestAtmTransport implements ATMTransport {

	/* (non-Javadoc)
	 * @see org.unitedstollutions.cdi.dztut.ATMTransport#communicateWithBank(byte[])
	 */
	@Override
	public void communicateWithBank(byte[] datapacket) {
		// TODO Auto-generated method stub
		 System.out.println("communicating with bank via JSON REST transport");
	}

}
