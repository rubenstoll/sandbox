package ws.rest;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Initializer for the Web Application.
 */
public class MgmntConsoleApplicationInitializer implements WebApplicationInitializer {

  /**
   * {@inheritDoc}
   */
  @Override
  public void onStartup(ServletContext container) throws ServletException {

    AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext(MgmtConsoleConfiguration.class);

    AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
    webContext.setParent(parentContext);
    webContext.register(WebMvcConfig.class);
    webContext.setServletContext(container);

    ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(webContext));
    container.addListener(new ServletContextListener() {

      @Override
      public void contextInitialized(ServletContextEvent sce) {
      }

      @Override
      public void contextDestroyed(ServletContextEvent sce) {
        // Dispatcher servlet only closes webContext
        parentContext.close();
      }

    });

    servlet.addMapping("/*");

  }
}
