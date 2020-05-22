package com.stratio.financial.test.infrastructure.message.springkafka.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stratio.financial.test.infrastructure.message.springkafka.consumer.SpringKafkaEventConsumer;

@Configuration
public class SpringKafkaConsumerConfig {

  @Bean
  public SpringKafkaEventConsumer stratioKafkaEventConsumerAdapter() {
    return new SpringKafkaEventConsumer();
  }

}
