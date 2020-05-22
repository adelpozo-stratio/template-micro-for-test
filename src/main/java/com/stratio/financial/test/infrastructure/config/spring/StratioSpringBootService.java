package com.stratio.financial.test.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.stratio.financial.test.infrastructure")
@EntityScan(basePackages = "com.stratio.financial.test.domain")
public class StratioSpringBootService {

  public static void main(String[] args) {
    SpringApplication.run(StratioSpringBootService.class, args);
  }
}