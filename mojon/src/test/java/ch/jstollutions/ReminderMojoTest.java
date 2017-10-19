package ch.jstollutions;

import java.io.File;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

/**
 * FYI no junit annotation used because it's extending the mojo test case which uses other junit version
 */
public class ReminderMojoTest extends AbstractMojoTestCase {

  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testJustMessage() throws Exception {
    File pom = getTestFile("src/test/resources/unit/reminder-mojo/pom.xml");
    assertNotNull(pom);
    assertTrue(pom.exists());
    ReminderMojo myMojo = (ReminderMojo) lookupMojo("remind", pom);
    assertNotNull(myMojo);
    myMojo.execute();
  }
}