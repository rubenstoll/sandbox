package org.unitedstollutions.cdi.antoniogoncales;

import javax.inject.Inject;

public class Hello {
	
	
	@Inject
	World world;
	
	@Inject
	Mundo mundo;

	public String sayHelloWorld() {
		return "Hello " + world.sayWorld() + mundo.saludoMundo();
		
	}

}
