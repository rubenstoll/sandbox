/**
 * 
 */
package org.unitedstollutions.cdi.dztut;

/**
 * @author rustoll
 * 
 */
public interface ATMTransport {
	public void communicateWithBank(byte[] datapacket);
}
