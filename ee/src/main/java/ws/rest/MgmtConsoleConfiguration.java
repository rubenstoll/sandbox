package ws.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration class for the MgmtConsole Application.
 */
@Configuration
@Import({
//    CommonConfiguration.class,
//    JdbcConfiguration.class
})
public class MgmtConsoleConfiguration {

//  /**
//   * Uses datasource from container.
//   *
//   * @return the data source to be used
//   */
//  @Bean
//  public DataSource dataSource() {
//    return new JndiDataSourceLookup().getDataSource("java:jboss/datasources/SixDS");
//  }
}
