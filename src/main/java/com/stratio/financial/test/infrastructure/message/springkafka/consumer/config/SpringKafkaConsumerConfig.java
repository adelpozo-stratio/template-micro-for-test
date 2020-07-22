package com.stratio.financial.test.infrastructure.message.springkafka.consumer.config;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.stratio.financial.test.application.repository.PetRepository;
import com.stratio.financial.test.application.service.PetService;
import com.stratio.financial.test.infrastructure.message.springkafka.consumer.SpringKafkaEventConsumer;

@Configuration
@ComponentScan({"com.stratio.financial.test"})
public class SpringKafkaConsumerConfig {

  @Bean
  public PetService petService(PetRepository petRepository) {
    return new PetService(petRepository);
  }

  @Bean
  public SpringKafkaEventConsumer stratioKafkaEventConsumerAdapter() {
    return new SpringKafkaEventConsumer();
  }

}
