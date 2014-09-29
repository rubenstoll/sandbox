package org.unitedstollutions.cdi.antoniogoncales;

import org.jboss.weld.environment.se.events.ContainerInitialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class MainJavaSE6 {

	@Inject
	Hello hello;

	public void saySomething(@Observes ContainerInitialized event) {
		System.out.println(hello.sayHelloWorld());
	}
}
