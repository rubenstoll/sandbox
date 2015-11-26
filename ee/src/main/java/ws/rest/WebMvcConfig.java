package ws.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.six_group.p2x.bo.mgmtconsole.status.StatusRestController;

/**
 * MVC Configuration.
 */
@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  /**
   * Bean for the status rest Controller.
   * @return the controller.
   */
  @Bean
  public StatusRestController restModuleController() {
    return new StatusRestController();
  }

}