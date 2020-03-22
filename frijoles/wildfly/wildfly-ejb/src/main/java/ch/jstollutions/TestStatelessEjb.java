package ch.jstollutions;

import javax.ejb.Stateless;

@Stateless
public class TestStatelessEjb {
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}

