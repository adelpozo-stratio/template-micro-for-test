package com.stratio.financial.test.infrastructure.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stratio.financial.test.application.service.PetService;
import com.stratio.financial.test.application.repository.PetRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class StratioSpringBootServiceConfig {

  private final PetRepository petRepository;

  @Bean
  public PetService petService() {
    return new PetService(petRepository);
  }



}
