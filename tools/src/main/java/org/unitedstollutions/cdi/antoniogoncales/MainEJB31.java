package org.unitedstollutions.cdi.antoniogoncales;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MainEJB31 {
	@Inject
    Hello hello;
 
    public String saySomething() {
        return hello.sayHelloWorld();
    }
}
