package com.stratio.financial.test.infrastructure.db.springdata.config;

import javax.sql.DataSource;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Configuration
@EnableJpaRepositories(basePackages = "com.stratio.financial.test.infrastructure.db.springdata.repository")
@ConfigurationProperties("spring.datasource")
@Log4j2
@NoArgsConstructor
@Getter
@Setter
public class SpringDataConfig {

  private String url;

  private String username;

  private String driverClassName;

  private String password;

  private boolean continueOnError;

  @SuppressWarnings("unchecked")
  @Bean
  @Primary
  public DataSource dataSource() throws SQLException, ClassNotFoundException {
    log.info("Initializing simple datasource (no pooling) with url {} username {} and driver class name {}", url,
        username, driverClassName);
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriver(DriverManager.getDriver(url));
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setDriverClass((Class<? extends Driver>) Class.forName(driverClassName));
    Properties connectionProperties = new Properties();
    connectionProperties.put("continue-on-error", continueOnError);
    dataSource.setConnectionProperties(connectionProperties);
    log.info("Simple datasource (no pooling) Initialized!");
    return dataSource;
  }

}
