package ch.jstollutions;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 * https://dzone.com/articles/a-detailed-guide-to-ejbs-with-code-examples
 */
public class TestEjbClient {
  public static void main(String[] args) throws NamingException {
    Properties properties = new Properties();
    properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
        "org.apache.openejb.client.LocalInitialContextFactory");
    properties.setProperty(Context.PROVIDER_URL, "ejbd://host:4201");
    Context context = new InitialContext(properties);
    TestStatelessEjbRemote testStatelessEjbRemote
        = (TestStatelessEjbRemote) context.lookup("ejb/TestStatelessEjbRemote");
    testStatelessEjbRemote.sayHello("Stackify");
  }
}