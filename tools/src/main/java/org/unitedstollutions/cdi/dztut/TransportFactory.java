/**
 * 
 */
package org.unitedstollutions.cdi.dztut;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * @author rustoll
 * 
 */
public class TransportFactory {

	private boolean useJSON = true;
	private boolean behindFireWall = false;

	@Produces
	ATMTransport createTransport(InjectionPoint injectionPoint) {
		// System.out.println("ATMTransport created with producer");
		// return new StandardAtmTransport();az

		// Look up config parameters in some config file or LDAP server or
		// database


		Transport transportConfig = injectionPoint.getAnnotated().getAnnotation(Transport.class);

		if (transportConfig!=null) {
			
		}
		StandardAtmTransport transport = new StandardAtmTransport();

		transport.setRetries(transportConfig.retries());
		return transport;
		
//		System.out
//				.println("ATMTransport created with producer makes decisions");
//
//		if (behindFireWall) {
//			if (useJSON) {
//				System.out.println("Created JSON transport");
//				return new JsonRestAtmTransport();
//			} else {
//				System.out.println("Created SOAP transport");
//				return new SoapAtmTransport();
//			}
//		} else {
//			System.out.println("Created Standard transport");
//			return new StandardAtmTransport();
//		}
	}
	
	
//    @Produces ATMTransport createTransport(	@Soap ATMTransport soapTransport, 
//                        @Json ATMTransport jsonTransport) {
        @Produces ATMTransport createTransport(	@Transport(type=TransportType.SOAP) ATMTransport soapTransport, 
        		@Transport(type=TransportType.JSON) ATMTransport jsonTransport) { 
        	
        //Look up config parameters in some config file
        System.out.println("ATMTransport created with producer makes decisions");

        if (behindFireWall) {
            if (useJSON) {
                System.out.println("return passed JSON transport");
                return jsonTransport;
            } else {
                System.out.println("return passed SOAP transport");
                return soapTransport;
            }
        } else {
            System.out.println("Create Standard transport");
            return new StandardAtmTransport();
        }
    }

}
