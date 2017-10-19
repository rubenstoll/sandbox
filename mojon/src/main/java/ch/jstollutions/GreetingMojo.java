package ch.jstollutions;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Says "Hi" to the user. https://maven.apache.org/guides/plugin/guide-java-plugin-development.html
 *
 */
@Mojo(name = "sayhi")
public class GreetingMojo extends AbstractMojo {

  public void execute() throws MojoExecutionException {
    getLog().info("Hello, world.");
  }
}